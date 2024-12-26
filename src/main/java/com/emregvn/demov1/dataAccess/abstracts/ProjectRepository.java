package com.emregvn.demov1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emregvn.demov1.entities.concretes.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
