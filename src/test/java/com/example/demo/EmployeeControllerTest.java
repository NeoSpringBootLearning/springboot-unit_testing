package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.employee.Person;
import com.example.demo.employee.PersonController;
import com.example.demo.employee.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PersonController.class)
public class EmployeeControllerTest {

		@Autowired
		MockMvc mockMvc;
		@Autowired
		ObjectMapper objectMapper;
		@MockBean
		PersonService personService;
		@Test
		public void getAllEmployeeMethod_doReturn200_response() throws Exception {
			
			    List<Person> persons = new ArrayList<>();
			    Person p1 =  new Person();
			    p1.setId(1);p1.setFirstName("xx");p1.setLastName("yy");p1.setEmail("xx.yy@gmail.com");
			    p1.setBirthDate(LocalDate.of(1987, 10, 15));
			    persons.add(p1);
				mockMvc.perform(get("/api/v1/person/findall")
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(persons)))
						.andExpect(status().isOk());
		}
}
