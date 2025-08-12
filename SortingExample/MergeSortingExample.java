package SortingExample;

import java.util.Scanner;

public class MergeSortingExample {

	public static void main(String[] args) 
	{
		System.out.println("Enter the number of elements in Array : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MergeSort m = new MergeSort(n);
		m.InputArray();
		m.SortMerge(m.arr, 0, n-1);
		m.DisplayArray();

	}
}


class MergeSort
{
	int size;
	int[] arr;
	MergeSort(int size)
	{
		this.size = size;
		arr = new int[size];
	}
	
	void InputArray()
	{
		System.out.println("Enter the elements of Array : ");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<size; i++)
		{
			arr[i]= sc.nextInt();
		}
		
	}
	
	void DisplayArray()
	{
		System.out.println("\nThe elements present in the Array : ");
		for(int n : arr)
		{
			System.out.print(n + ", ");
		}
	}
	
	void Merge(int[] arr, int beg, int mid, int end)
	{
		int[] temp = new int[size];
		int i = beg;
		int j = mid+1;
		int k = beg;
		while(i <= mid && j <= end)
		{
			if(arr[i] < arr[j])
			{
				temp[k] = arr[i];
				i++;
			}
			else
			{
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		if(i>mid)
		{
			while(j<=end)
			{
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		else
		{
			while(i<=mid)
			{
				temp[k] = arr[i];
				i++;
				k++;
			}
		}		
		
		for(i=beg; i<k; i++)
		{
			arr[i] = temp[i];
		}
	}
	
	
	
	void SortMerge(int[] arr, int beg, int end)
	{
		int mid = (beg + end)/2;
		if(beg<end)
		{			
			SortMerge(arr, beg, mid);			
			SortMerge(arr, mid+1, end);			
			Merge(arr, beg, mid, end);
			
		}
	}
}