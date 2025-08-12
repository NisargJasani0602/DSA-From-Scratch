package DataStructure1;

import java.util.Scanner;

public class StackGenericUsingArray {
	public static void main(String[] args) 
	{
		

		StackArrayGeneric<Integer> s1 = new StackArrayGeneric<Integer>(3);
		int option;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("\nSelect from the following option : ");
			System.out.println("1.\tFor Pushing Data into the stack");
			System.out.println("2.\tFor Popping Data from the stack");
			System.out.println("3.\tFor Peeking Data from the stack");
			System.out.println("4.\tTo Check whether stack is full or not");
			System.out.println("5.\tTo Check whether stack is Empty or not");
			System.out.println("6.\tTo Display the content of the stack");
			System.out.println("7.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1 : 
					System.out.println("Enter the data to be pushed to stack : ");
					int data = sc.nextInt();
					s1.Push(data);
					break;
				case 2 : 
					int val = s1.Pop();
					if(val != -1)
					{
						System.out.println("The Deleted data is : " + val);
					}
					break;
				case 3 :
					int val1 = s1.Peek();
					System.out.println("The data present on the top of the stack is : " + val1);
					break;
				case 4 :
					if(s1.isStackFull())
					{
						System.out.println("Stack is Full");
					}
					else
					{
						System.out.println("Stack is not Full");
					}
					break;
				case 5 :
					if(s1.isStackEmpty())
					{
						System.out.println("Stack is Empty");
					}
					else
					{
						System.out.println("Stack is not Empty");
					}
					break;
				case 6 :
					s1.DisplayStack();
					break;
				case 7 :
					System.out.println("Exiting the program");
					break;
				default : 
					System.out.println("Invalid Option. Please select the option again.");
			}
		
		}while(option != 7);

	}
}


class StackArrayGeneric<T>
{
	int top;
	T[] arr;
	
	StackArrayGeneric(int size)
	{
		top = -1;
		arr = (T[])new Object[size];
	}
	
	boolean isStackFull()
	{
		return (top == arr.length - 1);
	}
	
	boolean isStackEmpty()
	{
		return (top == -1);
	}
	
	void Push(T data)
	{
		if(isStackFull())
		{
			System.out.println("Stack Overflow. Cannot insert value into the stack");
		}
		else
		{
			arr[++top] = data;			
		}
	}
	
	
	T Pop()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return null;
		}
		else
		{
			return arr[top--];
		}
	}
	
	T Peek()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return null;
		}
		else
		{
			return arr[top];
		}
	}
	
	void DisplayStack()
	{
		System.out.println("The Elements present in the stack : \n");
		for(int i = top; i>=0; i--)
		{
			System.out.println(arr[i]);
		}
	}
}
