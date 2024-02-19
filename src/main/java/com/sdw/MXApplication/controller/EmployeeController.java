package com.sdw.MXApplication.controller;

import com.sdw.MXApplication.model.Address;
import com.sdw.MXApplication.model.Employee;
import com.sdw.MXApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.sdw.MXApplication.model.Employee.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/employee")
    public List<Employee> getEmployeeList(){
        return employeeService.getAllEmployee();
    }


    @RequestMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployeeByID(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/employee")
    public List<Employee> postEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee putEmployee(@RequestBody Employee employee, @PathVariable int id){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }
}
