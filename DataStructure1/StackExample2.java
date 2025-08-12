package DataStructure1;

import java.util.Scanner;

//Reversing the characters of the word using stacks
public class StackExample2 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Word : ");
		String str = sc.next();
		StackChar s = new StackChar(100);
		for(char ch : str.toCharArray())
		{
			s.Push(ch);
		}
		
		System.out.println("Word in reverse form : ");
		while(!s.isStackEmpty())
		{
			System.out.print(s.Pop());
		}
	}

}
