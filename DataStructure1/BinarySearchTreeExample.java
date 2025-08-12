package DataStructure1;

import java.util.Scanner;

public class BinarySearchTreeExample {

	public static void main(String[] args) 
	{
		int option;
		BinarySearchTree bst = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("\nSelect from the following option : ");
			System.out.println("1.\tInserting Node In BST");
			System.out.println("2.\tPre-Order Traversing");
			System.out.println("3.\tIn-Order Traversing");
			System.out.println("4.\tPost-Order Traversing");
			System.out.println("5.\tDeleting Node from BST");
			System.out.println("6.\tSearching Value in BST");
			System.out.println("7.\tDisplay Max Value in BST");
			System.out.println("8.\tDisplay Max Value in BST");
			System.out.println("9.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();
			
			switch(option)
			{
				case 1 : 
					System.out.println("Enter the data to be inserted into the BST : ");
					int data = sc.nextInt();
					bst.root = bst.InsertNode(bst.root, data);
					break;
				case 2 : 
					bst.PreOrder(bst.root);
					break;
				case 3 :
					bst.InOrder(bst.root);
					break;
				case 4 :
					bst.PostOrder(bst.root);
					break;
					
				case 5 :
					System.out.println("Enter the data to be deleted from the BST : ");
					int delVal = sc.nextInt();
					bst.root = bst.DeleteNode(bst.root, delVal);
					break;
				case 6 :
					System.out.println("Enter the data to be searched into the BST : ");
					int val = sc.nextInt();
					BinaryTreeNode temp = bst.SearchNode(bst.root, val);
					if(temp == null)
					{
						System.out.println("Searched Node Not found");
					}
					else
					{
						System.out.println("Searched Node is present in the BST");
					}
					break;
				case 7 :
					System.out.println("Max Value in BST : " + bst.MaxValue(bst.root));
					break;
				case 8 :
					System.out.println("Max Value in BST : " + bst.MinValue(bst.root));
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


class BinarySearchTree
{
	BinaryTreeNode root;
	BinarySearchTree()
	{
		root = null;
	}
	
	//NLR
	void PreOrder(BinaryTreeNode node)
	{
		if(node != null)
		{
			System.out.print(node.data + ", ");
			PreOrder(node.left);
			PreOrder(node.right);
		}
	}
	
	
	//LNR
	void InOrder(BinaryTreeNode node)
	{
		if(node != null)
		{				
			InOrder(node.left);
			System.out.print(node.data + ", ");
			InOrder(node.right);
		}
	}
	
	//LRN
	void PostOrder(BinaryTreeNode node)
	{
		if(node != null)
		{				
			PostOrder(node.left);			
			PostOrder(node.right);
			System.out.print(node.data + ", ");
		}
	}
	
	
	BinaryTreeNode InsertNode(BinaryTreeNode node, int data) 
	{
		if(node == null)
		{
			node = new BinaryTreeNode(data); 
		}
		else if(data < node.data)
		{
			node.left = InsertNode(node.left, data);
		}
		else if(data > node.data) 
		{
			node.right = InsertNode(node.right, data);
		}
		else
		{
			System.out.println("Duplicate data in BST is not allowed here");
		}		
		return node;
	}
	
	
	BinaryTreeNode SearchNode(BinaryTreeNode node, int data)
	{
		if(node == null || node.data == data)
		{
			return node;
		}
		else if (data < node.data) 
		{
			return SearchNode(node.left, data);
		}
		else
		{
			return SearchNode(node.right, data);
		}
	}
	
	int MinValue(BinaryTreeNode node)
	{
		if(node.left == null)
		{
			return node.data;
		}
		else
		{
			return MinValue(node.left);
		}
	}
	
	
	int MaxValue(BinaryTreeNode node)
	{
		if(node.right == null)
		{
			return node.data;
		}
		else
		{
			return MaxValue(node.right);
		}
	}
	
	BinaryTreeNode DeleteNode(BinaryTreeNode node, int data)
	{
		if(node == null)
		{
			System.out.println("Data to be deleted not present in the BST");
			return node;
		}
		else if(data < node.data) 
		{
			node.left = DeleteNode(node.left,data);
		}
		else if(data > node.data) 
		{
			node.right = DeleteNode(node.right,data);
		}
		else if(data == node.data) 
		{			
			if(node.left == null && node.right == null) //Case 1 : Deleting the Leaf Node
			{
				return null;
			}
			else if(node.left == null)//Case 2 : when right child is present
			{
				return node.right;
			}
			else if(node.right == null)//Case 2 : When left child is present
			{
				return node.left;
			}
			else //Case 3 : When both child are present : Successor
			{
				int minVal = MinValue(node.right);
				node.data = minVal;
				//node.right = DeleteNode(node.right,minVal);
				DeleteNode(node.right,minVal);
			}
		}
		return node;
	}
	
}




class BinaryTreeNode
{
	int data;
	BinaryTreeNode left, right;
	
	BinaryTreeNode(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}