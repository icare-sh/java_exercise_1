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
            else if (str.equals("fibo")) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Donner un nombre entier positif: ");
                int num = scan.nextInt();
                int n1 = 1, n2 = 1, n3 = 0;
                if (num == 0 || num == 1) {
                    System.out.println("Fibo: " + n1);    
                }
                else {
                    for (int i = 2; i <= num; i++) {
                        n3 = n2 + n1;
                        n1 = n2;
                        n2 = n3;
                    }
                    System.out.println("Fibo: " + n1);
                }

            }
            else {
                System.out.println("Unknown command");
            }
        }
    }
}
