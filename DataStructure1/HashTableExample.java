package DataStructure1;

import java.util.Scanner;

public class HashTableExample 
{

	public static void main(String[] args) 
	{
		Student s;
		int option = 0;
		System.out.println("Select from the Following Option : ");
		System.out.println("1.\tChaining");
		System.out.println("2.\tLinear Probing");
		System.out.print("\nYour Option : ");
		Scanner sc = new Scanner(System.in);
		int selection = sc.nextInt();
		System.out.println("Enter the Size of Hash Table : ");
		int n = sc.nextInt();
		if(selection == 1)
		{
			s = new Chaining(n);
		}
		else
		{
			s = new LinearProbe(n);
		}
		
		do
		{
			System.out.println("Select from the following Option : ");
			System.out.println("1.\tFor Inserting Student Data in Hash Table");
			System.out.println("2.\tFor Displaying Student Data present in Hash Table");
			System.out.println("3.\tFor Deleting Student Data from Hash Table");
			System.out.println("4.\tFor Searching Student Data in Hash Table");
			System.out.println("5.\tFor Exit");
			System.out.print("\nYour Option : ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1 : 
					s.InsertHashTable();
					break;
				case 2 :
					s.DisplayHashTable();
					break;
				case 3 :
					s.DeleteHashTable();
					break;					
				case 4 :
					s.SearchHashTable();
					break;
				case 5 : 
					System.out.println("Exiting the Application. ");
					break;
				default :
					System.out.println("Invalid Option. Please select option again");
					
			}
		}while(option != 5);
			
			
	}

}

interface Student
{
	void InsertHashTable();
	void DeleteHashTable();
	void SearchHashTable();
	void DisplayHashTable();
}

class Chaining implements Student
{
	int size;
	HashNode[] hashHead;
	Chaining(int size)
	{
		this.size = size;	
		hashHead = new HashNode[size];
	}

	private int GetKey(int value)
	{
		return (value%size);
	}
	public void InsertHashTable()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Registration ID : ");
		int regID = sc.nextInt();
		System.out.println("Enter Student Name : ");
		String name = sc.next();
		System.out.println("Enter Student Address : ");
		String Address = sc.next();
		System.out.println("Enter Student Class : ");
		int Class = sc.nextInt();
		System.out.println("Enter Student Grade : ");
		String Grade = sc.next();
		HashNode newNode = new HashNode(regID, Class, name, Address, Grade);
		for(int i = 0; i<size; i++)
		{
			int key = GetKey(regID);
			if(hashHead[key] == null)
			{
				hashHead[key] = newNode;
				System.out.println("Data Inserted into the Hash Table at Key : " + key);
				return;
			}
			else
			{
				HashNode temp = hashHead[key];
				while(temp.next != null)
				{
					temp = temp.next;
				}
				temp.next = newNode;
				System.out.println("Data Inserted into the Hash Table at Key : " + key);
				return;
			}
			
		}
		System.out.println("Error in inserting the data.");
	}

	public void DisplayHashTable() 
	{
		System.out.println("The Data Present in the Hash Table is : ");
		for(int i = 0; i<size; i++)
		{
			System.out.println("__________________________________________________________________________");
			System.out.println("\n\nKey = " + i);
			if(hashHead[i] != null)
			{
				HashNode temp = hashHead[i];
				while(temp != null)
				{
					temp.Display();
					temp = temp.next;
				}						
			}
			else
			{
				System.out.println("\n\t\tLocation is Empty for given key");
			}
		}
		
	}
	
	public void SearchHashTable()
	{
		System.out.println("Enter the Reg ID for which you need to search student details : ");
		Scanner sc = new Scanner(System.in);
		int regID = sc.nextInt();
		int key = GetKey(regID);
		if(hashHead[key] != null )
		{
				HashNode temp = hashHead[key];
				while(temp != null && temp.RegID != regID)
				{
					temp = temp.next;
				}
				if(temp != null && temp.RegID == regID)
				{
					temp.Display();
					return;
				}
		}

		System.out.println("Searched Reg ID is not present in the given Hash Table");
	}
	
	public void DeleteHashTable()
	{
		System.out.println("Enter the Reg ID for which you need to search student details : ");
		Scanner sc = new Scanner(System.in);
		int regID = sc.nextInt();
		int key = GetKey(regID);
		if(hashHead[key] != null )
		{				
				if(hashHead[key].RegID == regID)
				{
					if(hashHead[key].next == null)
					{
						hashHead[key] = null;
					}
					else						
					{
						hashHead[key] = hashHead[key].next;
					}	
					System.out.println("The data to be deleted have been deleted from the key : " + key);
				}
				else
				{
					HashNode temp = hashHead[key];
					HashNode prev = hashHead[key];
					while(temp != null && temp.RegID != regID)
					{
						prev = temp;
						temp = temp.next;
					}
					if(temp != null && temp.RegID == regID)
					{
						prev.next = temp.next;
						System.out.println("The data to be deleted have been deleted from the key : " + key);
						return;
					}
				}
		}

		System.out.println("The Reg ID to be deleted is not present in the given Hash Table");
	}
}


