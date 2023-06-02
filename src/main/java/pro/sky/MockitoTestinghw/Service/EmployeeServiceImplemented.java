package pro.sky.MockitoTestinghw.Service;

import org.springframework.stereotype.Service;
import pro.sky.MockitoTestinghw.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.MockitoTestinghw.Exceptions.EmployeeNotFoundException;
import pro.sky.MockitoTestinghw.Exceptions.InvalidInputException;
import pro.sky.MockitoTestinghw.Model.Employee;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImplemented implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImplemented () {
        employees = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstname, String lastName, int department, int salary) {
        validateInput(firstname, lastName);
        Employee employee = new Employee(firstname, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Such employee already exists");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstname, String lastName) {
        validateInput(firstname, lastName);
        Employee employee = findEmployee(firstname, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee findEmployee(String firstname, String lastName)  {
        validateInput(firstname, lastName);
        String key = firstname + lastName;
        if (employees.containsKey(key)) {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}