import java.util.Scanner;

public class TestScoop{
	public static void main(String[] args){
		System.out.print(
		"=================\n\r" +
		"MICE TESTER v0.01\n\r" +
		"=================\n\r"
		);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Create new (m)ixin, (i)ce cream flavor, or (q)uit? ");
        char input = scanner.next().charAt(0);
        while (input != 'i' && input != 'm' && input != 'q'){
        	System.out.print("You didn't select properly! Try Again!\n");
        	input = scanner.next().charAt(0);
        }
        if (input=='i'){
        	System.out.print("Creating new Ice Cream Flavor!\n");
        }
        else if (input=='m'){
        	System.out.print("Creating new MixIn Flavor!\n");
        }
        else if (input=='q'){
        	System.out.print("Goodbye!\n");
        }
	}
}
