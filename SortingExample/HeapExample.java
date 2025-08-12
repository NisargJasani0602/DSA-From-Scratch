package SortingExample;

import java.util.Scanner;

public class HeapExample {

	public static void main(String[] args) 
	{
		
		Heap h = new Heap(10);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements needs to be inserted into the heap : ");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements : ");
		for(int i = 0; i<n; i++)
		{
			int x = sc.nextInt();
			h.InsertHeap(x);
			h.DisplayHeap();
		}
		
		h.HeapSort();
		System.out.println("\n\nAfter Sorting the values of Heap : ");
		h.DisplayHeap();
	}

}


class Heap
{
	int size, pos;//pos will indicates the number of elements present in the given heap of size
	int[] heap;
	Heap(int size)
	{
		heap = new int[size];
		this.size = size;
		pos = 0;
	}
	
	void InsertHeap(int n)
	{
		System.out.println("\nInserting Value : " + n);
		heap[pos] = n;
		pos++;
		if(pos > 1)
		{
			for(int i=pos/2-1; i>=0; i--)
			{
				Heapify(i);
			}
		}
	}

	private void Heapify(int i)
	{
		if(pos <= 1)
		{
			return;
		}
		
		int leftIndex = 2*i+1;
		int rightIndex = 2*i+2;
		int maxIndex = i;
		
		if(leftIndex <  pos && heap[leftIndex] > heap[maxIndex] && heap[leftIndex] >= heap[rightIndex] )
		{
			maxIndex = leftIndex;
		}
		else if(rightIndex < pos && heap[rightIndex] > heap[maxIndex])
		{
			maxIndex = rightIndex;
		}
		
		if(maxIndex != i)
		{
			int temp = heap[maxIndex];
			heap[maxIndex] = heap[i];
			heap[i]= temp;
			Heapify(maxIndex);
		}
		
	}
	
	void DisplayHeap()
	{
		System.out.println("\nThe elements present in the heap is : ");
		for(int i=0; i<pos; i++)
		{
			System.out.print(heap[i] + ", ");
		}
	}
	
	
	void HeapSort()
	{
		for(int i=pos/2-1; i>=0; i--)
		{
			Heapify(i);
		}
		
		int n = pos;
		for(int i = pos-1; i>=1; i--)
		{
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			pos--;
			
			Heapify(0);
		}
		
		
		pos = n;
	}
	
	
}
