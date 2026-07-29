import java.util.Arrays;


public class Challenge1 {
    public static void main(String[] args) {
        Student student1 = new Student("Jeronimo Moreno Herrera",19,"jeronimo.moreno-h@mail.escuelaing.edu.co",6);
        Student student2 = new Student("Derly Valeria Pachon Pinzon",19,"derly.pachon-p@mail.escuelaing.edu.co",6);

        new WelcomeMessage().buildMessage(Arrays.asList(student1, student2)).printMessage(student1, student2);
    }
}