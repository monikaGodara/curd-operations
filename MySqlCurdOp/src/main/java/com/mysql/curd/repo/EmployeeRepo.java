package com.mysql.curd.repo;

import org.springframework.stereotype.Repository;

import com.mysql.curd.entity.Employee;

import org.springframework.data.jpa.repository.*;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{

	
}
