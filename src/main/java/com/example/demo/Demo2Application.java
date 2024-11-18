package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.config.ProjectConfig;

import com.example.demo.entity.Person3;
import com.example.demo.entity.Song;
import com.example.demo.entity.Vehicle;


@SpringBootApplication
@EnableDiscoveryClient

public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
		
		
		AnnotationConfigApplicationContext	 context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // Vehicle veh = context.getBean(Vehicle.class);
       // Vehicle veh = context.getBean("vehicle1",Vehicle.class);
      //  Vehicle veh = context.getBean("audiVehicle",Vehicle.class);
        
//        Vehicle veh = context.getBean(Vehicle.class);
//        
//        
//        System.out.println("Vehicle name from Spring Context is: " + veh.getName());
        
        
      
//			  Vehicle vehicle = context.getBean(Vehicle.class);
//			  System.out.println("Component Vehicle name from " + "Spring Context is: " + vehicle.getName());
//			  vehicle.printHello();
			  
			  
			  
			  
			  Person3 person = context.getBean(Person3.class);
		        Vehicle vehicle = context.getBean(Vehicle.class);
		        System.out.println("Person name from Spring Context is: " + person.getName());
		        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());
		        System.out.println("Vehicle that Person own is: " + person.getVehicle());
		        
		        
//		        
//		        VehicleServices vehicleServices = context.getBean(VehicleServices.class);
//		        System.out.println(vehicleServices.getClass());
//		        Song song = new Song();
//		        song.setTitle("Blank Space");
//		        song.setSingerName("Taylor Swift");
//		        boolean vehicleStarted = true;
//		        String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
//		       // String playMusicStatus = vehicleServices.playMusic(vehicleStarted,song);
//		        String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);
		        
			  context.close();
			  
			  

        
        
	}

}