class LinearProbe implements Student
{
	int size;
	HashNode[] hashTable;
	LinearProbe(int size)
	{
		this.size = size;	
		hashTable = new HashNode[size];		
	}
	
	private int GetKey(int value, int i)
	{
		int key = ((value%size)+i)%size;
		return key;
	}
	
	public void InsertHashTable()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Registration ID : ");
		int regID = sc.nextInt();
		System.out.println("Enter Student Name : ");
		String name = sc.next();
		System.out.println("Enter Student Address : ");
		String Address = sc.next();
		System.out.println("Enter Student Class : ");
		int Class = sc.nextInt();
		System.out.println("Enter Student Grade : ");
		String Grade = sc.next();
		HashNode newNode = new HashNode(regID, Class, name, Address, Grade);
		for(int i = 0; i<size; i++)
		{
			int key = GetKey(regID,i);
			if(hashTable[key] == null)
			{
				hashTable[key] = newNode;
				System.out.println("Data Inserted into the Hash Table at Key : " + key);
				return;
			}
			else
			{
				System.out.println("\nCollision Occurred at Key : " + key + " and Probe : " + i);
			}
		}
		System.out.println("Error in inserting the data.");
	}
	
	
	public void DisplayHashTable()
	{
		System.out.println("The Data Present in the Hash Table is : ");
		for(int i = 0; i<size; i++)
		{
			System.out.println("__________________________________________________________________________");
			System.out.println("\n\nKey = " + i);
			if(hashTable[i] != null)
			{
				hashTable[i].Display();
			}
			else
			{
				System.out.println("\nLocation is Empty for given key");
			}
		}
	}


	public void SearchHashTable()
	{
		System.out.println("Enter the Reg ID for which you need to search student details : ");
		Scanner sc = new Scanner(System.in);
		int regID = sc.nextInt();
		for(int i=0; i<size; i++)
		{
			int key = GetKey(regID, i);
			if(hashTable[key] != null && hashTable[key].RegID == regID)
			{
				hashTable[key].Display();
				return;
			}
		}
		System.out.println("Searched Reg ID is not present in the given Hash Table");
	}
	
	public void DeleteHashTable()
	{
		System.out.println("Enter the Reg ID for which you need to delete student details : ");
		Scanner sc = new Scanner(System.in);
		int regID = sc.nextInt();
		for(int i=0; i<size; i++)
		{
			int key = GetKey(regID, i);
			if(hashTable[key] != null && hashTable[key].RegID == regID)
			{
				hashTable[key] = null;
				System.out.println("The Data to be deleted have been deleted from Key : " + key);
				return;
			}
		}
		System.out.println("The data to be deleted for given Reg ID is not present in the given Hash Table");
	}
	

}


class HashNode
{
	int RegID, Class;
	String Name, Address, Grade;
	HashNode next;
	
	HashNode(int RegID,int Class, String Name,String Address,String Grade)
	{
		this.RegID = RegID;
		this.Class = Class;
		this.Name = Name;
		this.Address = Address;
		this.Grade = Grade;
		next = null;
	}
	
	void Display()
	{
		System.out.println("\n\t\tRegistration ID : " + RegID);
		System.out.println("\t\tName : " + Name);
		System.out.println("\t\tAddress : " + Address);
		System.out.println("\t\tClass : " + Class);
		System.out.println("\t\tGrade : " + Grade);
	}
}