import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Login {
	
	static void employee(String c) throws IOException {
		
		FileReader fr = new FileReader(c);
    	BufferedReader br = new BufferedReader(fr);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(terminalColours.GREEN_BRIGHT+"Enter G-Mail:"+terminalColours.RESET+" ");
		String gmail = sc.nextLine();
		System.out.print(terminalColours.GREEN_BRIGHT+"Enter password:"+terminalColours.RESET+" ");
		String password = sc.nextLine();
		
		String oId;
		String oPass;
		String str;
		while((str=br.readLine())!=null) {
			String[] arr = str.split(",");
			oId = arr[0];
			oPass = arr[1];
			
			if(gmail.equals(oId)) {
				if(password.equals(oPass)) {
					Employee employee = new Employee();
					employee.employee();
				}
			}
		}
		br.close();
		sc.close();
	}
	
    static void manager(String c) throws IOException {
		
		FileReader fr = new FileReader(c);
    	BufferedReader br = new BufferedReader(fr);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(terminalColours.GREEN_BRIGHT+"Enter G-Mail:"+terminalColours.RESET+" ");
		String gmail = sc.nextLine();
		System.out.print(terminalColours.GREEN_BRIGHT+"Enter password:"+terminalColours.RESET+" ");
		String password = sc.nextLine();
		
		String oId;
		String oPass;
		String str;
		while((str=br.readLine())!=null) {
			String[] arr = str.split(",");
			oId = arr[0];
			oPass = arr[1];
			
			if(gmail.equals(oId)) {
				if(password.equals(oPass)) {
					Manager manager = new Manager();
					manager.manager();
				}
			}
		}
		br.close();
		sc.close();
	}

    static void director(String c) throws IOException {
    	FileReader fr = new FileReader(c);
    	BufferedReader br = new BufferedReader(fr);
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print(terminalColours.GREEN_BRIGHT+"Enter G-Mail:"+terminalColours.RESET+" ");
    	String gmail = sc.nextLine();
    	System.out.print(terminalColours.GREEN_BRIGHT+"Enter password:"+terminalColours.RESET+" ");
    	String password = sc.nextLine();
    	
    	String oId;
    	String oPass;
    	String str;
    	while((str=br.readLine())!=null) {
    		String[] arr = str.split(",");
    		oId = arr[0];
    		oPass = arr[1];
    		
    		if(gmail.equals(oId)) {
    			if(password.equals(oPass)) {
    				Director director = new Director();
    				director.director();
    			}
    		}
    	}
	br.close();
	sc.close();
}
	
	public void login() throws IOException {
		
        Scanner scan = new Scanner(System.in);
        
        // Logging in using different files
        
		System.out.println("1.Director");
		System.out.println("2.Manger");
		System.out.println("3.Employee");
		System.out.print(terminalColours.WHITE_BACKGROUND_BRIGHT+terminalColours.RED_BOLD_BRIGHT+"Select your position: "+terminalColours.RESET+"  ");
		
		int a = scan.nextInt();
		
		// If-else for logging in
		
		switch(a) {
		case 1:
			Login.director("/Users/bharath/Desktop/DSA_Project/directorLogin.txt");
			break;
		case 2:
			Login.manager("/Users/bharath/Desktop/DSA_Project/managerLogin.txt");
			break;
		case 3:
			Login.employee("/Users/bharath/Desktop/DSA_Project/employeeLogin.txt");
			break;
		}
        scan.close();
	}   
}
