import java.util.List;
import java.util.stream.Collectors;

public class WelcomeMessage{
    public WelcomeMessage() {
    }

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
