package org.java.full.stack.java9;

/**
 * Java has improved its process API in Java 9 version that helps to manage and
 * control operating system processes.
 * 
 * @author Rupak Kumar...
 *
 */
public class Java9Process {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProcessHandle currentProcess = ProcessHandle.current(); // Current processhandle
		System.out.println("Process Id: " + currentProcess.pid()); // Process id
		System.out.println("Direct children: " + currentProcess.children()); // Direct children of the process
		System.out.println("Class name: " + currentProcess.getClass()); // Class name
		System.out.println("All processes: " + ProcessHandle.allProcesses()); // All current processes
		System.out.println("Process info: " + currentProcess.info()); // Process info
		System.out.println("Is process alive: " + currentProcess.isAlive());
		System.out.println("Process's parent " + currentProcess.parent()); // Parent of the processs
	}

}
