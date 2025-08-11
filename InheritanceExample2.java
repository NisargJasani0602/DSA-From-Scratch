package DataStructure1;

import java.util.Scanner;

//Implementing Method Overriding/Function Overriding
public class InheritanceExample2 {

	public static void main(String[] args) 
	{
		Base2 b = new Base2();
		b.Max(2, 5);
		
		Derived2 d = new Derived2();
		d.Max(2, 3);
		
		Base2 b1;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int option = sc.nextInt();
		if(option == 1)
		{
			b1 = new Derived2();
		}
		else
		{
			b1 = new Derived22();
		}
		b1.Max(3, 4);
				
		final int x;
		x = 20;
		
	}

}


class Base2
{
	void Max(int x, int y)
	{
		System.out.println("Base Class : " + (x>y?x:y));
	}
}

class Derived2 extends Base2
{
	void Max(int a, int b)
	{
		System.out.println("Derived2 Class : " + (a>b?a:b));
	}
}


class Derived22 extends Base2
{
	void Max(int a, int b)
	{
		System.out.println("Derived22 Class : " + (a>b?a:b));
	}
}