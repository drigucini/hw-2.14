package pro.sky.MockitoTestinghw.Service;


import org.springframework.stereotype.Service;
import pro.sky.MockitoTestinghw.Model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImplemented implements DepartmentService{

    private final EmployeeService employeeService;

    public DepartmentServiceImplemented(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> getEmployeeMinSalary(Integer departmentID){
        Collection<Employee> employees = employeeService.findAll();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentID)
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getEmployeeMaxSalary(Integer departmentID){
        Collection<Employee> employees = employeeService.findAll();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentID)
                .max(Comparator.comparing(Employee::getSalary));
    }
    @Override
    public List<Employee> getEmployeesByDepartment(Integer departmentID){
        Collection<Employee> employees = employeeService.findAll();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentID)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments(){
        Collection<Employee> employees = employeeService.findAll();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
