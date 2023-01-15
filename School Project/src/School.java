//This line imports ArrayList, which allows the program to increase or decrease the size of arrays
import java.util.ArrayList;

//This is the School class, which is used to house the ArrayLists of students and teachers and methods to add, delete, and show lists of students and teachers
public class School {

    //These lines create a constructor for a School object
    School() {
    }

    //These lines create ArrayLists for students and teachers, as well as array lists for certain grades for students and subjects that teachers teach
    private ArrayList students = new ArrayList();
    private ArrayList teachers = new ArrayList();
    private ArrayList grade1 = new ArrayList();
    private ArrayList grade10 = new ArrayList();
    private ArrayList subjectScience = new ArrayList();

    //These lines create students by using the constructor from the Student class. It requires the students' full name and grade
    public Student studentAnnie = new Student("Annie", "Ark", 4);
    public Student studentBonnie = new Student("Bonnie", "Baker", 8);
    public Student studentChica = new Student("Chica", "Cook", 5);
    public Student studentDonald = new Student("Donald", "Davis", 1);
    public Student studentEvan = new Student("Evan", "Eraser", 1);
    public Student studentFonzi = new Student("Fonzi", "Ferrari", 10);
    public Student studentGabe = new Student("Gabe", "Gavin", 6);
    public Student studentHonda = new Student("Honda", "Hello", 10);
    public Student studentIvan = new Student("Ivan", "Irmin", 9);
    public Student studentJake = new Student("Jake", "Justin", 2);

    //These lines create teachers by using the constructor from the Teacher class. It requires the teachers' full name and subject they teach
    public Teacher teacherZach = new Teacher("Zach", "Zeta", "Math");
    public Teacher teacherYelena = new Teacher("Yelena", "Yen", "Science");
    public Teacher teacherXiangling = new Teacher("Xiangling", "Xiphos", "Science");

    //These are the getters and setters for the School class. They allow the data of the School class to be accessed from outside the class
    public ArrayList getStudents() {
        return students;
    }

    public void setStudents(ArrayList students) {
        this.students = students;
    }

    public ArrayList getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList teachers) {
        this.teachers = teachers;
    }

    public ArrayList getGrade1() {
        return grade1;
    }

    public void setGrade1(ArrayList grade1) {
        this.grade1 = grade1;
    }

    public ArrayList getGrade10() {
        return grade10;
    }

    public void setGrade10(ArrayList grade10) {
        this.grade10 = grade10;
    }

    public ArrayList getSubjectScience() {
        return subjectScience;
    }

    public void setSubjectScience(ArrayList subjectScience) {
        this.subjectScience = subjectScience;
    }

    //This method categorizes students into the "grade1" and "grade10" ArrayLists if they're of the right grade
    public void categorizeStudent(Student studentName){
        if (studentName.getGrade() == 1) {
            grade1.add(studentName);
        }
        if (studentName.getGrade() == 10) {
            grade10.add(studentName);
        }
    }

    //This method categorizes teachers into the "science" ArrayList if they teach science
    public void categorizeTeacher(Teacher teacherName) {
        if (teacherName.getSubject().equals("Science")) {
            subjectScience.add(teacherName);
        }
    }

    //These lines create a method to add a student to the students array using their name
    public void addStudent(Student studentName) {
        students.add(studentName);
    }

    //These lines create a method to add a teacher to the teachers array using their name
    public void addTeacher(Teacher teacherName) {
        teachers.add(teacherName);
    }

    //These lines create a method to remove a specific student from the students ArrayList
    public void removeStudent(Student studentName) {
        students.remove(studentName);
    }

    //These lines create a method to remove a specific teacher from the teachers ArrayList
    public void removeTeacher(Teacher teacherName) {
        teachers.remove(teacherName);
    }

    //These lines create a method to print out a list of the students in the students array
    public void studentList() {

        //The variable "a" starts at 0, and will increase every time a student is added until there are no more students to add
        //The program will print out the information of the student equivalent to "a" (since arrays start at 0) using the method from the Student class
        for (int a = 0; a < students.size(); a++) {
            System.out.println(students.get(a));
        }
    }

    //These lines create a method to print out a list of the teachers in the teachers array
    public void teacherList() {
        for (int a = 0; a < teachers.size(); a++) {
            System.out.println(teachers.get(a));
        }
    }

    //These lines create a method to print the information of grade 1 and 10 students and science teachers
    public void categoryList() {

        //If there are no grade 1 students, the code will skip over these lines
        if (!grade1.isEmpty()) {
            System.out.println("Grade 1 Students:");
            for (int a = 0; a < grade1.size(); a++) {
                System.out.println(grade1.get(a));
            }
            System.out.println("");
        }

        if (!grade10.isEmpty()) {
            System.out.println("Grade 10 Students:");
            for (int a = 0; a < grade10.size(); a++) {
                System.out.println(grade10.get(a));
            }
            System.out.println("");
        }

        if (!subjectScience.isEmpty()) {
            System.out.println("Science Teachers:");
            for (int a = 0; a < subjectScience.size(); a++) {
                System.out.println(subjectScience.get(a));
            }
            System.out.println("");
        }
    }
}