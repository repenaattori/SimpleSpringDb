package com.db.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.db.example.data.Company;
import com.db.example.data.Employee;
import com.db.example.repo.CompanyRepository;
import com.db.example.repo.EmployeeRepository;

@Service
public class CompanyService {

    CompanyRepository companyRepository;
    EmployeeRepository employeeRepository;

    public CompanyService(CompanyRepository companyRepository, EmployeeRepository employeeRepository){
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    public void saveCompany(Company company){
        companyRepository.save(company);
    }
    
    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getEmpoyees(){
        return employeeRepository.findAll();
    }

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    /**
     * Etsii työntekijän yrityksen
     */
    public Company getEmployeeCompany(int employeeId){
        
        //Haetaan työntekijä kannasta id:llä
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        //Tarkistaa löytyikö työntekijä
        if(employee.isEmpty()){
            return null;
        }

        //Haetaan työntekijän yrityksen id
        int companyId = employee.get().companyId;
        
        
        //Palautetaan yritys id:n perusteella kannasta 
        //(ei tarvitse tarkistaa, koska jos työntekijä löytyy, täytyy myös company id olla validi foreign key)
        return companyRepository.findById( companyId ).get();
    }
}
