/**
 * Represents a student with their personal and academic information.
 */
public class Student{
   private String fullName;
   private int age;
   private String institutionalEmail;
   private int currentSemester;

   /**
    * Constructs a new Student with the given information.
    *
    * @param fullName the full name of the student
    * @param age the age of the student
    * @param institutionalEmail the institutional email address of the student
    * @param currentSemester the current semester the student is enrolled in
    */
   public Student(String fullName, int age, String institutionalEmail, int currentSemester){
      this.fullName = fullName;
      this.age = age;
      this.institutionalEmail = institutionalEmail;
      this.currentSemester = currentSemester;
   }

   /**
    * Gets the full name of the student.
    *
    * @return the full name of the student
    */
   public String getFullName() {
      return fullName;
   }

   /**
    * Gets the age of the student.
    *
    * @return the age of the student
    */
   public int getAge() {
      return age;
   }

   /**
    * Gets the institutional email of the student.
    *
    * @return the institutional email of the student
    */
   public String getInstitutionalEmail() {
      return institutionalEmail;
   }

   /**
    * Gets the current semester of the student.
    *
    * @return the current semester of the student
    */
   public int getCurrentSemester() {
      return currentSemester;
   }
 }