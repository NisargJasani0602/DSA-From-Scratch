package DataStructure1;

public class ObjectinJavaExample {

	public static void main(String[] args) 
	{
		TestingObject t1 = new TestingObject();
		t1.SetData(20);
		t1.PrintData();
		
		TestingObject t2;
		t2 = t1;
		t2.SetData(25);
		t1.PrintData();
		t1.SetData(2000);
		t2.PrintData();
		
		TestingObject t3 = t2;
		t3.PrintData();
		

	}

}



class TestingObject
{
	int x;
	void SetData(int data)
	{
		x = data;
	}
	
	void PrintData() 
	{
		System.out.println(x);
	}
}