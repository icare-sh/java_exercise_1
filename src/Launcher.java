import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.*;

public class Launcher {
  public static void main(String[] args) throws IOException {
    List<Command> list = new ArrayList<>(5);
    list.add(new Quit());
    list.add(new Fibo());
    list.add(new Freq());
    list.add(new Predict());
    boolean var = false;
        System.out.println("Welecome to the best program of the world!!");
    while (!var) {
      Scanner scanner = new Scanner(System.in);
      String str = scanner.nextLine();
        for (Command elt : list){
            if (elt.name().equals(str)) {
                var = elt.run(scanner);
            }
        }
      }
    }
}
