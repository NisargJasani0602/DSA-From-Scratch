package DataStructure1;

import java.util.Scanner;

public class AVLTreeExample {

	public static void main(String[] args) {
		int option;
		AVLTree avl = new AVLTree();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\nSelect from the following option for AVL: ");
			System.out.println("1.\tInserting Node In AVL");
			System.out.println("2.\tPre-Order Traversing");
			System.out.println("3.\tIn-Order Traversing");
			System.out.println("4.\tPost-Order Traversing");
			System.out.println("5.\tDeleting Node from AVL");
		    System.out.println("6.\tSearching Value in AVL");
		    System.out.println("7.\tDisplay Max Value in AVL");
			System.out.println("8.\tDisplay Max Value in AVL");
			System.out.println("9.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter the data to be inserted into the AVL : ");
				int data = sc.nextInt();
				avl.root = avl.InsertNode(avl.root, data);
				break;
			case 2:
				avl.PreOrder(avl.root);
				break;
			case 3:
				avl.InOrder(avl.root);
				break;
			case 4:
				avl.PostOrder(avl.root);
				break;
			case 5:
				System.out.println("Enter the data to be deleted from the AVL : ");
				int delVal = sc.nextInt();
				avl.root = avl.DeleteNode(avl.root, delVal);
				break;
			case 6 : 
				System.out.println("Enter the data to be searched into the AVL : ");
				int val = sc.nextInt();
				AVLTreeNode temp = avl.SearchNode(avl.root, val);
				if(temp == null)
				{ 
					System.out.println("Searched Node Not found");
				} 
				else 
				{
					System.out.println("Searched Node is present in the AVL");
				}
				break; 
			case 7 :
			 	 System.out.println("Max Value in AVL : " + avl.MaxValue(avl.root));
			 	 break;
			  
			case 8 :
				 System.out.println("Min Value in AVL : " + avl.MinValue(avl.root));
				 break;
			 
			case 9:
				System.out.println("Exiting the program");
				break;
			default:
				System.out.println("Invalid Option. Please select the option again.");
			}

		} while (option != 9);

	}

}

class AVLTree {
	AVLTreeNode root;

	AVLTree() {
		root = null;
	}

	// NLR
	void PreOrder(AVLTreeNode node) {
		if (node != null) {
			System.out.println(node.data + ", (Height = " + node.height + "), (BF = " + GetBalanceFactor(node) + ")");
			PreOrder(node.left);
			PreOrder(node.right);
		}
	}

	// LNR
	void InOrder(AVLTreeNode node) {
		if (node != null) {
			InOrder(node.left);
			System.out.println(node.data + ", (Height = " + node.height + "), (BF = " + GetBalanceFactor(node) + ")");
			InOrder(node.right);
		}
	}

	// LRN
	void PostOrder(AVLTreeNode node) {
		if (node != null) {
			PostOrder(node.left);
			PostOrder(node.right);
			System.out.println(node.data + ", (Height = " + node.height + "), (BF = " + GetBalanceFactor(node) + ")");
		}
	}

