import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class PriorityQueue {
	
	static Node head;

    class Node {
        String data;
        int priority;
        Node next;

        Node(String data, int a) {
            this.data = data;
            this.priority = a;
        }
    }
    
    // Updating file

    public void updateFile() throws IOException{
        FileWriter fw = new FileWriter("/Users/bharath/Desktop/DSA_Project/taskData.txt");
        Node x = head;
        while(x != null){
            fw.write(x.data+","+x.priority);
            fw.write(System.lineSeparator());
            x=x.next;
        }
        fw.close();
    }
    
    // Method for displaying completed tasks
    
    public void tasksCompleted() throws IOException {
    	
    	FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/taskCompleted.txt");
    	BufferedReader br = new BufferedReader(fr);
    	
    	System.out.println(terminalColours.PURPLE_BOLD_BRIGHT+terminalColours.WHITE_BACKGROUND+"Completed tasks list"+terminalColours.RESET);
    	String str;
    	while((str=br.readLine())!=null) {
    		
    		String arr[] = str.split(",");
    		System.out.println(terminalColours.PURPLE_BRIGHT+"Task: "+terminalColours.RESET+" "+arr[0]/*+"   ---->   "+terminalColours.PURPLE_BRIGHT+"Priority: "+terminalColours.RESET+" "+arr[1]*/);
    	}	
    	br.close();
    }
    
    // Getting minimum from the file

    public void getMin() {
        System.out.println(terminalColours.CYAN_BRIGHT+"Task to be completed first:" +terminalColours.RESET+ "  " + head.data);
    }

    public void removeMin() throws IOException {
         Node temp = head;
         System.out.println(terminalColours.RED_BRIGHT+"Removing the first task completed:"+terminalColours.RESET+"  "+head.data);
         
      // Keeping track of completed tasks
         FileWriter fw = new FileWriter("/Users/bharath/Desktop/DSA_Project/taskCompleted.txt",true);
         fw.write(head.data + "," + head.priority);
         fw.write(System.lineSeparator());
         fw.close();
         head = head.next;
         temp.next = null;
         

         updateFile();
    }

    public void push(String data, int priority) {
        Node temp = new Node(data, priority);
        if (head == null) {
            head = temp;
        } 
        else {
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

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } 
        else {
            return false;
        }
    }

    public void Display() {
        Node t = head;
        while (t != null) {
            System.out.println(terminalColours.GREEN_BOLD+"Task: "+terminalColours.RESET+t.data + "  ---->  "+terminalColours.GREEN_BOLD+"Priority:  "+terminalColours.RESET+ t.priority);
            t = t.next;
        }
    }
    
    public void activateQ() throws NumberFormatException, IOException {
   	 PriorityQueue toDo = new PriorityQueue();
        FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/taskData.txt");
        BufferedReader bf = new BufferedReader(fr);
        String str;

        while ((str = bf.readLine()) != null) {
            String[] arr = str.split(",");
            toDo.push(arr[0], Integer.parseInt(arr[1]));
        }
        bf.close();
   }
}
