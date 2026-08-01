public class Challenge3 {
    public static void main(String[] args){
        String test = "Buenas tardes";
        Challenge3 challenge = new Challenge3();
        System.out.println(challenge.repeatString(test, 3));
    }

    public String repeatString(String str, int times){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < times; i++){
            result.append(" " + str);
        }
        return result.toString();
    }
}