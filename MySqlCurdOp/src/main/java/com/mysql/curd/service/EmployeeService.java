package com.mysql.curd.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.curd.entity.Employee;
import com.mysql.curd.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getAllEmployee()
	{
		return employeeRepo.findAll();
		
	} 
	public Employee savedata(Employee emp)
	{
		
		Employee savesEmployee= employeeRepo.save(emp);
		return savesEmployee;
	}
	public void deleteEmp(Employee emp) {
		employeeRepo.deleteById(emp.getId());
		
	}
	@Transactional
	public void updateEmp(Employee emp) {
		 employeeRepo.findById(emp.getId()).ifPresent(emp1->{
			emp1.setName(emp.getName());
			employeeRepo.save(emp1);
		});
		
		
	} 
}
