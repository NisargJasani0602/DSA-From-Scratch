package DataStructure1;

public class InheritanceExample1 {

	public static void main(String[] args) 
	{
		Base1 b = new Base1();
		b.Display();
		
		Derived1 d1 = new Derived1();
		d1.Show();
		d1.Display();
		
		//Creating base class object to point it to derived class instance
		Base1 b1 = new Derived1();
		b1.Display();
		
		
		Derived11 d11 = new Derived11();
		d11.Display();
		
		
		//Derived1 d1 = new Base1(); --> not Permitted to create derived class object to point to base class instance
		

	}

}

class Base1
{
	void Display()
	{
		System.out.println("Display function of Base 1 class");
	}
}

class Derived1 extends Base1
{
	void Show()
	{
		System.out.println("Show function of Derived1 class");
	}
}

class Derived11 extends Base1
{
	void Show()
	{
		System.out.println("Show function of Derived11 class");
	}
}