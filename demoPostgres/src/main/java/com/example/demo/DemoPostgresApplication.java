package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Employee;
import com.example.demo.repo.*;

@SpringBootApplication
public class DemoPostgresApplication implements CommandLineRunner{
	@Autowired
   private EmployeeRepo employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(DemoPostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = getEmployee();
		employeeRepo.save(emp);
		
	}
	private Employee getEmployee()
	{
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Udit");
		return emp;
		
	}

}
