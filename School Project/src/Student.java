//This is the Student class. It houses variables and methods relating to students
public class Student {

    //These lines set the fields, or info of the students. They include the first names, last names, grades, and a unique ID number for each student
    //private means the field can only be accessed in the Student class
    private String firstName;
    private String lastName;
    private int grade;

    //static means there can only be one value of the information at any point
    //This is helpful to create a unique ID for every student
    static int studentId = 1;
    private int idNumber;

    //This is a constructor of how the program makes a student. The program requires the first name, last name, and grade of the student
    //It will then input that info into the student list alongside a unique student ID
    Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;

        //After the "idNumber" of a student is set, the "studentId" value increases by one so the next student created will have a different "idNumber"
        this.idNumber = studentId;
        studentId++;
    }

    //These are the getters and setters of the Student class. They allow the data of the Student class to be accessed from outside the class
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    //These lines use a toString method to print out a student's data. It requires the student's program name, which is different from their first and last name
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() +
                " Grade: " + getGrade() +
                " Student Number: " + getIdNumber();
    }
}
