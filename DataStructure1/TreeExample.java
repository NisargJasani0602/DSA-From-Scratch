package DataStructure1;

public class TreeExample 
{
	
	TreeNode InitializeTree(TreeNode root)
	{
		root = new TreeNode("Electronics R'US", 4);
		root.ChildNodes[0] = new TreeNode("R&D",0);
		root.ChildNodes[1] = new TreeNode("Sales",2);
		root.ChildNodes[2] = new TreeNode("Purchasing",0);
		root.ChildNodes[3] = new TreeNode("Manufacturing",3);
		
		root.ChildNodes[1].ChildNodes[0] = new TreeNode("Domestic",0);
		root.ChildNodes[1].ChildNodes[1] = new TreeNode("International",3);
		
		root.ChildNodes[3].ChildNodes[0] = new TreeNode("TV",0);
		root.ChildNodes[3].ChildNodes[1] = new TreeNode("CD",0);
		root.ChildNodes[3].ChildNodes[2] = new TreeNode("Tuner",0);
		
		root.ChildNodes[1].ChildNodes[1].ChildNodes[0] = new TreeNode("Canada",0);
		root.ChildNodes[1].ChildNodes[1].ChildNodes[1] = new TreeNode("America",0);
		root.ChildNodes[1].ChildNodes[1].ChildNodes[2] = new TreeNode("Overseas",4);
		
		root.ChildNodes[1].ChildNodes[1].ChildNodes[2].ChildNodes[0] = new TreeNode("Africa",0);
		root.ChildNodes[1].ChildNodes[1].ChildNodes[2].ChildNodes[1] = new TreeNode("Europe",0);
		root.ChildNodes[1].ChildNodes[1].ChildNodes[2].ChildNodes[2] = new TreeNode("Asia",0);
		root.ChildNodes[1].ChildNodes[1].ChildNodes[2].ChildNodes[3] = new TreeNode("Australia",0);
		return root;
	}

	void DisplayTree(TreeNode node, int n, String prefix)
	{
		if(n!=0)
		{
			System.out.println(prefix + n + "\t" + node.strName);
		}
		else
		{
			System.out.println(node.strName);
		}
		
		if(node.childCount>0)
		{
			for(int i=0; i<node.childCount; i++)
			{
				if(n==0)
				{
					DisplayTree(node.ChildNodes[i], i+1,"\t" );
				}
				else
				{
					DisplayTree(node.ChildNodes[i], i+1,"\t" + prefix + n + "." );
				}
				
			}			
		}
	}
	public static void main(String[] args) 
	{
		TreeNode root = null;
		TreeExample t = new TreeExample();
		root = t.InitializeTree(root);
		t.DisplayTree(root, 0, "");
		
	}

}


class TreeNode
{
	String strName;
	TreeNode[] ChildNodes; // creating array of Objects(nodes) of Tree Node 
	int childCount;
	TreeNode(String strName, int n) // here 'n' is the number of child objects 
	{
		this.strName = strName;
		childCount = n;
		ChildNodes = new TreeNode[n];
	}
}
