package com.adityo.springboot.soap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adityo.springboot.soap.entities.Employee;
import com.adityo.springboot.soap.repo.EmployeeRepository;
import com.adityo.springboot.soap.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	 @Autowired
	 EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee getEmployeeById(long employeeId) {
		
		Employee obj = employeeRepository.findByEmployeeId(employeeId);
		return obj;
		
	}

	@Override
	public void AddEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);

	}
	
}
