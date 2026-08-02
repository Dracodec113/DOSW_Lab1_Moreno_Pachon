import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Challenge 4
 */

public class Challenge4{

    public static void main(String args[]){
        Challenge4 c4 = new Challenge4();
        List<Map<String, Integer>> info = new ArrayList<>();
        info.add(Map.of("silver", 8));
        info.add(Map.of("ruby", 4));
        info.add(Map.of("gold", 12));
        info.add(Map.of("emerald", 6));
        System.out.println(c4.writeAnswer(c4.organize(info)));
    }

    private Hashtable<String, Integer> organize(List<Map<String, Integer>> info){
        Hashtable<String, Integer> table = info.stream()
            .flatMap(m -> m.entrySet().stream())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (initial, second) -> initial,
                Hashtable::new
            ));

        return table;
    }

    private String writeAnswer(Hashtable<String, Integer> data){
        String ans = data.entrySet().stream()
            .map(n -> "Key: " + n.getKey() + " |  Value:" + n.getValue())
            .collect(Collectors.joining("\n"));
        return ans;
    }
}