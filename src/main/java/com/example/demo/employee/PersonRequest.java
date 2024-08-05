package com.example.demo.employee;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
}
