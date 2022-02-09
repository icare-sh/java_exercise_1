import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Launcher {
    public static void main(String [] args) 
        throws IOException
    {
        System.out.println("Welecome to the best program of the world!!");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str.equals("quit")) {
                break; 
            }
            else if (str.equals("fibo")) {
               fibo();  
            }
            else if (str.equals("freq")) {
                freq();              
            }
            else {
                System.out.println("Unknown command");

            }
        }
    }
        private static void fibo() {
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

        private static void freq() 
        throws IOException
        {
            System.out.println("Donnez le chemin du fichier: ");
            Scanner p = new Scanner(System.in);
            String pt = p.nextLine();
            Path path =  Paths.get(pt);

            String s = Files.readString(path);
            String newStr = s.replaceAll("\\p{Punct}", " ");
            String[] words = newStr.toLowerCase().split("\\s+");
            Stream<String> stream = Arrays.stream(words);

            Map<String, Long> result = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<String, Long> finalMap = new LinkedHashMap<>();

            result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

            int i = 0;
            for (Map.Entry<String, Long> entry : finalMap.entrySet()) {
            String val = entry.getKey();
            System.out.print(val);
            i++;
            if (i == 3) {

                System.out.print("\n");
                break;
            }
             System.out.print(" ");
            }

        } 
}
