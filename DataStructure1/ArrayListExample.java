package DataStructure1;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) 
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(110);
		a.add(20);
		a.add(0,100);
		a.add(320);
		a.add(40);
		
		System.out.println(a.size());
		System.out.println(a);
		System.out.println(a.get(3)+a.get(4));
		a.remove(0);
		System.out.println(a);	
		
		
		ArrayList a1 = new ArrayList();
		a1.add(11);
		a1.add("STRING");
		a1.add(22.55f);
		System.out.println(a1);

	}

}