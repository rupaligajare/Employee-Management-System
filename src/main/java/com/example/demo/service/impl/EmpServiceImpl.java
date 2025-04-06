package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmpDto;
import com.example.demo.entity.Employee;
import com.example.demo.mapping.EmpMapping;
import com.example.demo.repo.EmpRepo;
import com.example.demo.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepo empRepo;
	
	@Override
	public EmpDto createEmp(EmpDto empDto) {
		
		Employee employee = EmpMapping.mapToEmp(empDto);
		Employee savedEmp=empRepo.save(employee);
			
		return EmpMapping.mapToEmpDto(savedEmp); 
	}

	@Override
	public EmpDto getEmpById(Long empId) {
		
		Employee employee= empRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not exists"+ empId));
		return EmpMapping.mapToEmpDto(employee);
	}

	@Override
	public List<EmpDto> getAllEmp() {
		
		List<Employee> employees = empRepo.findAll();
		return employees.stream().map((employee)-> EmpMapping.mapToEmpDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmpDto updateEmp(Long empId, EmpDto updatedEmp) {
		
		Employee employee=empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee not present"));
		
		employee.setFirstName(updatedEmp.getFirstName());
		employee.setLastName(updatedEmp.getLastName());
		employee.setEmail(updatedEmp.getEmail());
		
		Employee updEmpObj= empRepo.save(employee);
		return EmpMapping.mapToEmpDto(updEmpObj);
	}

	@Override
	public void deleteEmp(Long empId) {
		Employee employee = empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee does not exist" + empId));
		empRepo.deleteById(empId);
	}
	
}
