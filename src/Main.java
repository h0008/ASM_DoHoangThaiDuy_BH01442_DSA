import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the maximum number of students
        System.out.print("Enter the maximum number of students allowed: ");
        int maxStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create the StudentManagement object with the user-defined limit
        StudentManagement stuM = new StudentManagement(maxStudents);

        int choice;

        // Load example data
        StudentManagement.loadExampleData(stuM);

        // Multiple choices
        do {
            System.out.println("\nWelcome to the Student Management System!");
            System.out.println("1. Add a new student");
            System.out.println("2. Edit a student's marks");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all of the students");
            System.out.println("5. Search up a student by ID");
            System.out.println("6. Sort students by marks in descending order");
            System.out.println("7. Load example data");
            System.out.println("8. Show current maximum queue size (default = 6)");
            System.out.println("0. Quit the program");
            System.out.print("Input in a number then press ENTER: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter the student's ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the student's marks: ");
                    float marks = scanner.nextFloat();
                    stuM.addStudent(id, name, marks);
                    break;

                case 2:
                    // Edit student marks
                    System.out.print("Enter Student ID to Edit: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    marks = scanner.nextFloat();
                    stuM.editStudent(id, marks);
                    System.out.println("Student marks updated!");
                    break;

                case 3:
                    // Delete student
                    System.out.print("Enter Student ID to Delete: ");
                    id = scanner.nextLine();
                    stuM.deleteStudent(id);
                    break;

                case 4:
                    // Display all students
                    stuM.displayStudents();
                    break;

                case 5:
                    // Search student by ID
                    System.out.print("Enter the student's ID to search: ");
                    id = scanner.nextLine();
                    Student student = stuM.searchStudent(id);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Cannot find the student with that ID.");
                    }
                    break;

                case 6:
                    // Sort students by marks
                    stuM.sortStudents();
                    System.out.println("Students sorted by marks (descending).");
                    break;

                case 7:
                    // Load example data
                    StudentManagement.loadExampleData(stuM);
                    System.out.println("Example data loaded.");
                    break;

                case 8:
                    // Show max queue size
                    System.out.println("Current maximum queue size: " + stuM.getMaxQueueSize());
                    break;

                case 0:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please enter a valid number from 0 to 8.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
