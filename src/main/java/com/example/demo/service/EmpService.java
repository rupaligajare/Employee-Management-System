package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmpDto;

public interface EmpService {
		
	  
		EmpDto createEmp(EmpDto empDto);
		
		EmpDto getEmpById(Long empId);
		
		List<EmpDto> getAllEmp();
		
		EmpDto updateEmp(Long empId, EmpDto updatedEmp);
		
		void deleteEmp(Long empId);
		
}
