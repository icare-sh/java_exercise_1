import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.*;

public class Freq implements Command{
  public String name() { return "freq"; }
  public boolean run(Scanner p) {
      System.out.println("Donnez le chemin du fichier: ");
      String pt = p.nextLine();
      Path path = Paths.get(pt);
    
      try {
      String s = Files.readString(path);
      String newStr = s.replaceAll("\\p{Punct}", " ");
      String[] words = newStr.toLowerCase().split("\\s+");
      Stream<String> stream = Arrays.stream(words);

      Map<String, Long> result = stream.collect(
          Collectors.groupingBy(Function.identity(), Collectors.counting()));
      Map<String, Long> finalMap = new LinkedHashMap<>();

      result.entrySet()
          .stream()
          .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
          .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

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
    } catch(IOException e ) {
            System.err.println("Unreadable File: " + e.getClass() + " " + e.getMessage());
      }
    return false;
  }
}
