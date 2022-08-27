import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = System.getProperty("user.name");
        System.out.println("Hello, " + line + "!");
    }
}