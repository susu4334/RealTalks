package com.reeltalks.controller;

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
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reeltalks.dto.Category;
import com.reeltalks.dto.Movie;
import com.reeltalks.dto.MovieCategory;
import com.reeltalks.dto.Moviedata;
import com.reeltalks.service.CategoryService;
import com.reeltalks.service.MovieCategoryService;
import com.reeltalks.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService service;
	@Autowired
	CategoryService service2;
	@Autowired
	MovieCategoryService service3;
	@ResponseBody
	@PostMapping("/movieadd")
	public void movieadd(HttpServletRequest request, Model m) throws IOException {
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
        	imageUrlStr = "/images/noimage.png";	
		}// 이쪽이 문제, 
        
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
        File dir = new File("/app/web/images");
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
		
		int findmovie = service.find(movie_id);
		int n = 0;
		if(findmovie==0) {
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
			movie.setCreate_at(LocalDateTime.now());
			movie.setUpdate_at(LocalDateTime.now());
			
			n = service.insert(movie);
		}
		
		
		
		String[] catearr = category.split(",");
		
		for(String category_id : catearr) {
			
			int count = service2.find(category_id);
			
			if (count==0) {
				Category mcategory = new Category();
				mcategory.setCategory_id(category_id);
				mcategory.setCreate_at(LocalDateTime.now());
				mcategory.setUpdate_at(LocalDateTime.now());
				
				int n2 = service2.insert(mcategory);
			}
			if(n==1) {
				//moviecategory 테이블에 insert
				MovieCategory moviecategory = new MovieCategory();
				moviecategory.setMovie_id(movie_id);
				moviecategory.setCategory_id(category_id);
				moviecategory.setCreate_at(LocalDateTime.now());
				moviecategory.setUpdate_at(LocalDateTime.now());
				
				int n3 = service3.insert(moviecategory);
			}
		}
	}
	
	@GetMapping("/movie/{movie_id}")
	@ResponseBody
	public Moviedata movie(@PathVariable("movie_id") String movie_id) {
		Moviedata moviedata = service.moviedata(movie_id);
		moviedata.setCategory_id("#"+moviedata.getCategory_id());
		return moviedata;
	}
	
}
