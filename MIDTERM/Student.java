import java.util.Scanner;

   public class Student {
   private String first_name = "";
   private String middle_name = "";
   private String last_name = "";
   private String suffix = "";

   public Student() {
}

   public String getFullname() {
   String fullName = first_name;
   if (!middle_name.isEmpty()) {
   fullName += " " + middle_name;
}
   fullName += " " + last_name;
   if (!suffix.isEmpty()) {
   fullName += " " + suffix;
}
   return fullName;
}

   public String getFirstname() {
   return first_name;
}

   public String getMiddlename() {
   return middle_name;
}

   public String getLastname() {
   return last_name;
}

   public String getSuffix() {
   return suffix;
}

   public void setFirstname(String first_name) {
   this.first_name = first_name;
}

   public void setMiddlename(String middle_name) {
   this.middle_name = middle_name;
}

   public void setLastname(String last_name) {
   this.last_name = last_name;
}

   public void setSuffix(String suffix) {
   this.suffix = suffix;
}

   public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);

   System.out.println("Enter student information:");

   Student student1 = new Student();

   System.out.print("First Name: ");
   String firstName = scanner.nextLine();
   student1.setFirstname(firstName);

   System.out.print("Middle Name: ");
   String middleName = scanner.nextLine();
   student1.setMiddlename(middleName);

   System.out.print("Last Name: ");
   String lastName = scanner.nextLine();
   student1.setLastname(lastName);

   System.out.print("Suffix: ");
   String suffix = scanner.nextLine();
   student1.setSuffix(suffix);

   scanner.close();

   System.out.println("\nStudent Information:");
   System.out.println("First Name: " + student1.getFirstname());
   System.out.println("Middle Name: " + student1.getMiddlename());
   System.out.println("Last Name: " + student1.getLastname());
   System.out.println("Suffix: " + student1.getSuffix());
   System.out.println("Full Name: " + student1.getFullname());

}
}