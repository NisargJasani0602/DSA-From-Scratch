package DataStructure1;

import java.util.Scanner;

public class StringExamples {

	public static void main(String[] args) 
	{
		String s1 = "Testing";
		String s2 = new String("Testing");
		char[] ch = {'T', 'e', 's', 't', 'i', 'n', 'g'};
		String s3 = new String(ch);
		String s4 = "Testing";
		String s5 = s1;
		
		s1 = "New Testing";
		
		if(s1 == s5)
		{
			System.out.println("String are Same");
		}
		else
		{
			System.out.println("Strings are Different");
		}
		
		StringBuilder sb = new StringBuilder(s1);
		s1 = s1 + " Appending to the existing string";
		sb.append(" Appending to the existing string");
		System.out.println(sb);
		
		//Accessing Characters of the string using index and charAt function in Java
		for(int i=0; i<s2.length(); i++)
		{
			System.out.println(s1.charAt(i));
		}
		
		//Accessing character by character from string using for each loop
		for(char ch1 : s2.toCharArray())
		{
			System.out.println(ch1);
		}
		CheckVowel();
	}
	
	//WAP in Java to input a character and check whether its vower or not
	static void  CheckVowel()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Character : ");
		char ch = sc.next().toLowerCase().charAt(0);
		switch(ch)
		{
			case 'a' :
			case 'e' :
			case 'i' :
			case 'o' :
			case 'u' :
				System.out.println("Vowel");
				break;
			default :
				System.out.println("Not a Vowel");
		}
		
	}

}
