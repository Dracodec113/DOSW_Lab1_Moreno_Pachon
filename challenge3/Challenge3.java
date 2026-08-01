/*
Challenge 3
 */

public class Challenge3{
    
    public static void main(String args[]){
        Challenge3 c3 = new Challenge3();
        String text = "Hello world!";
        System.out.println(c3.repeatReverseString(text, 3));
    }

    public StringBuffer reverseText(String text){
        StringBuffer sbf = new StringBuffer(text);
        return sbf.reverse();
    }

    public String repeatString(String str, int times){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < times; i++){
            result.append(" " + str);
        }
        return result.toString();
    }

    public String repeatReverseString(String str, int times){
        String repeat = repeatString(str, times);
        String reverse = "The reverse of the text is:" + reverseText(repeat).toString();
        return repeat + "   " + reverse;
    }
}
