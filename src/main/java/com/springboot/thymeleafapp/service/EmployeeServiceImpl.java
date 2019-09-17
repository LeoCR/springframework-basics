package com.springboot.thymeleafapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.springboot.thymeleafapp.dao.EmployeeRepository;
import com.springboot.thymeleafapp.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee= result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
