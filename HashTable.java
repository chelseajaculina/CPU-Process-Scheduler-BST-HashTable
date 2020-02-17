package programmingAssignment2;

import java.util.*;



/*
 * Chelsea Jaculina
 * CS 146 - Programming #2
 * Professor Mike Wu - Spring 2018
 * Due May 2, 2018
 */
/*
 * This method implements a a CPU Priority Scheduler using Hash Tables
 */

public class HashTable 
{ 

	private LinkedList[] table; //creates a linked list
	private static int hashTableSize = 11; // Create a 11-slots separate chaining Hash Table for the 20 processes

	/**
	 * Empty Constructor 
	 * Constructs a hash table with 11 slots
	 */
	public HashTable()
	{
		table = new LinkedList[hashTableSize]; // sets the size of the linked list
		for(int i = 0; i < hashTableSize; i++)
		{
			table[i] = new LinkedList(); // creates a linked list for each slot for chaining
		}
	}

	/**
	 * Hash Function
	 * Calculates the index in where the object needs to be insert at
	 * @param x - node in which we will obtain it's priority index and find it's appropriate slot
	 */
	public int hashFunction(Node x)
	{
		int indexSlot = (x.getInfo()) % hashTableSize; // create all slots to hash to
		return indexSlot;
	}
	
	/** 
	 * Insert a process to the chaining Hash Table
	 * @param T - hash table to insert to
	 * @param x - node to insert at the head of the list
	 */
	public void chainedHashInsert(HashTable T, Node x)
	{
		int tableSlot = hashFunction(x); // use the hash function to obtain the slot
		table[tableSlot].listInsert(table[tableSlot], x); // insert the node to the linkedlist slot in the hash table
	}
	
	/**
	 * Search a process' name by entering a priority code
	 * @param T - hash table to search through
	 * @param k - an int to search for in the hash table
	 */
	public Node chainedHashSearch(HashTable T, int k)
	{
		// creates an int to hold the table slot
		// uses the key value k that is passed in and hashes it with the size of the hash table
		int tableSlot = k % hashTableSize; 
		
		// creates a new node and stores the priority into a particular slot
		Node x = table[tableSlot].listSearch(table[tableSlot], k);
		
		if (x == null)
		{
			sop("Can't find node"); // error message if you can't find the node
		}
		return x;
	}
	/**
	 * Delete a process from the chaining Hash Table
	 * @param T - hash table to delete from 
	 * @param x - node to delete
	 */
	public void chainedHashDelete(HashTable T, Node x)
	{
		int tableSlot = hashFunction(x);
		table[tableSlot].listDelete(table[tableSlot], x);
	}

	
	/*
	 * Private shortcut function that implements the input/output System.out.println
	
	 */
	private static void sop(Object x)
	{
		System.out.println(x);
	}
	
	/**
	 * toString function for hash table
	 * This function prints out the hash table with the slot number
	 * It uses the toLinkedString 
	 */
	
	public String toHashString()
	{
		String s = "";
		
		for(int i = 0; i < hashTableSize; i++)
		{
			s = s +  "Slot " + i + ":\n";
			s = s + table[i].toLinkedListString();
			s = s + "\n";
		}
		return s;
	}
}


