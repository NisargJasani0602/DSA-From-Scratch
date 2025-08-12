package DataStructure1;

import java.util.Date;
import java.io.*;

public class FileTreeExample 
{

	FileNode CreateTreeStructure(FileNode node, File f)
	{
		if (f.isDirectory()) 
		{
			File[] fileList = f.listFiles();			
			node = new FileNode( f.getName(),1,f.length(),f.lastModified(),fileList.length);			
			for(int i=0; i<fileList.length; i++)
			{
				node.ChildNodes[i] = CreateTreeStructure(node.ChildNodes[i], fileList[i]);
			}			
		} 
		else 
		{
			node = new FileNode( f.getName(),0,f.length(),f.lastModified(),0);
		}
		return node;
	}
	
	void DisplayFileTree(FileNode node)
	{
		node.DisplayFileDetails();
		if(node.childCount > 0)
		{
			for(int i = 0; i<node.childCount; i++)
			{
				DisplayFileTree(node.ChildNodes[i]);
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		FileTreeExample f = new FileTreeExample();
		File fRoot = new File("D:\\Testing");
		FileNode root = new FileNode("",0,0,0,0);
		root = f.CreateTreeStructure(root,fRoot);
		f.DisplayFileTree(root);
	}

}



class FileNode
{
	String name;
	int type;
	long size;
	Date date;
	int childCount;
	FileNode[] ChildNodes;
	
	FileNode(String name, int type, long size, long time, int n)
	{
		this.name = name;
		this.type = type;
		this.size = size;
		date = new Date(time);
		ChildNodes = new FileNode[n];
		childCount = n;
	}
	
	void DisplayFileDetails()
	{		
		System.out.println(date.toString() + "\t" + (type==1?"<DIR>\t": "\t") + "\t" + size + "\t" + name);		
	}
}
