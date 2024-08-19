package com.ElasticSearch.EsAPI.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.time.OffsetDateTime;

@Document(indexName = "empmanager")
public class EmployeeManagerModel {

    @Id
    private String id;

    private String name;
    private String designation;
    private String email;
    private String department;
    private String mobile;
    private String location;
    private String managerId;

    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime dateOfJoining;
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime createdTime;
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private OffsetDateTime updatedTime;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public OffsetDateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(OffsetDateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public OffsetDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(OffsetDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public OffsetDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(OffsetDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "EmployeeManagerModel [id=" + id + ", name=" + name + ", designation=" + designation + ", email=" + email
                + ", department=" + department + ", mobile=" + mobile + ", location=" + location + ", managerId="
                + managerId + ", dateOfJoining=" + dateOfJoining + ", createdTime=" + createdTime + ", updatedTime="
                + updatedTime + "]";
    }

    
}
