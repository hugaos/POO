package aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Gradebook {
    private Map<String, Student> students;
    private IGradeCalculator calculator;

    public Gradebook(IGradeCalculator calculator) {
        this.calculator = calculator;
        this.students = new HashMap<>();
    }

    public void load(String file) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        while (input.hasNextLine()) {
            String linha = input.nextLine();
            String[] parts = linha.split("//|");
            String nome = parts[0];
            ArrayList<Double> grades = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                Double grade = Double.parseDouble(parts[i].trim());
                grades.add(grade);
            }
            Student student = new Student(nome, grades);
            students.put(nome, student);
        }
    }

    public void addStudent(String name, List<Double> grades) {
        Student student = new Student(name, grades);
        students.put(name, student);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public Student getStudent(String name) {
        return students.get(name);
    }

    public double calculateAverageGrade(String name) {
        Student student = students.get(name);
        return (student.getGrades().get(0) + student.getGrades().get(1) + student.getGrades().get(2)) / 3;
        
    }

    public void printAllStudents() {
        for (Student student : students.values()) {
            System.out.println("Name: " + student.getName() + " | Grades: " + student.getGrades());
        }
    }
}
