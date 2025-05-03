package gevernova.workShopStreams.student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .toList();

        //Find the list of students whose rank is in between 50 and 100
        System.out.println("1.Find the list of students whose rank is in between 50 and 100");
        studentList.stream().
                filter(student -> student.getRank() >= 50 && student.getRank() <= 100)
                .forEach(students -> System.out.println(students.getFirstName() + " "));
        System.out.println("\n");

        //Find the Students who stays in Karnataka and sort them by their names
        System.out.println("2.Find the Students who stays in Karnataka and sort them by their names");
        List<Student> karnatakaStudentNames=studentList.stream()
                .filter(student -> student.getCity().equalsIgnoreCase("karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList();

        System.out.println("Students who stays in karnataka and their names in sorted");
        karnatakaStudentNames.forEach(object->System.out.print(object.getFirstName()+" "));
        System.out.println("\n");

        //Find all departments names
        System.out.println("3.All the department names");
        studentList.stream()
                .map(Student::getDept)
                .distinct()
                .forEach(System.out::println);
        System.out.println("\n");

        //Find all the contact numbers
        System.out.println("4.All the contact nums ");
        List<String> contactNum=studentList.stream()
                .flatMap(student -> student.getContacts().stream())
                .toList();
        System.out.println(contactNum);
        System.out.println("\n");


        //Group The Student By Department Names
        System.out.println("5.Group The Student By Department Names ");
        studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept))
                .forEach((deptName, students2) -> {
                    System.out.println(deptName);
                        students2.forEach(student ->
                            System.out.println(student.getFirstName()));
        });
        System.out.println("\n");

        // Find the department who is having maximum number of students
        System.out.println("6. Find the department with the maximum number of students:");

        String deptWithMaxStudents = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No department");

        System.out.println("Max students are in: " + deptWithMaxStudents);
        System.out.println("\n");


        System.out.println("7.Find the average age of male and female students");
        System.out.println(studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge))));
        System.out.println("\n");


        System.out.println("8.Find the highest rank in each department");
          studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept))
                .forEach((deptName, students2) -> {
                    System.out.println(deptName);
                    students2.stream()
                            .max(Comparator.comparingInt(Student::getRank))
                            .ifPresentOrElse(
                                    student -> System.out.println("Name " + student.getFirstName() + " marks " + student.getRank()),
                                    () -> System.out.println("Not present")
                            );
                }
        );
        System.out.println("\n");


        System.out.println("9.Find the student who has second rank");
         studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept))
                .forEach((deptName, students2) -> {
                    System.out.println("Dept Name: " + deptName);
                    students2.stream()
                            .sorted(Comparator.comparingInt(Student::getRank))
                            .skip(1)
                            .findFirst()
                            .ifPresentOrElse(
                                    student -> System.out.println("Name " + student.getFirstName() + " marks " + student.getRank()),
                                    () -> System.out.println("Not present")
                            );
                });

//         studentList.stream()
//                 .sorted(Comparator.comparingInt(Student::getRank).reversed())
//                 .skip(1)
//                 .findFirst()
//                 .ifPresentOrElse(
//                         student -> System.out.println("Name "+student.getFirstName()+" marks "+student.getRank()),
//                         ()-> System.out.println("Not present")
//                 );


    }

}
