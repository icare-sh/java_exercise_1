import java.util.Scanner;

public class Launcher {
    public static void main(String [] args) {
        System.out.println("Welecome to the best program of the world!!");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.equals("quit")) {
            System.out.println("command " + str);
        }
        else {
            System.out.println("Unknown command");
        }
    }
}
