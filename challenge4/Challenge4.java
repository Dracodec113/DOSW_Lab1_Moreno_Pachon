/**
 * Challenge 4
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Challenge4{
    //Remember:Entry is the key-value pair in the map. The key is the name of the treasure, and the value is the amount of that treasure.
    /**
     * Building a HashMap and a Hashtable of gems from lists
     * of key-value pairs, then merges and prints their combined, sorted contents.
     *
     * @param args command-line arguments 
     */
    public static void main(String[] args) {
        Challenge4 c4 = new Challenge4();
        List<Map.Entry<String, Integer>> pairs1 = List.of(
            Map.entry("gold", 5),
            Map.entry("silver", 3),
            Map.entry("gold", 7),
            Map.entry("diamond", 10));

        List<Map<String, Integer>> pairs2 = new ArrayList<>();
        pairs2.add(Map.of("silver", 8));
        pairs2.add(Map.of("ruby", 4));
        pairs2.add(Map.of("gold", 12));
        pairs2.add(Map.of("emerald", 6));

        HashMap<String, Integer> treasureHashMap = c4.hashMapTreasure(pairs1);
        Hashtable<String, Integer> treasureHashTable = c4.hashTableTreasure(pairs2);

        System.out.println(c4.writeAnswer(treasureHashMap, treasureHashTable));
    }

    /**
     * Builds a HashMap of treasures from a list of key-value pairs, keeping
     * only the first occurrence of each key.
     *
     * @param pairs the list of treasure name-amount pairs 
     * @return a HashMap containing each treasure name mapped to its first
     *         encountered amount
     */
    public HashMap<String, Integer> hashMapTreasure(List<Map.Entry<String, Integer>> pairs) {
        HashMap<String, Integer> map = new HashMap<>();

        for (Map.Entry<String, Integer> pair : pairs) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            if (!map.containsKey(key)) {
                map.put(key, value);
            }
        }

        return map;
    }

    /**
     * Builds a Hashtable of treasures by flattening a list of single-entry
     * maps into a single table, keeping the first occurrence of each key.
     *
     * @param info the list of maps, each containing one treasure name-amount pair
     * @return a Hashtable containing each treasure name mapped to its first
     *         encountered amount
     */
    private Hashtable<String, Integer> hashTableTreasure(List<Map<String, Integer>> info){
        Hashtable<String, Integer> table = info.stream()
            .flatMap(m -> m.entrySet().stream())
            .collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue,
                (initial, second) -> initial,
                Hashtable::new
            ));

        return table;
    }

    /**
     * Merges the entries of a HashMap and a Hashtable of treasures, keeping
     * the first occurrence of each key, and builds a alphabetically
     * sorted string.
     *
     * @param treasureHashMap the HashMap of treasure names and amounts
     * @param treasureHashTable the Hashtable of treasure names and amounts
     * @return a formatted string listing each treasure key (uppercase) and its
     *         value, sorted alphabetically by key
     */
    private String writeAnswer(HashMap<String, Integer> treasureHashMap, Hashtable<String, Integer> treasureHashTable){

        HashMap<String, Integer> data = Stream.concat(treasureHashTable.entrySet().stream(), treasureHashMap.entrySet().stream())
            .collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue,
                (initial, second) -> initial, 
                HashMap::new));
        

        String ans = data.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getKey))
            .map(n -> "Key: " + n.getKey().toUpperCase() + " |  Value:" + n.getValue())
            .collect(Collectors.joining("\n"));
        return ans;
    }

}