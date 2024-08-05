package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee" ,description = "Employee Managment APIs concentrating on Jpa Relationship")
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

		@Autowired
		private PersonService employeeService;
		
		@Operation(summary = "Create a new employee",description = "Create a new employee based on Employee Object")
		@PostMapping("/create")
		public ResponseEntity<CommonResponse> createEmployee(@RequestBody PersonRequest employeeRequest){
			
			CommonResponse response = employeeService.createEmployee(employeeRequest);
			return new ResponseEntity<CommonResponse>(response,HttpStatus.CREATED);
		}
		
		@GetMapping("/findall")
		public ResponseEntity<PersonsResponse> getAllEmployee(){
			
			PersonsResponse response = employeeService.getAllEmployee();
			return new ResponseEntity<PersonsResponse>(response,HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<PersonResponse> findEmployeeById(@PathVariable("id") Integer id) throws Exception{
			
			PersonResponse response = employeeService.findEmployeeById(id);
			return new ResponseEntity<PersonResponse>(response,HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<CommonResponse> deleteEmployeeById(@PathVariable("id") Integer id) throws Exception{
			
			CommonResponse response = employeeService.deleteEmployeeById(id);
			return new ResponseEntity<CommonResponse>(response,HttpStatus.OK);
		}
}
