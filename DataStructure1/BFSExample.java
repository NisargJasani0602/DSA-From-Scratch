package DataStructure1;

public class BFSExample 
{
	int adjMatrix[][];
	int size;
	
	BFSExample(int size)
	{
		this.size = size;
		adjMatrix = new int[size][size];
	}
	
	void InitializeAdjMatrix()
	{
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
		
		adjMatrix[0][1] = 1;
		adjMatrix[0][3] = 1;
		adjMatrix[1][3] = 1;
		adjMatrix[2][1] = 1;
		adjMatrix[3][4] = 1;
		adjMatrix[4][2] = 1;
	}
	
	void DisplayAdjMatrix()
	{
		System.out.println("\nThe Given Adjacent Matrix is : \n");
		for(int i = 0; i<size; i++)
		{
			for(int j = 0; j<size; j++)
			{
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	void BFSTraverse(int startNode)
	{
		Queue q = new Queue(size) ;
		int[] visited = new int[size];
		for(int i = 0; i<size; i++)
		{
			visited[i] = 0;
		}
		
		q.enqueue(startNode);
		visited[startNode] = 1;
		
		System.out.println("BFS Traversal for the given graph is : \n");
		
		while(!q.isQueueEmpty())
		{
			int node = q.dequeue();
			System.out.println((char)(node+65));
			
			for(int i=0; i<size; i++)
			{
				if(adjMatrix[node][i] == 1 && visited[i] != 1)
				{
					q.enqueue(i);
					visited[i] =1;
				}
			}
			
		}
	}
	
	public static void main(String[] args) 
	{
		BFSExample bfs = new BFSExample(5);
		bfs.InitializeAdjMatrix();
		bfs.DisplayAdjMatrix();
		bfs.BFSTraverse(0);
	}

}


class Queue
{
	int front,rear;
	int[] queue;
	int n;
	Queue(int size)
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
}