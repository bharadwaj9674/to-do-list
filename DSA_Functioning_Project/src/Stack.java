import java.io.*;
import java.util.*;

class Stack {
    // Implementing stack using linked list
    static class StackNode {
        String data;
        StackNode next;
        StackNode(String data) { 
            this.data = data; 
        }
    }
     
    StackNode root;
     
    // pushing data to stack
    
    public void push(String data) throws IOException
    {
        StackNode newNode = new StackNode(data);
        if (root == null) {
            root = newNode;
        }
        else {
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
        //System.out.println("Item pushed into stack = "+data);
    }
    
    // deleting and viewing the top most data from stack
  
    public void pop()
    {
        String popped;
        if (root == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = root.data;
            root = root.next;
            System.out.println(popped);
        }
    }
    
    // just viewing the top most data without deleting
  
    public void peek()
    {
        if (root == null) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println(root.data);
        }
    }
    
    public Stack activateStack(Stack s) throws IOException {
        FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/announcements.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String str;
        
        while((str=br.readLine())!=null) {
            s.push(str);
        }
        br.close();
        return s;
    }
    
    /*public static void PrintStack(Stack<Integer> s)
    {
      Stack<Integer> temp = new Stack<Integer>();
       
      while (s.empty() == false)
      {
        temp.push(s.peek());
        s.pop();
      }  
     
      while (temp.empty() == false)
      {
        int t = temp.peek();
        System.out.print(t + " ");
        temp.pop();
     
        // To restore contents of
        // the original stack.
        s.push(t); 
      }
    }*/
  
    public static void main(String[] args) throws IOException{
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter 1 to view the latest announcement...!"+" :");
        int a = scan.nextInt();
        
        Stack s = new Stack();
        
        if(a==1) {
            System.out.println();
            System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Latest Announcement--------->"+terminalColours.RESET);
            System.out.println();
            s=s.activateStack(s);
            s.peek();
        }
        scan.close();
       
    }
}