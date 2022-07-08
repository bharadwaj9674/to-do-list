import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Director {
	
	public void director() throws IOException {
		
        PriorityQueue pr = new PriorityQueue();
		
		FileWriter fileWriter = new FileWriter("/Users/bharath/Desktop/DSA_Project/taskData.txt", true);
		
		System.out.println(terminalColours.GREEN_BRIGHT+"1.Show Tasks"+terminalColours.RESET);
        System.out.println(terminalColours.RED_BRIGHT+"2.Remove Task"+terminalColours.RESET);
        System.out.println(terminalColours.CYAN_BRIGHT+"3.First Task To Be Done"+terminalColours.RESET);
        System.out.println(terminalColours.YELLOW_BRIGHT+"4.Adding Task"+terminalColours.RESET);
        System.out.println(terminalColours.PURPLE_BRIGHT+"5.Display completed tasks"+terminalColours.RESET);
		
        
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        
        int a = scan.nextInt();
        
        
        if (a == 1) {
        	pr.activateQ();
        	if(pr.isEmpty() == true) {
        		System.out.println(terminalColours.RED_BRIGHT+"There are no tasks to display....!"+terminalColours.RESET);
        	}
        	else {
            pr.Display();
        	}
        }
        
        // To remove tasks
        
        if (a == 2) {
        	pr.activateQ();
            if (pr.isEmpty() == true) {
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
            		pr.removeMin();
            	}
            	
            	// Multiple tasks removing
            	if(single==2) {
            		System.out.print(terminalColours.RED_BRIGHT+"Specify how many tasks to remove:  "+terminalColours.RESET);
            		int multiple = scan.nextInt();
            		for(int i=0;i<multiple;i++) {
            			pr.removeMin();
            		}
            	}   
            }
        }
        
        // Checking if task list is empty

        if (a == 3) {
        	pr.activateQ();
        	if(pr.isEmpty() == true) {
        		System.out.println(terminalColours.RED_BRIGHT+"There are no tasks to do....!"+terminalColours.RESET);
        	}
        	else {
        		pr.getMin();
        	}  
        }
        
        // Adding tasks
        

        if (a == 4) {
        	pr.activateQ();
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
                
                pr.push(string, integer);
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
                    
                    pr.push(string, integer);
                    fileWriter.write(string + "," + integer);
                    fileWriter.write(System.lineSeparator());
        		}
        	}
        	
        	// Displaying completed tasks
        	
        }
        
        if(a==5) {
        	pr.activateQ();
    		pr.tasksCompleted();
    	}
        
        fileWriter.close();
        scan.close();
        sc.close();
		
	}
}
