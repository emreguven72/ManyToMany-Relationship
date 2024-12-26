package com.emregvn.demov1.business.concretes;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emregvn.demov1.business.abstracts.EmployeeService;
import com.emregvn.demov1.business.requests.CreateEmployeeRequest;
import com.emregvn.demov1.business.responses.GetAllEmployeesResponse;
import com.emregvn.demov1.business.responses.GetEmployeeByIdResponse;
import com.emregvn.demov1.business.responses.GetEmployeesByProjectIdResponse;
import com.emregvn.demov1.core.mappers.ModelMapperService;
import com.emregvn.demov1.dataAccess.abstracts.EmployeeProjectRepository;
import com.emregvn.demov1.dataAccess.abstracts.EmployeeRepository;
import com.emregvn.demov1.entities.concretes.Employee;
import com.emregvn.demov1.entities.concretes.EmployeeProject;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	private EmployeeProjectRepository employeeProjectRepository;

	@Override
	public List<GetAllEmployeesResponse> getAll() {
		List<Employee> employees = employeeRepository.findAll();

		List<GetAllEmployeesResponse> employeesResponses = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeesResponse.class))
				.toList();

		return employeesResponses;
	}

	@Override
	public GetEmployeeByIdResponse getById(int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow();

		GetEmployeeByIdResponse employeeResponse = this.modelMapperService.forResponse().map(employee,
				GetEmployeeByIdResponse.class);

		return employeeResponse;
	}

	@Override
	public void add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = new Employee();

		employee.setName(createEmployeeRequest.getName());
		employee.setProjects(new HashSet<EmployeeProject>());

		this.employeeRepository.save(employee);
	}

	@Override
	public void delete(int id) {
		this.employeeRepository.deleteById(id);
	}

	@Override
	public List<GetEmployeesByProjectIdResponse> getEmployeesByProjectId(int projectId) {
		List<EmployeeProject> employeeProjects = this.employeeProjectRepository.findByProjectId(projectId);

		return employeeProjects.stream().map(ep -> {
			GetEmployeesByProjectIdResponse response = new GetEmployeesByProjectIdResponse();

			response.setId(ep.getEmployee().getId());
			response.setName(ep.getEmployee().getName());

			return response;
		}).toList();
	}

}
