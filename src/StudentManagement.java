import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class StudentManagement {
    public Object loadExampleData;
    private final List<Student> students;
    private final Stack<Student> operationStack;
    private final Queue<Student> operationQueue;

    public StudentManagement() {
        students = new ArrayList<>();
        operationStack = new Stack<>();
        operationQueue = new LinkedList<>();
    }

//Add a student to the list
    public void addStudent(String id, String name, float marks) {
        Student newStudent = new Student(id, name, marks);
        students.add(newStudent);
        operationStack.push(newStudent);
        operationQueue.offer(newStudent);
    }

//Edit the marks of an existing student

    public void editStudent(String id, float newMarks) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {

                student.setMarks(newMarks);
                operationStack.push(student);
                return;
            }
        }
    }

// Delete a student from the list by their ID

    public void deleteStudent(String id) {
        students.removeIf(student -> student.getStudentId().equals(id));
    }

//Sort students based on their marks using Bubble Sort in descending order

    public void sortStudents() {
        int n = students.size();
        boolean swapped;
        // Bubble Sort algorithm implementation
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    // Swap if the current student has lower marks than the next
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true; // Set the swap flag to true
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

// Search for a student by their ID

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }

//Display all the students

    public void displayStudents() {
        for (int i = students.size() - 1; i >= 0; i--) {
            System.out.println(students.get(i));
        }
    }

//Undo the last operation using the stack
    public Student undoLastOperation() {
        if (!operationStack.isEmpty()) {
            return operationStack.pop(); // Pop!
        }
        return null;
    }

//Process operations in FIFO order using the queue

    public void processOperations() {
        while (!operationQueue.isEmpty()) {
            Student student = operationQueue.poll(); // Retrieve and remove the head of the queue
            System.out.println("Processing student: " + student);
        }
    }
//Load example data
    public static void loadExampleData(StudentManagement stuM) {
        stuM.addStudent("BH00001", "Duy", 8.5F);
        stuM.addStudent("BH00002", "Huy", 6.0F);
        stuM.addStudent("BH00003", "Quang", 9.2F);
        stuM.addStudent("BH00004", "Hoang", 7.4F);
        stuM.addStudent("BH00005", "Hieu", 5.5F);
    }
}
