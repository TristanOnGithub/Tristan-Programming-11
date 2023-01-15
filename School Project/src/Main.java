//This is the Main class. It is primarily used to run code and print it to the user
public class Main {
    public static void main(String[] args) {

        //This line adds a new School object so the Main class can access variables and methods from the School class
        School school = new School();

        //These lines add students to the students array
        school.addStudent(school.studentAnnie);
        school.addStudent(school.studentBonnie);
        school.addStudent(school.studentChica);
        school.addStudent(school.studentDonald);
        school.addStudent(school.studentEvan);
        school.addStudent(school.studentFonzi);
        school.addStudent(school.studentGabe);
        school.addStudent(school.studentHonda);
        school.addStudent(school.studentIvan);
        school.addStudent(school.studentJake);

        //These lines add teachers to the teachers array
        school.addTeacher(school.teacherZach);
        school.addTeacher(school.teacherYelena);
        school.addTeacher(school.teacherXiangling);

        //These lines use the categorizeStudent method to categorize students based on their grade
        for (int a = 0; a < school.getStudents().size(); a++) {
            school.categorizeStudent((Student) school.getStudents().get(a));
        }

        //These lines use the categorizeTeacher method to categorize teachers based on their subject
        for (int a = 0; a < school.getTeachers().size(); a++) {
            school.categorizeTeacher((Teacher) school.getTeachers().get(a));
        }

        //These lines print out the current amount of students and teachers and where the students list starts
        System.out.println(school.getStudents().size() + " students, " + school.getTeachers().size() + " teachers\n\n" +
                "Students:");

        //This line prints out all the current students' full name, grade, and student number
        school.studentList();

        //This line prints out where the teachers list starts
        System.out.println("\nTeachers:");

        //This line prints out all the current teachers' full name and subject they teach
        school.teacherList();

        //This line prints text signifying the removal of students and teachers
        System.out.println("\nRemoving Students Annie Ark, Bonnie Baker, and Teacher Zach Zeta\n");

        //These lines remove the students Annie and Bonnie
        school.removeStudent(school.studentAnnie);
        school.removeStudent(school.studentBonnie);

        //This line removes the teacher Zach
        school.removeTeacher(school.teacherZach);

        //These lines repeat the process of printing the information of the current students and teachers in the students and teachers ArrayLists
        System.out.println(school.getStudents().size() + " students, " + school.getTeachers().size() + " teachers\n\n" +
                "Students:");
        school.studentList();
        System.out.println("\nTeachers:");
        school.teacherList();
        System.out.println("");

        //These lines use the categoryList method to print the information of grade 1 and 10 students and science teachers
        school.categoryList();
    }
}
