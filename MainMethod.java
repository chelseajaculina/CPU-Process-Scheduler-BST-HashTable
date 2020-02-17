package programmingAssignment2;

import java.util.*;

import programmingAssignment2.Process;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #2
 * Professor Mike Wu - Spring 2018
 * Due May 2, 2018
 */

/*
 * This method runs the main method that runs the binary search tree and hash table menu
 */
public class MainMethod 
{
	/*
	 *  main tester
	 *  Displays the home menu in where it shows the option to 
	 *  simulate in binary search tree or hash tables
	 */
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in); // creates a scanner
		
		int userChoice;
		
		boolean repeat = true;
		
		do 
		{
			sop("---------------------------------------------------------------");
			sop("\t\t *HOME* Menu - Enter an Option Number \t\t");
			sop("---------------------------------------------------------------");
			sop("0 - Terminate");
			sop("1 - Simulate using Binary Search Tree (BST)"); 
			sop("2 - Simulate using Hash Tables"); 
			sop("---------------------------------------------------------------");
		
			System.out.print("Option Choice: "); // prompt user input
			userChoice = scan.nextInt();
			
			switch(userChoice)
			{
			
				/* case 0
				 * terminate the program 
				 */
				case 0:
				{
					repeat = false;
					sop("Home Program has terminated. Goodbye.");
					break;
				}
				
				/*
				 * case 1
				 * simulate using binary search tree
				 */
				case 1:
				{
					ProcessBST menu = new ProcessBST();
					BSTMenu(menu);
					break;
				}
				
				/*
				 * case 2
				 * simulate using hash tables
				 */
				case 2:
				{
					HashTable menu = new HashTable();
					hashTableMenu(menu);
					break;
				}
				
				default:
				{
						sop("I'm sorry. The option choice that you entered is not valid. Select another option choice. ");
				}
			}
		} while(repeat);
	}
	
	/**
	 * BINARY SEARCH TREE MENU
	 * @param bst - a binary search to perform insert, delete and view a list of processes
	 */
	
	public static void BSTMenu(ProcessBST bst)
	{
		Scanner scan = new Scanner(System.in);
		
		int userChoice;
		
		boolean repeat = true;
 
		sop("");

		for(int i = 0; i < 20; i++)
		{
			Node n = new Node (new Process());
			bst.treeInsert(bst, n);
		}
		bst.inorderTreeWalk(bst.getRoot());
		
		/**
		 * Binary Search Tree Menu Display
		 */
		do 
		{
			sop(" ");
			sop("-------------------------------------------------------------------");
			sop("\t*Binary Search Tree* (BST) MENU - Enter an Option Number \t\t");
			sop("-------------------------------------------------------------------");
			sop("0 - Terminate");
			sop("1 - Insert a Process to the BST (based on priority index)"); 
			sop("2 - Delete a Process from the BST"); 
			sop("3 - View Sorted List of Processes (based on priority index) from BST"); 
			sop("-------------------------------------------------------------------");
		
			System.out.print("Option Choice: ");
			userChoice = scan.nextInt();
			
			switch(userChoice)
			{
				/* case 0
				 * terminate the program
				 */
				case 0:
				{
					repeat = false;
					sop("BST Program has terminated. Goodbye.");
					break;
				}
			
				/*
				 * case 1
				 * insert a process
				 */
				case 1:
				{
					sop("\t\t------Inserting a Process------");
		
					Process newProcess = new Process();
					
					Node newNode = new Node(newProcess);
					
					sop("Process Inserted - " + "Process ID: " + newProcess.getProcessId() + "\t" + "Priority Index of " + newProcess.getProcessId() 
					+ ": " + newProcess.getPriorityIndex());
					
					sop(" ");
					
					bst.treeInsert(bst, newNode);
					
					sop("");
					sop("\t------Process list AFTER insertion------");
					bst.inorderTreeWalk(bst.getRoot());
					break;
					
				}
				
				/*
				 * case 2
				 * delete a process
				 */
				case 2:
				{
					sop("");
					sop("\t\t-------Deleting a Process-------");
					Node n = bst.getRoot();
					
					Process p = new Process();
					
					bst.iterativeTreeSearch(n,  p);
					
					bst.treeDelete(bst, n);
					
					sop("Process Deleted - " + "Process ID: " + n.getKey().getProcessId() + "\t\t" + "Priority Index of " + n.getKey().getProcessId() 
					+ ": " + n.getKey().getPriorityIndex());
					
					sop("");
					
					sop("\t-----Process list AFTER deletion------");
					bst.inorderTreeWalk((bst.getRoot()));
					break;	
				}
				
				/*
				 * case 3
				 * view a sorted list of processes
				 */
				case 3:
				{
					sop("");
					sop("\t-----Sorted List of Processes------");
					bst.inorderTreeWalk(bst.getRoot());
					break;
				}
				
				default:
				{
					sop("I'm sorry. The option choice that you entered is not valid. Select another option choice. ");
				}
			}
		} while (repeat);		
	}

	/**
	 * HASH TABLE MENU
	 * @param hash - the hash table to perform the features of insert, search, delete, and view a list of processes
	 */
	public static void hashTableMenu(HashTable hash)
	{
		Scanner scan = new Scanner(System.in);
		int userChoice;
		boolean repeat = true;

		
		int defaultNumOfProcesses = 20;
		for(int i = 0; i < defaultNumOfProcesses; i++)
		{
			Process p = new Process();
			Node n = new Node(p);
			hash.chainedHashInsert(hash,n);
		}
		
		/* 
		 * Hash Table Menu Display
		 */
		do 
		{
			sop("-------------------------------------------------------------------");
			sop("\t*Hash Table* MENU - Enter an Option Number \t\t");
			sop("-------------------------------------------------------------------");
			sop("0 - Terminate");
			sop("1 - Insert a Process to the Chaining Hash Table"); 
			sop("2 - Search for a Process' name by enter a priority index"); 
			sop("3 - Delete a Process from the Chaining Hash Table"); 
			sop("4 - Make a List of Processes"); 
			sop("-------------------------------------------------------------------");
		
			System.out.print("Option Choice: ");
			userChoice = scan.nextInt();
			
			switch(userChoice)
			{
				/* case 0
				 * terminate the program
				 */
				case 0:
				{
					repeat = false;
					sop("Hash Table Program has terminated. Goodbye.");
					break;
				}
				
				/*
				 * case 1
				 * insert a process
				 */
				case 1:
				{
					sop("");
					sop("------------Inserting a Process------------");
					sop("Enter a process name: ");
					String processName = scan.next();
					Process newProcess = new Process(processName);
					Node newNode = new Node(newProcess);

					hash.chainedHashInsert(hash, newNode);
					
					sop("Process Inserted:");
					sop("Process ID: " + newNode.getKey().getProcessId() + "\t\t" + "Priority Index of " + newNode.getKey().getProcessId() 
							+ ": " + newNode.getKey().getPriorityIndex());
					
					sop("");
					sop("-------List AFTER Insertion of Process--------");
					sop(hash.toHashString());
					break;
				}
				
				/*
				 * case 2
				 * search a process in a hash table
				 */
				case 2:
				{
					sop("\t\t------Search for a Process------");
					Process searchProcess = new Process(); // create a new process
					
					sop("Enter priority index: "); // prompt user to enter a priority index to search for
					int pIndex = scan.nextInt(); // retrieve value from user
					searchProcess.setPriorityIndex(pIndex); // set the new Process' priority index you have created 
	
					Node n = new Node(searchProcess); // store the process in a node
					
					n = hash.chainedHashSearch(hash, pIndex); 
					// perform chained hash search to see if the index is in the hash table or not
					// if it is set it to the new node
					
					/*
					 * while statement that prompts user until a priority index that is already in the hash table exists
					 */
					while (n == null)
					{
						sop("That priority index doesn't exist.");
						sop("Enter priority index: ");
						pIndex = scan.nextInt();
						searchProcess.setPriorityIndex(pIndex);	
					}		
					
					sop(n.toNodeString()); //to string method for node class
					
					break;
				}
				
				/*
				 * case 3
				 * delete a process
				 */
				case 3:
				{
					sop("------Delete a Process------");
					sop("List BEFORE Deletion");
					sop(hash.toHashString());
					
					sop("Enter a priority index to delete a process: ");
					int pId = scan.nextInt();
					
					
					Node nodeToDelete = hash.chainedHashSearch(hash, pId);
					hash.chainedHashDelete(hash, nodeToDelete);
					sop(nodeToDelete.toNodeString());

					break;
				}
				/*
				 * case 4
				 * view sorted list of processes
				 */
				case 4:
				{
					sop("");
					sop("--------Sorted List of Processes based on Priority Index--------");
					sop(hash.toHashString());
					
					break;
				}
					
				default:
				{
					sop("I'm sorry. The option choice that you entered is not valid. Select another option choice. ");
				}
			}
		} while (repeat);
	}

	/**
	 * Private shortcut function that implements the input/output System.out.println
	 * @param x - an object to print
	 */
	private static void sop(Object x)
	{
		System.out.println(x);
	}
}
