package com.sample.test.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
class Student {
	private String name;
	private UUID id;
	List<Subject> subjectList;
	
	Student() {
		this.id = UUID.randomUUID();
	}
	
	public Student(String name, List<Subject> subjectList) {
		super();
		this.name = name;
		this.subjectList = subjectList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
class Subject {
	private String subjectName;
	private Integer Marks;
	
	public Subject(String subjectName, Integer marks) {
		super();
		this.subjectName = subjectName;
		Marks = marks;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public Integer getMarks() {
		return Marks;
	}
	
	public void setMarks(Integer marks) {
		Marks = marks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Subject [subjectName=").append(subjectName).append(", Marks=").append(Marks).append("]");
		return builder.toString();
	}
	
}

public class StreamTest {

	public static void main(String[] args) {
		
//		Scanner s = new Scanner(System.in);
//      String name = s.nextLine();                 // Reading input from STDIN
//      int size = Integer.parseInt(name);
//      String intList[] = s.nextLine().split(" ");
//      List<Long> longList = new ArrayList<Long>();
//      for(int i=0;i<size;i++) {
//      	
//      }
		
		List<Subject> subjectList = new ArrayList<Subject>();
		List<Student> studentList = new ArrayList<Student>();
		subjectList.add(new Subject("Hindi", 20));
		subjectList.add(new Subject("English", 10));
		subjectList.add(new Subject("Math", 40));
		subjectList.add(new Subject("Science", 50));
		subjectList.add(new Subject("History", 30));
		studentList.add(new Student("vikas", subjectList));

		subjectList = new ArrayList<Subject>();
		subjectList.add(new Subject("Hindi", 50));
		subjectList.add(new Subject("English", 10));
		subjectList.add(new Subject("Math", 40));
		subjectList.add(new Subject("Science", 50));
		subjectList.add(new Subject("History", 40));
		studentList.add(new Student("aman", subjectList));
		
		subjectList = new ArrayList<Subject>();
		subjectList.add(new Subject("Hindi", 30));
		subjectList.add(new Subject("English", 60));
		subjectList.add(new Subject("Math", 20));
		subjectList.add(new Subject("Science", 60));
		subjectList.add(new Subject("History", 80));
		studentList.add(new Student("rakesh", subjectList));
		
		subjectList = new ArrayList<Subject>();
		subjectList.add(new Subject("Hindi", 20));
		subjectList.add(new Subject("English", 10));
		subjectList.add(new Subject("Math", 40));
		subjectList.add(new Subject("Science", 50));
		subjectList.add(new Subject("History", 30));		
		studentList.add(new Student("himani", subjectList));
		
		subjectList = new ArrayList<Subject>();
		subjectList.add(new Subject("Hindi", 20));
		subjectList.add(new Subject("English", 10));
		subjectList.add(new Subject("Math", 40));
		subjectList.add(new Subject("Science", 50));
		subjectList.add(new Subject("History", 30));
		studentList.add(new Student("vinod", subjectList));
		
		subjectList = new ArrayList<Subject>();
		subjectList.add(new Subject("Hindi", 20));
		subjectList.add(new Subject("English", 10));
		subjectList.add(new Subject("Math", 40));
		subjectList.add(new Subject("Science", 50));
		subjectList.add(new Subject("History", 30));
		subjectList.add(new Subject("sanskrit", null));
		studentList.add(new Student("preeti", subjectList));
		
//		studentList.stream().collect(Collectors.groupingBy()
		List<Subject> sl = studentList.stream().flatMap(s->s.getSubjectList().stream().distinct()).collect(Collectors.toList());
		System.out.println( sl);
		//[Subject [subjectName=Hindi, Marks=20], Subject [subjectName=English, Marks=10], Subject [subjectName=Math, Marks=40], Subject [subjectName=Science, Marks=50], Subject [subjectName=History, Marks=30], Subject [subjectName=Hindi, Marks=50], Subject [subjectName=English, Marks=10], Subject [subjectName=Math, Marks=40], Subject [subjectName=Science, Marks=50], Subject [subjectName=History, Marks=40], Subject [subjectName=Hindi, Marks=30], Subject [subjectName=English, Marks=60], Subject [subjectName=Math, Marks=20], Subject [subjectName=Science, Marks=60], Subject [subjectName=History, Marks=80], Subject [subjectName=Hindi, Marks=20], Subject [subjectName=English, Marks=10], Subject [subjectName=Math, Marks=40], Subject [subjectName=Science, Marks=50], Subject [subjectName=History, Marks=30], Subject [subjectName=Hindi, Marks=20], Subject [subjectName=English, Marks=10], Subject [subjectName=Math, Marks=40], Subject [subjectName=Science, Marks=50], Subject [subjectName=History, Marks=30], Subject [subjectName=Hindi, Marks=20], Subject [subjectName=English, Marks=10], Subject [subjectName=Math, Marks=40], Subject [subjectName=Science, Marks=50], Subject [subjectName=History, Marks=30], Subject [subjectName=sanskrit, Marks=null]]
		Map<String, Optional<Integer>> sl1 = studentList.stream().flatMap(s->s.getSubjectList().stream().distinct()).collect(Collectors.groupingBy(Subject::getSubjectName, Collectors.mapping(Subject::getMarks, Collectors.maxBy(Comparator.naturalOrder()))));
		//{English=Optional[60], Science=Optional[60], sanskrit=Optional.empty, Hindi=Optional[50], History=Optional[80], Math=Optional[40]}
		
		System.out.println(sl1);
		//
//		
		
//		subjectList = new ArrayList<Subject>();
//		subjectList.add(new Subject("Hindi", 20));
//		subjectList.add(new Subject("English", 10));
//		subjectList.add(new Subject("Math", 40));
//		subjectList.add(new Subject("Science", 50));
//		subjectList.add(new Subject("History", 30));
//		studentList.add(new Student("swati", subjectList));
//		
//		subjectList = new ArrayList<Subject>();
//		subjectList.add(new Subject("Hindi", 20));
//		subjectList.add(new Subject("English", 10));
//		subjectList.add(new Subject("Math", 40));
//		subjectList.add(new Subject("Science", 50));
//		subjectList.add(new Subject("History", 30));
//		studentList.add(new Student("kanika", subjectList));
		
//		Student vikas= new Student("vikas", subjectList);
//		Student aman= new Student("aman", subjectList);
//		Student rakesh= new Student("rakesh", subjectList);
//		Student himani= new Student("himani", subjectList);
//		Student vikas= new Student("vikas", subjectList);
//		Student vikas= new Student("vikas", subjectList);
//		Student vikas= new Student("vikas", subjectList);
		
	}
}
