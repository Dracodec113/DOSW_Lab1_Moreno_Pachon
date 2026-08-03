import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Challenge 5
 */
public class Challenge5 {
    /**
     * Generates random numbers and combining the filtered
     * results into a single sorted set.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Challenge5 c5 = new Challenge5();

        HashSet<Integer> numbers = c5.numberGenerator(10, 100);
        System.out.println("Generated numbers: " + numbers);
        HashSet<Integer> filteredHashSet = c5.hashSetNumbers(numbers);
        System.out.println("Filtered numbers: " + filteredHashSet);

        List<Integer> treeInput = List.of(12, 3, 25, 10, 7, 30, 18, 4);
        TreeSet<Integer> filteredTreeSet = c5.treeSetBattle(treeInput);

        TreeSet<Integer> battle = Stream.concat(filteredHashSet.stream(), filteredTreeSet.stream())
                                    .collect(Collectors.toCollection(TreeSet::new));

        battle.forEach(n -> System.out.println("Number in the arena: " + n));
    }

    /**
     * Filters the given set of numbers, keeping only those that are not
     * multiples of 3.
     *
     * @param numbers the set of numbers to filter
     * @return a HashSet containing only the numbers not divisible by 3
     */
    public HashSet<Integer> hashSetNumbers(HashSet<Integer> numbers) {
        return numbers.stream()
                    .filter(n -> n % 3 != 0)
                    .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Generates a set of random numbers.
     *
     * @param quantity the number of random values to generate
     * @param limit the upper bound (exclusive) for each generated random number
     * @return a HashSet containing the generated random numbers
     */
    public HashSet<Integer> numberGenerator(int quantity, int limit) {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < quantity; i++) {
            set.add(random.nextInt(limit));
        }

        return set;
    }

    /**
     * Filters the given list of numbers, keeping only those that are not
     * multiples of 5, and collects them into a sorted set.
     *
     * @param numbers the list of numbers to filter
     * @return a TreeSet containing only the numbers not divisible by 5, sorted
     *         in natural order
     */
    private TreeSet<Integer> treeSetBattle(List<Integer> numbers){
        TreeSet<Integer> answer = numbers.stream()
        .filter(n -> n % 5 != 0)
        .collect(Collectors.toCollection(TreeSet::new));

        return answer;
    }
}