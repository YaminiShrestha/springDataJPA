package com.ttn.bootcamp.springDataJPA.employee.service;

import com.ttn.bootcamp.springDataJPA.employee.entities.Employee;
import com.ttn.bootcamp.springDataJPA.employee.respository.EmployeePageRepository;
import com.ttn.bootcamp.springDataJPA.employee.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeePageRepository employeePageRepository;

    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }


    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);

    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }


    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> saveList(List<Employee> employees) {
        return (List<Employee>) employeeRepository.saveAll(employees);
    }


    public Employee update(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setLocation(employee.getLocation());
        return employeeRepository.save(existingEmployee);
    }


    public String delete(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee removed" + id;
    }


    public String count() {
        int count = (int) employeeRepository.count();
        return "Total count of Employee is " + count;
    }

    public List<Employee> getPageSortedOnAge(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc(sortBy)));
        Page<Employee> pagedResult = employeePageRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }

    public List<Employee> findByNameLikeEmployee() {
        return employeeRepository.findByNameLike("A%");
    }

    public List<Employee> findByAgeBetweenEmployee(int age1, int age2) {
        return employeeRepository.findByAgeBetween(age1, age2);
    }
}



