import java.util.List;
import java.util.function.Function;

public class ParallelRace {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        ParallelRace race = new ParallelRace();
        System.out.println("All values: " + race.findAllValues(nums));
    }

    private Integer findMaxValue(List<Integer> nums) {
        Function<List<Integer>, Integer> max = (numbs) -> numbs.stream()
        .max(Integer::compare)
        .orElse(null);
        Integer maxValue = max.apply(nums);
        return maxValue;
    }

    private List<Integer> findAllValues(List<Integer> nums) {
        return List.of(findMaxValue(nums));
    }
}

