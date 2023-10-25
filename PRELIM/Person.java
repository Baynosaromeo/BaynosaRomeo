public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String birthday;
    private String address;

    public Person(String firstName, String middleName, String lastName, int age, String birthday, String address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
    }

    public static void main(String[] args) {
        Person person = new Person("Romeo", "Reyes", "Baynosa", 19, "December 15, 2003", "Sitio Lower Gun Club Banawa Cebu City");

        System.out.println("Personal Information:");
        System.out.println("First Name: " + person.firstName);
        System.out.println("Middle Name: " + person.middleName);
        System.out.println("Last Name: " + person.lastName);
        System.out.println("Age: " + person.age);
        System.out.println("Birthday: " + person.birthday);
        System.out.println("Address: " + person.address);
    }
}
