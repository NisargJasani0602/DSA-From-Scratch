package DataStructure1;
import java.util.Scanner;

public class RecursiveExample {

	public static void main(String[] args) 
	{
		RecursiveExample r = new RecursiveExample();
		r.CalcDecimal2Binary();
	}
	
	//recursive call
	//termination of recursive calls
	
	//Sum of Series : sum = 1 + 2 + 3 + 4 + .... + n
	void SumExample()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int x = sc.nextInt();
		System.out.println("Sum of the series is : " + Sum(x));
	}
	
	
	
	int Sum(int n)
	{
		if(n == 0)
		{
				return 0;
		}
		else
		{
			return n + Sum(n-1);
		}
	}
	
	void FactorialExample()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int x = sc.nextInt();
		System.out.println("Factorial of the number is : " + Fact(x));
	}

	//Find x!, 
	int Fact(int n)
	{
		if(n == 1 || n == 0)
		{
			return 1;
		}
		else
		{
			return n*Fact(n-1);
		}
	}
	
	
	
	void CalcGCD()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 2 Numbers : ");
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		System.out.println("GCD of the 2 numbers is : " + GCD(x1, x2));
	}

	private int GCD(int n1, int n2) 
	{
		if(n2 == 0)
		{
			return n1;
		}
		else
		{
			return GCD(n2, n1%n2);
		}
	}
	
	void PrintFiboSeries()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++)
		{
			System.out.println(Fibo(i));
		}
	}
	
	int Fibo(int n)
	{
		if(n==0 || n == 1)
		{
			return n;
		}
		else
		{
			return Fibo(n-1) + Fibo(n-2);
		}
	}
	
	//WAP using recursive function to find power of a number x^y
	
	int Power(int x, int y)
	{
		if(y==0)
		{
			return 1;
		}
		else
		{
			return x*Power(x, y-1);
		}
	}
	
	
	//WAP using recursion to find the sum of the digits of a number
	
	int SumDigit(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		else
		{
			return n%10 + SumDigit(n/10);
		}
	}
	
	
	//WAP to print a number in reverse order using recursion
	
	void PrintReverse(int n)
	{
		if(n>0)
		{
			System.out.print(n%10);
			PrintReverse(n/10);
		}
	}
	
	
	void PrintArrayInReverse()
	{
		int a[] = {10,20,30,40,50,60};
		ArrayPrint(a,a.length-1);
	}
	
	void ArrayPrint(int[] a, int n)
	{
		if(n==-1)
		{
			return;
		}
		else
		{
			System.out.println(a[n]);
			ArrayPrint(a, n-1);
		}
	}
	
	//WAP to input a Decimal Number and print its binary number using recursion
	void CalcDecimal2Binary()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the decimal Numbers : ");
		int n = sc.nextInt();
		Decimal2Binary(n);
	}
	
	void Decimal2Binary(int n)
	{
		if(n==0)
		{
			return;
		}
		else
		{
			Decimal2Binary(n/2);
			System.out.print(n%2);
		}
	}
	

}
