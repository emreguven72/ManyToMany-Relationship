package com.emregvn.demov1.business.abstracts;

import java.util.List;

import com.emregvn.demov1.business.requests.CreateProjectRequest;
import com.emregvn.demov1.business.responses.GetAllProjectsResponse;
import com.emregvn.demov1.business.responses.GetProjectByIdResponse;
import com.emregvn.demov1.business.responses.GetProjectsByEmployeeIdResponse;

public interface ProjectService {
	List<GetAllProjectsResponse> getAll();

	GetProjectByIdResponse getById(int id);

	void add(CreateProjectRequest createProjectRequest);

	void delete(int id);
	
	List<GetProjectsByEmployeeIdResponse> getProjectsByEmployeeId(int employeeId);
}
