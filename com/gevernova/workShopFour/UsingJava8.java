package gevernova.workShopFour;
import java.util.*;

public class UsingJava8 {

	public static void main(String[] args){
		Employee emp1=new Employee("Krethik",450000.7);
        Employee emp2=new Employee("Ana",50000.5);
        Employee emp3=new Employee("Stuti",750000.8);
        Employee emp4=new Employee("Ben",450000.50);
        Employee emp5=new Employee("Sam",678000.9);

        Department dept1=new Department("HR");
        dept1.addEmployee(emp1);
        dept1.addEmployee(emp2);
        dept1.addEmployee(emp5);

        Department dept2=new Department("Technical");
        dept2.addEmployee(emp3);
        dept2.addEmployee(emp4);

        ArrayList<Employee> dept1Details=new ArrayList<>();
        ArrayList<Employee> dept2Details=new ArrayList<>();

        dept1.SetValues(dept1Details);
        dept2.SetValues(dept2Details);

//       dept1Details.stream()
//       		.sorted(Comparator.comparingDouble(Employee::getSalary))
//               .limit(1)
//               .forEach(x->System.out.println(x.getName()+" "+x.getSalary()));

            Employee miniSalaryEmpDept1 = Collections.min(dept1Details, Comparator.comparingDouble(Employee::getSalary));
            System.out.println("Min salary in dept1: " + miniSalaryEmpDept1.getName() + " " + miniSalaryEmpDept1.getSalary());

            Employee maxiSalaryEmpDept1 = Collections.max(dept1Details, Comparator.comparingDouble(Employee::getSalary));
            System.out.println("Max salary in dept1: " + maxiSalaryEmpDept1.getName() + " " + maxiSalaryEmpDept1.getSalary());


            Employee miniSalaryEmpDept2 = Collections.min(dept2Details, Comparator.comparingDouble(Employee::getSalary));
            System.out.println("Min salary in dept2: " + miniSalaryEmpDept2.getName() + " " + miniSalaryEmpDept2.getSalary());

            Employee maxiSalaryEmpDept2 = Collections.max(dept2Details, Comparator.comparingDouble(Employee::getSalary));
            System.out.println("Max salary in dept2: " + maxiSalaryEmpDept2.getName() + " " + maxiSalaryEmpDept2.getSalary());

//
//            dept2Details.stream()
//                .sorted((employee1,employee2)-> (int) (employee2.getSalary()-employee1.getSalary()))
//                .limit(1)
//                .forEach(x->System.out.println(x.getName()+" "+x.getSalary()));
//

	}
}