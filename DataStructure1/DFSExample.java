package DataStructure1;


public class DFSExample {
	
	int adjMatrix[][];
	int size;
	
	DFSExample(int size)
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
	void DFSTraverse(int startNode)
	{
		Stack s=new Stack(size);
		int[] visited = new int[size];
		for(int i = 0; i<size; i++)
		{
			visited[i] = 0;
		}
		
		s.Push(startNode);
		visited[startNode] = 1;
		System.out.println("DFS Traversal for the given graph is : \n");
		while(!s.isStackEmpty())
		{
			int node = s.Pop();
			System.out.println((char)(node+65));
			
			for(int i=0; i<size; i++)
			{
				if(adjMatrix[node][i] == 1 && visited[i] != 1)
				{
					s.Push(i);
					visited[i] =1;
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		DFSExample dfs = new DFSExample(5);
		dfs.InitializeAdjMatrix();
		dfs.DisplayAdjMatrix();
		dfs.DFSTraverse(0);

	}

}
class Stack
{
	int top;
	int[] arr;
	
	Stack(int size)
	{
		top = -1;
		arr = new int[size];
	}
	
	boolean isStackFull()
	{
//		if(top == arr.length-1)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
		return (top == arr.length - 1);
	}
	
	boolean isStackEmpty()
	{
		return (top == -1);
	}
	
	void Push(int data)
	{
		if(isStackFull())
		{
			System.out.println("Stack Overflow. Cannot insert value into the stack");
		}
		else
		{
//			top++;
//			arr[top]= data;
			
			arr[++top] = data;
			//System.out.println("Data pushed on to the stack successfully.");
		}
	}
	
	
	int Pop()
	{
		if(isStackEmpty())
		{
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return -1;
		}
		else
		{
//			int data = arr[top];
//			top--;
//			return data;
			
			return arr[top--];
		}
	}
	
	
}


