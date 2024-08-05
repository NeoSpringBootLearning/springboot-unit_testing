package com.example.demo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CommonController.class)
public class CommonControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	CommonService commonService;
	
	@Test
	public void greeting_doReturn200_response() throws Exception {
		
//		 String response = commonService.greetings();
//		 
//		 when(commonService.greetings()).thenReturn(response);
		 mockMvc.perform(get("/api/v1/greetings")
		 			 .contentType(MediaType.APPLICATION_JSON)
		 			 .content("Greetings from Hello World Controller -- Current Date and Time --"))
		 			 .andExpect(status().isOk());
	}
	
}
