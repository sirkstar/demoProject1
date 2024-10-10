package com.ipl.practice;

@FunctionalInterface
interface Cab {	
	public void bookCab();
//	public void m2();
//	default void m2() {
//		
//	}
//	static void m3() {
//	}
}
@FunctionalInterface
interface MathOperation{
	public int operate(int a, int b);
}
/*
class Ola implements Cab{
//
//	@Override
//	public void bookCab() {
//		System.out.println("Ola Cab Booked");
//	}
	
	()-> System.out.println("Ola Cab Booked");
	
}
*/
public class LambdaDemo {

	
	public static void main(String[] args) {
		Cab ola = ()-> System.out.println("Ola Cab Booked");
		ola.bookCab();
		
		MathOperation add = (a,b)-> a+b;
		MathOperation add1 = (a,b)-> {return (a+b);};
		MathOperation sub = (a,b)-> (a<b)? (b-a):(a-b);
		
		System.out.println("New Addition: "+add1.operate(10, 20));
		System.out.println("Addition: "+operate(10,20,add));
		System.out.println("Subtraction: "+operate(1000,250,sub));
//		add.operation(10,20);
	}

	private static int operate(int i, int j, MathOperation operation) {
		// TODO Auto-generated method stub
		return operation.operate(i, j);
	}

}
