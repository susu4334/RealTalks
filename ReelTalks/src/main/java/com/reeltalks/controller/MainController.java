package com.reeltalks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.Temp;
import com.reeltalks.repository.TempRepository;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		System.out.println("main.jsp 불러오기");
		return "main.jsp";
	}
	
	
	// (Temp 샘플용) 구현 안되어있음
	@Autowired
	private TempRepository tempRepository;

    @GetMapping("/temp")
    @ResponseBody
    public List<Temp> getAllTemp() {
        return tempRepository.findAll();
    }

    @PostMapping("/temp")
    @ResponseBody
    public Temp createTemp(@RequestBody Temp temp) {
        return tempRepository.save(temp);
    }

    @GetMapping("/temp/{id}")
    @ResponseBody
    public Temp getTempById(@PathVariable Long id) {
        return tempRepository.findById(id).get();
    }
    
    @PutMapping("/temp/{id}")
    @ResponseBody
    public Temp updateTemp(@PathVariable Long id, @RequestBody Temp getTemp) {
    	System.out.println("@PutMapping('/temp/{id}')" + id + getTemp);
    	Temp temp = tempRepository.findById(id).get();

    	temp.setName(getTemp.getName());
    	temp.setDescription(getTemp.getDescription());
    	temp.setPrice(getTemp.getPrice());

        return tempRepository.save(temp);
    }

    @DeleteMapping("/temp/{id}")
    @ResponseBody
    public void deleteTemp(@PathVariable Long id) {
    	tempRepository.deleteById(id);
    }
}
