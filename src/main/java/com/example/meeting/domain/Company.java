package com.example.meeting.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Province location;
    @NotNull
    private Integer totalEmployeeNumber;

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

    public Province getLocation() {
        return location;
    }

    public void setLocation(Province location) {
        this.location = location;
    }

    public Integer getTotalEmployeeNumber() {
        return totalEmployeeNumber;
    }

    public void setTotalEmployeeNumber(Integer totalEmployeeNumber) {
        this.totalEmployeeNumber = totalEmployeeNumber;
    }
}
