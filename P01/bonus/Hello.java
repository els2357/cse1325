import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Hello, " + line + "!");
    }
}