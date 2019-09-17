package com.springboot.thymeleafapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.thymeleafapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllByOrderByLastNameAsc();
}
