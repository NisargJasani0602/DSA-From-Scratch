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
			System.out.println("7.\tExit");
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
					//s.Delete_Sepecific_Node();
					break;
				case 6 :
					d.display();
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
		DLLNode lastNode=head;
		while(lastNode.next != null)
		{
			lastNode = lastNode.next;
		}
		lastNode.prev.next = null;
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