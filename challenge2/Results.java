/**
 * Holds the results (maximum value, minimum value, element count, and parity checks) 
 * for two lists of numbers.
 */
public class Results{
    private int maxValue1;
    private int minValue1;
    private int numberOfElements1;
    private boolean isEven1;
    private boolean isListEven1;

    private int maxValue2;
    private int minValue2; 
    private int numberOfElements2;
    private boolean isEven2;
    private boolean isListEven2;

    /**
     * Constructs a new Results object with the analysis values for two
     * lists of numbers.
     *
     * @param maxValue1 the maximum value of the first list
     * @param minValue1 the minimum value of the first list
     * @param numberOfElements1 the number of elements in the first list
     * @param isEven1 whether the maximum value of the first list is even
     * @param isListEven1 whether the number of elements in the first list is even
     * @param maxValue2 the maximum value of the second list
     * @param minValue2 the minimum value of the second list
     * @param numberOfElements2 the number of elements in the second list
     * @param isEven2 whether the maximum value of the second list is even
     * @param isListEven2 whether the number of elements in the second list is even
     */
    public Results(int maxValue1, int minValue1, int numberOfElements1, boolean isEven1, boolean isListEven1, int maxValue2, int minValue2, int numberOfElements2, boolean isEven2, boolean isListEven2) {
        this.maxValue1 = maxValue1;
        this.minValue1 = minValue1;
        this.numberOfElements1 = numberOfElements1;
        this.isEven1 = isEven1;
        this.isListEven1 = isListEven1;
        this.maxValue2 = maxValue2;
        this.minValue2 = minValue2;
        this.numberOfElements2 = numberOfElements2;
        this.isEven2 = isEven2;
        this.isListEven2 = isListEven2;
    }

    /**
     * Builds a string summarizing the analysis results for both
     * lists, including their maximum value, minimum value, element count,
     * and parity checks.
     *
     * @return a string showing the results for both lists
     */
    public String showResults(){
        return "Max Value: " + maxValue1 + ", Min Value: " + minValue1 + ", Number of Elements: " + numberOfElements1 + ", Is Max Value Even? " + isEven1 + ", Is List Size Even? " + isListEven1 + "\n" +
               "Max Value: " + maxValue2 + ", Min Value: " + minValue2 + ", Number of Elements: " + numberOfElements2 + ", Is Max Value Even? " + isEven2 + ", Is List Size Even? " + isListEven2;
    }

}