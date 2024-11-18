package com.example.demo.audit;

import java.util.Optional;


//import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
           // return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    	 return Optional.of("admin"); 
    }
}