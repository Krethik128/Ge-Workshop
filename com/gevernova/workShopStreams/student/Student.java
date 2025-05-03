package gevernova.workShopStreams.student;

import java.util.List;

class Student {

    private int id;
    private String firstName;
    private int age;
    private String gender;
    private String dept;
    private String city;
    private int rank;

    private List<String> contacts;


    public Student(int id, String firstName, int age, String gender, String dept, String city, int rank,List<String>contacts) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.city = city;
        this.rank = rank;
        this.contacts = contacts;

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    public int getRank() {
        return rank;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public String getCity() {
        return city;
    }
}
