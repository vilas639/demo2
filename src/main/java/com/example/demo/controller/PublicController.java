package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.coyote.http11.Http11InputBuffer;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person1;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.PersonService;

import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

@RestController
@RequestMapping("public/")
public class PublicController {

	
	@Autowired
   private PersonService personService;

	
	@PostMapping("createUser")
	public ResponseEntity<ErrorResponse> createUser(@Valid @RequestBody  Person1 person1, BindingResult result) {
        
		 System.out.println(""+person1.toString());
//		 
//		if(result.hasErrors()){
//			 Map<String, String> errors = new HashMap<>();
//		        for (FieldError error : result.getFieldErrors()) {
//		            errors.put(error.getField(), error.getDefaultMessage());
//		        }      
//		     System.out.println(errors);   
//		}
		
		
		
        boolean isSaved = personService.createNewPerson(person1);
        if(isSaved){
           
        	
        
        }
        
        return ResponseEntity.
        		status(HttpStatus.SC_CREATED)
        		.body(new ErrorResponse(HttpStatus.SC_CREATED,"user register successfully !"));
        
        
	}
	
}
