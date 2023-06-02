package pro.sky.MockitoTestinghw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.MockitoTestinghw.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.MockitoTestinghw.Exceptions.EmployeeNotFoundException;
import pro.sky.MockitoTestinghw.Model.Employee;
import pro.sky.MockitoTestinghw.Service.EmployeeService;
import pro.sky.MockitoTestinghw.Service.EmployeeServiceImplemented;

import java.util.Collection;

public class EmployeeServiceImplementedTest {

    private final EmployeeService employeeService = new EmployeeServiceImplemented();


    @Test
    public void shouldThrowExceptionWhenEmployeeAlreadyExists() {
        //given
        Employee employee = new Employee("Dmitry", "Smirnoff", 2, 350_000);
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        //when & then
        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary())
        );
    }

    @Test
    public void shouldReturnCorrectEmployee() {
        //given
        Employee employee = new Employee("Dmitry", "Smirnoff", 2, 350_000);

        //when
        Employee addedEmployee = employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        // then
        Assertions.assertEquals(employee, addedEmployee);
    }

    @Test
    public void shouldThrowExceptionWhenTryingToRemoveNonExistentEmployee() {
        //given
        Employee employee = new Employee("Dmitry", "Smirnoff", 2, 350_000);

        //when & then
        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee(employee.getFirstName(), employee.getLastName())
        );
    }

    @Test
    public void shouldRemoveAndReturnCorrectEmployee() {
        //given
        Employee employee = new Employee("Dmitry", "Smirnoff", 2, 350_000);
        Employee addedEmployee = employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        //when
        employeeService.removeEmployee(employee.getFirstName(), employee.getLastName());

        // then
        Assertions.assertEquals(employee, addedEmployee);
    }

    @Test
    public void shouldThrowExceptionWhenTryingToFindNonExistentEmployee() {
        //given
        Employee employee = new Employee("Dmitry", "Smirnoff", 2, 350_000);
        Employee employee2 = new Employee("Ivan", "Belov", 1, 70_000);
        Employee employee3 = new Employee("Sergei", "Yar", 2, 500_000);

        //when
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getDepartment(), employee2.getSalary());
        employeeService.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getDepartment(), employee3.getSalary());

        // & then
        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(employee.getFirstName(), employee.getLastName())
        );
    }

    @Test
    public void shouldFindCorrectEmployee() {
        //given
        Employee employee1 = new Employee("Dmitry", "Smirnoff", 2, 350_000);
        Employee employee2 = new Employee("Ivan", "Belov", 1, 70_000);
        Employee employee3 = new Employee("Sergei", "Yar", 2, 500_000);

        //when
        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getDepartment(), employee1.getSalary());
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getDepartment(), employee2.getSalary());
        employeeService.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getDepartment(), employee3.getSalary());

        // & then
        Assertions.assertEquals(employee1, employeeService.findEmployee(employee1.getFirstName(), employee1.getLastName()));
    }

    @Test
    public void shouldReturnCorrectEmployees() {
        //given
        Employee employee1 = new Employee("Dmitry", "Smirnoff", 2, 350_000);
        Employee employee2 = new Employee("Ivan", "Belov", 1, 70_000);
        Employee employee3 = new Employee("Sergei", "Yar", 2, 500_000);

        employeeService.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getDepartment(), employee1.getSalary());
        employeeService.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getDepartment(), employee2.getSalary());
        employeeService.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getDepartment(), employee3.getSalary());

        //when
        Collection<Employee> allEmployees = employeeService.findAll();

        // then
        Assertions.assertTrue(allEmployees.contains(employee1));
        Assertions.assertTrue(allEmployees.contains(employee2));
        Assertions.assertTrue(allEmployees.contains(employee3));

    }
}
