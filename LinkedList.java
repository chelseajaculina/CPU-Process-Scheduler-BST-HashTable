package programmingAssignment2;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #2
 * Professor Mike Wu - Spring 2018
 * Due May 2, 2018
 */

/*
 * This class implements a linked list
 * It 
 */

public class LinkedList 
{
	private Node head; // node for the head
	//Node tail; // node for the tail
	
	/**
	 * Getter method for Node head
	 */
	public Node getHead()
	{
		return head;
	}
	
	/**
	 * Setter method for Node head
	 * @param head - the new head
	 */
	public void setHead(Node head)
	{
		this.head = head;
	}

	/**
	 * listInsert
	 * This method procedure 'splices' x onto the front of the linked list
	 * @param L - linked list to insert to 
	 * @param x - node to insert
	 */
	public void listInsert(LinkedList L, Node x)
	{
		x.setNext(L.getHead()); // x.next = L.head;
		if (L.head != null) // when the head doesn't equal to null
		{
			L.getHead().setPrev(x);
		}
		L.head = x;
		x.setPrev(null);
	}
	
	/**
	 * listSearch
	 * This method uses a simple linear search in a given linked list
	 * and returns a pointer to the element 
	 * @param L  - linked list to search through
	 * @param k - the process to search for
	 * @return x - returns the node in the linked list
	 */
	public Node listSearch(LinkedList L, int k)
	{
		Node x = L.head;
		while(x != null && x.getInfo() != k)
		{
			x = x.getNext();
		}
		return x;
	}
	
	/**
	 * listDelete
	 * This method removes an element x from a linked list L
	 * @param L - linked list to delete from 
	 * @param x - the node to delete
	 */
	public void listDelete(LinkedList L, Node x)
	{
		if (x.getPrev() != null)
		{
			x.getPrev().setNext(x.getNext());
		}
		else
		{
			L.head = x.getNext();
		}
		if(x.getNext() != null)
		{
			x.getNext().setPrev(x.getPrev());
		}
	}
	
	
	/**
	 * toString function that prints out a linked list
	 */
	public String toLinkedListString()
	{
		String s = "";
		Node head = getHead(); // retrieve the head
		
		if(head == null) // check if the head is empty 
			return s;
		
		s = s +  head.toNodeString(); // print out the linkedlist for the head
		s = s + "\n"; // new space
		
		while (head.getNext() != null)
		{
			head = head.getNext(); // obtain the next node 
			s = s + head.toNodeString(); // print out each node until it hits the tail
			s = s + "\n";
		}
		return s;
		
	}
	
	/**
	 * Private shortcut function that implements the input/output System.out.println
	 */
	private static void sop(Object x)
	{
		System.out.println(x);
	}
}
