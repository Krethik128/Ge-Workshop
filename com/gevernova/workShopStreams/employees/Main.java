package gevernova.workShopStreams.employees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Stream.of(
                new Employee(101, "Alice", "HR", 26, 55000, "Pune", Arrays.asList("alice@company.com", "alice.hr@company.com")),
                new Employee(102, "Bob", "Finance", 33, 72000, "Delhi", Arrays.asList("bob@company.com")),
                new Employee(103, "Charlie", "IT", 28, 88000, "Bangalore", Arrays.asList("charlie@company.com", "charlie.dev@company.com")),
                new Employee(104, "David", "HR", 35, 67000, "Pune", Arrays.asList("david.hr@company.com")),
                new Employee(105, "Eve", "IT", 29, 99000, "Delhi", Arrays.asList("eve@company.com")),
                new Employee(106, "Frank", "Finance", 41, 120000, "Mumbai", Arrays.asList("frank@company.com")),
                new Employee(107, "Grace", "Marketing", 25, 45000, "Pune", Arrays.asList("grace@company.com")),
                new Employee(108, "Heidi", "IT", 31, 110000, "Bangalore", Arrays.asList("heidi@company.com", "heidi.it@company.com")),
                new Employee(109, "Ivan", "Finance", 38, 78000, "Chennai", Arrays.asList("ivan@company.com")),
                new Employee(110, "Judy", "Marketing", 27, 48000, "Delhi", Arrays.asList("judy@company.com"))
        ).toList();

        // List all employees working in Pune, sorted by name
        System.out.println("Employees in Pune (sorted):");
        employeeList.stream()
                .filter(emp -> emp.getCity().equalsIgnoreCase("Pune"))
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(emp -> System.out.println(emp.getName()));

        System.out.println("\nEmployees in IT department under 30:");
        // Find all employees in IT department younger than 30
        employeeList.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("IT"))
                .filter(emp -> emp.getAge() < 30)
                .forEach(emp -> System.out.println(emp.getName()));

        //Create a list of all email addresses (flatten List<List<String>> using flatMap).
        List<String> emails=employeeList.stream()
                .flatMap(x->x.getEmails().stream())
                .toList();
        System.out.println(emails);

        //Find if all employees are from the same city.
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCity))
                .forEach((key,val)->{
                    System.out.println("City -"+key);
                    val.forEach(e-> System.out.println(e.getName()));
                });
        //Using EntrySet
//        employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getCity))
//                .entrySet()
//                .forEach(entry-> {
//                            System.out.println("city- " + entry.getKey());
//                            entry.getValue().forEach(e-> System.out.println(e.getName()));
//                        });



        //Skip first 2 highest-paid and get next 3.
        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(2)
                .findFirst()
                .ifPresentOrElse(
                       employee ->  System.out.println("3rd highest salary is :"+employee.getName()+" with "+employee.getSalary()),
                        ()-> System.out.println("No 3rd highest available from given data set")
                );

        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(emp-> System.out.println(emp.getName()));

        //Group employees by city and find the average salary in each city.
        System.out.println(employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCity,Collectors.averagingDouble(Employee::getSalary))));
    }
}
