package com.init.api.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.api.daos.ImageDao;
import com.init.api.daos.MessageDao;
import com.init.api.entitys.*;


@RestController
@RequestMapping
public class Rest {
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private MessageDao messageDao;

	@GetMapping
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping(value="images")
	public ResponseEntity<List<Image>> getImages() {
		return ResponseEntity.ok(imageDao.findAll());
	}
	

	@RequestMapping(value="image/{id}")
	public ResponseEntity<Image> getImage(@PathVariable("id") Long id) {
		
		Optional<Image> image = imageDao.findById(id);
		
		if(!image.isPresent())
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.ok(image.get());
	}
	

	@RequestMapping(value="image/", method = RequestMethod.POST)
	public ResponseEntity<Boolean> setImage(@RequestBody Image image) {
		imageDao.save(image);
		
		return ResponseEntity.ok(true);
	}

	@RequestMapping(value="message", method = RequestMethod.POST)
	public ResponseEntity<Boolean> setMessage(@RequestBody Message message){
		messageDao.save(message);
		
		return ResponseEntity.ok(true);
	}

	@RequestMapping(value="user", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getUser(){
		Map<String, String> map=new HashMap<String, String>();  
		    
	    map.put("name","Luis Reyes");  
	    map.put("email","siulfegocho3@gmail.com");  
	    map.put("information","Desarrollador Fullstack (Golang, Java, Python, PHP, JS, CSS, HTML...)");   
	    map.put("img","");
	    map.put("phone","");
	    map.put("showPhone","false");
	    
		return map;
	}
	
	@PostMapping
	public ResponseEntity<ResponseTime> getTimeZoneMMGVS(@RequestBody ResponseTime input) {
		
		input.dateToUTCTimeStamp();
		
		return ResponseEntity.ok(input);
	}
	
}
