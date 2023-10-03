package com.db.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.example.data.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
}

