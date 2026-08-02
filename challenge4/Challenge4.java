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
    //SELF REMINDER:Entry is the key-value pair in the map. The key is the name of the treasure, and the value is the amount of that treasure.
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
