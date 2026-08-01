import java.util.List;
import java.util.function.Function;

public class ParallelRace {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        ParallelRace race = new ParallelRace();
        System.out.println("All values: " + race.findAllValues(nums));
    }
    public Integer smallestNum(List<Integer> numbers){
        Integer small = numbers.stream()
        .min(Integer::compare)
        .orElse(null);

        return small;
    }

    public Integer totalNums(List<Integer> numbers){
        Long total = numbers.stream()
        .count();

        return total.intValue();
    }

    private Integer findMaxValue(List<Integer> nums) {
        Function<List<Integer>, Integer> max = (numbs) -> numbs.stream()
        .max(Integer::compare)
        .orElse(null);
        Integer maxValue = max.apply(nums);
        return maxValue;
    }

    public List<Integer> findAllValues(List<Integer> nums){
        return List.of(smallestNum(nums), totalNums(nums), findMaxValue(nums));
    }
}