	int GetHeight(AVLTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int lh = (node.left == null) ? 0 : node.left.height;
			int rh = (node.right == null) ? 0 : node.right.height;

			return lh > rh ? (lh + 1) : (rh + 1);
		}
	}

	int GetBalanceFactor(AVLTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int lh = (node.left == null) ? 0 : node.left.height;
			int rh = (node.right == null) ? 0 : node.right.height;

			return lh - rh;
		}
	}

	AVLTreeNode RotateLeft(AVLTreeNode node) 
	{
		AVLTreeNode y = node.right;
		node.right = y.left;
		y.left = node;

		node.height = GetHeight(node);
		y.height = GetHeight(y);

		return y;
	}

	AVLTreeNode RotateRight(AVLTreeNode node) 
	{

		AVLTreeNode y = node.left;
		node.left = y.right;
		y.right = node;

		node.height = GetHeight(node);
		y.height = GetHeight(y);

		return y;
	}

	AVLTreeNode Rotate_LL(AVLTreeNode node) {
		return RotateRight(node);
	}

	AVLTreeNode Rotate_LR(AVLTreeNode node) {
		node.left = RotateLeft(node.left);
		return RotateRight(node);
	}

	AVLTreeNode Rotate_RR(AVLTreeNode node) {
		return RotateLeft(node);
	}

	AVLTreeNode Rotate_RL(AVLTreeNode node) {
		node.right = RotateRight(node.right);
		return RotateLeft(node);
	}

	AVLTreeNode InsertNode(AVLTreeNode node, int data) {
		if (node == null) {
			node = new AVLTreeNode(data);
		} else if (data < node.data) {
			node.left = InsertNode(node.left, data);
			if (GetBalanceFactor(node) == 2) {
				if (data < node.left.data) {
					// LL Rotation
					System.out.println(
							"\nLL Rotation : " + node.data + ", " + node.left.data + ", " + node.left.left.data);
					node = Rotate_LL(node);
				} else {
					// LR Rotation
					System.out.println(
							"\nLR Rotation : " + node.data + ", " + node.left.data + ", " + node.left.right.data);
					node = Rotate_LR(node);

				}
			}

		} else if (data > node.data) {
			node.right = InsertNode(node.right, data);
			if (GetBalanceFactor(node) == -2) {
				if (data > node.right.data) {
					// RR Rotation
					System.out.println(
							"\nRR Rotation : " + node.data + ", " + node.right.data + ", " + node.right.right.data);
					node = Rotate_RR(node);
				} else {
					// RL Rotation
					System.out.println(
							"\nRL Rotation : " + node.data + ", " + node.right.data + ", " + node.right.left.data);
					node = Rotate_RL(node);
				}
			}
		} else {
			System.out.println("Duplicate data in BST is not allowed here");
		}
		node.height = GetHeight(node);
		return node;
	}

	int MinValue(AVLTreeNode node)
	{
		if (node.left == null)
		{
			return node.data;
		}
		else 
		{
			return MinValue(node.left);
		}
	}
	
	int MaxValue(AVLTreeNode node)
	{
		if (node.right == null)
		{
			return node.data;
		}
		else 
		{
			return MaxValue(node.right);
		}
	}


	AVLTreeNode DeleteNode(AVLTreeNode node, int data)
	{
		if (node == null)
		{
			System.out.println("Data to be deleted not present in the BST");
			return node;
		}
		else if (data < node.data) 
		{
			node.left = DeleteNode(node.left, data);
			if (GetBalanceFactor(node) == 2) 
			{
				if (data < node.left.data)
				{
					// LL Rotation
					System.out.println("\nLL Rotation : " + node.data + ", " + node.left.data + ", " + node.left.left.data);
					node = Rotate_LL(node);
				} 
				else 
				{
					// LR Rotation
					System.out.println("\nLR Rotation : " + node.data + ", " + node.left.data + ", " + node.left.right.data);
					node = Rotate_LR(node);
				}
			}
		} 
		else if (data > node.data)
		{
			node.right = DeleteNode(node.right, data);
			if (GetBalanceFactor(node) == -2) 
			{
				if (data > node.right.data) 
				{
					// RR Rotation
					System.out.println("\nRR Rotation : " + node.data + ", " + node.right.data + ", " + node.right.right.data);
					node = Rotate_RR(node);
				} 
				else 
				{
					// RL Rotation
					System.out.println("\nRL Rotation : " + node.data + ", " + node.right.data + ", " + node.right.left.data);
					node = Rotate_RL(node);
				}
			}
		}
		else 
		{
			if (node.left == null && node.right == null) // Case 1 : Deleting the Leaf Node
			{
				return null;
			}
			else if (node.left == null)// Case 2 : when right child is present
			{
				return node.right;
			} 
			else if (node.right == null)// Case 2 : When left child is present
			{
				return node.left;
			} 
			else // Case 3 : When both child are present : Successor
			{
				int minVal = MinValue(node.right);
				node.data = minVal;
				node.right = DeleteNode(node.right,minVal);
			}
		}
		node.height = GetHeight(node);		
		return node;
	}
	
	AVLTreeNode SearchNode(AVLTreeNode node, int data)
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
	
	 

}

class AVLTreeNode {
	int data;
	AVLTreeNode left, right;
	int height;

	AVLTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
		height = 0;
	}
}