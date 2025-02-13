package aula11;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GradebookTester {
    public static void main(String[] args) {
        // Create a new Gradebook instance
        IGradeCalculator calculator = new SimpleGradeCalculator();
        Gradebook gradebook = new Gradebook(calculator);

        // Load the student data from a text file
        try {
            gradebook.load("alunos.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        // Add a new student to the collection
        Student newStudent = new Student("Johny May", new ArrayList<>(List.of(10.0, 15.0, 19.0)));
        gradebook.addStudent("Johny May", newStudent.getGrades());

        // Remove a student from the collection
        gradebook.removeStudent("Jane Smith");

        // Retrieve a student from the collection
        Student student = gradebook.getStudent("John Doe");

        // Calculate the average grade for a specific student
        double averageGrade = gradebook.calculateAverageGrade("John Doe");
        System.out.println("Average grade for John Doe: " + averageGrade);

        // Print a summary of all students in the collection
        gradebook.printAllStudents();
    }
}
