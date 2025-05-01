package gevernova.workShopFour;

import java.util.*;
import java.util.List;

public class Department implements Methods{
	String deptName;
	List<Employee> employees;

	public Department(String deptName){
		this.deptName=deptName;
		employees=new ArrayList<>();
	}
	public void addEmployee(Employee emp){
		employees.add(emp);
	}
	public String getDept(){
		return deptName;
	}

	@Override
	public void getHighestSalary(){
		double maxSalary=0;
		String name=" ";
		for(Employee emp:employees){
			if(emp.getSalary()>maxSalary){
				maxSalary=emp.getSalary();
				name=emp.getName();
			}
		}
		System.out.println("Maximum salary of "+deptName+" is "+name+" of salary "+maxSalary);
	}
	public void SetValues(ArrayList<Employee> details){
        details.addAll(employees);
	}

}