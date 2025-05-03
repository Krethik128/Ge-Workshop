package gevernova.workShopStreams.employees;

import java.util.List;

class Employee {
    private int id;
    private String name;
    private String department;
    private int age;
    private double salary;
    private String city;
    private List<String> emails;

    public Employee(int id, String name,String department ,int age,double salary , String city, List<String> emails) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.city = city;
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public List<String> getEmails() {
        return emails;
    }
}
