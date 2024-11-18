package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contact;

public interface ContactService {
	
	
	public boolean saveMessageDetails(Contact contact);
	
	public List<Contact> findMsgsWithOpenStatus();
	
	
	public boolean updateMsgStatus(int contactId, String updatedBy);

}
