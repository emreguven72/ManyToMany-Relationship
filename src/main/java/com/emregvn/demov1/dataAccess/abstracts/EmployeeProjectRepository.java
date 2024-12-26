package com.emregvn.demov1.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emregvn.demov1.entities.concretes.EmployeeProject;

@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Integer> {
	List<EmployeeProject> findByEmployeeId(int id);
	List<EmployeeProject> findByProjectId(int id);
	
}
