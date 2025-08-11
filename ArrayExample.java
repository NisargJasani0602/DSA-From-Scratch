package DataStructure1;

import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) 
	{
		ArrayExample a = new ArrayExample();
		a.ArrayExample1();
		

	}
	
	void ArrayExample1()
	{
		int[] a = new int[10];
		int[] b = {11,22,33,44,55,66,77};
		PrintArray(b);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers : ");
		for(int i=0; i<a.length;i++)
		{
			System.out.println("Enter Number " + (i+1) + " : ");
			a[i] = sc.nextInt();
		}
		System.out.println("\nThe Entered Numbers are : ");
		PrintArray(a);
		
		//For Each loop in java
		for(int x : a)
		{
			x = x+2;
			System.out.println(x*x);
		}
		
	}
	
	void PrintArray(int[] a)
	{
		for(int i = 0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	
	

}
