import java.util.Scanner;

public class TestScoop{
	public static void main(String[] args){
		System.out.print(
		"=================\n\r" +
		"MICE TESTER v0.01\n\r" +
		"=================\n\n\r"
		);
		
		Scanner scanner = new Scanner(System.in);
		char input;
        while (true){
        	System.out.print("Create new (m)ixin, (i)ce cream flavor, (s)coop, or (q)uit? ");
        	input = scanner.next().charAt(0);

        	if (input=='i'){
        		System.out.print("Creating new Ice Cream Flavor!\n\n");        	
  	     		String buffer = scanner.nextLine();
  	     		System.out.print("Name? ");
        		String name = scanner.nextLine();
        		System.out.print("Description? ");
        		String description = scanner.nextLine();
        		System.out.print("Price? ");
        		int price = scanner.nextInt();
        		System.out.print("Cost? ");
        		int cost = scanner.nextInt();
        		new IceCreamFlavor(name, description, price, cost);
        		
        		System.out.print(
				"\n" + 
				"=================\n\r" +
				"MICE TESTER v0.01\n\r" +
				"=================\n\n\r"
				);       
        	}
        	
        	else if (input=='m'){
        		System.out.print("Creating new MixIn Flavor!\n\n");
        		
        		String buffer = scanner.nextLine();       	
  	     		System.out.print("Name? ");
        		String name = scanner.nextLine();
        		System.out.print("Description? ");
        		String description = scanner.nextLine();
        		System.out.print("Price? ");
        		int price = scanner.nextInt();
        		System.out.print("Cost? ");
        		int cost = scanner.nextInt();
        		
        		new MixInFlavor(name, description, price, cost);
        		
				System.out.print(
				"\n" + 
				"=================\n\r" +
				"MICE TESTER v0.01\n\r" +
				"=================\n\n\r"
				);       
        	}
        	
        	
        	else if (input=='s'){
        		System.out.print("Creating a Scoop of Ice cream!\n");
        		//new Scoop(vanilla);
        	}
        	
        	else if (input=='q'){
        		System.out.print("Goodbye!\n");
        		System.exit(1);
        	}
        	
        	else {
        		System.out.print("Incorrect Input. Try Again!\n");
        	}
		}
	}
}
