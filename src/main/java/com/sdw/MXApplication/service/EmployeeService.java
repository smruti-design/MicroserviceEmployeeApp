package com.sdw.MXApplication.service;

import com.sdw.MXApplication.model.Address;
import com.sdw.MXApplication.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>(List.of(
            Employee.builder().id(1)
                    .email("smruti.digiworl@gmail.com")
                    .phone(1234567890)
                    .address(Address.builder()
                            .city("Bhubaneswar")
                            .country("India")
                            .street("Sachivalaya Marg").build())
                    .name("Smruti")
                    .build() ,
            Employee.builder().id(2)
                    .email("alex@gmail.com")
                    .phone(123888890)
                    .address(Address.builder()
                            .city("Bangalore")
                            .country("India")
                            .street("Church Street").build())
                    .name("Alex Hales")
                    .build() ,
            Employee.builder().id(3)
                    .email("jacob@gmail.com")
                    .phone(1494567890)
                    .address(Address.builder()
                            .city("Mumbai")
                            .country("India")
                            .street("Srichatrapati Shivaji")
                            .build())
                    .name("Jacob ")
                    .build()
    ));

    public List<Employee> getAllEmployee(){
        return employeeList;
    }

    public Employee getEmployeeByID(int id){
        return employeeList.stream()
                .filter(x -> x.getId() == id)
                .findFirst().get();
    }

    public List<Employee> addEmployee(Employee employee){
        employeeList.add(employee);
        return employeeList;
    }

    public Employee updateEmployee(int id, Employee employee){
        return employeeList.stream()
                .filter(x -> x.getId() == id)
                .peek(o -> o.setName(employee.getName()))
                .peek(o -> o.setEmail(employee.getEmail()))
                .peek(o -> o.setPhone(employee.getPhone()))
                .findFirst().get();
    }

    public List<Employee> deleteEmployee(int id){
        employeeList.removeIf(x -> x.getId() == id);
        return employeeList;
    }

}
