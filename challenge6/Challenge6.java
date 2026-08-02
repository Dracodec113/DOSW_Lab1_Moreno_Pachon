import java.util.HashMap;
import java.util.Map;

public class Challenge6 {

    private final Map<String, Runnable> commands = new HashMap<>();
    public static void main(String[] args) {
        Challenge6 c6 = new Challenge6();
        c6.executeCommand("GREET");
        c6.executeCommand("DANCE");
        c6.executeCommand("SING");
        c6.executeCommand("FAREWELL");
    }

    public Challenge6() {
        commands.put("GREET", () -> System.out.println("Greetings, traveler of time and code!"));
        commands.put("FAREWELL", () -> System.out.println("May the bits be with you until the next mission."));
        commands.put("SING", () -> System.out.println("01010101"));
        commands.put("DANCE", () -> System.out.println("Spinning in party mode."));
    }

    public void executeCommand(String command) {
        Runnable action = commands.get(command);
        action.run();
    }

}