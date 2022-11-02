package com.db.example.data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Long companyId;

    public Employee() {}

    public Employee(String name, Long companyId) {
        this.name = name;
        this.companyId = companyId;
    }

}
