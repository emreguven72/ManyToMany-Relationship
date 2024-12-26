package com.emregvn.demov1.webApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emregvn.demov1.business.abstracts.ProjectService;
import com.emregvn.demov1.business.requests.CreateProjectRequest;
import com.emregvn.demov1.business.responses.GetAllProjectsResponse;
import com.emregvn.demov1.business.responses.GetProjectByIdResponse;
import com.emregvn.demov1.business.responses.GetProjectsByEmployeeIdResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectsController {
	private ProjectService projectService;
	
	@GetMapping()
	public List<GetAllProjectsResponse> getAll() {
		return this.projectService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetProjectByIdResponse getById(int id) {
		return this.projectService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateProjectRequest createProjectRequest) {
		this.projectService.add(createProjectRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.projectService.delete(id);
	}
	
	@GetMapping("/{employeeId}/projects")
	public List<GetProjectsByEmployeeIdResponse> getProjectsByEmployeeId(@PathVariable int employeeId) {
		return this.projectService.getProjectsByEmployeeId(employeeId);
	}
	
}
