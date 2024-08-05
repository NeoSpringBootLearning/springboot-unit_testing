package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

	
	public String greetings() {
		
		LocalDateTime dateTime = LocalDateTime.now();
		String date = String.valueOf(dateTime).substring(0,20);
		return "Greetings from Hello World Controller" +"-- Current Date and Time --" +date;
	}
}
