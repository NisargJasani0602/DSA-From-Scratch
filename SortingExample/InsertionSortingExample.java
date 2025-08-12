package SortingExample;

import java.util.Scanner;

public class InsertionSortingExample {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Count of the Elements : ");
		int n = sc.nextInt();
		InsertionSort b = new InsertionSort(n);
		b.InputNumbers();
		System.out.println("Before Sorting : ");
		b.Display();
		b.SortNumbers();
		System.out.println("After Sorting : ");
		b.Display();
	}

}


class InsertionSort
{
	int[] arr;
	InsertionSort(int size)
	{
		arr = new int[size];
	}
	
	void InputNumbers()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Elements of the Array : ");
		for(int i = 0; i<arr.length; i++)
		{
			System.out.print("Enter Element number : " + (i+1) + " : ");
			arr[i] = sc.nextInt();
		}
	}
	
	void Display() 
	{
		System.out.println("\nThe Numbers are : ");
		for(int x : arr)
		{
			System.out.println(x);
		}
	}
	
	void SortNumbers()
	{
		for(int i=1;i<arr.length;i++)
		{
			int temp=arr[i];
			int j=i-1;
			while(j>=0 && temp<arr[j])
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
}