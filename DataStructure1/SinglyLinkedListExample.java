package DataStructure1;

import java.util.Scanner;

public class SinglyLinkedListExample {

	public static void main(String[] args) 
	{
		int option;
		SinglyLinkedList s = new SinglyLinkedList();
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("\nSelect from the following option : ");
			System.out.println("1.\tAdding Node at the Beginning");
			System.out.println("2.\tAdding Node at the End");
			System.out.println("3.\tDelete Node at the Beginning");
			System.out.println("4.\tDeleting Node at the End");
			System.out.println("5.\tDeleting Specific Node");
			System.out.println("6.\tDisplay All Nodes");
			System.out.println("7.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1 : 
					s.Add_Node_At_Begin();
					break;
				case 2 : 
					s.Add_Node_At_End();
					break;
				case 3 :
					s.Delete_Node_At_Begin();
					break;
				case 4 :
					s.Delete_Node_At_End();
					break;
				case 5 :
					s.Delete_Sepecific_Node();
					break;
				case 6 :
					s.Display_All_Nodes();
					break;
				case 7 :
					System.out.println("Exiting the program");
					break;
				default : 
					System.out.println("Invalid Option. Please select the option again.");
			}
			
		}while(option != 7);
	}

}


class SinglyLinkedList
{
	Node head;
	
	public SinglyLinkedList() 
	{
		head = null;
	}
	
	boolean isLinkedListEmpty()
	{
		return head == null;
	}
	
	
	void Add_Node_At_Begin()
	{
		int x;
		System.out.println("Enter the data to be present in node : ");
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		Node newnode = new Node(x);
		
		if(isLinkedListEmpty())
		{
			head = newnode;
		}
		else
		{
			newnode.link = head;
			head = newnode;
		}
	}
	
	
	void Add_Node_At_End()
	{
		int x;
		System.out.println("Enter the data to be present in node : ");
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		Node newnode = new Node(x);
		
		if(isLinkedListEmpty())
		{
			head = newnode;
		}
		else
		{
			Node lastnode = head;
			//if the lastnode link is not null, then move it to the next node object till we reach last node
			while(lastnode.link != null) 
			{
				lastnode = lastnode.link; 
			}
			//pointing link of the last node to point it to the newly created node.
			lastnode.link = newnode;
		}
	}
	
	
	int Delete_Node_At_Begin()
	{
		if(isLinkedListEmpty())
		{
			System.out.println("Linked List is Empty. Not able to delete node");
			return (Integer)null;
		}
		else
		{
			Node temp = head;
			head = head.link;
			return temp.data;
		}
	}
	
	int Delete_Node_At_End()
	{
		if(isLinkedListEmpty())
		{
			System.out.println("Linked List is Empty. Not able to delete node");
			return (Integer)null;
		}
		else if(head.link == null)//When only one node is present in the linked list
		{
			Node temp = head;
			head = null;
			return temp.data;
		}
		else //Case when there are more than 1 nodes present in the linked list
		{
			Node prev = head;
			while(prev.link.link != null) //Taking prev to point to the second last node of the linked list
			{
				prev = prev.link;
			}
			Node temp = prev.link;
			prev.link = null;
			return temp.data;
		}		
		
	}
	
	void Delete_Sepecific_Node()
	{
		System.out.println("Enter the data you want to delete : ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(isLinkedListEmpty())
		{
			System.out.println("Linked List is Empty. Not able to delete node");			
		}
		else if(head.data == x)//Node to be deleted is the first node
		{
			head = head.link;
		}
		else //Case when there are more than 1 nodes present in the linked list
		{
			Node temp = head;
			while(temp.link != null && temp.link.data != x)
			{
				temp = temp.link;
			}
			
			if(temp.link == null)
			{
				System.out.println("Specific node to be deleted is not present in the linked list");
			}
			else
			{
				temp.link = temp.link.link;
			}
		}
	}
	
	void Display_All_Nodes()
	{
		Node temp = head;
		System.out.println("Displaying values of all nodes : ");
		while(temp != null)
		{
			temp.Display();
			temp = temp.link;
		}
		
	}
}





class Node
{
	int data;
	Node link;
	
	Node(int data)
	{
		this.data = data;
		link = null;
	}
	
	
	void Display()
	{
		System.out.println(data);
	}
}