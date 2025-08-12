package DataStructure1;

import java.util.ArrayList;

public class QueueGenericExample {

	public static void main(String[] args)
	{
		QueueGeneric<String> q1 = new QueueGeneric<String>(10);
		q1.Enqueue("ABC");
		q1.Enqueue("XYZ");
		q1.Enqueue("AAA");
		q1.Enqueue("BBB");
		q1.DisplayQueue();
		q1.Dequeue();
		q1.Enqueue("CCC");
		q1.DisplayQueue();
		
		QueueGeneric<Integer> q2 = new QueueGeneric<Integer>(10);
		q2.Enqueue(10);
		q2.Enqueue(20);
		q2.Enqueue(30);
		
		q2.DisplayQueue();
		
		
		QueueGeneric<Double> q3 = new QueueGeneric<Double>(10);
		q3.Enqueue(10.11);
		q3.Enqueue(20.22);
		q3.Enqueue(30.33);
		
		

	}

}

class QueueGeneric<T>
{
	int front, rear;
	ArrayList<T> queue;
	int size;
	QueueGeneric(int size)
	{
		front = rear = -1;
		queue = new ArrayList<T>();
		this.size = size;
	}
	
	boolean isQueueFull()
	{
		return rear == size -1; // if size is not defined then the queue can never get full since in ArrayList the size is not limited
	}
	boolean isQueueEmpty()
	{
		return (rear == -1 && front == -1);
	}
	
	void Enqueue(T data)
		{
			if(isQueueFull())
			{
				System.out.println("Queue Overflow. Cannot insert value into the queue");
			}
			else if(isQueueEmpty())
				{
					front = 0;
					rear = 0;
					queue.add(data);
					
				}
				else
				{
					rear = rear + 1;
					queue.add(data);
				}
		}
	T Dequeue()
	{
		T temp;
		if(isQueueEmpty())
		{
			System.out.println("Queue Underflow. Cannot delete value from the Queue.");
			return (T) null;
		}
		else if(front == rear)
			{
				temp = queue.get(front);
				queue.remove(front);
				front = -1;
				rear = -1;
				return temp;
			}
			else
			{
				temp =  queue.get(front);
				queue.remove(front);
				front = front + 1;
				return temp;
			}
		
	}
	T Peek()
	{
		if(isQueueEmpty())
		{
			System.out.println("Queue Underflow. Cannot delete value from the Queue.");
			return (T) null;
		}
		else
		{
			return queue.get(front);
		}
		
	}
	void DisplayQueue()
	{
		System.out.println("The Elements present in the Queue : \n");
		for(int i = front; i<=rear; i++)
		{
			System.out.println(" " + queue.get(i));
		}
	}
	
}