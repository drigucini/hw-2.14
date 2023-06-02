package pro.sky.MockitoTestinghw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.MockitoTestinghw.Model.Employee;
import pro.sky.MockitoTestinghw.Service.DepartmentServiceImplemented;
import pro.sky.MockitoTestinghw.Service.EmployeeServiceImplemented;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplementedTest {
    @Mock
    private EmployeeServiceImplemented employeeServiceImplemented;

    @InjectMocks
    private DepartmentServiceImplemented departmentServiceImplemented;


    @Test
    public void shouldReturnEmployeeWithMaxSalaryByDepartment() {
        //given
        final int departmentID = 2;

        Employee employee1 = new Employee("Dmitry", "Smirnoff", departmentID, 350_000);
        Employee employee2 = new Employee("Ivan", "Belov", departmentID, 70_000);
        Employee employee3 = new Employee("Sergei", "Yar", departmentID, 500_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put(employee1.getFullName(), employee1);
        employees.put(employee2.getFullName(), employee2);
        employees.put(employee3.getFullName(), employee3);

        when(departmentServiceImplemented.getEmployeesByDepartment(departmentID)).thenReturn((List<Employee>) employees);

        //when

        Optional<Employee> emloyeewithMaxSalary = departmentServiceImplemented.getEmployeeMaxSalary(departmentID);

        //then
        Assertions.assertEquals(employee3,emloyeewithMaxSalary);

    }
}
