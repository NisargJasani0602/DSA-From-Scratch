package DataStructure1;

import java.util.ArrayList;


public class GenericClassExample 
{
	public static void main(String args[])
	{
		GenericClass<String> s1 = new GenericClass<String>();
		s1.AddValues("Testing");
		s1.AddValues("ABC");
		s1.AddValues("XYZ");
		
		s1.Display();
		
		GenericClass<Integer> s2 = new GenericClass<Integer>();
		s2.AddValues(21);
		s2.AddValues(12);
		s2.AddValues(19);
		s2.Display();
	}
}

class GenericClass<T>
{
	ArrayList<T> a;
	
	GenericClass()
	{
		a = new ArrayList<T>();
	}
	
	void AddValues(T data)
	{
		a.add(data);
	}
	
	
	
	T GetEndValue()
	{
		return a.get(a.size()-1);
	}
	
	void Display()
	{
		System.out.println(a);
	}
}