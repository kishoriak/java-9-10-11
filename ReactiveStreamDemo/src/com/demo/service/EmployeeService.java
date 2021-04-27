package com.demo.service;
import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Employee;

public class EmployeeService {
	

	
		public static List<Employee> getEmps() {

			Employee e1 = new Employee(1, "Rajas");
			Employee e2 = new Employee(2, "Devendra");
			Employee e3 = new Employee(3, "Tejas");
			Employee e4 = new Employee(4, "Aradhya");
			Employee e5 = new Employee(5, "Anupam");
			
			List<Employee> emps = new ArrayList<>();
			emps.add(e1);
			emps.add(e2);
			emps.add(e3);
			emps.add(e4);
			emps.add(e5);
			
			return emps;
		}
}
