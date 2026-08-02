import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Challenge 5
 */

public class Challenge5{
    public static void main(String args[]){
        Challenge5 c5 = new Challenge5();
        List<Integer> numbers = List.of(12, 3, 25, 10, 7, 30, 18, 4);

        TreeSet newNums = c5.treeSetBattle(numbers);
        newNums.forEach(n -> System.out.println("Number in the arena: " + n));
    }

    private TreeSet<Integer> treeSetBattle(List<Integer> numbers){
        TreeSet<Integer> answer = numbers.stream()
        .filter(n -> n % 5 != 0)
        .collect(Collectors.toCollection(TreeSet::new));

        return answer;
    }
}