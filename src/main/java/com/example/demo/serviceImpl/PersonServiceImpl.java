package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.EazySchoolConstants;
import com.example.demo.entity.Person1;
import com.example.demo.entity.Roles;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.RolesRepository;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl  implements PersonService{

	 @Autowired
	    private PersonRepository personRepository;

	    @Autowired
	    private RolesRepository rolesRepository;
	
	
	@Override
	public boolean createNewPerson(Person1 person) {
		// TODO Auto-generated method stub
		boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        //person.setRoles(role);
       
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
	}

}
