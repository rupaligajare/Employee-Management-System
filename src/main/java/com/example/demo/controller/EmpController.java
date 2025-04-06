package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDto;
import com.example.demo.service.EmpService;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

	@Autowired
	private EmpService empService;
	 
	// Build add emp rest api
	
	@PostMapping
	public ResponseEntity<EmpDto> createEmp(@RequestBody EmpDto empDto){
		EmpDto savedEmp = empService.createEmp(empDto);
		return new ResponseEntity<>(savedEmp,HttpStatus.CREATED);	
	}
	
	// build get emp rest api
	
	@GetMapping("{id}")
	public ResponseEntity<EmpDto> getEmpById(@PathVariable("id") Long empId){
		EmpDto empDto = empService.getEmpById(empId);
		return ResponseEntity.ok(empDto);
	}
	
	//build get all emp rest api
	
	@GetMapping
	public ResponseEntity<List<EmpDto>> getAllEmp(){
		List<EmpDto> employees = empService.getAllEmp();
		
		return ResponseEntity.ok(employees);
	}
	
	//update emp rest api
	
	@PutMapping("{id}")
	public ResponseEntity<EmpDto> updateEmp(@PathVariable("id") Long empId, @RequestBody EmpDto updatedEmp){
		EmpDto empDto = empService.updateEmp(empId, updatedEmp);
		return ResponseEntity.ok(empDto);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Long empId){
		empService.deleteEmp(empId);
		return ResponseEntity.ok("Employee deleted successfully");
	}
	
}
