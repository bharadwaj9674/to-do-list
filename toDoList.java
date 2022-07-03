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

    public void updateFile() throws IOException{
        FileWriter fw = new FileWriter("/Users/bharath/Desktop/DSA_Project/data.txt");
        Node x = head;
        while(x != null){
            fw.write(x.data+","+x.priority);
            fw.write(System.lineSeparator());
            x=x.next;
        }
        fw.close();
    }

    public void getMin() {
        System.out.println("Task to be completed first:" + " " + head.data);
    }

    public void removeMin() throws IOException {
         Node temp = head;
         System.out.println("Removing the first task completed:"+" "+head.data);
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
            System.out.println("Task: "+t.data + "  ---->  Priority: " + t.priority);
            t = t.next;
        }
    }

    public static void main(String[] args) throws IOException {
        toDoList toDo = new toDoList();
        FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/data.txt");
        BufferedReader bf = new BufferedReader(fr);
        String str;

        while ((str = bf.readLine()) != null) {
            String[] arr = str.split(",");
            toDo.push(arr[0], Integer.parseInt(arr[1]));
        }

        FileWriter fileWriter = new FileWriter("/Users/bharath/Desktop/DSA_Project/data.txt", true);

        System.out.println("------------To do list------------");
        System.out.println();
        System.out.println("1.Show Tasks");
        System.out.println("2.Remove Task");
        System.out.println("3.First Task To Be Done");
        System.out.println("4.Adding Task");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter one number to do following functions:  ");
        int a = scan.nextInt();

        if (a == 1) {
            if(toDo.isEmpty() == true) {
                System.out.println("There are no tasks to display....!");
            }
            else {
            toDo.Display();
            }
        }
        
        if (a == 2) {
            if (toDo.isEmpty() == true) {
                System.out.println("There are no tasks to remove.....!");
            } 
            else {
                toDo.removeMin();
            }
        }

        if (a == 3) {
            if(toDo.isEmpty() == true) {
                System.out.println("There are no tasks to do....!");
            }
            else {
                toDo.getMin();
            }  
        }

        if (a == 4) {
            String string = scan.next();
            int integer = scan.nextInt();
            toDo.push(string, integer);
            fileWriter.write(string + "," + integer);
            fileWriter.write(System.lineSeparator());
        }
        scan.close();
        fileWriter.close();
        bf.close();
    }
}
