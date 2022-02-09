import java.util.Scanner;

public class Launcher {
    public static void main(String [] args) {
        System.out.println("Welecome to the best program of the world!!");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str.equals("quit")) {
                break; 
            }
            else {
                System.out.println("Unknown command");
            }
        }
    }
}
