package DataStructure1;

import java.util.ArrayList;

public class StackGenericExample {

	public static void main(String[] args) 
	{
		StackGeneric<String> s1 = new StackGeneric<String>(10);
		s1.Push("ABC");
		s1.Push("XYZ");
		s1.Push("AAA");
		s1.Push("BBB");
		s1.Pop();
		s1.Push("CCC");
		s1.Display();
		
		StackGeneric<Integer> s2 = new StackGeneric<Integer>(10);
		s2.Push(10);
		s2.Push(20);
		s2.Push(30);
		s2.Push(40);
		s2.Display();
		
		
		StackGeneric<Double> s3 = new StackGeneric<Double>(10);
		s3.Push(10.55);
		s3.Push(22.33);
		s3.Push(44.66);
		s3.Push(66.98);
		s3.Display();
	}

}


class StackGeneric<T>
{
	int top;
	ArrayList<T> stack;
	int size;
	StackGeneric(int size)
	{
		top = -1;
		stack = new ArrayList<T>();
		this.size = size;
	}
	
	
	boolean isStackEmpty()
	{
		return top ==-1;
	}
	
	boolean isStackFull()
	{
		return top == size-1;
	}
	
	void Push(T data)
	{
		if(isStackFull())
		{
			System.out.println("Stack Overflow");
			return;
		}
		else
		{
			top++;
			if(stack.size()>top)
			{
				stack.set(top, data);
			}
			else
			{
				stack.add(data);
			}
			System.out.println("Stack Push Operation : " + data + " pushed into the stack");
		}		
	}
	
	T Pop() 
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow");
			return null;
		}
		else
		{
			T temp = stack.get(top);
			stack.remove(top);
			top--;
			return temp;			
		}
	}
	
	T Peek()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow");
			return null;
		}
		else
		{			
			return stack.get(top);			
		}
	}
	
	void Display()
	{
		for(int i = top; i>=0; i--)
		{
			System.out.println(" " + stack.get(i));
		}
	}
}