package com.mysql.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mysql.curd.entity.Employee;
import com.mysql.curd.service.EmployeeService;

@RestController

public class EmployeeController {

	
	
	@Autowired
	private EmployeeService empService;
	@GetMapping("/getemp")
	public List<Employee> getAllEmployee()
	{
		return empService.getAllEmployee();
		
	}
	
	
	
	  @RequestMapping(value = "/save", headers = {
	            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	  public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		  Employee savesEmployee= this.empService.savedata(emp);
		  return new ResponseEntity<>(savesEmployee,HttpStatus.CREATED) ;
	  }
	 
	  @DeleteMapping("/deleteEmp")
	  public ResponseEntity<String>deleteEmp(@RequestBody Employee emp){
		  empService.deleteEmp(emp);
		  return new ResponseEntity<String>("record delete",HttpStatus.CREATED);
		  
	  }
	  
	  @PutMapping("/updateEmp")
	  public ResponseEntity<String>updateEmp(@RequestBody Employee emp){
		  empService.updateEmp(emp);
		  return new ResponseEntity<String>("record updated",HttpStatus.CREATED);
		  
	  }
	  
	  
}
