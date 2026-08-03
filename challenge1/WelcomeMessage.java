import java.util.List;
import java.util.stream.Collectors;

/**
 * Builds a welcome {@link Message} that greets a list of students and
 * displays their academic details and institutional emails.
 */
public class WelcomeMessage{
    /**
     * Constructs a new WelcomeMessage.
     */
    public WelcomeMessage() {
    }

    /**
     * Builds a Message that, when printed, displays a welcome greeting
     * including each student's full name, current semester, age, and
     * institutional email.
     *
     * @param students the list of students to include in the welcome message
     * @return a Message instance ready to print the welcome greeting
     */
    public Message buildMessage(List<Student> students) {
        String studentDetails = students.stream()
                .map(student -> student.getFullName() + ", a " + student.getCurrentSemester() + "-semester student, " + student.getAge() + " years old")
                .collect(Collectors.joining(" and "));

        String emails = students.stream()
                .map(student -> student.getInstitutionalEmail())
                .collect(Collectors.joining("\r\n"));

        Message message = (student1, student2) -> System.out.println("Hello and welcome!\r\n" +
                "\r\n" + "We are " + studentDetails + ".\r\n" +
                "\r\n" + "Our institutional emails are:\r\n" + emails);

        return message;
    }
}