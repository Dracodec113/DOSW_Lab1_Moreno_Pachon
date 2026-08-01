/*
Challenge 3
 */

public class Challenge3{
    
    public static void main(String args[]){
        Challenge3 c3 = new Challenge3();
        String text = "Hello world!";
        System.out.println("The reverse of Hello world! is: " + c3.reverseText(text));
    }

    public StringBuffer reverseText(String text){
        StringBuffer sbf = new StringBuffer(text);
        return sbf.reverse();
    }
}