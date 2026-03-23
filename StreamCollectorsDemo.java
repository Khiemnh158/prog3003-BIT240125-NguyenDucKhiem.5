import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Class Employee
class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class StreamCollectorsDemo {
    public static void main(String[] args) {
        // Tạo danh sách 4 nhân viên
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Nguyen Van C", 1500),
            new Employee(2, "Le Thi A", 900),
            new Employee(3, "Tran Van B", 1200),
            new Employee(4, "Pham Thi D", 850)
        );

        // Xử lý bằng Stream
        List<String> result = employees.stream()
                .filter(emp -> emp.getSalary() > 1000) // 1. Lọc nhân viên lương > 1000
                .map(Employee::getName)                // Lấy ra danh sách tên
                .sorted()                              // 2. Sắp xếp Alpha-beta
                .collect(Collectors.toList());         // 3. Gom kết quả về một List

        // In kết quả
        System.out.println("Danh sách nhân viên có lương > 1000 (đã sắp xếp):");
        result.forEach(System.out::println);
    }
}