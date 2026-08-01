import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge4{
    //SELF REMINDER:Entry is the key-value pair in the map. The key is the name of the treasure, and the value is the amount of that treasure.
    public static void main(String[] args) {
        Challenge4 c4 = new Challenge4();
        List<Map.Entry<String, Integer>> pairs = List.of(
            Map.entry("gold", 5),
            Map.entry("silver", 3),
            Map.entry("gold", 7),
            Map.entry("diamond", 10)
        );
        HashMap<String, Integer> treasureMap = c4.hashMapTreasure(pairs);
        treasureMap.entrySet()
        .stream()
        .forEach(kv -> System.out.println(kv.getKey() + " | " + kv.getValue()));
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
}