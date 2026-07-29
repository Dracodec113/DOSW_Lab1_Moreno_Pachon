import java.util.List;

public class ParallelRace {

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

    public List<Integer> findAllValues(List<Integer> nums){
        return List.of(smallestNum(nums), totalNums(nums));
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        ParallelRace race = new ParallelRace();
        System.out.println("All values: " + race.findAllValues(nums));
    }
}