/*
Challenge 3
 */

public class Challenge3{
    
    public static void main(String args[]){
        Challenge3 c3 = new Challenge3();
        String text = "Hello world!";
        System.out.println("The reverse of Hello world! is: " + c3.reverseText(text));
        System.out.println(c3.repeatString(text, 3));
        System.out.println(c3.repeatReverseString(text));
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

    public String repeatReverseString(String str){
        String repeated =repeatString(str, 3);
        return reverseText(repeated).toString();
    }

}
