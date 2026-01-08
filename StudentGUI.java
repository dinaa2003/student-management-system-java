
package dina120220014;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentGUI extends JFrame {
    private JTextField idField;
    private JTextArea outputArea;
    private JButton gpaButton, addCourseButton, deleteCourseButton, infoButton;
     Program program;

    public StudentGUI() {
        program = new Program();
        initializeUI();
    }
    public void initializeUI() {
        setTitle("Student Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Enter Student ID:");
        idField = new JTextField(10);
        inputPanel.add(idLabel);
        inputPanel.add(idField);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        gpaButton = new JButton("Calculate GPA");
        addCourseButton = new JButton("Add Course");
        deleteCourseButton = new JButton("Delete Course");
        infoButton = new JButton("Display Info");

        buttonPanel.add(gpaButton);
        buttonPanel.add(addCourseButton);
        buttonPanel.add(deleteCourseButton);
        buttonPanel.add(infoButton);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listeners
        gpaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGPA();
            }
        });

        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourse();
            }
        });

        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCourse();
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInfo();
            }
        });
    }

    private void calculateGPA() {
        String id = idField.getText();
        Students student = findStudentById(id);
        if (student != null) {
            double gpa = student.CalculateGPA();
            outputArea.setText("GPA for student " + student.getFirstName() + " " + student.getLastName() + " is: " + gpa);
        } else {
            outputArea.setText("Student not found!");
        }
    }

    private void addCourse() {
        String id = idField.getText();
        Students student = findStudentById(id);
        if (student != null) {
            String courseName = JOptionPane.showInputDialog(this, "Enter Course Name:");
            String courseID = JOptionPane.showInputDialog(this, "Enter Course ID:");
            String hasMarks = JOptionPane.showInputDialog(this, "Do you have marks for this course? (yes/no)");

            if (hasMarks != null && hasMarks.equalsIgnoreCase("yes")) {
                double firstExam = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter First Exam Mark:"));
                double secondExam = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Second Exam Mark:"));
                double finalExam = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Final Exam Mark:"));
                Courses course = new Courses(courseName, courseID, firstExam, secondExam, finalExam);
                student.addCourses(course);
            } else {
                Courses course = new Courses(courseName, courseID, 0, 0, 0);
                student.addCourses(course);
            }
            outputArea.setText("Course added successfully!");
        } else {
            outputArea.setText("Student not found!");
        }
    }

    private void deleteCourse() {
        String id = idField.getText();
        Students student = findStudentById(id);
        if (student != null) {
            String courseID = JOptionPane.showInputDialog(this, "Enter Course ID to delete:");
            List<Courses> courses = student.getCourses();
            for (Courses course : courses) {
                if (course.getCourseID().equals(courseID)) {
                    courses.remove(course);
                    outputArea.setText("Course deleted successfully!");
                    return;
                }
            }
            outputArea.setText("Course not found!");
        } else {
            outputArea.setText("Student not found!");
        }
    }

    private void displayInfo() {
        String id = idField.getText();
        Students student = findStudentById(id);
        if (student != null) {
            StringBuilder info = new StringBuilder();
            info.append("Student Name: ").append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
            info.append("GPA: ").append(student.CalculateGPA()).append("\n");
            info.append("Courses:\n");
            for (Courses course : student.getCourses()) {
                info.append("* ").append(course.getCourseName()).append(" Total Marks: ").append(course.calTotal()).append("\n");
            }
            outputArea.setText(info.toString());
        } else {
            outputArea.setText("Student not found!");
        }
    }

    private Students findStudentById(String id) {
        for (Students student : program.students) {
            if (student.getID().equals(id)) {
                return student;
            }
        }
        return null;
    }

}


