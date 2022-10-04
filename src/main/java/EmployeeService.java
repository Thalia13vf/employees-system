import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class EmployeeService {

    public List<Employee> findAllEmployees() {
        return Arrays.asList(new Employee("Max", 17),
                new Employee("Sepp", 18),
                new Employee("Nina", 15),
                new Employee("Mike", 51));
    }

    public List<Employee> findEmployees18OrOlder() {
        return findAllEmployees()
                .stream()
                .filter(employee -> employee.getIdade() >= 18)
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .peek(employee -> employee.setName(employee.getName().toUpperCase()))
                .toList();

    }

}
