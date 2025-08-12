package DataStructure1;

import java.util.Scanner;

public class DoublyLinkedListExample {

	public static void main(String[] args) {
		int option;
		DoublyLinkedList d = new DoublyLinkedList();
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
			System.out.println("7.\tAdding Node After a Specific Node");
			System.out.println("8.\tAdding Node Before a Specific Node");
			System.out.println("9.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1 : 
					d.AddNodeAtStart();
					break;
				case 2 : 
					d.AddNodeAtEnd();
					break;
				case 3 :
					d.DeleteNodeAtBegin();
					break;
				case 4 :
					d.DeleteNodeAtEnd();
					break;
				case 5 :
					d.DeleteSpecificNode();
					break;
				case 6 :
					d.display();
					break;
				case 7 :
					d.Add_Node_AfterSpecificNode();
					break;
				case 8:
					d.Add_Node_BeforeSpecificNode();
					break;
				case 9 :
					System.out.println("Exiting the program");
					break;
				default : 
					System.out.println("Invalid Option. Please select the option again.");
			}
			
		}while(option != 9);
	}

}


class DoublyLinkedList
{
	DLLNode head;
	
	boolean isEmpty()
	{
		return head==null;
	}
	
	DoublyLinkedList()
	{
		head = null;
	}
	
	void AddNodeAtStart()
	{
		int x;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data to be added:");
		x=sc.nextInt();
		DLLNode<Integer> newNode=new DLLNode<Integer>(x);
		if(isEmpty())
		{
			head=newNode;
		}
		else
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
			
	}
	
	void AddNodeAtEnd()
	{
		int x;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data to be added:");
		x=sc.nextInt();
		DLLNode<Integer> newNode=new DLLNode<Integer>(x);
		if(isEmpty())
		{
			head=newNode;
		}
		else
		{
			DLLNode lastNode=head;
			while(lastNode.next !=null)
			{
				lastNode=lastNode.next;
			}
			lastNode.next=newNode;
			newNode.prev=lastNode;
		}
		
	}
	
	void DeleteNodeAtBegin()
	{
		if(isEmpty())
		{
			System.out.println("list is empty ,cannot remove node");
		}
		else if(head.next==null)
		{
			head=null;
		}
		else
		{
			head=head.next;
			head.prev=null;
		}
	}
	
	void DeleteNodeAtEnd()
	{
		if(isEmpty())
		{
			System.out.println("list is empty ,cannot remove node");
		}
		else if(head.next==null)
		{
			head=null;
		}
		else
		{	
			DLLNode lastNode=head;
			while(lastNode.next != null)
			{
				lastNode = lastNode.next;
			}
			lastNode.prev.next = null;
		}
		
	}
	
	void DeleteSpecificNode()
	{
		System.out.println("Enter The data that you want to delete :");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		if(isEmpty())
		{
			System.out.println("Linked List is Empty. Cannot delete the Node.");
		}
		
		DLLNode temp = head;
		else
		
			while(temp != null && temp.data != x)
			{
				temp = temp.next;
			}
			if(temp == null)
			{
				System.out.println("The Specified data not found in the given linked list. So not able to delete the data");
			}
			else if(temp.prev == null)
			{
				 DeleteNodeAtBegin();
			}
			else if(temp.next == null)
			{
				DeleteNodeAtEnd();
			}
			else
			{
				temp.next.prev = temp.prev;
				temp.prev.next = temp.next;
			}
		
		
	}
	
	void Add_Node_AfterSpecificNode()
	{
		int x;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data to be added:");
		x=sc.nextInt();
		DLLNode<Integer> newNode=new DLLNode<Integer>(x);
		
		int y;
		Scanner sc1 =new Scanner(System.in);
		System.out.println("Enter the data after which the Node is to be to be added:");
		y=sc.nextInt();
		DLLNode temp = head;
		while(temp != null && temp.data != y)
		{
			temp = temp.next;
		}
		if(temp == null)
		{
			System.out.println("The specified data not found in the given linked list. So not able to add the data in DLL");
		}
		else if(temp.next == null) //if the Specific Node is the last node : (if(temp->next == null)
		{
			temp.next = newNode;
			newNode.prev = temp;
		}
		else
		{
			newNode.next = temp.next;
			newNode.prev = temp;
			temp.next.prev = newNode;
			temp.next = newNode;
		}
	}
	
	void Add_Node_BeforeSpecificNode() 
	{
		int x;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data to be added:");
		x=sc.nextInt();
		DLLNode<Integer> newNode=new DLLNode<Integer>(x);
		
		int y;
		Scanner sc1 =new Scanner(System.in);
		System.out.println("Enter the data before which the Node is to be to be added:");
		y=sc.nextInt();
		DLLNode temp = head;
		while(temp != null && temp.data != y)
		{
			temp = temp.next;
		}
		if(temp == null)
		{
			System.out.println("The specified data not found in the given linked list. So not able to add the data in DLL");
		}
		else if(temp.prev == null) // if the Specific Node is the start node : (if(temp->prev == null)
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			newNode.next = temp;
		}
		else
		{
			newNode.next = temp;
			newNode.prev = temp.prev;
			temp.prev.next = newNode;
			temp.prev = newNode;
			
		}
	}
	
	
	void display()
	{
		System.out.println("displayinng all the nodes:");
		DLLNode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
}




class DLLNode<T>
{
	T data;
	DLLNode prev, next;
	
	DLLNode(T data)
	{
		this.data = data;
		prev = null;
		next = null;
	}
}