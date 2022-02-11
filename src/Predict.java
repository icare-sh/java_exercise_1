import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Predict implements Command{
    @Override
    public String name() {
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrer le chemin du fichier");
        String pathString = "";

        try {
            pathString = scanner.nextLine();
            String text = Files.readString(Paths.get(pathString));
            text = text.replaceAll("[.!?\\-,\\n]", " ").toLowerCase(Locale.ROOT);
            List<String> tab = List.of(text.split(" "));

            System.out.println("Entrer un mot");
            String word = scanner.nextLine();
            word = word.toLowerCase(Locale.ROOT);

            if (!tab.contains(word)) {
                System.out.println("Le mot n'est pas présent dans le fichier");
                return false;
            }

            StringJoiner sentence = new StringJoiner(" ");
            sentence.add(word);
            for (int j = 0; j < 19; j++) {
                List<String> next = new ArrayList<String>();
                for (int i = 0; i < tab.size() - 1; i++) {
                    if (tab.get(i).equals(word)) {
                        next.add(tab.get(i + 1));
                    }
                }

                Map<String, Long> next_list = next.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                Map<String, Long> result = next_list.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                List<String> list3 = new ArrayList<>(result.keySet());
                String str = list3.get(0);
                sentence.add(str);
                word = str;
            }
            System.out.println(sentence);
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass() + " " + e.getMessage());
            return false;
        }
        return true;
    }
}
