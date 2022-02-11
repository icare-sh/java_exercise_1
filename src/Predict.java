import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Predict implements Command{
    public String name(){
        return "predict";
    }

    public boolean run(Scanner sc) {
        System.out.println("Chemin du fichier a lire :");
        String pathStr = sc.nextLine();
        Path path = Paths.get(pathStr);
        try {
            String content = java.nio.file.Files.readString(path);
            System.out.println("Ecrivez un mot :");
            String userWords = sc.nextLine().toLowerCase(Locale.ROOT);
            content = content.toLowerCase()
                    .replaceAll("[.!?,(\\r\\n|\\r|\\n)]", " ")
                    .replaceAll(" {2}", " ");
            if (!content.contains(userWords)){
                System.out.println("le mot n'est pas dans le texte");
                return false;
            }
            String[] listWord = content.split(" ");
            Map<String, String> wordsFreq = new HashMap<String, String>();
            for (String word : listWord){
                if (wordsFreq.get(word) == null) {
                    wordsFreq.put(word, getNextFreq(word, listWord));
                }
            }
            System.out.print(userWords);
            for(int i = 0; i < 19 ; i++){
                System.out.print(" "+wordsFreq.get(userWords));
                userWords = wordsFreq.get(userWords);
            }
        }  catch (IOException e) {
            System.out.println("Unreadable file: " + e.toString());
        }
        System.out.println("");
        return false;
    }

    public String getNextFreq(String word,String[] content){
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0;i < content.length;i++){
            if (content[i].equals(word) && i != content.length - 1){
                tmp.add(content[i+1]);
            }
        }
        Map<Object, Integer> frequencyMap = tmp.stream()
                .collect(toMap(
                        s -> s, // key is the word
                        s -> 1, // value is 1
                        Integer::sum));
        List<Object> res = tmp.stream()
                .sorted(comparing(frequencyMap::get).reversed()) // sort by descending frequency
                .distinct() // take only unique values
                .limit(1)   // take only the first 1
                .collect(toList()); // put it in a returned list
        if (res.size() != 0) {
            return res.get(0).toString();
        }
        return "";
    }
}
