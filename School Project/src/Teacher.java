//This is the Teacher class. It houses variables and methods relating to teachers
public class Teacher {

    //These lines set the fields, or info of the teachers. They include the first names, last names, and subjects the teachers teach
    private String firstName;
    private String lastName;
    private String subject;

    //This is the constructor of how the program creates a teacher. The program requires the first name, last name, and subject of the teacher
    Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    //These are the getters and setters of the Teacher class. They allow the data of the Teacher class to be accessed from outside the class
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    //These lines use a toString method to print out a teacher's data. It requires the teacher's program name, which is different from their first and last name
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() +
                " Subject: " + getSubject();
    }
}
