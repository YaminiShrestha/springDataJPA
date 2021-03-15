package com.ttn.bootcamp.springDataJPA.employee.entities;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String location;

}
