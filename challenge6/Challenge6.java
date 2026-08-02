 import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Challenge6
 */

public class Challenge6{
    public static void main(String args[]){
        Challenge6 c6 = new Challenge6();
        List<String> commands = List.of("JOKE", "SHOUT", "WHISPER", "ANALYZE");
        
        Map<String, Runnable> responses = c6.executeCommand(commands);
        responses.entrySet().forEach(n-> {System.out.println("Command: " + n.getKey()); 
        n.getValue().run();});
    }
    
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
            default:
                System.out.println("We will include a response fot the command soon =)");
        }}
        ));   
        
        return answers;
    }
}