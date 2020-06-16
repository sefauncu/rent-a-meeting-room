package com.example.meeting.dto;

public class CompanyDTO {
    private Long id;
    private String name;
    private Long locationId;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Integer getTotalEmployeeNumber() {
        return totalEmployeeNumber;
    }

    public void setTotalEmployeeNumber(Integer totalEmployeeNumber) {
        this.totalEmployeeNumber = totalEmployeeNumber;
    }
}
