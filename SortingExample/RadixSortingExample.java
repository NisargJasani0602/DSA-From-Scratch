package SortingExample;

import java.util.Scanner;

public class RadixSortingExample 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the Elements : ");
		for(int i=0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println("Before Sorting the Array is : ");
		Display(arr);
		RadixSort(arr);
		System.out.println("\nAfter Sorting the Array is : ");
		Display(arr);
	}
	
	
	static void RadixSort(int[] arr)
	{
		int max= MaxNumber(arr);
		int digitCount = NumberOfDigits(max);
		int loc = 1;
		for(int i=1; i<=digitCount; i++)
		{
			ArrangePlaces(arr, loc);
			loc= loc*10;
		}
	}
	
	private static void ArrangePlaces(int[] arr, int loc) 
	{
		int[] index = new int[arr.length];
		int[] count = new int[10];
		
		for(int i = 0; i<arr.length; i++)
		{
			index[i] = (arr[i]/loc)%10;
			count[index[i]]++;
		}	
		
		for(int i = 1; i<10; i++)
		{			
			count[i] = count[i] + count[i-1];
		}
		
		
		int[] finalArr = new int[arr.length];
		for(int i = arr.length-1; i>=0; i--)
		{
			finalArr[count[index[i]]-1] = arr[i];
			count[index[i]]--;			
		}
		
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = finalArr[i];
		}
		
		
	}


	static void Display(int[] arr) 
	{
		for(int n : arr)
		{
			System.out.print(n + ", ");
		}
	}
	
	
	static int MaxNumber(int[] arr)
	{
		int max = arr[0];
		for(int x : arr)
		{
			if(x>max)
			{
				max = x;
			}
		}
		return max;
	}
	
	static int NumberOfDigits(int n)
	{
		int dig = 0;
		while(n>0)
		{
			dig++;
			n = n/10;
		}
		return dig;
	}
	
	

}

