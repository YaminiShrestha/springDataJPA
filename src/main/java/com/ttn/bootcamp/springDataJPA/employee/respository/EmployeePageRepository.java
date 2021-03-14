package com.ttn.bootcamp.springDataJPA.employee.respository;

import com.ttn.bootcamp.springDataJPA.employee.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePageRepository extends PagingAndSortingRepository<Employee,Integer> {
}
