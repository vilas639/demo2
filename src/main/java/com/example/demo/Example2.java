package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.ProjectConfig;
import com.example.demo.entity.Vehicle;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext	 context = new AnnotationConfigApplicationContext(ProjectConfig.class);
	        // Vehicle veh = context.getBean(Vehicle.class);
	        Vehicle veh = context.getBean("vehicle1",Vehicle.class);
	        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

	}

}
