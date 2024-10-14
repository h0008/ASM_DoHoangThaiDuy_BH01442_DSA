import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement stuM = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Student Management System!");
            System.out.println("1. Add a new student");
            System.out.println("2. Edit a student's marks");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all of the students");
            System.out.println("5. Search up a student by ID");
            System.out.println("6. Sort students by marks in descending order");
            System.out.println("7. Load example data");
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
                    System.out.println("Added successfully!");
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
                    System.out.print("Enter Student ID to Delete (BH000xx): ");
                    id = scanner.nextLine();
                    stuM.deleteStudent(id);
                    System.out.println("Student deleted successfully!");
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
                        System.out.println("Cannot find the student with that ID, please try again.");
                    }
                    break;

                case 6:
                    // Sort students by marks
                    stuM.sortStudents();
                    System.out.println("Here is the student list sorted by descending order:");
                    stuM.displayStudents();
                    break;

                case 7:
                    // Load example data
                    StudentManagement.loadExampleData(stuM);
                    System.out.println("Example data loaded successfully!");
                    break;

                case 0:
                    // Exit
                    System.out.println("Quitting...");
                    break;

                default:
                    System.out.println("Please input a valid WHOLE number from 0 to 7.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
