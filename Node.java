package programmingAssignment2;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #2
 * Professor Mike Wu - Spring 2018
 * Due May 2, 2018
 */

/*
 * This class implements a Node used for the Binary Search Tree and Hash Table class
 */

public class Node 	
{
	// initializes the properties of a Node		
	private Node left; // left child of the node
	private Node right; // right child of the node
	private Node parent; // parent of the node
	
	private Process key;
	
	private Node next;
	private Node prev;
	
	/**in 
	 * One argument constructor
	 * @param key - places a process into a node 
	 */
	public Node(Process key)
	{
		this.left = null;
		this.right = null;
		this.parent = null;
		this.next = null;
		this.prev = null;
		this.key = key; // creates a node thats a process 
	}
	
	/**
	 * getNext()
	 * Gets the next node in the linked list 
	 */
	public Node getNext()
	{
		return next;
	}
	
	/**
	 * setNext()
	 * Sets the node with another node
	 */
	public void setNext(Node no)
	{
		next = no;
	}
	
	/**
	 * getNext()
	 * Gets the previous node in the linked list  
	 */
	public Node getPrev()
	{
		return next;
	}
	
	/**
	 * setPrev()
	 * Sets the previous node with another node
	 */
	public void setPrev(Node p)
	{
		prev = p;
	}
					
	/**
	* Sets left child node
	* @param left - new node to set the left child
	*/
	public void setLeft(Node left)
	{
		this.left = left;
	}
		
	/**
	* Gets left child node
	* @return left - returns the left child
	*/
	public Node getLeft()
	{
		return left;
	}
	
	/**
	* Set right child node
	* @param right - new node to set the right child
	*/
	public void setRight(Node right)
	{
		this.right = right;
	}
	
	/**
	* Get right child node
	* @return right - returns the right child
	*/
	public Node getRight()
	{
		return right;
	}		
			
	/**
	* Set the value of the node
	* @param key - passes in a Process object and sets it to another process
	*/
	public void setKey(Process key)
	{
		this.key = key;
	}
	
	/**
	* Gets value of the node
	* @return key - value of the node
	*/
	public Process getKey()
	{
		return key;
	}
	
	/**
	 * Sets the parent of the node
	 * @param parent - new node to be set as parent
	 */
	public void setParent(Node parent)
	{
		this.parent = parent;
	}	
			
	/**
	 * Gets the parent 
	 * @return parent - returns the parent
	 */
	public Node getParent()
	{
		return parent;
	}
	
	/**
	 * Gets the info of a Process.
	 * @return info - data that contains the name and the priority index of the Proces.
	 */
	public int getInfo()
	{
		return key.getPriorityIndex();
	}
	
	
	/**
	 * toString method 
	 * Prints out the process ID and 
	 */
	public String toNodeString()
	{
		String s = "";
		//Process p = new Process();
		s = s + "Process ID: " + key.getProcessId() + "\t\t" + "Priority Index of " + key.getProcessId() + ": " + key.getPriorityIndex();
		return s;
	}
	
}
