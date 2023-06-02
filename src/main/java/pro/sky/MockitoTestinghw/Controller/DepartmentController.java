package pro.sky.MockitoTestinghw.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.MockitoTestinghw.Model.Employee;
import pro.sky.MockitoTestinghw.Service.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalary(@RequestParam("departmentID") Integer departmentID) {
        Optional<Employee> optionalEmployee = departmentService.getEmployeeMinSalary(departmentID);
        return optionalEmployee.orElse(null);
    }
    @GetMapping("/max-salary")
    public Employee getEmployeeMaxSalary(@RequestParam("departmentID") Integer departmentID) {
        Optional<Employee> optionalEmployee = departmentService.getEmployeeMaxSalary(departmentID);
        return optionalEmployee.orElse(null);
    }
    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam("departmentID") Integer departmentID) {
        return departmentService.getEmployeesByDepartment(departmentID);
    }
    @GetMapping("/findAll")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartments() {
        return departmentService.getAllEmployeesByDepartments();
    }
}
