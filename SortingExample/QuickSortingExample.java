package SortingExample;

import java.util.Scanner;

public class QuickSortingExample {

	public static void main(String[] args) 
	{
		
		System.out.println("Enter the number of elements in Array : ");
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int[] a = new int[size];
		System.out.println("Enter the elements of Array : ");
		for(int i=0; i<size; i++)
		{
			a[i]= sc.nextInt();
		}
		
		QuickSorting q = new QuickSorting();
		q.QuickSort(a, 0, size-1);
		
		System.out.println("\nAfter Sorting the array is : \n");
		for(int n : a)
		{
			System.out.println(n);
		}
	}

}

class QuickSorting
{
	void QuickSort(int[] arr, int beg, int end)
	{
		if(beg < end)
		{
			int loc = Partition(arr, beg, end);
			QuickSort(arr, beg, loc-1);//Left Sub Array
			QuickSort(arr, loc+1, end);//Right Sub array
		}
	}
	
	int Partition(int[] arr, int beg, int end)
	{
		int loc = beg;
		int left = beg, right = end;
		int flag = 0; //We are using it to confirm whether the partition location is found or not
		
		while(flag != 1)
		{
			//Logic when location is on the left side
			while(arr[loc] <= arr[right] && (loc != right))
			{
				right--;
			}
			if(loc == right)
			{
				flag = 1;
			}
			else if(arr[loc] > arr[right] )
			{
				int temp = arr[loc];
				arr[loc] = arr[right];
				arr[right] = temp;
				loc = right;
			}
			
			if(flag != 1)
			{
				//Logic when location is on the right side
				while(arr[loc] >= arr[left] && (loc != left))
				{
					left++;
				}
				if(loc == left)
				{
					flag = 1;
				}
				else if(arr[loc] < arr[left] )
				{
					int temp = arr[loc];
					arr[loc] = arr[left];
					arr[left] = temp;
					loc = left;
				}
			}			
		}
		
		return loc;
	}
}
