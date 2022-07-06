import java.util.*;

import java.io.*;

public class toDoList {
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

    public static void main(String[] args) throws IOException {
        
        
        
        toDoList toDo = new toDoList();
        FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/taskData.txt");
        BufferedReader bf = new BufferedReader(fr);
        String str;

        while ((str = bf.readLine()) != null) {
            String[] arr = str.split(",");
            toDo.push(arr[0], Integer.parseInt(arr[1]));
        }

        FileWriter fileWriter = new FileWriter("/Users/bharath/Desktop/DSA_Project/taskData.txt", true);

        System.out.println(terminalColours.WHITE_BACKGROUND+terminalColours.BLUE_BOLD+"------------To do list------------"+terminalColours.RESET);
        System.out.println();
        System.out.println(terminalColours.GREEN_BRIGHT+"1.Show Tasks"+terminalColours.RESET);
        System.out.println(terminalColours.RED_BRIGHT+"2.Remove Task"+terminalColours.RESET);
        System.out.println(terminalColours.CYAN_BRIGHT+"3.First Task To Be Done"+terminalColours.RESET);
        System.out.println(terminalColours.YELLOW_BRIGHT+"4.Adding Task"+terminalColours.RESET);
        System.out.println(terminalColours.PURPLE_BRIGHT+"5.Display completed tasks"+terminalColours.RESET);
        System.out.println();

        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.print(terminalColours.WHITE_BACKGROUND+terminalColours.BLUE_BOLD+"Enter one number to do following functions:"+terminalColours.RESET+"  ");
        int a = scan.nextInt();
        
        // To display tasks

        if (a == 1) {
            if(toDo.isEmpty() == true) {
                System.out.println(terminalColours.RED_BRIGHT+"There are no tasks to display....!"+terminalColours.RESET);
            }
            else {
            toDo.Display();
            }
        }
        
        // To remove tasks
        
        if (a == 2) {
            if (toDo.isEmpty() == true) {
                System.out.println(terminalColours.RED_BRIGHT+"There are no tasks to remove.....!"+terminalColours.RESET);
            } 
            else {
                
                
                System.out.println(terminalColours.RED_BRIGHT+"Select to remove single task or multiple tasks"+terminalColours.RESET);
                System.out.println();
                System.out.println("1.Remove Single Task");
                System.out.println("2.Remove Multiple Tasks");
                System.out.print("Enter the number:  ");
                int single = scan.nextInt();
                
                // Single tasks removing
                if(single==1) {
                    toDo.removeMin();
                }
                
                // Multiple tasks removing
                if(single==2) {
                    System.out.print(terminalColours.RED_BRIGHT+"Specify how many tasks to remove:  "+terminalColours.RESET);
                    int multiple = scan.nextInt();
                    for(int i=0;i<multiple;i++) {
                        toDo.removeMin();
                    }
                }   
            }
        }
        
        // Checking if task list is empty

        if (a == 3) {
            if(toDo.isEmpty() == true) {
                System.out.println(terminalColours.RED_BRIGHT+"There are no tasks to do....!"+terminalColours.RESET);
            }
            else {
                toDo.getMin();
            }  
        }
        
        // Adding tasks
        

        if (a == 4) {
            
            System.out.println("1.Add single task");
            System.out.println("2. Add multiple tasks");
            System.out.println("Enter the number to select function:  ");
            int addSingle = scan.nextInt();
            
            // Adding single task
            
            if(addSingle==1) {
                System.out.println(terminalColours.YELLOW_BRIGHT+"Enter the priority"+terminalColours.RESET+"  ");
                int integer = scan.nextInt();
                System.out.println(terminalColours.YELLOW_BRIGHT+"Enter the task"+terminalColours.RESET+"  ");
                String string = sc.nextLine();
                
                toDo.push(string, integer);
                fileWriter.write(string + "," + integer);
                fileWriter.write(System.lineSeparator());
            }
            
            // Adding multiple tasks
            
            if(addSingle==2) {
                System.out.print("Enter the number of tasks you want to enter");
                int multiple = scan.nextInt();
                for(int i=0;i<multiple;i++) {
                    System.out.println(terminalColours.YELLOW_BRIGHT+"Enter the priority"+terminalColours.RESET+"  ");
                    int integer = scan.nextInt();
                    System.out.println(terminalColours.YELLOW_BRIGHT+"Enter the task"+terminalColours.RESET+"  ");
                    String string = sc.nextLine();
                    
                    toDo.push(string, integer);
                    fileWriter.write(string + "," + integer);
                    fileWriter.write(System.lineSeparator());
                }
            }
            
            // Displaying completed tasks
            
        }
        
        if(a==5) {
            toDo.tasksCompleted();
        }
        scan.close();
        sc.close();
        fileWriter.close();
        bf.close();
    }
}
