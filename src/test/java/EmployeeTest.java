
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {

    @InjectMocks
    private EmployeeService employeeService;

    private static List<Employee> employeesList;

    @BeforeAll
    public static void setUp(){
        employeesList = Arrays.asList(new Employee("Max", 17),
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51));
    }

    @Test
    @DisplayName("Get a list with all employees")
    public void searchAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();

        Assertions.assertEquals(employees, employeesList);
    }

    @Test
    @DisplayName("The shop owner whats to see a list of employees who are 18 years old or older")
    public void getEmployeesWhoAre18OrOlder() {
        List<Employee> employees18OrOlder = employeeService.findEmployees18OrOlder();

        Assertions.assertEquals(employees18OrOlder.get(0).getName(), employeesList.get(1).getName().toUpperCase());
        Assertions.assertEquals(employees18OrOlder.get(1).getName(), employeesList.get(3).getName().toUpperCase());
        Assertions.assertTrue(employees18OrOlder.get(0).getIdade() >=18);
        Assertions.assertTrue(employees18OrOlder.get(1).getIdade() >= 18);
    }

    @Test
    @DisplayName("The shop owner wants to see the employees list sorted by name")
    public void getEmployeesWhoAre18OrOlderSortByName(){
        List<Employee> employees18OrOlderSortByName = employeeService.findEmployees18OrOlder();

        Assertions.assertEquals(employees18OrOlderSortByName.get(0).getName(), employeesList.get(1).getName().toUpperCase());
        Assertions.assertEquals(employees18OrOlderSortByName.get(1).getName(), employeesList.get(3).getName().toUpperCase());

    }

    @Test
    @DisplayName("The shop owner wants to see the employees list sorted by name")
    public void getEmployeesWhoAre18OrOlderSortByNameCapitelized(){
        List<Employee> employees18OrOlderSortByNameAndCapitelized = employeeService.findEmployees18OrOlder();

        Assertions.assertEquals(employees18OrOlderSortByNameAndCapitelized.get(0).getName().toUpperCase(),"SEPP");
        Assertions.assertEquals(employees18OrOlderSortByNameAndCapitelized.get(1).getName().toUpperCase(),"MIKE");
    }

    @Test
    @DisplayName("The owner shop wants to see the employess list sorted by their names in desceding order")
    public void getEmployeesWhoAre18OrOlderSortByNameCapitelizedDescending(){
        List<Employee> employees18OrOlderSortByNameAndCapitelized = employeeService.findEmployees18OrOlder();


        Assertions.assertEquals(employees18OrOlderSortByNameAndCapitelized.get(0).getName(), "SEPP");
        Assertions.assertEquals(employees18OrOlderSortByNameAndCapitelized.get(1).getName(), "MIKE");
    }
}
