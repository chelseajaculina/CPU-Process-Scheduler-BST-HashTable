package programmingAssignment2;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #2
 * Professor Mike Wu - Spring 2018
 * Due May 2, 2018
 */

import java.util.*;

/*
 * This class creates a Process for a CPU Process Scheduling System
 */

public class Process
{
	private String processId; // instance variable for Process Id
	private int priorityIndex; // instance variable for Priority Index
	private static int count; // count for Process Id
	

	/**
	 * No argument constructor
	 * Constructors a process
	 */
	public Process()
	{
		Random randomGen = new Random(); // generator for random number
		count = count + 1; // increase the count 1..2..3..4.5..etc.
		processId = "P" + count; // concatenate character P and the count for process id
		priorityIndex = randomGen.nextInt(1000) + 1;	 // generates a random integer up to the maximum integer value
	}
	
	/**
	 * One argument constructor
	 * @param processId - allows user to pass into a string to produce a process
	 */
	public Process(String processId)
	{
		Random randomGen = new Random(); 
		this.processId = processId; // initializes processId
		priorityIndex = randomGen.nextInt(1000) + 1;	
	}

	/**
	 * Getter method to retrieve process id 
	 * Mainly used for printing out process id
	 */
	public String getProcessId()
	{
		return processId; // returns the processId
	}
	
	/**
	 * setProcessID
	 * Sets the process id
	 * @param s - process id with a new string
	 */
	public void setProcessId(String s)
	{
		processId = s;
	}
	
	/**
	 * gets the priority index
	 * @return priorityIndex - returns the value of the random priority index
	 */
	public int getPriorityIndex()
	{
		return priorityIndex;
	}
	
	/**
	 * Setter method to retrieve priority index
	 * Mainly used for printing out priority index
	 * @param priorityIndex - value to set the priority index 
	 */
	public void setPriorityIndex(int priorityIndex)
	{
		this.priorityIndex = priorityIndex; // returns the priority Index
	}

}


