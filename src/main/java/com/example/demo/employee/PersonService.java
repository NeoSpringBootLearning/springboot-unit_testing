package com.example.demo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	public PersonRepository employeeRepository;

	public PersonsResponse getAllEmployee() {

		PersonsResponse response = new PersonsResponse();
		List<Person> employees = employeeRepository.findAll();
		response.setEmployees(employees);
		response.setStatusCode(200);
		response.setStatus("Success");
		return response;
	}

	public PersonResponse findEmployeeById(Integer id) throws Exception {

		Person response = new Person();
		Optional<Person> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional.isEmpty()) {
			throw new Exception("Employee Not Exist Currently");
		}
		response.setId(employeeOptional.get().getId());
		response.setFirstName(employeeOptional.get().getFirstName());
		response.setLastName(employeeOptional.get().getLastName());
		response.setBirthDate(employeeOptional.get().getBirthDate());
		PersonResponse empResponse = PersonResponse.builder().employees(response).build();
		empResponse.setStatus("Success");
		empResponse.setStatusCode(200);
		return empResponse;
	}

	public CommonResponse deleteEmployeeById(Integer id) throws Exception {

		CommonResponse response = new CommonResponse();
		employeeRepository.deleteById(id);
		response.setStatus("Success");
		response.setStatusCode(200);
		return response;
	}

	public CommonResponse createEmployee(PersonRequest employeeRequest) {

		Person employee = new Person();
		employee.setFirstName(employeeRequest.getFirstName());
		employee.setLastName(employeeRequest.getLastName());
		employee.setEmail(employeeRequest.getEmail());
		employee.setBirthDate(employeeRequest.getBirthDate());
		employeeRepository.save(employee);
		CommonResponse response = new CommonResponse();
		response.setStatusCode(200);
		response.setStatus("Success");
		return response;
	}
}
