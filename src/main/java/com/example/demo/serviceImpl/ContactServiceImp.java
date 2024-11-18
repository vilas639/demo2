package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.EazySchoolConstants;
import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

import java.util.Optional;

@Service
public class ContactServiceImp  implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	ContactServiceImp(ContactRepository contactRepository)
	{
		this.contactRepository=contactRepository;
	}
	
	@Override
	public boolean saveMessageDetails(Contact contact) {
		// TODO Auto-generated method stub
		
		boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
      //  contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
       // contact.setCreatedAt(LocalDateTime.now());
        
       
        Contact savedContact = contactRepository.save(contact);
        
        if(null != savedContact && savedContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
        
	}

	@Override
	public List<Contact> findMsgsWithOpenStatus() {
		// TODO Auto-generated method stub
		List<Contact> contactMsgs = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
	}

	@Override
	public boolean updateMsgStatus(int contactId, String updatedBy) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		
        Optional<Contact> contact = contactRepository.findById(contactId);
        
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EazySchoolConstants.CLOSE);
           // contact1.setUpdatedBy(updatedBy);
            //contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
	}

	
	
	
}
