package com.adityo.springboot.soap.application;

import com.adityo.springboot.soap.interfaces.DeleteEmployeeResponse;
import com.adityo.springboot.soap.interfaces.UpdateEmployeeRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.adityo.springboot.soap.entities.Employee;
import com.adityo.springboot.soap.interfaces.AddEmployeeRequest;
import com.adityo.springboot.soap.interfaces.AddEmployeeResponse;
import com.adityo.springboot.soap.interfaces.DeleteEmployeeRequest;
import com.adityo.springboot.soap.interfaces.EmployeeInfo;
import com.adityo.springboot.soap.interfaces.GetEmployeeByIdRequest;
import com.adityo.springboot.soap.interfaces.GetEmployeeResponse;
import com.adityo.springboot.soap.interfaces.ServiceStatus;
import com.adityo.springboot.soap.interfaces.UpdateEmployeeResponse;
import com.adityo.springboot.soap.serviceImpl.EmployeeService;

@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://interfaces.soap.springboot.adityo.com";

	@Autowired
	private EmployeeService employeeService;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.AddEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.updateEmployee(employee);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		employeeService.deleteEmployee(request.getEmployeeId());
		ServiceStatus serviceStatus = new ServiceStatus();

		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Deleted Successfully");
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

}
