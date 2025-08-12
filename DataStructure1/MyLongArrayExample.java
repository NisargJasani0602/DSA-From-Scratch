package DataStructure1;

import java.util.Scanner;

public class MyLongArrayExample {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		int n = sc.nextInt();
		MyLongArray m = new MyLongArray(n);
		int option;
		do
		{
			System.out.println("\n\nSelect from the following option : \n");
			System.out.println("1.\tFor Inserting element into the array");
			System.out.println("2.\tFor Inserting element into the array at Index Location");
			System.out.println("3.\tFind element in Array");
			System.out.println("4.\tGet element from the array based on Index Value");
			System.out.println("5.\tDelete element from the Array");
			System.out.println("6.\tDelete all entries of the element from Array");
			System.out.println("7.\tDisplaying the list of the Array");
			System.out.println("8.\tExiting the Program");
			System.out.print("Your Option : ");
			option = sc.nextInt();
			switch(option)
			{
				case 1 :
					System.out.println("Enter the number to be input to array : ");
					long val = sc.nextLong();
					m.insert(val);
					break;
				case 2 :
					System.out.println("Enter the number to be input to array : ");
					long val1 = sc.nextLong();
					System.out.println("Enter the Index Position where you need to insert the number : ");
					int pos = sc.nextInt();
					m.insert(pos,val1);
					break;
				case 3 :
					System.out.println("Enter the search value for the array : ");
					long searchKey = sc.nextLong();
					int loc = m.find(searchKey);
					if(loc == -1)
					{
						System.out.println("The Search element is not present in the array");
					}
					else
					{
						System.out.println("The first Occurance of the element is located at : " + (loc+1));
					}
					break;
				case 4 :
					System.out.println("Enter the index of the array : ");
					int index = sc.nextInt();
					long retVal = m.getElem(index);
					if(retVal == -1)
					{
						System.out.println("Array Index out of Bound");
					}
					else
					{
						System.out.println("The element present at the given index is : " + retVal);
					}
					break;
				case 5 :
					System.out.println("Enter the Element to be deleted from array : ");
					long del = sc.nextLong();
					if(m.delete(del))
					{
						System.out.println("The first occurance of the element deleted successfully...");
					}
					else
					{
						System.out.println("Element to be deleted not found in the array");
					}
					break;
				case 6 :
					System.out.println("Enter the Element whose all occurances to be deleted from array : ");
					long delAll = sc.nextLong();
					int count = m.dupDelete(delAll);
					System.out.println("The Number of Elements deleted : " + count);
					break;
				case 7 :
					m.display();
					break;
				case 8 :			
					System.out.println("\nExiting from the Program");
					break;
				default : 
					System.out.println("Invalid Option. Please select the option again");
			}
			
		}while(option != 8);

	}

}


class MyLongArray
{
	long[] a;
	int currentIndex;
	
	MyLongArray(int size)
	{
		a = new long[size];
		currentIndex = -1;
	}
	
	void DoubleArraySize()
	{
		long[] b = new long[a.length];
		for(int i = 0; i<a.length;i++)
		{
			b[i] = a[i];
		}
		a = new long[b.length*2];
		for(int i = 0; i<b.length;i++)
		{
			a[i] = b[i];
		}
	}
	
	int find(long searchKey)
	{
		int retVal=-1;
		for(int i=0; i<=currentIndex; i++)
		{
			if(a[i]==searchKey)
			{
				retVal = i;
				break;
			}
		}
		return retVal;
	}
	
	void insert(long value)
	{
		 if(currentIndex == a.length-1)
		 {
			 DoubleArraySize();
		 }
		 currentIndex++;
		 a[currentIndex] = value;
		 System.out.println("The Value Inserted in the array successfully.");
	}
	
	long getElem(int index)
	{
		if(index < 0 || index>currentIndex)
		{
			return -1;
		}
		else
		{
			return a[index];
		}
		
	}
	
	boolean delete(long value)
	{
		int loc = find(value);
		if(loc != -1)
		{
			for(int i = loc; i<currentIndex; i++ )
			{
				a[i] = a[i+1];
			}
			currentIndex--;
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	void display()
	{
		System.out.println("\nThe values present in the array : \n");
		for(int i=0; i<=currentIndex; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	int dupDelete(long value)
	{
		int count=0;
		while(find(value) != -1)
		{
			delete(value);
			count++;
		}
		return count;
	}
	
	void insert(int index, long value)
	{
		 if(currentIndex == a.length-1)
		 {
			DoubleArraySize();
		 }
		 if(index > currentIndex)
		 {
			 index = currentIndex+1;
		 }
		 for(int i = currentIndex; i>=index; i--)
		 {
			 a[i+1] = a[i];			 
		 }
		 a[index] = value;
		 currentIndex++;
		 System.out.println("Value inserted at given index");
	}
}