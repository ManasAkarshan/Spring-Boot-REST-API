package com.manas.SpringBootRestAPI.controller;

import com.manas.SpringBootRestAPI.dto.EmployeeDTO;
import com.manas.SpringBootRestAPI.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //    GET  /employees/
    @GetMapping("/")
    public List<EmployeeDTO> getEmployees(){
//        return new EmployeeDTO(12L, "Manas", true, LocalDate.of(2024, 11, 28));
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") long id){
        return service.getEmployeeById(id);
    }

//    @GetMapping("/")  // http://localhost:8080/employee?sortBy=age&limit=10  Hello age 10
//    public String getData(@PathParam("sortBy") String sortBy){
//        return "Hello "+sortBy;
//    }


//    POST /employees

    @PostMapping("/")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO emp){
        return service.createNewEmployee(emp);
    }

//    PUT
//    DELETE /employees/{id}

    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable long id){
        return service.deleteEmployeeById(id);
    }

    @GetMapping("/active")
    public List<EmployeeDTO> getActiveUsers() {
        return service.getActiveUsers();
    }
    

}
