package com.ElasticSearch.EsAPI.repositories;



import org.springframework.stereotype.Repository;

import com.ElasticSearch.EsAPI.model.EmployeeManagerModel;


import java.time.OffsetDateTime;
import java.util.List;


@Repository
public interface EmployeeManagerCustomRepository {

    List<EmployeeManagerModel> getAllEmployees();
    
    EmployeeManagerModel findByIdCustom(String id);

    EmployeeManagerModel findByExistingManagerId(String managerId);
    
    EmployeeManagerModel findManagerByDepartment(String department);
    
    List<EmployeeManagerModel> getEmployeesByManagerIdAndJoiningDate(String managerId, OffsetDateTime dateOfJoining);
    
    List<EmployeeManagerModel> findByManagerId(String managerId);
    
    List<EmployeeManagerModel> findByDepartment(String department);

    //List<EmployeeManagerModel> findByDateOfJoiningBefore(OffsetDateTime minJoiningDate);
}
