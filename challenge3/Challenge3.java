/**
 * Challenge3
 */

public class Challenge3{
    
    /**
     * String reversal, repetition, and combined reverse-of-repeated
     * string operations on a text.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String args[]){
        Challenge3 c3 = new Challenge3();
        String text = "Hello world!";
        System.out.println("The reverse of Hello world! is: " + c3.reverseText(text));
        System.out.println(c3.repeatString(text, 3));
        System.out.println(c3.repeatReverseString(text));
    }

    /**
     * Reverses the given text.
     *
     * @param text the text to reverse
     * @return a StringBuffer containing the reversed text
     */
    public StringBuffer reverseText(String text){
        StringBuffer sbf = new StringBuffer(text);
        return sbf.reverse();
    }

    /**
     * Repeats the given string a specified number of times, separating each
     * repetition with a blank space.
     *
     * @param str the string to repeat
     * @param times the number of times to repeat the string
     * @return the resulting string with str repeated the given number of times
     */
    public String repeatString(String str, int times){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < times; i++){
            result.append(" " + str);
        }
        return result.toString();
    }

    /**
     * Repeats the given string three times and then reverses the resulting
     * string.
     *
     * @param str the string to repeat and reverse
     * @return the reversed version of str repeated three times
     */
    public String repeatReverseString(String str){
        String repeated =repeatString(str, 3);
        return reverseText(repeated).toString();
    }

}