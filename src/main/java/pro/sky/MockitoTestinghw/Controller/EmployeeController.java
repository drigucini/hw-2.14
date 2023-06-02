package pro.sky.MockitoTestinghw.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.MockitoTestinghw.Model.Employee;
import pro.sky.MockitoTestinghw.Service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") int department,
                                @RequestParam("salary") int salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/findAll")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}