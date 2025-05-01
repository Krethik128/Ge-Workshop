package gevernova.workShopFour;

public class Employee{
    String name;
    double salary;
    public Employee(String name,double salary){
        this.name= name;
        this.salary=salary;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getName(){
        return this.name;
    }

}
