package DataStructure1;

import java.util.Scanner;

public class FirstClassExample {

	public static void main(String[] args) 
	{		
		System.out.println("Hello World..\n");
		System.out.println("Next Line");
		FirstClassExample f1 = new FirstClassExample();//to create object of the class
		f1.Display();
		
		Testing t1 = new Testing();
		t1.Display();		
		Testing.Show();
		t1.PrintPrime();
	}
	
	void Display()
	{
		System.out.println("Display Function Invoked");
	}

}

class Testing
{
	
	void Display()
	{
		System.out.println("Display function in Testing Class Invoked");
		Display2();
		Show();
	}
	
	static void Show()
	{
		System.out.println("Show function in Testing Class Invoked");
		ShowTest();
	}
	
	static void ShowTest()
	{
		System.out.println("ShowTest function in Testing Class Invoked");
	}
	
	void Display2()
	{
		System.out.println("Display 2 function in Testing Class Invoked");
	}
	
	void Add()
	{
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers : ");
		x = sc.nextInt();
		y = sc.nextInt();
		System.out.println("The Addition is : " + (x+y));		
	}
	
	void PrintPrime()
	{
		int n1, n2;
		System.out.println("Enter the values of n1 and n2 : ");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		for(int i = n1; i <= n2; i++)
		{
			if(CheckPrime(i))
			{
				System.out.println(i);
			}
		}
	}
	
	boolean CheckPrime(int n)
	{
		int count = 0;
		for(int i=1; i<=n; i++)
		{
			if(n%i == 0)
			{
				count++;
			}
		}
//		if(count == 2)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		return count==2;
	}
	
	
}
