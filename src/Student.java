import java.util.*;

class Student {
    private String studentId;
    private String studentName;
    private float marks;
    private String rank;

    // Constructor
    public Student(String studentId, String studentName, float marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
        this.rank = assignRank(marks);
    }

    // Method to assign rank based on marks
    private String assignRank(float marks) {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public Float getMarks() { return marks; }
    public String getRank() { return rank; }

    // For updating student details
    public void setMarks(float marks) {
        this.marks = marks;
        this.rank = assignRank(marks);
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + studentName + ", Marks: " + marks + ", Rank: " + rank;
    }
}
