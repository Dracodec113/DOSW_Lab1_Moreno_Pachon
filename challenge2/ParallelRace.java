import java.util.List;
import java.util.function.Function;

public class ParallelRace {
    public static void main(String[] args) {
        List<Integer> nums = List.of(0, 1, 2, 3, 4, 5, 6);
        ParallelRace race = new ParallelRace();
        List<Integer> allValues = race.findAllValues(nums);
        System.out.println("All values: (Smallest, Total, Biggest)" + allValues);
        Integer biggestNum = race.findMaxValue(nums);
        System.out.println("Is "+ biggestNum +" a multiple of 2: " + race.isItEven(biggestNum));
        System.out.println("Is the list size even? " + race.isItEven(nums.size()));
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

    private boolean isItEven(Integer num){
        return num % 2 == 0 ? true : false;
    }
}
