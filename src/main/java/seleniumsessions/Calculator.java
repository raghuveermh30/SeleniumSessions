package seleniumsessions;

public class Calculator {
	
	//https://calc.com/add
	//json: 10,20
	//response: 30
	
	
	//api - producer
	public static int add(int a , int b) {
		return a+b; //buss logic
	}
	
	
	//client - consumer
	public static void main(String a[]) {
		System.out.println(add(100,200));
	}
	

}
