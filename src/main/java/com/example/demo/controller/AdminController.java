package com.example.demo.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EazyClass;
import com.example.demo.entity.Person1;
import com.example.demo.exception.ErrorResponse;
import com.example.demo.repository.EazyClassRepository;
import com.example.demo.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@RestController
@RequestMapping("admin/")
public class AdminController {

	
	
	 @Autowired
	    EazyClassRepository eazyClassRepository;

	    @Autowired
	    PersonRepository personRepository;

	    @PostMapping("/displayClasses")
	    public ResponseEntity<ErrorResponse> displayClasses() throws JsonProcessingException {
	      
	    	
	    	List<EazyClass> eazyClasses = eazyClassRepository.findAll();
	       
 	    	ObjectMapper objectMapper = new ObjectMapper();
 	    	objectMapper.registerModule(new JavaTimeModule());
	    	String json = objectMapper.writeValueAsString(eazyClasses);
	       
	    	
	        return ResponseEntity.
	        		status(HttpStatus.SC_OK)
	        		.body(new ErrorResponse(HttpStatus.SC_OK,json));
	    }

	    @PostMapping("/addNewClass")
	    public ResponseEntity<ErrorResponse>  addNewClass(@RequestBody EazyClass eazyClass) {
	        
	    	System.out.println(eazyClass.toString());
	    	
	    	
	    	eazyClassRepository.save(eazyClass);
	      
	        return ResponseEntity.
	        		status(HttpStatus.SC_CREATED)
	        		.body(new ErrorResponse(HttpStatus.SC_CREATED,"class added"));
	    }

