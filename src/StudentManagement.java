import java.util.*;

public class StudentManagement {
    private final int maxStudents; // Maximum number of students
    private final int maxQueueSize; // Maximum queue size, default to 6
    private final List<Student> students;
    private final Stack<Student> operationStack;
    private final Queue<Student> operationQueue;

    // Constructor with maxStudents and default maxQueueSize
    public StudentManagement(int maxStudents) {
        this.maxStudents = maxStudents;
        this.maxQueueSize = 6; // Default max queue size
        students = new ArrayList<>();
        operationStack = new Stack<>();
        operationQueue = new LinkedList<>();
    }

    // Option to set the queue size
    public StudentManagement(int maxStudents, int maxQueueSize) {
        this.maxStudents = maxStudents;
        this.maxQueueSize = maxQueueSize;
        students = new ArrayList<>();
        operationStack = new Stack<>();
        operationQueue = new LinkedList<>();
    }

    // Add a student to the list or to the queue if the limit is reached
    public void addStudent(String id, String name, float marks) {
        Student newStudent = new Student(id, name, marks);
        if (students.size() < maxStudents) {
            students.add(newStudent);
            operationStack.push(newStudent);
        } else if (operationQueue.size() < maxQueueSize) {
            operationQueue.offer(newStudent); // Enqueue new student if limit is reached
            System.out.println("Student limit reached. " + name + " has been added to the queue.");
        } else {
            System.out.println("Queue is full. Cannot add " + name + " to the queue.");
        }
    }

    // Method to display the maximum queue size
    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    // Edit the marks of an existing student
    public void editStudent(String id, float newMarks) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                student.setMarks(newMarks);
                operationStack.push(student);
                return;
            }
        }
    }

    // Delete a student and add the next one from the queue (if any)
    public void deleteStudent(String id) {
        boolean removed = students.removeIf(student -> student.getStudentId().equals(id));
        if (removed) {
            System.out.println("Student deleted successfully.");
            // If there are students in the queue, add the next one to the list
            if (!operationQueue.isEmpty()) {
                Student nextStudent = operationQueue.poll(); // Remove from the queue
                students.add(nextStudent); // Add to the student list
                System.out.println("Student " + nextStudent.getStudentName() + " has been added from the queue.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    // Sort students based on their marks using Bubble Sort in descending order
    public void sortStudents() {
        int n = students.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true;
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

    // Display all the students starting with the newest
    public void displayStudents() {
        for (int i = students.size() - 1; i >= 0; i--) {
            System.out.println(students.get(i));
        }
    }

    // Undo the last operation using the stack
    public Student undoLastOperation() {
        if (!operationStack.isEmpty()) {
            return operationStack.pop();
        }
        return null;
    }

    // Process operations in FIFO order using the queue
    public void processOperations() {
        while (!operationQueue.isEmpty()) {
            Student student = operationQueue.poll();
            System.out.println("Processing student: " + student);
        }
    }

    // Load example data
    public static void loadExampleData(StudentManagement stuM) {
        stuM.addStudent("BH00001", "Duy", 8.5F);
        stuM.addStudent("BH00002", "Huy", 6.0F);
        stuM.addStudent("BH00003", "Quang", 9.2F);
        stuM.addStudent("BH00004", "Hoang", 7.4F);
        stuM.addStudent("BH00005", "Hieu", 5.5F);
        stuM.addStudent("BH00006", "Tuan", 7.8F); // This student will be added to the queue
    }
}
