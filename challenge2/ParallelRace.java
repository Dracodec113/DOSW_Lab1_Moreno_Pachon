import java.util.List;
import java.util.function.Function;

/**
 * Demonstrates operations on lists of integers, including finding minimum,
 * maximum, and count values, checking parity, and consolidating results
 * for two lists into a single {@link Results} object.
 */
public class ParallelRace {
    /**
     * Entry point that exercises the various list analysis methods on two
     * sample lists of integers and prints the resulting values.
     *
     * @param args command-line arguments (not used)
     */
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



    


    /**
     * Finds the smallest number in the given list.
     *
     * @param numbers the list of numbers to search
     * @return the smallest number in the list, or null if the list is empty
     */
    public Integer smallestNum(List<Integer> numbers){
        Integer small = numbers.stream()
        .min(Integer::compare)
        .orElse(null);

        return small;
    }

    /**
     * Counts the total number of elements in the given list.
     *
     * @param numbers the list of numbers to count
     * @return the total number of elements in the list
     */
    public Integer totalNums(List<Integer> numbers){
        Long total = numbers.stream()
        .count();

        return total.intValue();
    }

    /**
     * Finds the maximum value in the given list of numbers.
     *
     * @param nums the list of numbers to search
     * @return the maximum value in the list, or null if the list is empty
     */
    private Integer findMaxValue(List<Integer> nums) {
        Function<List<Integer>, Integer> max = (numbs) -> numbs.stream()
        .max(Integer::compare)
        .orElse(null);
        Integer maxValue = max.apply(nums);
        return maxValue;
    }

    /**
     * Finds the smallest value, total count, and biggest value of the given
     * list, combined into a single list.
     *
     * @param nums the list of numbers to analyze
     * @return a list containing, in order, the smallest value, the total
     *         count of elements, and the biggest value
     */
    public List<Integer> findAllValues(List<Integer> nums){
        return List.of(smallestNum(nums), totalNums(nums), findMaxValue(nums));
    }

    /**
     * Checks whether the given number is even.
     *
     * @param num the number to check
     * @return true if the number is even, false otherwise
     */
    private boolean isItEven(Integer num){
        return num % 2 == 0 ? true : false;
    }

    /**
     * Creates a {@link Results} object consolidating the maximum value,
     * minimum value, element count, and parity checks for two lists of
     * numbers.
     *
     * @param nums the first list of numbers
     * @param nums2 the second list of numbers
     * @return a Results object containing the computed values for both lists
     */
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

    /**
     * Checks whether the given number is odd.
     *
     * @param num the number to check
     * @return true if the number is odd, false otherwise
     */
    private boolean sizeIsOdd(Integer num){
        return num % 2 != 0 ? true : false;
    }

    /**
     * Checks whether the given number is a multiple of 2.
     *
     * @param num the number to check
     * @return true if the number is a multiple of 2, false otherwise
     */
    private boolean isItMultiple(Integer num){
        return num % 2 == 0 ? true : false;
    }
}