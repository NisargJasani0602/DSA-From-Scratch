package DataStructure1;
//Implementing Stack using Arrays
import java.util.Scanner;
public class StackExample1 {

	public static void main(String[] args) 
	{
		Stack s = new Stack(3);
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
					s.Push(data);
					break;
				case 2 : 
					int val = s.Pop();
					if(val != -1)
					{
						System.out.println("The Deleted data is : " + val);
					}
					break;
				case 3 :
					int val1 = s.Peek();
					System.out.println("The data present on the top of the stack is : " + val1);
					break;
				case 4 :
					if(s.isStackFull())
					{
						System.out.println("Stack is Full");
					}
					else
					{
						System.out.println("Stack is not Full");
					}
					break;
				case 5 :
					if(s.isStackEmpty())
					{
						System.out.println("Stack is Empty");
					}
					else
					{
						System.out.println("Stack is not Empty");
					}
					break;
				case 6 :
					s.DisplayStack();
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


class Stack
{
	int top;
	int[] arr;
	
	Stack(int size)
	{
		top = -1;
		arr = new int[size];
	}
	
	boolean isStackFull()
	{
//		if(top == arr.length-1)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
		return (top == arr.length - 1);
	}
	
	boolean isStackEmpty()
	{
		return (top == -1);
	}
	
	void Push(int data)
	{
		if(isStackFull())
		{
			System.out.println("Stack Overflow. Cannot insert value into the stack");
		}
		else
		{
//			top++;
//			arr[top]= data;
			
			arr[++top] = data;
			//System.out.println("Data pushed on to the stack successfully.");
		}
	}
	
	
	int Pop()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return -1;
		}
		else
		{
//			int data = arr[top];
//			top--;
//			return data;
			
			return arr[top--];
		}
	}
	
	int Peek()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return -1;
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


class StackChar
{
	int top;
	char[] arr;
	
	StackChar(int size)
	{
		top = -1;
		arr = new char[size];
	}
	
	boolean isStackFull()
	{
		return (top == arr.length - 1);
	}
	
	boolean isStackEmpty()
	{
		return (top == -1);
	}
	
	void Push(char data)
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
	
	
	char Pop()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return ' ';
		}
		else
		{
			return arr[top--];
		}
	}
	
	char Peek()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return ' ';
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