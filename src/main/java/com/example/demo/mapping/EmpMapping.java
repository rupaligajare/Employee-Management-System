package com.example.demo.mapping;

import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Employee;

public class EmpMapping {
	
	 public static EmpDto mapToEmpDto(Employee employee) {
	     
	        return new EmpDto(
	            employee.getId(),
	            employee.getFirstName(),
	            employee.getLastName(),
	            employee.getEmail()
	        );
	 }
	 
	  public static Employee mapToEmp(EmpDto empDto) {
	      
	        return new Employee(
	            empDto.getId(),
	            empDto.getFirstName(),
	            empDto.getLastName(),
	            empDto.getEmail()
	        );
	    }
}
