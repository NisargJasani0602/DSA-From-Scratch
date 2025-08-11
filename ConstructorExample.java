package DataStructure1;

import java.util.Scanner;

public class ConstructorExample {

	public static void main(String[] args) 
	{
		//(new Test1(1)).Display();
		Test1 t1 = new Test1();
		//Test1 t2 = new Test1(t1);//Copy Constructor will get executed
		t1.Display();
		
		Test1 t2 = t1;
		t2.Display();
		
		t2.ChangeValue();
		t1.Display();
		
		//int x = (new Scanner(System.in)).nextInt();

	}
	
	

}


class Test1
{
	int x, y;//instance variable or class variables or properties
	Test1()//Default Constructor
	{		
		x = 10;
		y = 20;
		System.out.println("Default Constructor");		
	}
	
	Test1(int n)
	{
		this();
		System.out.println("Parameterized Constructor 1");
	}
	
	Test1(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	Test1(Test1 t)
	{
		this.x = t.x;
		this.y = t.y;
	}
	void Display()
	{		
		System.out.println("Display function of Test1 Class");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
	
	void Show()
	{
		int x, y;
		x = 10;
		y = 20; 
		System.out.println("Instance variable value of x is  : " + this.x);
	}
	
	void ChangeValue()
	{
		x = 100;
		y = 200;
	}
}
