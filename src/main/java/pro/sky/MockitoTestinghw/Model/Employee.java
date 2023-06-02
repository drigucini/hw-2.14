package pro.sky.MockitoTestinghw.Model;



import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private int salary;


    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.department = department;
        this.salary = salary;

    }

    public String getFirstName() {
        return firstName;
    }

    @Transient
    public String getFullName() {
        return firstName + lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Full name: " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }
}