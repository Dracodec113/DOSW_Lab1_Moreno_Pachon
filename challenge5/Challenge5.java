import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

public class Challenge5{
    public static void main(String[] args){
        Challenge5 c5 = new Challenge5();
        HashSet<Integer> numbers = c5.numberGenerator(10, 100);
        System.out.println("Generated numbers: " + numbers.toString());
        System.out.println("Filtered numbers: " + c5.hashSetNumbers(numbers).toString());
    }

    public HashSet<Integer> hashSetNumbers(HashSet<Integer> numbers) {
        return numbers.stream()
                    .filter(n -> n % 3 != 0)
                    .collect(Collectors.toCollection(HashSet::new));
    }

    public HashSet<Integer> numberGenerator(int quantity, int limit) {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < quantity; i++) {
            set.add(random.nextInt(limit));
        }

        return set;
    }
}