import java.util.LinkedHashMap;

public class StudentGrades {
    private LinkedHashMap<Integer, Student> studentMap;

    public StudentGrades() {
        studentMap = new LinkedHashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("Student added: " + student);
    }

    public void removeStudent(int studentId) {
        Student removedStudent = studentMap.remove(studentId);
        if (removedStudent != null) {
            System.out.println("Student removed: " + removedStudent);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void updateStudentGrade(int studentId, char newGrade) {
        Student student = studentMap.get(studentId);
        if (student != null) {
            student.setGrade(newGrade);
            System.out.println("Updated grade for student ID " + studentId + ": " + newGrade);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void displayStudents() {
        System.out.println("Student Grades:");
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
    }
}
