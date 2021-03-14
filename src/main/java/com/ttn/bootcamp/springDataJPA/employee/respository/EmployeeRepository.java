package com.ttn.bootcamp.springDataJPA.employee.respository;

import com.ttn.bootcamp.springDataJPA.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByAgeBetween(int age1,int age2);
    List<Employee> findByNameLike(String name);


}

