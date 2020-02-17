package programmingAssignment2;

import java.util.*;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #2
 * Professor Mike Wu - Spring 2018
 * Due May 2, 2018
 */
/*
 * A class that demonstrates a Binary Search Tree for a CPU Scheduler
 * Features include: inorderTreeWalk, insert, search, delete
 * Each of the functions implemented are based off pseudocodes in
 * Intro to Algorithms by Thomas H. Cormen
 */

public class ProcessBST 
{ 
	private Node root; // instance variable for the root of the binary search tree
	
	/**
	 * ProcessBST() - Empty Constructor
	 * Sets the root node to empty
	 */
	public ProcessBST()
	{
		root = null;
	}
	
	/**
	 * getRoot() - Getter Method 
	 * This method retrieves the root node of the binary search tree
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/**
	 * setRoot() - Setter Method
	 * This method sets the root node according to the Node that is passed for the binary search tree
	 * @param root - node to set the root to
	 */
	public void setRoot(Node root)
	{
		this.root = root;
	}
	
	/**
	 * inorderTreeWalk() 
	 * This method prints the binary search tree in-order
	 * That is left-node-right
	 * @param - node to start printing at
	 */
	public void inorderTreeWalk(Node x) // prints left-node-right
	{
		if (x != null) // if x != nil
		{
			inorderTreeWalk(x.getLeft()); // inorderTreeWalk(x.left)	
			System.out.println(x.toNodeString()+ " ");	// print x.key
			inorderTreeWalk(x.getRight()); // inorderTreeWalk(x.right)
		}
	}
	
	
	/**
	 * iterativeTreeSearch()
	 * This method is the iterative approach method to search through a binary search tree
	 * @param x - node to compare key value with
	 * @param k - key value to compare with node x
	 * @return x - node that contains the key value 
	 */
	public Node iterativeTreeSearch(Node x, Process k)
	{
		while (x != null && k != x.getKey())// while x != nil and k != x.key
		{
			if (k.getPriorityIndex() < x.getKey().getPriorityIndex()) // if k < x.key
			{
				x = x.getLeft(); 	// x = x.left
			}
			else
			{
				x = x.getRight(); // else x = x.right
			}
		}
		 return x; // return x
	}
	
	/**
	 * treeMinumum()
	 * This method finds the minimum key value in the binary search tree
	 * @param x - node to start the search at
	 * @return x - a pointer to the minimum element in the subtree rooted at the given node x
	 */
	public Node treeMinimum(Node x)
	{
		while (x.getLeft() != null)// while x.left != nil
		{
			x = x.getLeft();// x = x.left
		}
		return x; // return x
	}
	
	/**
	 * treeMaximum()
	 * This method finds the maximum key value in the binary search tree
	 * @param x - node to start the search at
	 * @return x - a pointer to the maximum element in the subtree rooted at the given node x
	 */
	public  Node treeMaximum(Node x)
	{
		while (x.getRight() != null)// while x.right != nil
		{
			x = x.getRight();// x = x.right
		}
		return x;// return x
	}
	
	/**
	 * treeSuccessor()
	 * This method finds the successor of the given node
	 * A successor is defined as the node with the smallest key greater than x.key
	 * @param x - node to find the successor for
	 * @param y - the successor of node x
	 */
	public Node treeSuccessor(Node x)
	{
		if (x.getRight() != null)// if x.right != nil
		{
			return treeMinimum(x.getRight());// return treeMinimum(x.right)
		}
		Node y = x.getParent();// y = x.p
		while (y != null && x == y.getRight())// while y != nil and x == y.right 
		{
			x = y;// x = y
			y = y.getParent();// y = y.p 
		}
		return y; // return y
	}
	
	/*
	 * treeInsert()
	 * This method inserts a new node with a value into the binary search tree
	 * @param T - binary tree to insert to
	 * @param z - the node to insert into binary search tree 'T'
	 */
	public static void treeInsert(ProcessBST T, Node z)
	{
		Node y = null;// y = nil
		Node x = T.root;// x = t.root
		while (x != null)// while x != null
		{ 	
			y = x; // y = x
		
			if (z.getInfo()< x.getInfo())// if z.key < x.key
			{
				x = x.getLeft();// x = x.left
			}
			else
			{
				x = x.getRight();// else x = x.right
			}
		}
		z.setParent(y);// z.p = y
		if (y == null)// if y == nil
		{
		 	T.setRoot(z);// t.root = z // tree T was empty
		}
		else if (z.getInfo() < y.getInfo()) // else if z.key < y.key
		{
			y.setLeft(z); // y.left = z
		}
		else
		{
			y.setRight(z);	 // else y.right = z
		}
		
		//System.out.println(T);
	}
	 
	/**
	 * transplant()
	 * This method is a subroutine in which it allows subtrees to moved around 
	 * within the binary search tree.
	 * It replaces one subtree as a child of its parent with another subtree.
	 * After executing transplant we will see that TRANSPLANT replaces the subtree rooted at 
	 * node 'u' with the subtree rooted at node 'v', and the parent of node 'u' becomes the parent of 
	 * node 'v' and the 'u's parent ends up having 'v' as its appropriate child
	 * @param T - the binary tree to perform the subroutine on
	 * @param u - subtree to swap with
	 * @param v - subtree to swap with
	 */
	public void transplant(ProcessBST T, Node u, Node v)
	{
		if (u.getParent() == null)// if u.p == nil
		{
			T.root = v;// t.root = v
		}
		else if (u == u.getParent().getLeft())// else if u == u.p.left
		{
			u.getParent().setLeft(v);//u.p.left = v
		}
		else
		{
			u.getParent().setLeft(v);// else u.p.right = v 
		}
		if (v != null)// if v != nil
		{
			v.setParent(u.getParent()); //v.p = u.p
		}
	}
	
	/**
	 * treeDelete()
	 * This method deletes a specific node from the Binary Search Tree
	 * There are 3 scenarios when it comes to deleting a node from a BST
	 * 1. node has no children
	 * 2. node has one child
	 * 3. node has two children
	 * @param T - binary search tree to delete node from
	 * @param z - the node to delete from binary search tree 'T'
	 */
	public void treeDelete(ProcessBST T, Node z)
	{
		// has no left child 
		if (z.getLeft() == null)// if z.left == nil
		{
			transplant(T, z, z.getRight());// transplant(t, z, z.right)
		}
		// has no right child
		// else if z.right == nil
		else if (z.getRight() == null)
		{
			transplant(T, z, z.getLeft()); //transplant(t, z, z.left)
		}
		else 	// else y = tree-minimum(z.right)
		{
			Node y = treeMinimum(z.getRight());
			if(y.getParent() != z) 	// if y.p != z
			{
				transplant(T, y, y.getRight()); // transplant(t, y, y.right)
				y.setRight(z.getRight()); // y.right = z.right
				y.getRight().setParent(y);; 	// y.right.p = y
			}
			transplant(T, z, y); //transplant(t, z, y)
			y.setLeft(z.getLeft());; 	// y.left = z.left
			y.getLeft().setParent(y); 	//y.left.p = y
		}	
	}	
}
