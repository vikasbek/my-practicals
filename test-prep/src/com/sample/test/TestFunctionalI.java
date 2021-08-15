package com.sample.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@FunctionalInterface
interface VehicleA {
	default void printSomething() {
		System.out.println("VA");
	}
	static void iamStatic() {
		System.out.println("VA static");
	}
	void foo();
}
interface VehicleB {
	default void printSomething() {
		System.out.println("VB");
	}
}

class Bus implements VehicleA, VehicleB {

	@Override
	public void printSomething() {
		VehicleA.super.printSomething();
	}
	
	@Override
	public void foo() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		VehicleA v = new Bus();
	}
	
	
	
}

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class TestFunctionalI {

	
	public static void main(String[] args) {
		//2 list
		// add some employee in list 1 and list 2
		// create a map and put employee list in map
		// Map<Integer, List<Employee>>
		
		
		List<Employee> list1 = new ArrayList<Employee>();
		list1.add(new Employee(1,"test1"));
		list1.add(new Employee(2,"test2"));
		list1.add(new Employee(3,"test3"));
		list1.add(new Employee(4,"test4"));
		list1.add(new Employee(5,"test5"));
		List<Employee> list2 = new ArrayList<Employee>();
		list2.add(new Employee(6,"test6"));
		list2.add(new Employee(7,"test7"));
		list2.add(new Employee(8,"test8"));
		list2.add(new Employee(9,"test9"));
		list2.add(new Employee(10,"test10"));
		Map<Integer, List<Employee>> empMap = new HashMap<Integer,List<Employee>>();
		empMap.put(1, list1);
		empMap.put(2, list2);
		
		empMap.forEach((k, v) -> {
//			v.stream().map(Employee::getName).collect(Collectors.toList());
//			v.stream().collect(Collectors.toMap(Employee::getName, Employee::getName.upp));
		});
		
		
		
		
		
		
	}
}
