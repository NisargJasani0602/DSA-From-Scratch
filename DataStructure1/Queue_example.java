package DataStructure1;

import java.util.Scanner;

public class Queue_example {

		public static void main(String[] args)
		{	
			Queue q = new Queue(5);
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
						q.Enqueue(data);
						break;
					case 2 : 
						int val = q.Dequeue();
						if(val != -1)
						{
							System.out.println("The Deleted data is : " + val);
						}
						break;
					case 3 :
						int val1 = q.Peek();
						System.out.println("The data present on the front of the Queue is : " + val1);
						break;
					case 4 :
						if(q.isQueueFull())
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
						q.DisplayQueue();
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

class Queue
{
	int front, rear;
	int[] queue;
	int size;
	
	Queue(int size)
	{
		this.size = size;
		front = -1;
		rear = -1;
		queue = new int[size];
		
	}
	
	boolean isQueueFull()
	{
		return (rear ==size -1);
	}
	boolean isQueueEmpty()
	{
		return( rear == -1 && front == -1);
	}
	void Enqueue(int data)
	{
		if(isQueueFull())
		{
			System.out.println("Queue Overflow. Cannot insert value into the queue");
		}
		else if(isQueueEmpty())
			{
				front = 0;
				rear = 0;
				queue[rear]= data;
				
			}
			else
			{
				rear = rear + 1;
				queue[rear]= data;
			}
		
	}
	
	int Dequeue()
	{
		int temp;
		if(isQueueEmpty())
		{
			System.out.println("Queue Underflow. Cannot delete value from the Queue.");
			return (Integer) null;
		}
		else if(front == rear)
			{
				temp = queue[front];
				front = -1;
				rear = -1;
				return temp;
			}
			else
			{
				temp =  queue[front];
				front = front + 1;
				return temp;
			}
		
	}
	
	int Peek()
	{
		if(isQueueEmpty())
		{
			System.out.println("Queue Underflow. Cannot delete value from the Queue.");
			return (Integer) null;
		}
		else
		{
			return queue[front];
		}
		
	}
	void DisplayQueue()
	{
		System.out.println("The Elements present in the Queue : \n");
		for(int i = front; i<=rear; i++)
		{
			System.out.println(queue[i]);
		}
	}
}
