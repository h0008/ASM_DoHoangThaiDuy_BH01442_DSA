import java.util.ArrayList;     // Importing the ArrayList class for dynamic array implementation
import java.util.List;          // Importing the List interface for the student collection
import java.util.Stack;         // Importing the Stack class for managing operations
import java.util.LinkedList;    // Importing the LinkedList class for Queue implementation
import java.util.Queue;         // Importing the Queue interface for managing FIFO operations

public class StudentManagement {
    // List to hold the students' information
    private List<Student> students;
    // Stack to manage recent student operations for undo functionality
    private Stack<Student> operationStack;
    // Queue to manage student operations in FIFO order
    private Queue<Student> operationQueue;

    // Constructor to initialize the students list and the operation structures
    public StudentManagement() {
        students = new ArrayList<>();  // Using ArrayList for dynamic student storage
        operationStack = new Stack<>(); // Initializing the stack for operations
        operationQueue = new LinkedList<>(); // Initializing the queue for operations
    }

    /**
     * Add a student to the list
     * @param id    The student's ID
     * @param name  The student's full name
     * @param marks The student's marks
     */
    public void addStudent(String id, String name, float marks) {
        Student newStudent = new Student(id, name, marks); // Create a new student object
        students.add(newStudent); // Add the new student to the list
        operationStack.push(newStudent); // Push the new student to the stack for potential undo
        operationQueue.offer(newStudent); // Enqueue the new student for processing in FIFO order
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
                operationStack.push(student); // Push the edited student to the stack for potential undo
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
        // Use the stack to manage the operation if needed for undo
    }

    /**
     * Sort students based on their marks using Bubble Sort in descending order
     */
    public void sortStudents() {
        int n = students.size();
        boolean swapped;
        // Bubble Sort algorithm implementation
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reset the swap flag
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent students' marks
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    // Swap if the current student has lower marks than the next
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true; // Set the swap flag to true
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
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

    /**
     * Undo the last operation using the stack
     * @return The student that was last added or edited, or null if no operation can be undone
     */
    public Student undoLastOperation() {
        if (!operationStack.isEmpty()) {
            return operationStack.pop(); // Pop the last operation from the stack
        }
        return null; // Return null if there are no operations to undo
    }

    /**
     * Process operations in FIFO order using the queue
     */
    public void processOperations() {
        while (!operationQueue.isEmpty()) {
            Student student = operationQueue.poll(); // Retrieve and remove the head of the queue
            // Here you can add logic to process the student
            System.out.println("Processing student: " + student);
        }
    }
}
