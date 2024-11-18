package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("contacts/")
public class ContactController {

	@Autowired
	 private  ContactService contactService;

	
	     @PostMapping("saveMsg")
	    public ResponseEntity<?> saveMessage(@Valid @RequestBody Contact contact,  BindingResult result){

	    	 
	    	 System.out.println(""+contact.toString());
	    	
	    	 if (result.hasErrors()) {
	    		 throw new ResourceNotFoundException("Contact not found with the given name.");

	    		}
	    	 else
	    	 {
	    		boolean issaved= contactService.saveMessageDetails(contact);
	    		if(issaved==true)
	    		{
	    			 return ResponseEntity.status(HttpStatus.CREATED).body("Message saved successfully!");
	    		}
	    	 }
		 

	        // Process valid data (e.g., save to database)
	        return ResponseEntity.status(HttpStatus.CREATED).body("Message saved successfully!");

	    }
	     
	     
	     @PostMapping("closeMsg")
	     public String closeMsg(@RequestParam int id) {
	       
	    	 //contactService.updateMsgStatus(id,authentication.getName());
	         return "redirect:/displayMessages";
	     }

}
