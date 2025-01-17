package com.manas.SpringBootRestAPI.services;

import com.manas.SpringBootRestAPI.dto.EmployeeDTO;
import com.manas.SpringBootRestAPI.entity.EmployeeEntity;
import com.manas.SpringBootRestAPI.exception.EmployeeNotFoundException;
import com.manas.SpringBootRestAPI.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    //@Autowired   // we can also use constructor injection instead of this
    final EmployeeRepository repo;

    final ModelMapper modelMapper;

    public EmployeeService(ModelMapper modelMapper, EmployeeRepository repo) {
        this.modelMapper = modelMapper;
        this.repo = repo;
    }

    public EmployeeDTO getEmployeeById(long id){
        return repo.findById(id)
        .map(entity -> modelMapper.map(entity, EmployeeDTO.class)) // Convert entity to DTO
        .orElseThrow(EmployeeNotFoundException::new);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO emp) {
        EmployeeEntity entity = modelMapper.map(emp, EmployeeEntity.class);
        return modelMapper.map(repo.save(entity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees(){
        return repo.findAll().stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(long id){
        boolean isPresent = repo.existsById(id);
        if(!isPresent) return false;
        repo.deleteById(id);
        return true;
    }

    public List<EmployeeDTO> getActiveUsers() {
        List<EmployeeEntity> activeUsers = repo.findByIsActive(true);
        return activeUsers.stream().map(employeeEntity->modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());
    }
}
