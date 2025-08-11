package DataStructure1;

public class BreakContinueExample {

	public static void main(String[] args) 
	{
		BreakExample();

	}
	
	static void BreakExample()
	{
		System.out.println("Before Starting Loop");
		OuterLoop :
		for(int i=1; i<=5; i++)
		{
			System.out.println("Outer Loop : Before Break Statement " + i);
			InnerLoop : 
			for(int j = 1; j<=5; j++)
			{ 
				System.out.println("Outer Loop : Before Break Statement : i = " + i + " , j = " + j);
				if(i==3)
				{
					break OuterLoop;
				}
				System.out.println("Outer Loop : After Break Statement : i = " + i + " , j = " + j);
			}				
			System.out.println("Outer Loop : After Break Statement " + i);
		}
		System.out.println("After Ending the Loop");
	}

}
