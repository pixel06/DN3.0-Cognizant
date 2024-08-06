public class StudentGradesTest {
    public static void main(String[] args) {
        StudentGrades grades = new StudentGrades();

        Student s1 = new Student(1, "John", 'A');
        Student s2 = new Student(2, "Jane", 'B');

        grades.addStudent(s1);
        grades.addStudent(s2);

        grades.displayStudents();

        grades.updateStudentGrade(2, 'A');
        grades.removeStudent(1);

        grades.displayStudents();
    }
}
