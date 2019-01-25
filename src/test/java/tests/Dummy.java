package tests;

import java.util.*;

public class Dummy {

    public static void main(String[] args) {
    	
    	/*String value = "House House";
    	
    	int a = repeatedStringCount(value, "House", " ");
    	System.out.println(repeatedStringCount(value, "House"));
    	System.out.println(a);
    	repeatedStringCount(value);
    	occurance(value);
    	reverseName(value);
    	pattern();*/
    	
    	/*String s1 = "ABC";
    	String s2 = "".concat("ABC");
    	System.out.println(s1+"+++++"+s2);
    	System.out.println(s1==s2);
    	System.out.println(s1.equals(s2));*/
    	
    	/*maxOf3Nums(1, 2 ,3);
    	maxOf3Nums(1, 3, 2);
    	maxOf3Nums(3, 2, 1);   	
    	swap2nums(34,45);
    	sumAvg(25,24);
    	areaOfCircle(7);
    	compoundInterest(100000, 8.75 , 5);
    	leapYear(2017);
    	sumofNumbers(5);
    	evenOdd(128);
    	evenOdd(5);
    	for(int i = 0;i<101;i++) {
    		primeNum(i);
    	}
    	primeNumFrom(100);
    	armStrongNum(153);
    	armStrongNum(300);*/
    	/*int[] input = {1,0,2,-1,3,4,-1,3,5,4,2};
    	removeDuplicates(input);*/
    	System.out.println(attempts(10,4,2));
    	System.out.println(attempts(30,3,2));
    	System.out.println(attempts(4,4,2));
    	System.out.println(attempts(2,4,2));
    	System.out.println(attempts(3,3,2));
    	System.out.println(attempts(2,3,2));
    	/*String s1 = new String("Hello");
    	String s2 = new String("Hello");
    	String s4 = "hello";
    	String s5 = "hello";
    	String s3 = s1;
    	//System.out.println(s1+"+"+s2+"+"+s3);
    	System.out.println(s1==s2);
    	System.out.println(s1==s3);
    	System.out.println(s1==s4);
    	System.out.println(s1==s5);
    	System.out.println(s4==s5); //Answer = true
    	System.out.println(s1.equals(s2));
    	System.out.println(s1.equals(s3));*/
	
	}
    
