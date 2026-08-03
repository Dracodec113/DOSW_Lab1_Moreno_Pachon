import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Challenge6
 */

public class Challenge6{
    /**
     * Builds a map of commands to their Runnable responses and executes
     * each one, printing the command name followed by its response.
     *
     * @param args command-line arguments
     */
    public static void main(String args[]){
        Challenge6 c6 = new Challenge6();
        List<String> commands = List.of("JOKE", "SHOUT", "WHISPER", "ANALYZE", "GREET", "DANCE", "SING", "FAREWELL");
        
        Map<String, Runnable> responses = c6.executeCommand(commands);
        responses.entrySet().forEach(n-> {System.out.println("Command: " + n.getKey()); 
        n.getValue().run();});
    }
    
    /**
     * Builds a map associating each command with a Runnable that prints the
     * corresponding response.
     *
     * @param commands the list of command strings
     * @return a map associating each command with its Runnable response
     */
    private Map<String, Runnable> executeCommand(List<String> commands){
        Map<String, Runnable> answers = commands.stream()
        .collect(Collectors.toMap(command -> command, command -> (Runnable) () -> {switch(command){
            case "JOKE":
                System.out.println("Why did the RAM break up with the CPU? It needed space.");
                break;
            case "SHOUT":
                System.out.println("STACK OVERFLOW ALERT!");
                break;
            case "WHISPER":
                System.out.println("Shhh... the bugs are sleeping.");
                break;
            case "ANALYZE":
                System.out.println("Processing data... result: You are amazing at programming!");
                break;
            case "GREET":
                System.out.println("Greetings, traveler of time and code!");
                break;
            case "DANCE":
                System.out.println("Spinning in party mode.");
                break;
            case "SING":
                System.out.println("01010101");
                break;
            case "FAREWELL":
                System.out.println("May the bits be with you until the next mission.");
                break;
            default:
                System.out.println("We will include a response fot the command soon =)");
        }}
        ));   
        
        return answers;
    }
}