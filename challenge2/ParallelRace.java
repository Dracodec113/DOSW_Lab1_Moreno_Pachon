import java.util.List;
import java.util.function.Function;

public class ParallelRace {
    public static void main(String[] args) {
        List<Integer> nums = List.of(0, 1, 2, 3, 4, 5, 6);
        List<Integer> nums2 = List.of(8, 9, 10, 11, 12, 13, 14);
        ParallelRace race = new ParallelRace();

        //FIRST TO THIRD CONFLICT

        List<Integer> allValues = race.findAllValues(nums);
        System.out.println("All values: (Smallest, Total, Biggest)" + allValues);
        Integer biggestNum = race.findMaxValue(nums);

        System.out.println("Is "+ biggestNum +" a multiple of 2: " + race.isItEven(biggestNum));
        System.out.println("Is "+ biggestNum +" a multiple of 2: " + race.isItMultiple(biggestNum));
        System.out.println("Is the list size odd or not?: " + race.sizeIsOdd(biggestNum));

        //FINAL CONFLICT
        Results results = race.createResults(nums, nums2);
        System.out.println(results.showResults());
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

    private Results createResults(List<Integer> nums, List<Integer> nums2){
        Integer maxValue1 = findMaxValue(nums);
        Integer minValue1 = smallestNum(nums);
        Integer numberOfElements1 = totalNums(nums);
        boolean isEven1 = isItEven(maxValue1);
        boolean isListEven1 = isItEven(numberOfElements1);

        Integer maxValue2 = findMaxValue(nums2);
        Integer minValue2 = smallestNum(nums2);
        Integer numberOfElements2 = totalNums(nums2);
        boolean isEven2 = isItEven(maxValue2);
        boolean isListEven2 = isItEven(numberOfElements2);

        return new Results(maxValue1, minValue1, numberOfElements1, isEven1, isListEven1, maxValue2, minValue2, numberOfElements2, isEven2, isListEven2);
    }

    private boolean sizeIsOdd(Integer num){
        return num % 2 != 0 ? true : false;
    }

    private boolean isItMultiple(Integer num){
        return num % 2 == 0 ? true : false;
    }
}
