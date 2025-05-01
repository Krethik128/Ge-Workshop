//Find Highest Paid Employee Per Department
//🔸 Task: From the employee list, find the highest paid employee in each department
/*class Employee {
    String name;
    double salary;
    // constructor, getters
}
*/
package gevernova.workShopFour;

public class Main{
    public static void main(String args[]){
        Employee emp1=new Employee("Krethik",450000.7);
        Employee emp2=new Employee("Ana",50000.5);
        Employee emp3=new Employee("Stuti",750000.8);
        Employee emp4=new Employee("Ben",450000.50);
        Employee emp5=new Employee("Sam",678000.9);

        Department dept1=new Department("HR");
        dept1.addEmployee(emp1);
        dept1.addEmployee(emp2);

        Department dept2=new Department("Technical");
        dept2.addEmployee(emp3);
        dept2.addEmployee(emp4);



        dept1.getHighestSalary();
        dept2.getHighestSalary();
    }
}