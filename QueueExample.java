package ClassCodes;

import java.util.Scanner;

public class QueueExample 
{
	public static void main(String[] args) 
	{
		queues q = new queues(5); 
		int option;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("\nSelect from the following option : ");
			System.out.println("1.\tFor Enqueue Data in Queue");
			System.out.println("2.\tFor Dequeue Data from Queue");
			System.out.println("3.\tFor Peeking Data from the Queue");
			System.out.println("4.\tTo Check whether Queue is full or not");
			System.out.println("5.\tTo Check whether Queue is Empty or not");
			System.out.println("6.\tTo Display the content of the Queue");
			System.out.println("7.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1 : 
					System.out.println("Enter the data to be insert into the Queue : ");
					int data = sc.nextInt();
					q.enqueue(data);
					break;
				case 2 : 
					int val = q.dequeue();
					if(val != -1)
					{
						System.out.println("The Deleted data is : " + val);
					}
					break;
				case 3 :
					int val1 = q.peek();
					System.out.println("The data present on the front of the Queue is : " + val1);
					break;
				case 4 :
					if(q.isQueuefull())
					{
						System.out.println("Queue is Full");
					}
					else
					{
						System.out.println("Queue is not Full");
					}
					break;
				case 5 :
					if(q.isQueueEmpty())
					{
						System.out.println("Queue is Empty");
					}
					else
					{
						System.out.println("Queue is not Empty");
					}
					break;
				case 6 :
					q.display();
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

class queues
{
	int front,rear;
	int[] queue;
	int n;
	queues(int size)
	{
		n=size;
		front=-1;
		rear=-1;
		queue=new int[n];
	}
	boolean isQueuefull()
	{
		return(rear==n-1);
	}
	boolean isQueueEmpty() 
	{
		return(rear==-1 && front==-1);
	}
	void enqueue(int data)
	{
		if(isQueuefull()) 
		{
			System.out.println("Queue overflow");
			return;
		}
		else if(isQueueEmpty())
		{
			rear=0;
			front=0;			
		}
		else 
		{
			rear++;
		}
		queue[rear] = data;
		
	}
	int dequeue()
	{
		if(isQueueEmpty())
	    {
			System.out.println("stack underflow");
			return -1;
	    }
		else if(front==rear)
		{
			int temp=queue[front];
			front=-1;
			rear=-1;
			return temp;
		}
		else 
			return queue[front++];
		
	}
	int peek()
	{
		if(isQueueEmpty())
		{
		    System.out.println("queue underflow");
		    return -1;
		}
		else return queue[front];
	}
	void display() 
	{
		for(int i=front;i<=rear;i++)
		{
			System.out.println(queue[i]);
		}
	}
}