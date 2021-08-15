package com.sample.test;

// Java code for serialization and deserialization
// of a Java object
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author vikasbek
 *
 */
/**
 * @author vikasbek
 *
 */
@FunctionalInterface
interface SumI{
	public Double sum(Double a, Double b);
}
class Sub {

	String sub = null;

	Sub(String sub) {
		this.sub = sub;
	}
	
	public Double increasedMarks(SumI s) {
		return s.sum(5d, 6d);
	}
}


class Emp implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 129348938L;
	// private static final long serialversionUID = 129348938L;
	transient int a;
	static int b;
	Long x = 2l;
	String name;
	int age;
	Sub sub = null;

	// Default constructor
	public Emp(String name, int age, int a, int b, Sub sub) {
		this.name = name;
		this.age = age;
		this.a = a;
		this.b = b;
		this.sub = sub;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [a=").append(a).append(", x=").append(x).append(", name=").append(name).append(", age=").append(age).append(", sub=")
				.append(sub).append("]");
		return builder.toString();
	}
}


public class SerialExample {
	public static void printdata(Emp object1) {

		System.out.println("name = " + object1.name);
		System.out.println("age = " + object1.age);
		System.out.println("a = " + object1.a);
		System.out.println("b = " + object1.b);
	}

	public static void main(String[] args) {
		Emp object = new Emp("ab", 20, 2, 1000, new Sub("Math"));
		Sub math = new Sub("Math");
		Double d = math.increasedMarks((a,b)-> a*b);
		System.out.println( d);
		List<Emp> list = new ArrayList<>();

// supplier, BiConsumer, filter(predicate), consumer
//
//list.stream().reduce(identity, accumulator, combiner)

		String filename = "shubham.txt";
		Optional.of(object);
		Optional.of(list);
		// Serialization
		try {
			try {
				Emp emp2 = (Emp) object.clone();

				Predicate<String> isLongword = t-> t.length() > 30;
				isLongword.and(t->t.length()>10).test("swan");
				
				extracted(object, emp2);
				
				
				
				
				
				System.out.println(object);
				System.out.println(emp2);
				
				object.a = 1;
				object.name = "xy";
				object.x = 3l;
				object.sub = new Sub("Math");
				System.out.println(emp2);
				System.out.println(object);
				//emp2.sub = new Sub("Eng"); emp2.sub.sub = "";
				System.out.println(object.sub.sub);
				System.out.println(emp2.sub.sub);

			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			printdata(object);

			// value of static variable changed
			// object.b = 2000;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		object = null;
		// object.b = 3;
		// Deserialization
		try {

			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			object = (Emp) in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			printdata(object);


			// System.out.println("z = " + object1.z);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
	}

	private static void extracted(Emp object, Emp emp2) {
		Predicate<Emp> empObjPredicate = t-> t instanceof Emp;
		empObjPredicate.and(t->{final Emp objectRef = object; return t.name==objectRef.name;}).test(emp2);
	}
}
