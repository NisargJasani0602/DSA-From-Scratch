package DataStructure1;

import java.util.Scanner;

public class StackExample3 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a Decimal Number : ");
		int n = sc.nextInt();
		Stack s = new Stack(50);
		while(n>0)
		{
			s.Push(n%2);
			n = n/2;
		}
		System.out.println("The Binarly Number is : ");
		while(!s.isStackEmpty())
		{
			System.out.print(s.Pop());
		}
	}

}
