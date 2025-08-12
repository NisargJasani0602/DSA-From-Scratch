package SortingExample;

import java.util.Scanner;

public class SelectionSortingExample {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Count of the Elements : ");
		int n = sc.nextInt();
		SelectionSort b = new SelectionSort(n);
		b.InputNumbers();
		System.out.println("Before Sorting : ");
		b.Display();
		b.SortNumbers();
		System.out.println("After Sorting : ");
		b.Display();

	}

}


class SelectionSort
{
	int[] arr;
	SelectionSort(int size)
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
		for(int i=0;i<arr.length-1;i++)
		{
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[minIndex])
				{
					minIndex=j;
				}
				
				
			}
			int temp=arr[minIndex];
			arr[minIndex]=arr[i];
			arr[i]=temp;
		}
	}
}