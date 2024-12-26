package com.emregvn.demov1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emregvn.demov1.entities.concretes.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
