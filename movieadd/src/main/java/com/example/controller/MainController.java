package com.example.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.Category;
import com.example.dto.Movie;
import com.example.dto.MovieCategory;
import com.example.service.CategoryService;
import com.example.service.MovieCategoryService;
import com.example.service.MovieService;

@Controller
public class MainController {
	@Autowired
	MovieService service;
	@Autowired
	CategoryService service2;
	@Autowired
	MovieCategoryService service3;
	
	@GetMapping("/")
	public String main() {
		return "test";
	}
	
	@GetMapping("/main")
	public String main2() {
		return "main";
	}
	
	@GetMapping("/movieadd")
	public String list(Model m, HttpServletRequest request) {
		
		String title ="";
		
		if (request.getParameter("title")!=null) {
			title = request.getParameter("title");
		}
		 System.out.println(title);
		
		String line = null;
		   
		   try{
		      String authkey = "0M1CRMOD0W2RFMSLVG1G";
		      String query = title;
		      query = URLEncoder.encode(query, "UTF-8");
		      String collection = "kmdb_new2";
		      String address = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection="+collection+"&detail=Y&listCount=100&ServiceKey="+authkey+"&title="+query;
		      
		      //객체 생성 및 url 연결
		      URL url = new URL(address);
		      URLConnection urlConn = url.openConnection();
		      
		      //데이터 받아오기
		      InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		      BufferedReader br = new BufferedReader(ir);
		      
		      line = br.readLine();
		      
		      //모든 데이터
		      String allData="";
		      
		      while ((line = br.readLine()) != null) {
		         allData+=line;
		      }
		      
		      //System.out.println("allData : "+ allData);
		      
		      m.addAttribute("allData", allData);
		      
		      br.close();
		      ir.close();
		      
		   }catch(Exception e){
		      e.printStackTrace();
		   }
		   		
		return "movie";
	}
	
	@PostMapping("/movieadd")
	public String movieadd(HttpServletRequest request, Model m) throws IOException {
		String movie_id = request.getParameter("movie_id");
		String title = request.getParameter("title");
		String release_date = request.getParameter("release_date");
		String plot = request.getParameter("plot");
		String rating = request.getParameter("rating");
		String director_nm = request.getParameter("director_nm");
		String actor_nm = request.getParameter("actor_nm");
		String category= request.getParameter("category_id");
		////////////////////////////////////////////
		
		// URL 및 저장할 이미지 이름 파라미터로 받기
        String imageUrlStr = request.getParameter("poster");
        //String imageUrlStr = "http://file.koreafilm.or.kr/thm/01/copy/00/56/24/tn_DST714548.jpg";
        if (request.getParameter("poster").length()==0) {
        	imageUrlStr = "file:///C:/images/noimage.png";	
		}// 이쪽이 문제, 
        
        System.out.println("imageUrlStr : "+imageUrlStr);
        
        int width = 200; // 변경할 이미지의 너비
		int height = (int) (200*1.3); // 변경할 이미지의 높이

        // 이미지 URL
        URL imageUrl = new URL(imageUrlStr);
        // 이미지 가져오기
        URLConnection conn = imageUrl.openConnection();
        conn.connect();
        InputStream inputStream = conn.getInputStream();

        // 이미지 크기 변경
        BufferedImage image = ImageIO.read(inputStream);
        BufferedImage resizedImage = new BufferedImage(width, height, image.getType());
        resizedImage.getGraphics().drawImage(image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH), 0, 0, width, height, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "png", baos);
        byte[] imageBytes = baos.toByteArray();
        
        // 이미지 저장
        File dir = new File("C:/images/");
        if(!dir.exists()) {
            dir.mkdirs();
        }
        
        String imageName = movie_id+".png";
		FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, imageName));
		BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
		outputStream.write(imageBytes);
		outputStream.flush();
		outputStream.close();

		////////////////////////////////////////////////////////////
		Movie movie = new Movie();
		movie.setMovie_id(movie_id);
		movie.setTitle(title);
		movie.setRelease_date(release_date);
		movie.setPlot(plot);
		movie.setRating(rating);
		movie.setDirector_nm(director_nm);
		movie.setActor_nm(actor_nm);
		movie.setBoxoffice_order(null);
		movie.setStar_avg_rate(0.0);
		
		int n = service.insert(movie);
		System.out.println("들어간 갯수 : "+n);
		
		String[] catearr = category.split(",");
		
		for(String category_id : catearr) {
			System.out.println(category_id);
			
			int count = service2.find(category_id);
			System.out.println(count);
			
			if (count==0) {
				Category mcategory = new Category();
				mcategory.setCategory_id(category_id);
				
				int n2 = service2.insert(mcategory);
				System.out.println("카테고리 추가 : "+n2);
			}
			
			//moviecategory 테이블에 insert
			MovieCategory moviecategory = new MovieCategory();
			moviecategory.setMovie_id(movie_id);
			moviecategory.setCategory_id(category_id);
			
			System.out.println(moviecategory);
			
			int n3 = service3.insert(moviecategory);
			System.out.println("db등록 : "+ n3);
		}
		
		 m.addAttribute("title", title);
		
		return "main";
	}
	
}
