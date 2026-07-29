public class Student{
   private String fullName;
   private int age;
   private String institutionalEmail;
   private int currentSemester;

   public Student(String fullName, int age, String institutionalEmail, int currentSemester){
      this.fullName = fullName;
      this.age = age;
      this.institutionalEmail = institutionalEmail;
      this.currentSemester = currentSemester;
   }

   public String getFullName() {
      return fullName;
   }

   public int getAge() {
      return age;
   }

   public String getInstitutionalEmail() {
      return institutionalEmail;
   }

   public int getCurrentSemester() {
      return currentSemester;
   }
 }