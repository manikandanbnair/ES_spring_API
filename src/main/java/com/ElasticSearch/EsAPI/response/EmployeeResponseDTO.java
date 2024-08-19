package com.ElasticSearch.EsAPI.response;






import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;

public class EmployeeResponseDTO {
    private String id; // Changed from Long to String
    private String name;
    private String designation;
    private String email;
    private String department;
    private String mobile;
    private String location;
    
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime dateOfJoining;
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime createdTime;
  
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime updatedTime;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) { // Fixed setter parameter type
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OffsetDateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(OffsetDateTime offsetDateTime) {
        this.dateOfJoining = offsetDateTime;
    }

    public OffsetDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(OffsetDateTime offsetDateTime) {
        this.createdTime = offsetDateTime;
    }

    public OffsetDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(OffsetDateTime offsetDateTime) {
        this.updatedTime = offsetDateTime;
    }
}
