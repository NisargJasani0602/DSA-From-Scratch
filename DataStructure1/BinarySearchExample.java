package DataStructure1;

import java.util.Scanner;

public class BinarySearchExample {

	public static void main(String[] args) 
	{
		BinarySearchExample b = new BinarySearchExample();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter the decimal Numbers : ");
		//int n = sc.nextInt();
		int[] a = {10,20,30,40,50,60,70,80};
		System.out.println("Enter the number to be searched in List : ");
		int n = sc.nextInt();
		int pos = b.RecursiveBinarySearch(a, n, 0, a.length-1);
		if(pos == -1)
		{
			System.out.println("Number Doesnt Exist in the given array");
		}
		else
		{
			System.out.println("The Number is located at position : " + (pos+1));
		}

	}
	
	int BinarySearch(int[] arr, int n)
	{
		int start =0; 
		int end = arr.length-1;
		while(start<=end)
		{
			int mid = (start+end)/2;
			
			if(arr[mid] ==  n)
			{
				return mid;
			}
			else if(arr[mid] > n)
			{
				end = mid-1;
			}
			else
			{
				start = mid+1;
			}
		}
		return -1;
	}
	
	int RecursiveBinarySearch(int[] arr,int n,int start,int end)
	{
		int mid=(start+end)/2;
		if(start>end)
			return -1;
		else if(arr[mid]==n)
		{
			return mid;
		}
		else if(arr[mid]<n)
		{
			return RecursiveBinarySearch(arr, n, mid+1, end);
		}
		else
		{
			return RecursiveBinarySearch(arr, n, start, mid-1);
		}
	}

}
