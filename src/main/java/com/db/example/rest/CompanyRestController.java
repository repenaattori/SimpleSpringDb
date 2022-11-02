package com.db.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.db.example.data.Company;
import com.db.example.data.Employee;

import com.db.example.service.CompanyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Esimerkissä käytetään tietokantaa, jossa on employee ja company taulut ja yhteys niiden välillä
 * (employee working for company)
 */

@RestController
public class CompanyRestController {

    @Autowired
    CompanyService companySercive;

    @PostMapping("addcompany")
    public String addCompany(@RequestBody Company company) {
        companySercive.saveCompany(company);
        return "Ok";
    }

    @PostMapping("addemployee")
    public String addEmployee(@RequestBody Employee employee) {
        companySercive.saveEmployee(employee);
        return "Ok";
    }

    @GetMapping("employees")
    public List<Employee> getEmployess(){
        return companySercive.getEmpoyees();
    }

    @GetMapping("companies")
    public List<Company> getCompanies(){
        return companySercive.getCompanies();
    }

    @GetMapping("employeecompany")
    public Company getEmployeeCompany(@RequestParam Long employeeId){
        return companySercive.getCustomerCompany(employeeId);
    }
  
}
