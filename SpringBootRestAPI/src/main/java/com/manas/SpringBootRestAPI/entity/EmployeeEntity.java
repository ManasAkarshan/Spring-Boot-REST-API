package com.manas.SpringBootRestAPI.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dataOfJoining;
    private boolean isActive;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name, boolean isActive, LocalDate dataOfJoining) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.dataOfJoining = dataOfJoining;
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

    public LocalDate getDataOfJoining() {
        return dataOfJoining;
    }

    public void setDataOfJoining(LocalDate dataOfJoining) {
        this.dataOfJoining = dataOfJoining;
    }
}
