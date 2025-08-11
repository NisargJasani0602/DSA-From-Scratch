package DataStrructure2;

import java.util.Scanner;



public class PositionalLinkedListExample {

	public static void main(String[] args) 
	{
		
		PositionalLinkedList<Integer> p = new PositionalLinkedList<Integer>();
		int option, data;
		Scanner sc = new Scanner(System.in);
		do 
		{
			System.out.println("\nSelect from the following option : ");
			System.out.println("1.\tAdding Node at the First");
			System.out.println("2.\tAdding Node at the Last");
			System.out.println("3.\tAdding Node Before Specific Node");
			System.out.println("4.\tAdding Node After Specific Node");
			System.out.println("5.\tRemoving Specific Node");
			System.out.println("6.\tTo Check Position Linked List is Empty or not");
			System.out.println("7.\tTo Get the Size of the Positional Linked List");
			System.out.println("8.\tDisplay All Nodes");
			System.out.println("9.\tExit");
			System.out.print("Your Option : ");
			option = sc.nextInt();

			switch (option) 
			{
				case 1:
					System.out.println("Enter the data to be inserted : ");
					data = sc.nextInt();
					p.addFirst(data);
					break;
				case 2:
					System.out.println("Enter the data to be inserted : ");
					data = sc.nextInt();
					p.addLast(data);
					break;
				case 3:
					try
					{
						System.out.println("Enter the data to be inserted : ");
						data = sc.nextInt();
						System.out.println("Enter the data for Specific Node : ");
						int temp = sc.nextInt();
						p.addBefore(p.Search(temp), data);
					}
					catch(IllegalStateException ex)
					{
						System.out.println("Error in Adding Node : " + ex.getMessage());
					}
					break;
				case 4:
					try
					{
						System.out.println("Enter the data to be inserted : ");
						data = sc.nextInt();
						System.out.println("Enter the data for Specific Node : ");
						int temp = sc.nextInt();
						p.addAfter(p.Search(temp), data);
					}
					catch(IllegalStateException ex)
					{
						System.out.println("Error in Adding Node : " + ex.getMessage());
					}
					break;
				case 5:
					try
					{						
						System.out.println("Enter the data for Specific Node to be removed : ");
						int temp = sc.nextInt();
						p.remove(p.Search(temp));
					}
					catch(IllegalStateException ex)
					{
						System.out.println("Error in Deleting Node : " + ex.getMessage());
					}
					break;
				case 6:
					if(p.isEmpty())
					{
						System.out.println("Linked List is Empty");
					}
					else
					{
						System.out.println("Linked List is not Empty");
					}
					break;
				case 7:
					System.out.println("The Total Size of the Linked List : " + p.size());
					break;
				case 8:
					p.DisplayPLL();
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


interface Position<E>
{
	E getElement() throws IllegalStateException;
}

class Node<E> implements Position<E>
{
	private E element;
	private Node<E> prev;
	private Node<E> next;
	
	
	public Node(E e, Node<E> p, Node<E> n)
	{
		this.element = e;
		this.prev = p;
		this.next = n;
	}
	public Node<E> getPrev() 
	{
		return prev;
	}

	public void setPrev(Node<E> prev) 
	{
		this.prev = prev;
	}

	public Node<E> getNext() 
	{
		return next;
	}

	public void setNext(Node<E> next) 
	{
		this.next = next;
	}

	public void setElement(E element) 
	{
		this.element = element;
	}
	public E getElement() throws IllegalStateException
	{
		if(next == null)
		{
			throw new IllegalStateException("Position is not valid");
		}
		return element;
	}
}


interface PositionalLL<E>
{
	int size();
	
	boolean isEmpty();
	
	Position<E> first();
	Position<E> last();
	
	Position<E> before(Position<E> p) throws IllegalStateException ;
	Position<E> after(Position<E> p) throws IllegalStateException;
	
	Position<E> addFirst(E e);
	Position<E> addLast(E e);
	
	Position<E> addBefore(Position<E> p, E e)  throws IllegalStateException;
	Position<E> addAfter(Position<E> p, E e)  throws IllegalStateException;
	
	E set(Position<E> p, E e) throws IllegalStateException;
	
	E remove(Position<E> p) throws IllegalStateException;
}


class PositionalLinkedList<E> implements PositionalLL<E>
{
	private Node<E> header;
	private Node<E> trailer;
	private int size;
	PositionalLinkedList()
	{
		header = new Node(null, null, null);
		trailer = new Node(null, header, null);
		header.setNext(trailer);
		size = 0;
	}
	
	Position<E> position(Node<E> node)
	{
		if(node == header || node == trailer)
		{
			return null;
		}
		else
		{
			return node;
		}
	}
	
	Node<E> validate(Position<E> p) throws IllegalStateException
	{
		if(!(p instanceof Node))
		{
			throw new IllegalStateException("p is not the object of Node class");
		}
		else
		{
			Node<E> n = (Node<E>)p;
			return n;
		}
	}
	
	
	public int size() 
	{		
		return size;
	}

	
	public boolean isEmpty() 
	{		
		return size == 0;
	}

	
	public Position<E> first() 
	{		
		return position(header.getNext());
	}

	
	public Position<E> last() 
	{
		return position(trailer.getPrev());
	}

	
	public Position<E> before(Position<E> p) throws IllegalStateException 
	{
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	
	public Position<E> after(Position<E> p) throws IllegalStateException 
	{
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	
	
	
	public Position<E> addBetween(E e, Node<E> node1, Node<E> node2 )
	{
		Node<E> newNode = new Node<E>(e, node1, node2);
		node1.setNext(newNode);
		node2.setPrev(newNode);
		size++;
		return position(newNode);
		
	}

	public Position<E> addFirst(E e) 
	{
		return addBetween(e, header, header.getNext());		
	}
	
	public Position<E> addLast(E e) 
	{		
		return addBetween(e, trailer.getPrev(), trailer);
	}

	
	public Position<E> addBefore(Position<E> p, E e) throws IllegalStateException 
	{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	
	public Position<E> addAfter(Position<E> p, E e) throws IllegalStateException 
	{		
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	
	public E set(Position<E> p, E e) throws IllegalStateException 
	{
		Node<E> n = validate(p);
		E data = n.getElement();
		n.setElement(e);
		return data;
	}

	
	public E remove(Position<E> p) throws IllegalStateException 
	{
		Node<E> node = validate(p);
		Node<E> node1 = node.getPrev();
		Node<E> node2 = node.getNext();
		
		node1.setNext(node2);
		node2.setPrev(node1);
		E data = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return data;
	}
	
	public Position<E> Search(E data)
	{
		Node<E> temp = header.getNext();
		while(temp != trailer && temp.getElement() != data)
		{
			temp = temp.getNext();
		}
		if(temp == trailer)
		{
			return null;
		}
		else
		{
			return temp;
		}
	}
	public void DisplayPLL()
	{
		Node<E> temp = header.getNext();
		while(temp != trailer)
		{
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
	}
	
}

