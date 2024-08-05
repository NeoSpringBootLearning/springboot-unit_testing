package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	@GetMapping("/greetings")
	public ResponseEntity<String> greetings() {
		
		String response = commonService.greetings();
		return ResponseEntity.ok(response);
	}
}
