import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {

        Map<String, Integer> myMap = new java.util.TreeMap<String, Integer>();

        for (int i = 0; i < args.length; i ++) {
            String word = args[i].toLowerCase();
            if (!myMap.containsKey(word))
                myMap.put(word, 1);
            else
                myMap.put(word, myMap.get(word) + 1);
        }
        System.out.println(myMap);
    }
}