	    @PostMapping("/deleteClass")
	    public ResponseEntity<ErrorResponse> deleteClass(@RequestParam int id) {
	     
	    	Optional<EazyClass> eazyClass = eazyClassRepository.findById(id);
	        
	    	for(Person1 person : eazyClass.get().getPersons()){
	           
	    		person.setEazyClass(null);
	            personRepository.save(person);
	        }
	    	
	        eazyClassRepository.deleteById(id);
	       
	        return ResponseEntity.
	        		status(HttpStatus.SC_OK)
	        		.body(new ErrorResponse(HttpStatus.SC_OK,"class delete"));
	    }
//
//	    @GetMapping("/displayStudents")
//	    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession session,
//	                                        @RequestParam(value = "error", required = false) String error) {
//	        String errorMessage = null;
//	        ModelAndView modelAndView = new ModelAndView("students.html");
//	        Optional<EazyClass> eazyClass = eazyClassRepository.findById(classId);
//	        modelAndView.addObject("eazyClass",eazyClass.get());
//	        modelAndView.addObject("person",new Person());
//	        session.setAttribute("eazyClass",eazyClass.get());
//	        if(error != null) {
//	            errorMessage = "Invalid Email entered!!";
//	            modelAndView.addObject("errorMessage", errorMessage);
//	        }
//	        return modelAndView;
//	    }
//
	    @PostMapping("/addStudent")
	    public ResponseEntity<ErrorResponse> addStudent(@RequestBody Person1 person, HttpSession session) {
	       
	    	System.out.println(person.toString());
	    	
//	        EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
	        
	        Optional<EazyClass> eazyClasses = eazyClassRepository.findById(3);
	        
	        System.out.println("find class"+eazyClasses.get().toString());
	        Person1 personEntity = personRepository.readByEmail(person.getEmail());
	     
	        
	        System.out.println("find person"+personEntity.toString());
	        
	        if(personEntity==null || !(personEntity.getPersonId()>0)){
	           
	        }
	        
	        personEntity.setEazyClass(eazyClasses.get());
	        
	        System.out.println("added class"+personEntity.toString());
	        
	        personRepository.save(personEntity);
	        
	        System.out.println("save person"+personEntity.toString());
	        
	        eazyClasses.get().getPersons().add(personEntity);
	        
	        
	        
	        eazyClassRepository.save(eazyClasses.get());
	        
	        System.out.println("check classes"+eazyClasses.get().toString());
	        
	     
	        return ResponseEntity.
	        		status(HttpStatus.SC_OK)
	        		.body(new ErrorResponse(HttpStatus.SC_OK,"class and student added"));
	    }
//
//	    @GetMapping("/deleteStudent")
//	    public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession session) {
//	        EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
//	        Optional<Person> person = personRepository.findById(personId);
//	        person.get().setEazyClass(null);
//	        eazyClass.getPersons().remove(person.get());
//	        EazyClass eazyClassSaved = eazyClassRepository.save(eazyClass);
//	        session.setAttribute("eazyClass",eazyClassSaved);
//	        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayStudents?classId="+eazyClass.getClassId());
//	        return modelAndView;
//	    }
//	}
	    
	    
	    
//	    
//	    @GetMapping("/displayCourses")
//	    public ModelAndView displayCourses(Model model) {
//	        List<Courses> courses = coursesRepository.findAll();
//	        ModelAndView modelAndView = new ModelAndView("courses_secure.html");
//	        modelAndView.addObject("courses",courses);
//	        modelAndView.addObject("course", new Courses());
//	        return modelAndView;
//	    }
//
//	    @PostMapping("/addNewCourse")
//	    public ModelAndView addNewCourse(Model model, @ModelAttribute("course") Courses course) {
//	        ModelAndView modelAndView = new ModelAndView();
//	        coursesRepository.save(course);
//	        modelAndView.setViewName("redirect:/admin/displayCourses");
//	        return modelAndView;
//	    }
//
//	    @GetMapping("/viewStudents")
//	    public ModelAndView viewStudents(Model model, @RequestParam int id
//	                 ,HttpSession session,@RequestParam(required = false) String error) {
//	        String errorMessage = null;
//	        ModelAndView modelAndView = new ModelAndView("course_students.html");
//	        Optional<Courses> courses = coursesRepository.findById(id);
//	        modelAndView.addObject("courses",courses.get());
//	        modelAndView.addObject("person",new Person());
//	        session.setAttribute("courses",courses.get());
//	        if(error != null) {
//	            errorMessage = "Invalid Email entered!!";
//	            modelAndView.addObject("errorMessage", errorMessage);
//	        }
//	        return modelAndView;
//	    }
//
//	    @PostMapping("/addStudentToCourse")
//	    public ModelAndView addStudentToCourse(Model model, @ModelAttribute("person") Person person,
//	                                           HttpSession session) {
//	        ModelAndView modelAndView = new ModelAndView();
//	        Courses courses = (Courses) session.getAttribute("courses");
//	        Person personEntity = personRepository.readByEmail(person.getEmail());
//	        if(personEntity==null || !(personEntity.getPersonId()>0)){
//	            modelAndView.setViewName("redirect:/admin/viewStudents?id="+courses.getCourseId()
//	                    +"&error=true");
//	            return modelAndView;
//	        }
//	        personEntity.getCourses().add(courses);
//	        courses.getPersons().add(personEntity);
//	        personRepository.save(personEntity);
//	        session.setAttribute("courses",courses);
//	        modelAndView.setViewName("redirect:/admin/viewStudents?id="+courses.getCourseId());
//	        return modelAndView;
//	    }
//
//	    @GetMapping("/deleteStudentFromCourse")
//	    public ModelAndView deleteStudentFromCourse(Model model, @RequestParam int personId,
//	                                                HttpSession session) {
//	        Courses courses = (Courses) session.getAttribute("courses");
//	        Optional<Person> person = personRepository.findById(personId);
//	        person.get().getCourses().remove(courses);
//	        courses.getPersons().remove(person);
//	        personRepository.save(person.get());
//	        session.setAttribute("courses",courses);
//	        ModelAndView modelAndView = new
//	                ModelAndView("redirect:/admin/viewStudents?id="+courses.getCourseId());
//	        return modelAndView;
//	    }
}
