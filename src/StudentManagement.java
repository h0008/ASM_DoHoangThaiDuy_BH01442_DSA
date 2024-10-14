
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagement {
    // List to hold the students' information
    private List<Student> students;

    // Constructor to initialize the students list
    public StudentManagement() {
        students = new ArrayList<>();
    }

    /**
     * Add a student to the list
     * @param id    The student's ID
     * @param name  The student's full name
     * @param marks The student's marks
     */
    public void addStudent(String id, String name, float marks) {
        students.add(new Student(id, name, marks));
    }

    /**
     * Edit the marks of an existing student
     * @param id        The student's ID to find the student
     * @param newMarks  The new marks to assign to the student
     */
    public void editStudent(String id, float newMarks) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                // If student ID matches, update the marks
                student.setMarks(newMarks);
                return;  // Exit the method once the student is found and updated
            }
        }
    }

    /**
     * Delete a student from the list by their ID
     * @param id The student's ID to find the student for deletion
     */
    public void deleteStudent(String id) {
        // Remove the student if their ID matches the given ID
        students.removeIf(student -> student.getStudentId().equals(id));
    }

    /**
     * Sort students based on their marks in descending order
     */
    public void sortStudents() {
        // Use Comparator to compare the marks and sort in descending order
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
    }

    /**
     * Search for a student by their ID
     * @param id The student's ID to search for
     * @return The student object if found, or null if not found
     */
    public Student searchStudent(String id) {
        // Loop through the list of students to find the matching ID
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student;  // Return the student if found
            }
        }
        return null;  // Return null if no student is found
    }

    /**
     * Display all the students with their details
     */
    public void displayStudents() {
        // Loop through the list of students and print their information
        for (Student student : students) {
            System.out.println(student);  // toString() method of Student class is called
        }
    }
}
