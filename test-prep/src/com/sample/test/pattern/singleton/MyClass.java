package com.sample.test.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyClass {

	public static void main(String[] args) throws Exception {
		SingletonClass obj = SingletonClass.getNewInstance();
		obj.setA("vikas");
		System.out.println(SingletonClass.getNewInstance());
		System.out.println(SingletonClass.getNewInstance());
		System.out.println(SingletonClass.getNewInstance());
		obj.setA("swapnil");
		FileOutputStream fos = new FileOutputStream("serialization.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		// de-serialization
		obj.setA("vikas");
		FileInputStream fis = new FileInputStream("serialization.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonClass test = (SingletonClass) ois.readObject();
		System.out.println("a = " + test);
		System.out.println(SingletonClass.getNewInstance());
	}

}
