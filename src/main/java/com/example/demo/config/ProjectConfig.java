package com.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration

@ComponentScan(basePackages = {"com.example.demo.serviceImpl","com.example.demo.entity","com.example.demo.repository",
        "com.example.demo.service", "com.example.demo.aspects","com.example.demo.audit"})
@EnableAspectJAutoProxy


@EnableJpaRepositories("com.example.demo.repository")
@EntityScan("com.example.demo.entity")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ProjectConfig {

	
	 @Bean(name="audiVehicle")
	Vehicle vehicle1()
	{
		Vehicle v= new Vehicle();
		v.setName("Audi");
		
		return v;
	}
	
	
	  @Bean
	    Vehicle vehicle2() {
		  Vehicle veh = new Vehicle();
	        veh.setName("Honda");
	        return veh;
	    }

	  @Primary
	    @Bean
	    Vehicle vehicle3() {
	    	Vehicle veh = new Vehicle();
	        veh.setName("Ferrari");
	        return veh;
	    }
	  
	  
	 
}

