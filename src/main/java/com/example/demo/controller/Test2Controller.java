package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;

@RestController
@RequestMapping("test2/")
public class Test2Controller {

	
	
	//get empoyee object
	@PostMapping("getemp1")
	public ResponseEntity<Employee> getemployee(@RequestBody Employee employee,@RequestHeader("channel") String channel)
	{
	   System.out.println("employee"+employee);
	   System.out.println("channel"+channel);
	   employee.setEmpid(77L);
	   employee.setName("rajesh");
	   return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("listofemp")
	public ResponseEntity<List<Employee>> listofemp(@RequestBody Employee employee,@RequestHeader("channel") String channel)
	{
	   System.out.println("employee"+employee);
	   System.out.println("channel"+channel);
	   List<Employee> emplist=new  ArrayList<>();
	   for (int i = 0; i < 10; i++) {
		
		   Employee e= new Employee();  
		   e.setEmpid((long) i);
		   e.setName("vilas"+i);
		   emplist.add(e);
	}
	   
	   System.out.println("listofemp end "+emplist);
	   return new ResponseEntity<List<Employee>>(emplist, HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	@GetMapping("info1")
	public String getinfo()
	{
		return "bye";
	}
	
	//address details
}
