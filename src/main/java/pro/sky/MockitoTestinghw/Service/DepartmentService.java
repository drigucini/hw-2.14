package pro.sky.MockitoTestinghw.Service;


import pro.sky.MockitoTestinghw.Model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {

    Optional<Employee> getEmployeeMinSalary(Integer departmentID);

    Optional<Employee> getEmployeeMaxSalary(Integer departmentID);

    List<Employee> getEmployeesByDepartment(Integer departmentID);

    Map<Integer, List<Employee>> getAllEmployeesByDepartments();
}