    public static void occurance(String value) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();    	
    	//char[] ar = value.toCharArray();
    	for(int i = 0;i<value.length();i++) {
    		if(!map.containsKey(value.charAt(i))) {
    			map.put(value.charAt(i), 1);
    		}else {
    			map.put(value.charAt(i), map.get(value.charAt(i))+1);
    		}
    	}
    	/*for(char c : ar) {
    		if(!map.containsKey(c)) {
    			map.put(c, 1);
    		}else {
    			map.put(c, map.get(c)+1);
    		}
    	}*/
    	System.out.println(map);  	
    	
    }
    
    public static int repeatedStringCount(String value, String duplicate,String delimiter) {
    	int count = 0;	
    	String[] ar = value.split(delimiter);
    	for(String s : ar) {		
    		if(s.equals(duplicate)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public static double repeatedStringCount(String value, String duplicate) {
    	int count = 0;	
    	String[] ar = value.split(" ");
    	for(String s : ar) {		
    		if(s.equals(duplicate)) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public static void repeatedStringCount(String value) {
    	//int count = 0;
    	HashMap<String, Integer> map = new HashMap<String, Integer>();    	
    	String[] ar = value.split(" ");
    	for(String s : ar) {
    		if(!map.containsKey(s)) {
    			map.put(s, 1);
    		}else {
    			map.put(s,map.get(s)+1);
    		}    	
    	}
    	System.out.println(map);
    }
    
    public static void reverseName(String name) {
    	String temp = "";
    	for(int i = name.length()-1;i>=0;i--) {
    		temp = temp+name.charAt(i);
    	}
    	System.out.println(temp);
    }
    
    
    public static void pattern() {
    	for(int i = 1;i<=5;i++) {
    		for(int j = 1; j<=i;j++) {
    			System.out.print(j);
    		}	
    		System.out.println();
    	}
    	
    }
    
    public static void maxOf3Nums(int n1, int n2, int n3) {
    	if(n1 >= n2 && n1>=n3) {
    		System.out.println(n1+ " is max out of "+n1+" , "+n2+" , "+n3);
    	}else if(n2 >= n1 && n2 >= n3) {
    		System.out.println(n2+ " is max out of "+n1+" , "+n2+" , "+n3);
    	}else {
    		System.out.println(n3+ " is max out of "+n1+" , "+n2+" , "+n3);
    	}
    	
    }
    
    public static void swap2nums(int n1, int n2) {
    	System.out.println("BeforeSwapping : "+n1+" and "+n2);
    	int temp = n1;
    	n1 = n2;
    	n2 = temp;
    	System.out.println("AfterSwapping : "+n1+" and "+n2);
    	n1 = n1+n2;
    	n2 = n1-n2;
    	n1 = n1-n2;
    	System.out.println("AfterSwapping Again : "+n1+" and "+n2);
    }
    
    public static void sumAvg(int n1, int n2) {
    	System.out.println("Sum is : "+(n1+n2));
    	System.out.println("Average is : "+((float)(n1+n2)/2));
    }
    
    public static void areaOfCircle(int radius) {
    	double area = Math.PI*Math.pow(radius, 2);
    	double area1 = Math.PI*radius*radius;
    	System.out.println("Area of Circle is : "+area+" = "+area1);
    }
    
    public static void compoundInterest(int principle, double interest, double time) {
    	double compuntInterest = principle*Math.pow((1+interest/100), time);
    	System.out.println("Compound Interest is : "+compuntInterest);
    }
    
    public static void leapYear(int year) {
    	if(year % 400 == 0 || (year % 100 !=0 && year % 4 == 0)) {
    		System.out.println(year+" is a leap year");
    	}else {
    		System.out.println(year+" is not a leap year");
    	}
    }
    
    public static void sumofNumbers(int n) {
    	int temp= 0;
    	for(int i = 0;i<=n;i++) {
    		temp = temp + i;
    	}
    	System.out.println("Sum of "+n+" numbers is "+temp);
    }
    
    public static void evenOdd(int number) {
    	if(number % 2 == 0) {
    		System.out.println(number+" is a Even number");
    	}else {
    		System.out.println(number+" is a Odd number");
    	}
    }
    
    public static void primeNum(int number) {
    	int count = 0;
    	int flag =0;
    	for(int i = 1;i<=number;i++) {
    		if(number%i == 0) {
				count++;
    		/*for(int j = 1; j <= i; j++) {
    			
    			}*/
    		}
    	}
    	
    	if(count == 2) {
    		System.out.println(number+" is a prime number");
    		flag++;
    	}else {
    		//System.out.println(number+" is not a prime number");
    	}
    	
    	System.out.print(flag);
    }
    
    public static void primeNumFrom(int number) {
    	
    	int flag =0;
    	int i;
    	for(i = 1;i<=number;i++) {
    		int count = 0;
    		for(int j = i; j >= 1; j--) {
    			if(i%j == 0) {
    				count++;
    			}
    		}
    		if(count == 2) {
        		System.out.println(i+" is a prime number");
        		flag++;
        	}else {
        		System.out.println(i+" is not a prime number");
        	}
    	}
    	System.out.println(flag);
    }
    
	public static void armStrongNum(int number) {	
	    	int armsNum =0;
	    	int rem =0;
	    	int temp = number;
	    	while(temp>0) {
	    		rem = temp%10;
	    		armsNum = armsNum+(rem*rem*rem);
	    		temp = temp/10;
	    	}
	    	
	    	if(armsNum==number) {
	    		System.out.println(number+" is a armstrong num");
	    	}else {
	    		System.out.println(number+" is not a armstrong");
	    	}
	    }
	
	public static int attempts(int height, int upwards, int downwards) {	
    	int temph =0;
    	int count =0;
    	if(height <= upwards) {
    		return 1;
    	} 
    	while(temph < height) {
    		temph = temph + upwards;
    		count = count + 1;
    		if(temph >= height) {
    			break;
    		}
    		temph = temph - downwards;
    	}
    	return count;
    }
	
	@SuppressWarnings("unlikely-arg-type")
	public static void removeDuplicates(int[] input) {	
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int in : input) {
			if(!map.containsKey(in)) {
				map.put(in, 1);
			}else {
				map.put(in, map.get(in)+1);
			}
		}
		
		System.out.println(map);
				
		Set<Integer> s = map.keySet();
		Iterator<Integer> its = s.iterator();
		while(its.hasNext()) {
			
			int value = map.get(its);
			if(value!=1) {
				//map.remove(its);
				System.out.println(its);
			}
		}
		//System.out.println(map);
		
    }
    
    
}

