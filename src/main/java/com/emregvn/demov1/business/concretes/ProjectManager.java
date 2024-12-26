package com.emregvn.demov1.business.concretes;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emregvn.demov1.business.abstracts.ProjectService;
import com.emregvn.demov1.business.requests.CreateProjectRequest;
import com.emregvn.demov1.business.responses.GetAllProjectsResponse;
import com.emregvn.demov1.business.responses.GetProjectByIdResponse;
import com.emregvn.demov1.business.responses.GetProjectsByEmployeeIdResponse;
import com.emregvn.demov1.core.mappers.ModelMapperService;
import com.emregvn.demov1.dataAccess.abstracts.EmployeeProjectRepository;
import com.emregvn.demov1.dataAccess.abstracts.ProjectRepository;
import com.emregvn.demov1.entities.concretes.EmployeeProject;
import com.emregvn.demov1.entities.concretes.Project;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectManager implements ProjectService {
	private ProjectRepository projectRepository;
	private ModelMapperService modelMapperService;
	private EmployeeProjectRepository employeeProjectRepository;

	@Override
	public List<GetAllProjectsResponse> getAll() {
		List<Project> projects = this.projectRepository.findAll();
		List<GetAllProjectsResponse> projectsResponses = projects.stream()
				.map(project -> this.modelMapperService.forResponse().map(project, GetAllProjectsResponse.class))
				.toList();

		return projectsResponses;
	}

	@Override
	public GetProjectByIdResponse getById(int id) {
		Project project = this.projectRepository.findById(id).orElseThrow();

		GetProjectByIdResponse projectResponse = this.modelMapperService.forResponse().map(project,
				GetProjectByIdResponse.class);

		return projectResponse;
	}

	@Override
	public void add(CreateProjectRequest createProjectRequest) {
		Project project = new Project();

		project.setName(createProjectRequest.getName());
		project.setEmployees(new HashSet<EmployeeProject>());

		this.projectRepository.save(project);
	}

	@Override
	public void delete(int id) {
		this.projectRepository.deleteById(id);
	}

	@Override
	public List<GetProjectsByEmployeeIdResponse> getProjectsByEmployeeId(int employeeId) {
		List<EmployeeProject> employeeProjects = this.employeeProjectRepository.findByEmployeeId(employeeId);

		return employeeProjects.stream().map(ep -> {
			GetProjectsByEmployeeIdResponse response = new GetProjectsByEmployeeIdResponse();

			response.setId(ep.getProject().getId());
			response.setName(ep.getProject().getName());

			return response;
		}).toList();
	}

}
