
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    @DisplayName("Get a list with all employees")
    public void searchAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();

        Assertions.assertFalse(employees.isEmpty());
    }

    @Test
    @DisplayName("The shop owner whats to see a list of employees who are 18 years old or older")
    public void getEmployeesWhoAre18OrOlder() {
        List<Employee> employees18OrOlder = employeeService.findEmployees18OrOlder();

        Assertions.assertNotNull(employees18OrOlder);
    }

    @Test
    @DisplayName("The shop owner wants to see the employees list sorted by name")
    public void getEmployeesWhoAre18OrOlderSortByName(){
        List<Employee> employees18OrOlderSortByName = employeeService.findEmployees18OrOlder();
        List<String> employessName = employees18OrOlderSortByName.stream()
                .map(Employee::getName)
                .map(String::toLowerCase)
                .toList();

        Assertions.assertLinesMatch(Arrays.asList("mike", "sepp"), employessName);
    }

    @Test
    @DisplayName("The shop owner wants to see the employees list sorted by name")
    public void getEmployeesWhoAre18OrOlderSortByNameCapitelized(){
        List<Employee> employees18OrOlderSortByNameAndCapitelized = employeeService.findEmployees18OrOlder();

        List<String> employessName = employees18OrOlderSortByNameAndCapitelized
                .stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .toList();

        Assertions.assertLinesMatch(Arrays.asList("MIKE", "SEPP"), employessName);
    }

    @Test
    @DisplayName("The owner shop wants to see the employess list sorted by their names in desceding order")
    public void getEmployeesWhoAre18OrOlderSortByNameCapitelizedDescending(){
        List<Employee> employees18OrOlderSortByNameAndCapitelized = employeeService.findEmployees18OrOlder();

        List<String> employessName = employees18OrOlderSortByNameAndCapitelized
                .stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .toList();

        Assertions.assertLinesMatch(Arrays.asList("SEPP", "MIKE"), employessName);
    }
}
