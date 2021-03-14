package com.ttn.bootcamp.springDataJPA.employee.controller;

import com.ttn.bootcamp.springDataJPA.employee.entities.Employee;
import com.ttn.bootcamp.springDataJPA.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.save(employee);

    }

    @PostMapping(path = "/addList")
    public List<Employee> addList(@RequestBody List<Employee> employees) {
        return employeeService.saveList(employees);

    }

    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/get/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping("/findByName")
    public List<Employee> findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }

    @GetMapping("/count")
    public String count() {
        return employeeService.count();
    }

    @GetMapping("/sortedOnAge")
    public List<Employee> getAllPage(
            @RequestParam("pageNo") Integer pageNo,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("age") String sortBy) {
        List<Employee> list = employeeService.getPageSortedOnAge(pageNo, pageSize, sortBy);

        return list;
    }

    @GetMapping("/like/{name}")
    @ResponseBody
    public List<Employee> findByNameLike(@PathVariable String name) {

        List<Employee> employeeResponse = (List<Employee>) employeeService.findByNameLikeEmployee(name);
        return employeeResponse;
    }

    @GetMapping("/findByAgeBetween")
    public List<Employee> getEmployeeFindByAgeBetween(@RequestParam("Age1") int age1, @RequestParam("Age2") int age2) {
        return employeeService.findByAgeBetweenEmployee(age1, age2);
    }

    @GetMapping("/findByNameLike")
    public List<Employee> findBYNameLike(@RequestParam String name) {
        return employeeService.findByNameLikeEmployee("%a" + name);
    }
}


