package tests;

import java.util.Arrays;

public class TestTry {
	
	public static void main(String[] args) {
		/*for(int i = 0;i<=12;i++) {
			flames(i);
		}*/
		//forTest();
		//flames(4);
		int x = 3;
		int y = 3;
		int k = 0;
		k = x & y;
		x = x ^ y;
		y = k << 1;
		System.out.println(x+" "+y+" "+k);
		/*if(isAnargam("CAT", "ACTQ")) {
			System.out.println("Anargam");
		}else {
			System.out.println("Not a Aragam");
		}*/
		//anargam("CAT", "act");
		//anargam("gowtha","gowtham");
		
		
	}
	
	public static void weird(int N) {
		if(N>=1 && N<=100) {
			if(N%2!=0){
	            System.out.println("Weird");
	        }else if(N>=2 && N<=5){
	            System.out.println("Not Weird");
	        }else if(N>=6 && N<=20){
	            System.out.println("Weird");
	        }else{
	            System.out.println("Not Weird");
	        }			
		}else {
			System.out.println(N+" is not a valid input");
		}
		
	}
	
	public static void forTest() {
		int num = 5;
		for(int i = 0; i<=num;i++) {
			if(i == 2) {	
				continue;			
			}
			System.out.println(i);
			if(i == 4) {
				
				break;
			}
		}
	}

	public static boolean isAnargam(String s1, String s2) {
		char st1[] = s1.toCharArray();
		char st2[] = s2.toCharArray();
		if(st1.length!=st2.length) {
			return false;	
		}
		
		Arrays.sort(st1);
		Arrays.sort(st2);
		for(int i = 0;i<st1.length;i++) {
			if(st1[i] != st2[i]) {
				return false;	
			}
		}
		return true;		
	}
	
	public static void flames(int number) {
		
		String baseInput = "flames";
		StringBuilder sb = new StringBuilder("AVDFS");
		sb.replace(0, 1, "1");
		System.out.println(sb);
		int resultLength = number;
		char relationIs = ' ';
	    String temp = "";
		if (resultLength > 0) {
		    while (baseInput.length() !=1)
		        {
		    	relationIs = ' ';
		           //System.out.println(baseInput);
		           int tmpLen = resultLength % baseInput.length(); //finding char position to strike
				if(tmpLen != 0)
		           {
		               temp = baseInput.substring(tmpLen) + baseInput.substring(0, tmpLen-1); //Append part start from next char to strike and first charater to char before strike.
		           }
		           else
		           {
		               temp = baseInput.substring(0, baseInput.length()-1); //If mod result zero we can strike last letter easily
		           }
		           baseInput = temp; //Assign the temp to baseinput for next iteration.
		        }
		        relationIs = baseInput.charAt(0);
		        
		 }
		//System.out.println(relationIs);
		//return relationIs;
		switch (relationIs) {
        case 'f':
            System.out.println("friendship");
            break;
        case 'l':
            System.out.println("Lovers");
            break;
        case 'a':
            System.out.println("Affection");
            break;
        case 'm':
            System.out.println("Marriage");
            break;
        case 'e':
            System.out.println("Enemity");
            break;
        case 's':
            System.out.println("Siblings");
            break;
        default:
            System.out.println("FLAME Test works only for different names");
            break;
    }
		
	}
	
	
	
}
