package DataStructure1;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FileHandlingExample {

	public static void main(String[] args) 
	{
		
		FileHandling f = new FileHandling();
		File f1 = new File("D:\\");
		f.PrintAllFiles(f1);
	}

}


class FileHandling
{
	
	
	//Reading Character by Character from file and displaying it on Screen
	//FileReader
	void ReadFileFileReader()
	{
		FileReader fr = null;
		int ch;
		try
		{
			String str = "D:\\Testing\\CircularQueueExample.java";
			fr = new FileReader(str);
			while((ch = fr.read()) != -1)
			{
				System.out.print((char)ch);
			}
			fr.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error in reading the file. " + ex.getMessage());
		}
	}
	
	
	
	//Reading Line by Line
	//Scanner class
	void ReadFileScanner()
	{
		File f = new File("D:\\Testing\\TestFile.txt");
		try
		{
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in reading the file. " + ex.getMessage());
		}
	}
	
	
	void PrintFileInfo()
	{
		File f = new File("D:\\Testing\\ArrayExample.java");
		if(f.exists())
		{
			System.out.println("File Name : " + f.getName());
			System.out.println("Absolute Path : " + f.getAbsolutePath());
			System.out.println("File Size : " + f.length());
			System.out.println("File Last Modified at : " + (new Date(f.lastModified())).toString());
		}
		else
		{
			System.out.println("File Doesnt exist");
		}
	}
	
	
	void PrintAllFileNamesInFolder()
	{
		System.out.println("Enter the Folder Name : ");
		Scanner sc = new Scanner(System.in);
		String strFolderPath = sc.nextLine();
		File f = new File(strFolderPath);
		if(f.exists())
		{
			if(f.isDirectory())
			{
				File[] listFiles = f.listFiles();
				if(listFiles != null)
				{
					for(File fr : listFiles)
					{
						System.out.println((new Date(fr.lastModified())).toString() + "\t" + fr.getName() + "\t\t\t" + fr.getAbsolutePath());
					}
				}
			}
			else
			{
				System.out.println("The Specified Path is File and not folder");
			}
		}
		else
		{
			System.out.println("File Doesnt exist");
		}
	}
	
	
	void SearchTextInFile()
	{
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the File Name with Path : ");		
		String strFilePath = sc.nextLine();		
		
		System.out.println("Enter the Text you want to search in the file : ");
		String strSearchText = sc.next();
		
		File f = new File(strFilePath);
		try
		{
			Scanner sc1 = new Scanner(f);
			while(sc1.hasNextLine())
			{
				String strLine = sc1.nextLine();
				if(strLine.toLowerCase().contains(strSearchText.toLowerCase()))
				{
					flag = true;
					break;
				}
			}
			if(flag)
			{
				System.out.println("Text Exists in the file");
			}
			else
			{
				System.out.println("Text Doenst Exist in the File");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in reading the file. " + ex.getMessage());
		}
		
	}
	
	
	
	boolean CheckStringInFile(File f, String strSearchString)
	{
		boolean flag = false;
		if(f.isFile())
		{
			try
			{
				Scanner sc1 = new Scanner(f);
				while(sc1.hasNextLine())
				{
					String strLine = sc1.nextLine();
					if(strLine.toLowerCase().contains(strSearchString.toLowerCase()))
					{
						flag = true;
						break;
					}
				}
				return flag;
			}
			catch(Exception ex)
			{
				System.out.println("Error in reading the file. " + ex.getMessage());
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	
	
	void CheckStringInFiles()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Folder Path : ");		
		String strFolder = sc.nextLine();		
		
		System.out.println("Enter the Text you want to search in the file : ");
		String strSearchText = sc.next();
		
		File f = new File(strFolder);
		if(f.isDirectory())
		{
			File[] fileList = f.listFiles();
			for(File fr : fileList)
			{
				if(CheckStringInFile(fr,strSearchText))
				{
					System.out.println(fr.getAbsolutePath());
				}
			}
		}
		else
		{
			System.out.println("It is a file and not directory");
		}
	}
	
	
	
	
	//To print all the files absolute path present in folder and also in the subfolders
	void PrintAllFiles(File f)
	{
		if(f.isDirectory())
		{
			File[] fileList = f.listFiles();
			if(fileList != null)
			{
				for(File file : fileList)
				{
					if((file.getAbsoluteFile().toString().endsWith(".java")))
					{
						System.out.println(file.getAbsolutePath());
					}
					if(file.isDirectory())
					{
						
						PrintAllFiles(file);
					}
				}
			}
		}
	}
	
}