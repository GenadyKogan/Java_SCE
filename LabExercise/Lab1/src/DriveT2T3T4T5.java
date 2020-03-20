import sun.net.www.content.audio.x_aiff;
import java.util.Scanner;
public class DriveT2T3T4T5 {
	private static Scanner s=new Scanner (System.in);
	public static void main(String[] args) {
		final int EXIT=-1;
		int answer;
		do {
			System.out.println();
			System.out.println("Choose one of the following options: ");
			System.out.println("1)(Task 2) N elements of Fibonacci");
			System.out.println("2)(Task 3) Max-Min digits of numbers");
			System.out.println("3)(Task 4) First N prime numbers");
			System.out.println("4)(Task 5) Convert decimal to binary");
			System.out.println(EXIT +") Exit");
			System.out.println("Enter your choise --> ");
			answer=s.nextInt();
			
			switch(answer) {
			case 1:
				System.out.print("Entre your number: ");
				int number = s.nextInt();
				Number x1=new Number(number);
				for(int i=0; i<x1.getNum(); i++)
			    	 System.out.print(getFib(i)+" ");	
				System.out.println("");
				break;
			case 2:
				System.out.print("Entre your number: ");
				int number2 = s.nextInt();
				Number x2=new Number(number2);
				x2.Digits();
				break;
			case 3:
				System.out.print("Enter two numbers(intervals) ");
				int number3 = s.nextInt();
				int number4 = s.nextInt();
				Number x3=new Number(number3);
				Number x4=new Number(number4);
				primeR(x3.getNum(),x4.getNum());
				break;
			case 4:
				System.out.print("Entre your number: ");
				int number5 = s.nextInt();
				Number x5=new Number(number5);
				System.out.print("Binary number is: "+decimalToBinary(x5.getNum()));
				break;
			case EXIT:
				System.out.println("Goodby");
				break;
			default:
				System.out.println("Invalid option");
				break;
			
			}
			
		}while(answer!=EXIT);
		s.close();
	}
	 
	static long getFib(int num)
    {
    	if(num<2)
    		return 1;
    	else
    		return getFib(num-1) + getFib(num-2);   
    }
	static int primeR(int low,int high) {
		int flag;
		while (low < high) {
	        flag = 0;

	        // if low is a non-prime number, flag will be 1
	        for (int i = 2; i <= low / 2; ++i) {
	            if (low % i == 0) {
	                flag = 1;
	                break;
	            }
	        }

	        if (flag == 0)
	        	System.out.println(low);
	        ++low;
	    }

		
		return 0;
	}
	static long decimalToBinary(int decimalnum)
	{
	    long binarynum = 0;
	    int rem, temp = 1;

	    while (decimalnum!=0)
	    {
	        rem = decimalnum%2;
	        decimalnum = decimalnum / 2;
	        binarynum = binarynum + rem*temp;
	        temp = temp * 10;
	    }
	    return binarynum;
	}

	
	
}
