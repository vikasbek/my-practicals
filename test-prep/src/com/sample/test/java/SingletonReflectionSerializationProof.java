package com.sample.test.java;

import java.io.ObjectStreamException;
import java.io.Serializable;

class SingletonA implements Serializable{
	
	public SingletonA singleton;
	

	public SingletonA getInstance() {
		 if(singleton != null) {
			 return singleton;
		 } else {
			 synchronized (SingletonA.class) {
				
			}
			 return singleton;
		 }
	}
//	@Override
	@Override
   public Object clone() throws CloneNotSupportedException {
       throw new CloneNotSupportedException();
   }
   private Object readResolve() throws ObjectStreamException {
       return getInstance();
   }
}

public class SingletonReflectionSerializationProof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
