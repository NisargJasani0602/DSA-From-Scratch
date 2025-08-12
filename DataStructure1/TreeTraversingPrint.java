package DataStructure1;

public class TreeTraversingPrint 
{

	public static void main(String[] args) 
	{
		BinTreeNode root = null;
		BinTree bt = new BinTree();
		root = bt.InitializeTree(root);
		//System.out.println(bt.GetHeight(root));
		bt.PrintLevelOrder(root);
	}

}


class BinTree
{
	BinTreeNode InitializeTree(BinTreeNode root)
	{
		root = new BinTreeNode("+");
		root.left = new BinTreeNode("*");
		root.right = new BinTreeNode("-");
		root.left.left = new BinTreeNode("1");
		root.left.right = new BinTreeNode("2");
		root.right.left = new BinTreeNode("3");
		root.right.right = new BinTreeNode("4");		
		return root;
	}
	
	
	int GetHeight(BinTreeNode node)
	{
		if(node == null)
		{
			return 0;
		}
		else
		{
			int lh = GetHeight(node.left);
			int rh = GetHeight(node.right);			
			return (lh>rh?(lh+1): (rh+1));
		}
	}
	
	void PrintLevelOrder(BinTreeNode root)
	{
		int h = GetHeight(root);
		for(int i=1; i<=h; i++)
		{
			PrintCurrentLevel(root, i, h);
			for(int j = 0; j<=(h-i); j++)
			{
				System.out.println();
			}
		}
	}
	
	void PrintCurrentLevel(BinTreeNode node, int level, int maxLevel)
	{
		if(node == null)
		{
			return;
		}
		else if(level == 1)
		{
			System.out.print(node.data + " ");
		}
		else if(level >1)
		{
			 PrintCurrentLevel(node.left, level-1, maxLevel);
			 PrintCurrentLevel(node.right, level-1, maxLevel);
		}
			
	}
}



class BinTreeNode{
	String data;
	BinTreeNode left, right;

	BinTreeNode(String data) 
	{
		this.data = data;
	}
}