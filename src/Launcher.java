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
    System.out.println("Welecome to the best program of the world!!");

    Scanner scanner = new Scanner(System.in);
    do {
      String str = scanner.nextLine();

      boolean var = false;
      for (Command elt : list) {
        if (elt.name().equals(str)) {
          if (elt.run(scanner))
            return;

          var = true;
        }
      }
      if (!var)
        System.out.println("Unknown command");

    }while(true);
  }
}
