import java.io.*;
import java.util.*;



public class toDoList {
	
	Node head;
    class Node {
      String data;
      int priority;
      Node next;
      
        Node(String data, int a){
            this.data = data;
            this.priority = a;
        }
  }
    
  public void getMin(){
      System.out.println("Task to be completed first:"+" "+head.data);
  }

   public void removeMin(){
      Node temp = head;
      System.out.println("Removing the first task completed:"+" "+head.data);
      head = head.next;
      temp.next = null;
  }

  public void  push(String data, int priority){
      Node temp = new Node(data, priority);
      if(head==null){
          head = temp;
      }
      else{
          Node t = head;
          if (head.priority > priority) {
              temp.next = head;
              head = temp;
          }
          else {
              while (t.next != null &&
                      t.next.priority < priority) {
                  t = t.next;
              }

              temp.next = t.next;
              t.next = temp;
          }
      }
  }

   public boolean isEmpty(){
      if(head==null){
          return true;
      }
      else{
          return false;
      }
  }
   
  public void Display(){
      Node t = head;
      while(t!=null){
          System.out.println(t.data);
          t = t.next;
      }
  }
	
	public static void main(String[]args) {
		
		toDoList toDo = new toDoList();
		
		toDo.push("task-1", 0);
		toDo.push("task-2", 1);
		toDo.push("task-3", 2);
		toDo.push("task-4", 3);
		
		// Displaying all tasks
		
		toDo.Display();
		
		// Showing the task that user has to complete next
		
		toDo.getMin();
		
		// Deleting the completed task
		
		toDo.removeMin();	
					
		}
}
