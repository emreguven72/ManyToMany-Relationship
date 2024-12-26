package com.emregvn.demov1.business.abstracts;

import java.util.List;

import com.emregvn.demov1.business.requests.CreateEmployeeRequest;
import com.emregvn.demov1.business.responses.GetAllEmployeesResponse;
import com.emregvn.demov1.business.responses.GetEmployeeByIdResponse;
import com.emregvn.demov1.business.responses.GetEmployeesByProjectIdResponse;

public interface EmployeeService {
	List<GetAllEmployeesResponse> getAll();

	GetEmployeeByIdResponse getById(int id);

	void add(CreateEmployeeRequest createEmployeeRequest);
	
	void delete(int id);
	
	List<GetEmployeesByProjectIdResponse> getEmployeesByProjectId(int projectId);
}
