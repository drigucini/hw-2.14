package pro.sky.MockitoTestinghw.Service;

import pro.sky.MockitoTestinghw.Model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstname, String lastName, int department, int salary);

    Employee removeEmployee(String firstname, String lastName);

    Employee findEmployee(String firstname, String lastName);

    Collection<Employee> findAll();
}



