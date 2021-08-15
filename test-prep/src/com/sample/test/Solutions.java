package com.sample.test;

import java.util.ArrayList;
import java.util.List;

interface DataType<T>{
	 void addition(T a, T b);
	 void subtraction(T a, T b);
	 void multiplication(T a, T b);
	 void division(T a, T b);	
}
/*class NumericDataType<T> implements DataType<T>{

	@Override
	public void addition(T a, T b) {
		// TODO Auto-generated method stub
		
	}


	public <T extends String> void addition(T a, T b) {
		if (a.getClass() == String.class && b.getClass() == String.class) {
			System.out.println("Adding two strings");
			System.out.println("The result is: " + (String) a + (String) b);
		}
	}

	public <T extends Number> void addition(T a, T b) {
		if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
			System.out.println("Adding 2 generic instances");
			System.out.println("The result is: " + ((Integer) a + (Integer) b));
		} else if (a.getClass() == Double.class && b.getClass() == Double.class) {
			System.out.println("Adding 2 generic instances");
			System.out.println("The result is: " + ((Double) a + (Double) b));
		} else if (a.getClass() == Long.class && b.getClass() == Long.class) {
			System.out.println("Adding 2 generic instances");
			System.out.println("The result is: " + ((Long) a + (Long) b));
		}
	}
   
   @Override
   public void subtraction(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Subtracting 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a - (Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Subtracting 2 generic instances");
           System.out.println("The result is: "+ ((Double)a- (Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Subtracting 2 generic instances");
           System.out.println("The result is: "+ ((Long)a-(Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
System.out.println("Can't perform this operation on strings");
       }
   }

   @Override
   public void multiplication(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Multiplying 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a*(Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Multiplying 2 generic instances");
           System.out.println("The result is: "+ ((Double)a* (Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Multiplying 2 generic instances");
           System.out.println("The result is: "+ ((Long)a* (Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
System.out.println("Can't perform this operation on strings");
       }
   }

   @Override
   public void division(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a/(Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Double)a/(Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Long)a/(Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
System.out.println("Can't perform this operation on strings");
       }
   }
   public void performAll(T a, T b){

       addition(a, b);
       subtraction(a, b);
       multiplication(a, b);
       division(a, b);
  }

}

class StringDataType <T> implements DataType<T>{




   @Override
   public void addition(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a + (Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Double)a + (Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Long)a+ (Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
           System.out.println("Adding two strings");
           System.out.println("The result is: "+ (String)a + (String)b);
       }
   }

   @Override
   public void subtraction(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Subtracting 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a - (Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Subtracting 2 generic instances");
           System.out.println("The result is: "+ ((Double)a- (Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Subtracting 2 generic instances");
           System.out.println("The result is: "+ ((Long)a-(Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
System.out.println("Can't perform this operation on strings");
       }
   }

   @Override
   public void multiplication(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Multiplying 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a*(Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Multiplying 2 generic instances");
           System.out.println("The result is: "+ ((Double)a* (Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Multiplying 2 generic instances");
           System.out.println("The result is: "+ ((Long)a* (Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
System.out.println("Can't perform this operation on strings");
       }
   }

   @Override
   public void division(T a, T b) {
       if (a.getClass() == Integer.class && b.getClass() == Integer.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Integer)a/(Integer)b));
       } else if (a.getClass() == Double.class && b.getClass() == Double.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Double)a/(Double)b));
       } else if (a.getClass() == Long.class && b.getClass() == Long.class) {
           System.out.println("Adding 2 generic instances");
           System.out.println("The result is: "+ ((Long)a/(Long)b));
       } else if (a.getClass() == String.class && b.getClass() == String.class) {
System.out.println("Can't perform this operation on strings");
       }
   }
   public void performAll(T a, T b){

       addition(a, b);
       subtraction(a, b);
       multiplication(a, b);
       division(a, b);
  }
}
*/

class DoubleClass <T extends Double> extends NumericDataType<T>{


	@Override
	public void addition(Double a, Double b) {
		System.out.println(a+b);
		
	}

	@Override
	public void subtraction(Double a, Double b) {
		System.out.println(a-b);
	}

	@Override
	public void multiplication(Double a, Double b) {
		System.out.println(a*b);
	}

	@Override
	public void division(Double a, Double b) {
		System.out.println(a/b);
	}
//	@Override
//	void performAll(T a, T b) {
//		System.out.println("Double performAll");
//		addition(a, b);
//		subtraction(a, b);
//		multiplication(a, b);
//		division(a, b);
//		
//	}
}

class StringClass <T extends String> extends NumericDataType<T>{

//	@Override
//	void performAll(T a, T b) {
//		System.out.println("String performAll");
//		addition(a, b);
//		subtraction(a, b);
//		multiplication(a, b);
//		division(a, b);
//		
//	}
	@Override
	public void addition(String a, String b) {
		System.out.println(a+b);
	}

	@Override
	public void subtraction(String a, String b) {
		System.out.println("Cann't be performed");
	}

	@Override
	public void multiplication(String a, String b) {
		System.out.println("Cann't be performed");
	}

	@Override
	public void division(String a, String b) {
		System.out.println("Cann't be performed");
	}
	
}

class NumericDataType<T> implements DataType<T>{
	
	public <T extends Double> void performAll(Double a, Double b) {
		System.out.println("performAll");
		(new DoubleClass()).addition(a, b);
		(new DoubleClass()).subtraction(a, b);
		(new DoubleClass()).multiplication(a, b);
		(new DoubleClass()).division(a, b);
	}
	
	public <T extends Integer> void performAll(T a, T b) {
		System.out.println("performAll");
//		(new DoubleClass()).addition(a, b);
//		(new DoubleClass()).subtraction(a, b);
//		(new DoubleClass()).multiplication(a, b);
//		(new DoubleClass()).division(a, b);
	}
	
//	public <T extends Number> void performAll(Number a, Number b) {
//		//System.out.println(a + b);
//}
	
//	public <T extends Number> void performAll(T a, T b) {
//		System.out.println("performAll");
////		(new DoubleClass()).addition(a, b);
////		(new DoubleClass()).subtraction(a, b);
////		(new DoubleClass()).multiplication(a, b);
////		(new DoubleClass()).division(a, b);
//	}
	
	public <T extends String> void performAll(T a, T b) {
		System.out.println("performAll");
		(new StringClass()).addition(a, b);
		(new StringClass()).subtraction(a, b);
		(new StringClass()).multiplication(a, b);
		(new StringClass()).division(a, b);
	}
	
	

	@Override
	public void addition(T a, T b) {
		System.out.println("Default");
	}

	@Override
	public void subtraction(T a, T b) {
		System.out.println("Default");
	}

	@Override
	public void multiplication(T a, T b) {
		System.out.println("Default");
	}

	@Override
	public void division(T a, T b) {
		System.out.println("Default");
	}
}

class Test{
	
	public void test(List<? extends TestFunctionalI> dl) {
		
	}
}

class Test1 extends Test{}

public class Solutions {
	public static void main(String[] args) {
		NumericDataType<Double> doub = new NumericDataType<>();
		Double a=14d;
		Double b=16d;
		doub.performAll(a, b);
		NumericDataType<Integer> intObj = new NumericDataType<>();
		intObj.performAll(11, 12);
		NumericDataType<String> str = new NumericDataType<>();
		str.performAll("abc", "def");
		
//		new Test().test(new ArrayList<Test1>());
//		List<? extends Double> ll = new ArrayList<>();
//		ll.add(new Double(2));
		
		//List<Integer> li = new ArrayList<>();
	}
	
}
