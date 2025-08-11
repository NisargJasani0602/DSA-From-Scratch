package DataStructure1;

import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) 
	{
		ArrayExample a = new ArrayExample();
		//a.ArrayExample3();
		a.ArrayExample4();
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
	
	void ArrayExample2()
	{
		int[] a = new int[10];// this is the most preferable in java
		int b[] = new int[10];
		int []c = new int[10];
		
		float x = 10.5f;
		double y = 10.5;
	}
	
	//WAP to input 10 integer numbers from user and find sum and avg of those numbers
	void ArrayExample3()
	{
		int arr[] = new int[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers : ");
		for(int i = 0; i<10; i++)
		{
			System.out.print("Enter Number : " + (i+1) + " : ");
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int x : arr)
		{
			sum += x;
		}
		
		float avg = sum/10.0f;
		
		System.out.println("The Sum is : " + sum);
		System.out.println("The Avg is : " + avg);
	}
	
	
	//WAP to input 10 numbers from user and find the frequency of each distinct number present in that array
	void ArrayExample4()
	{
		int[] frequency = new int[10];
		
		int[] arr = {1,2,1,3,4,1,2,5,3,2};
		for(int i=0;i<10;i++)
		{			
			if(frequency[i] != -1)
			{
				frequency[i]=1;
				for(int j=i+1;j<10;j++)
				{					
						if(arr[i]==arr[j])
						{
							frequency[i]++;
							frequency[j]=-1;
						}
					
				}
			}
		}
		for(int i=0;i<10;i++)
		{
			if(frequency[i]!=-1)
				System.out.println("frequency of "+arr[i]+" :"+frequency[i]);
		}
	}

}
