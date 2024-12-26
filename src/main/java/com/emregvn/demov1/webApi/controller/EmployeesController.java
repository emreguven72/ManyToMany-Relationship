package com.emregvn.demov1.webApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emregvn.demov1.business.abstracts.EmployeeService;
import com.emregvn.demov1.business.requests.CreateEmployeeRequest;
import com.emregvn.demov1.business.responses.GetAllEmployeesResponse;
import com.emregvn.demov1.business.responses.GetEmployeeByIdResponse;
import com.emregvn.demov1.business.responses.GetEmployeesByProjectIdResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
	private EmployeeService employeeService;

	@GetMapping()
	public List<GetAllEmployeesResponse> getAll() {
		return this.employeeService.getAll();
	}

	@GetMapping("/{id}")
	public GetEmployeeByIdResponse getById(int id) {
		return this.employeeService.getById(id);
	}

	@PostMapping()
	public void add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		this.employeeService.add(createEmployeeRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.employeeService.delete(id);
	}

	@GetMapping("/{projectId}/employees")
	public List<GetEmployeesByProjectIdResponse> getEmployeesByProjectId(@PathVariable int projectId) {
		return this.employeeService.getEmployeesByProjectId(projectId);
	}

}
