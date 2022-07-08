import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	
	public void login() throws IOException {
		
        Scanner scan = new Scanner(System.in);
        
        // Logging in using different files
        
        System.out.println("Select your position");
		System.out.println("1.Director");
		System.out.println("2.Manger");
		System.out.println("3.Employee");
		
		System.out.print("Enter your position: ");
		int a = scan.nextInt();
        
        if(a==1) {
        	FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/directorLogin.txt");
        	BufferedReader br = new BufferedReader(fr);
        	
        	Scanner sc = new Scanner(System.in);
    		
    		String oId;
    		String oPass;
    		String str;
    		while((str=br.readLine())!=null) {
    			String[] arr = str.split(",");
    			oId = arr[0];
    			oPass = arr[1];	
    			
    			System.out.println("Enter gmail");
    			String gmail = sc.nextLine();
    			System.out.println("Enter password");
    			String password = sc.nextLine();
    			
    			
    			if(gmail.equals(oId)) {
    				System.out.println("Mail");
    				if(password.equals(oPass)) {
    					Director director = new Director();
    					director.director();
    				}else {
    					System.out.println("Wrong Password....! ");
    				}
    			}else {
    				System.out.println("Wrong mail");
    			}
    		}
    		br.close();
    		sc.close();	
    	
        }
        if(a==2) {
        	FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/managerLogin.txt");
        	BufferedReader br = new BufferedReader(fr);
        	Scanner sc = new Scanner(System.in);
    		
    		String oId;
    		String oPass;
    		String str;
    		while((str=br.readLine())!=null) {
    			String[] arr = str.split(",");
    			oId = arr[0];
    			oPass = arr[1];	
    			
    			System.out.println("Enter gmail");
    			String gmail = sc.nextLine();
    			System.out.println("Enter password");
    			String password = sc.nextLine();
    			
    			if(gmail.equals(oId)) {
    				System.out.println("Mail");
    				if(password.equals(oPass)) {
    					Manager manager = new Manager();
    					manager.manager();
    				}else {
    					System.out.println("Wrong Password....! ");
    				}
    			}else {
    				System.out.println("Wrong mail");
    			}
    		}
    		br.close();
    		sc.close();	
    	}
        
        if(a==3) {
        	FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/employeeLogin.txt");
        	BufferedReader br = new BufferedReader(fr);
        	Scanner sc = new Scanner(System.in);
    		
    		String oId;
    		String oPass;
    		String str;
    		while((str=br.readLine())!=null) {
    			String[] arr = str.split(",");
    			oId = arr[0];
    			oPass = arr[1];	
    			
    			System.out.println("Enter gmail");
    			String gmail = sc.nextLine();
    			System.out.println("Enter password");
    			String password = sc.nextLine();
    			
    			if(gmail.equals(oId)) {
    				System.out.println("Mail");
    				if(password.equals(oPass)) {
    					Employee employee = new Employee();
    					employee.employee();
    				}else {
    					System.out.println("Wrong Password....! ");
    				}
    			}else {
    				System.out.println("Wrong mail");
    			}
    		}
    		br.close();
    		sc.close();	
    	}
        scan.close();
	}   
}
