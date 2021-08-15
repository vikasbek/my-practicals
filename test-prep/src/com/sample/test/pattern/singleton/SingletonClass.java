package com.sample.test.pattern.singleton;

import java.io.Serializable;

public class SingletonClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String a = null;

	private static SingletonClass sc = null;

	private SingletonClass() {

	}

	public static SingletonClass getNewInstance() {
		if (sc == null) {
			synchronized (SingletonClass.class) {
				if (sc == null) {
					sc = new SingletonClass();
				}
			}
		}
		
		return sc;
	}

//	@Override
//	public String toString() {
//		return "SingletonClass [a=" + a + "]";
//	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	protected Object readResolve() {
        return sc;
    }
}
