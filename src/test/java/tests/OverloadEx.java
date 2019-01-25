package tests;

public class OverloadEx {
	
	public static void main(String[] args) {
		add();
		System.out.println(add(2));
		System.out.println(add(""));	
		
	}
	
	public static void add() {
		System.out.println("void");	
	}
	
	public static int add(int a) {
		return 2;
	}
	
	public static double add(String a) {
		return 2;
	}

}
