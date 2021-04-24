import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "UTF-8");

        Map<String, Integer> myMap = new java.util.TreeMap<String, Integer>();

        String c = scan.nextLine();
        String words[] = c.split("\\s+");
        for (int i = 0; i < words.length; i ++) {
            if (!myMap.containsKey(words[i]))
                myMap.put(words[i], 1);
            else
                myMap.put(words[i], myMap.get(words[i]) + 1);
        }
        System.out.println(myMap);
    }
}
