package com.ElasticSearch.EsAPI;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ElasticSearch.EsAPI.model.EmployeeManagerModel;
import com.ElasticSearch.EsAPI.repositories.EmpImpl;
import com.ElasticSearch.EsAPI.repositories.EmployeeManagerRepository;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RepoTest {



    @Mock
    private EmployeeManagerRepository employeeManagerRepository;

    @InjectMocks
    private EmpImpl empImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEmployeesSortedById() {

        EmployeeManagerModel e1 = new EmployeeManagerModel();
        e1.setId("1002");
        e1.setName("Employee 2");

        EmployeeManagerModel e2 = new EmployeeManagerModel();
        e2.setId("1001");
        e2.setName("Employee 1");

        EmployeeManagerModel e3 = new EmployeeManagerModel();
        e3.setId("1003");
        e3.setName("Employee 3");
        List<EmployeeManagerModel> unsortedEmployees = Arrays.asList(e1, e2, e3);

        // Mock repository behavior
        when(employeeManagerRepository.findAll()).thenReturn(unsortedEmployees);

        // Call the service method
        List<EmployeeManagerModel> sortedEmployees = empImpl.getAllEmployees();

        // Verify the result
        assertEquals(3, sortedEmployees.size());
        assertEquals("1001", sortedEmployees.get(0).getId()); // First element should have the smallest ID
        assertEquals("1002", sortedEmployees.get(1).getId()); // Second element should have the next smallest ID
        assertEquals("1003", sortedEmployees.get(2).getId()); // Last element should have the largest ID
    }


    @Test
    public void testFindByIdCustom() {
        String id = "1001";
        EmployeeManagerModel employee = new EmployeeManagerModel();
        employee.setId(id);

        when(employeeManagerRepository.findById(id)).thenReturn(Optional.of(employee));

        EmployeeManagerModel result = empImpl.findByIdCustom(id);

        assertEquals(id, result.getId());
    }

    @Test
    public void testFindByExistingManagerId() {
        String managerId = "1002";
        EmployeeManagerModel employee = new EmployeeManagerModel();
        employee.setManagerId(managerId);

        when(employeeManagerRepository.findById(managerId)).thenReturn(Optional.of(employee));

        EmployeeManagerModel result = empImpl.findByExistingManagerId(managerId);

        assertEquals(managerId, result.getManagerId());
    }

    @Test
    public void testFindManagerByDepartment() {
        String department = "IT";
        EmployeeManagerModel employee = new EmployeeManagerModel();
        employee.setDepartment(department);

        when(employeeManagerRepository.findByDepartment(department)).thenReturn(Arrays.asList(employee));

        EmployeeManagerModel result = empImpl.findManagerByDepartment(department);

        assertEquals(department, result.getDepartment());
    }

    @Test
    public void testGetEmployeesByManagerIdAndJoiningDate() {
        String managerId = "1003";
        OffsetDateTime dateOfJoining = OffsetDateTime.now();
        EmployeeManagerModel employee = new EmployeeManagerModel();
        employee.setManagerId(managerId);
        employee.setDateOfJoining(dateOfJoining);

        when(employeeManagerRepository.findByManagerIdAndDateOfJoiningBefore(managerId, dateOfJoining))
            .thenReturn(Arrays.asList(employee));

        List<EmployeeManagerModel> result = empImpl.getEmployeesByManagerIdAndJoiningDate(managerId, dateOfJoining);

        assertEquals(1, result.size());
        assertEquals(managerId, result.get(0).getManagerId());
    }

    @Test
    public void testFindByManagerId() {
        String managerId = "1004";
        EmployeeManagerModel employee = new EmployeeManagerModel();
        employee.setManagerId(managerId);

        when(employeeManagerRepository.findByManagerId(managerId)).thenReturn(Arrays.asList(employee));

        List<EmployeeManagerModel> result = empImpl.findByManagerId(managerId);

        assertEquals(1, result.size());
        assertEquals(managerId, result.get(0).getManagerId());
    }

    @Test
    public void testFindByDepartment() {
        String department = "HR";
        EmployeeManagerModel employee = new EmployeeManagerModel();
        employee.setDepartment(department);

        when(employeeManagerRepository.findByDepartment(department)).thenReturn(Arrays.asList(employee));

        List<EmployeeManagerModel> result = empImpl.findByDepartment(department);

        assertEquals(1, result.size());
        assertEquals(department, result.get(0).getDepartment());
    }
}