import java.util.*;
import java.io.*;

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
    
    public void Display() throws FileNotFoundException{
    	File file = new File("/Users/bharath/Desktop/DSA_Project/data.txt");
    	Scanner scan = new Scanner(file);
    	while(scan.hasNextLine()) {
    		String str = scan.nextLine();
    		String[] arr = str.split(",");
    		System.out.println("task: "+arr[0]+" --> priority: "+arr[1]);
    	}
    	scan.close();
    }
    	
    
	public static void main(String[]args) throws IOException{
		
		FileWriter fileWriter = new FileWriter("/Users/bharath/Desktop/DSA_Project/data.txt",true);

		
		
		toDoList toDo = new toDoList();
		
		System.out.println("------------To do list------------");
		System.out.println();
		System.out.println("1.Show Tasks");
		System.out.println("2.Remove Task");
		System.out.println("3.Adding Task");
		System.out.println();
		
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter one number to do following functions:  ");
		int a = scan.nextInt();
		
		if(a==1) {
				toDo.Display();
		}
		if(a==2) {
			if(toDo.isEmpty()==true) {
				System.out.println("There are no tasks to remove.....!");
			}
			else {
				toDo.removeMin();
			}
		}
		
		if(a==3) {
			String string = scan.next();
			int integer = scan.nextInt();
			toDo.push(string, integer);	
			fileWriter.write(string+","+integer);
			fileWriter.write(System.lineSeparator());
		}
		scan.close();
		fileWriter.close();
	}
}
