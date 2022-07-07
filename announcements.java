
// This class is used to view the recent announcements.

public class announcements {
	
	private Node top;
	private int size;
	// Creating Node
	private class Node{
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}	
	}
	
	// Creating push
	
	public void push(int data) {
		Node tempNode = new Node(data);
		tempNode.next = top;
		top = tempNode;
		// After adding size has to be incremented
		size++;
	}
	
	// Creating pop
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("There are no announcements to remove");
		}
		int result = top.data;
		top = top.next;
		// After removing size has to be decremented
		size--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("There are no announcements");
		}
		return top.data;
	}
	
	// Method for size
	
	public int size(){
		return size;
	}
	// Method to display elements in stack
	public void displayStack() {
		Node current = top;
		while(current!=null) {
			System.out.print(current.data+" ");
			// Traversing through linked list
			current = current.next;
		}
	}
	
	// Checking if stack is empty
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[]args) {
		
		announcements a = new announcements();
		
		System.out.println("Enter the number to execute the following functions");
		System.out.println("1.View announcements");
		System.out.println("2.Add announcement");
		System.out.println("3.View the latest task");
		System.out.println("4.Remove the latest task");
		
		
		
		
		
	}

}
