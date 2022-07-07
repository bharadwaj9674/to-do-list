import java.io.IOException;
import java.util.Scanner;

public class Employee {
	
	public static void main(String[]args) throws NumberFormatException, IOException {
		
		PriorityQueue pr = new PriorityQueue();
		
		System.out.println("1.To view all tasks");
		System.out.println("2.To view the task that has to be done first");
		System.out.println();
		System.out.println("Enter the number to select the following function");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		if(a==1) {
			pr.activateQ();
			pr.Display();
		}
		if(a==2) {
			pr.activateQ();
			pr.getMin();
		}
		
		scan.close();
	}

}
