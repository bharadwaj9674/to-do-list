import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
	
	public static void main(String[]args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.To Do List");
		System.out.println("2.Salary");
		System.out.println("3.Contact List");
		
		System.out.print("Select something:  ");
		
		int a = scan.nextInt();
		
		if(a==1) {
			Login login = new Login();
			login.login();
		}
		
		if(a==2) {
			
		}
		
		if(a==3) {
			
		}
		
		scan.close();
	}
}
