package com.Hospital_App.Hospital.Management.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.Hospital_App.Hospital.Management.System.Model"})

public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

}
