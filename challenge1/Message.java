/**
 * Represents a message that can be printed for two students.
 */
public interface Message {
    /**
      * Prints a message related to the given students.
      *
      * @param student1 the first student
      * @param student2 the second student
      */
     void printMessage(Student student1, Student student2);
 }