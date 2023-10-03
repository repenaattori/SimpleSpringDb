package com.db.example.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.example.data.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {    
}
