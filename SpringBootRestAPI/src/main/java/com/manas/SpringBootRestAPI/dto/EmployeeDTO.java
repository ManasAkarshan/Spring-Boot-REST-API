package com.manas.SpringBootRestAPI.dto;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, boolean isActive, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getdateOfJoining() {
        return dateOfJoining;
    }

    public void setdateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
