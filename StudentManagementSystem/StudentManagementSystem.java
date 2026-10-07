import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// =====================================================
// PARENT CLASS
// =====================================================

class Person {

    private String name;
    private int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


// =====================================================
// CHILD CLASS
// INHERITANCE
// =====================================================

class Student extends Person {

    private String rollNumber;
    private String course;

    // Array for 3 subject marks
    private int[] marks = new int[3];

    // Constructor
    Student(String rollNumber, String name, int age,
            String course, int m1, int m2, int m3) {

        super(name, age);

        this.rollNumber = rollNumber;
        this.course = course;

        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    // Getters
    public String getRollNumber() {
        return rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public int[] getMarks() {
        return marks;
    }

    // Setters
    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(int m1, int m2, int m3) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    // Calculate total
    public int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    // Calculate average
    public double getAverage() {
        return getTotal() / 3.0;
    }

    // Calculate grade
    public String getGrade() {

        double average = getAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}


// =====================================================
// MAIN STUDENT MANAGEMENT APPLICATION
// =====================================================

public class StudentManagementSystem extends JFrame {

    // Array of Student objects
    private Student[] students = new Student[100];

    private int studentCount = 0;

    // Input fields
    private JTextField rollField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField courseField;

    private JTextField mark1Field;
    private JTextField mark2Field;
    private JTextField mark3Field;

    private JTextField searchField;

    // Table
    private DefaultTableModel tableModel;
    private JTable studentTable;


    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    StudentManagementSystem() {

        setTitle("Student Management System");
        setSize(1000, 700);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setResizable(false);


        // Main panel
        JPanel mainPanel =
                new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );


        // =================================================
        // TITLE
        // =================================================

        JLabel title =
                new JLabel(
                        "STUDENT MANAGEMENT SYSTEM",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font("Arial", Font.BOLD, 28)
        );


        JLabel subtitle =
                new JLabel(
                        "Java OOP Based Application",
                        SwingConstants.CENTER
                );

        subtitle.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );


        JPanel titlePanel =
                new JPanel(new GridLayout(2, 1));

        titlePanel.add(title);
        titlePanel.add(subtitle);

        mainPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );


        // =================================================
        // INPUT PANEL
        // =================================================

        JPanel inputPanel =
                new JPanel(
                        new GridLayout(7, 2, 8, 8)
                );

        inputPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Student Information"
                )
        );


        inputPanel.add(
                new JLabel("Roll Number:")
        );

        rollField = new JTextField();
        inputPanel.add(rollField);


        inputPanel.add(
                new JLabel("Student Name:")
        );

        nameField = new JTextField();
        inputPanel.add(nameField);


        inputPanel.add(
                new JLabel("Age:")
        );

        ageField = new JTextField();
        inputPanel.add(ageField);


        inputPanel.add(
                new JLabel("Course:")
        );

        courseField = new JTextField();
        inputPanel.add(courseField);


        inputPanel.add(
                new JLabel("Subject 1 Marks:")
        );

        mark1Field = new JTextField();
        inputPanel.add(mark1Field);


        inputPanel.add(
                new JLabel("Subject 2 Marks:")
        );

        mark2Field = new JTextField();
        inputPanel.add(mark2Field);


        inputPanel.add(
                new JLabel("Subject 3 Marks:")
        );

        mark3Field = new JTextField();
        inputPanel.add(mark3Field);


        // Add button
        JButton addButton =
                new JButton("ADD STUDENT");


        JPanel inputContainer =
                new JPanel(new BorderLayout(5, 5));

        inputContainer.add(
                inputPanel,
                BorderLayout.CENTER
        );

        inputContainer.add(
                addButton,
                BorderLayout.SOUTH
        );


        // =================================================
        // SEARCH PANEL
        // =================================================

        JPanel searchPanel =
                new JPanel(
                        new BorderLayout(8, 8)
                );

        searchPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Search Student"
                )
        );


        searchField = new JTextField();


        JButton searchButton =
                new JButton("SEARCH");


        JButton showAllButton =
                new JButton("SHOW ALL");


        searchPanel.add(
                new JLabel("Roll Number:"),
                BorderLayout.WEST
        );

        searchPanel.add(
                searchField,
                BorderLayout.CENTER
        );


        JPanel searchButtons =
                new JPanel();

        searchButtons.add(searchButton);
        searchButtons.add(showAllButton);


        searchPanel.add(
                searchButtons,
                BorderLayout.EAST
        );


        // =================================================
        // TABLE
        // =================================================

        String[] columns = {
                "Roll No.",
                "Name",
                "Age",
                "Course",
                "Marks",
                "Total",
                "Average",
                "Grade"
        };


        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                );


        studentTable =
                new JTable(tableModel);


        studentTable.setRowHeight(28);

        studentTable.setAutoResizeMode(
                JTable.AUTO_RESIZE_ALL_COLUMNS
        );


        JScrollPane scrollPane =
                new JScrollPane(studentTable);


        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Student List"
                )
        );


        // =================================================
        // BOTTOM BUTTONS
        // =================================================

        JButton updateButton =
                new JButton("UPDATE");


        JButton deleteButton =
                new JButton("DELETE");


        JButton clearButton =
                new JButton("CLEAR");


        JButton exitButton =
                new JButton("EXIT");


        JPanel bottomPanel =
                new JPanel(
                        new GridLayout(1, 4, 10, 10)
                );


        bottomPanel.add(updateButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(exitButton);


        // =================================================
        // TOP AREA
        // =================================================

        JPanel topArea =
                new JPanel(
                        new BorderLayout(10, 10)
                );


        topArea.add(
                inputContainer,
                BorderLayout.CENTER
        );


        topArea.add(
                searchPanel,
                BorderLayout.SOUTH
        );


        mainPanel.add(
                topArea,
                BorderLayout.CENTER
        );


        // =================================================
        // TABLE + BUTTONS
        // =================================================

        JPanel bottomArea =
                new JPanel(
                        new BorderLayout(10, 10)
                );


        bottomArea.add(
                scrollPane,
                BorderLayout.CENTER
        );


        bottomArea.add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        // Use a split layout for top and table
        JPanel completePanel =
                new JPanel(new BorderLayout(10, 10));


        completePanel.add(
                topArea,
                BorderLayout.NORTH
        );


        completePanel.add(
                scrollPane,
                BorderLayout.CENTER
        );


        completePanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );


        mainPanel.removeAll();

        mainPanel.add(
                titlePanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                completePanel,
                BorderLayout.CENTER
        );


        add(mainPanel);


        // =================================================
        // BUTTON ACTIONS
        // =================================================

        addButton.addActionListener(
                e -> addStudent()
        );


        searchButton.addActionListener(
                e -> searchStudent()
        );


        showAllButton.addActionListener(
                e -> displayAllStudents()
        );


        updateButton.addActionListener(
                e -> updateStudent()
        );


        deleteButton.addActionListener(
                e -> deleteStudent()
        );


        clearButton.addActionListener(
                e -> clearFields()
        );


        exitButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Do you want to exit?",
                            "Exit",
                            JOptionPane.YES_NO_OPTION
                    );


            if (choice ==
                    JOptionPane.YES_OPTION) {

                System.exit(0);
            }
        });


        setVisible(true);
    }


    // =====================================================
    // ADD STUDENT
    // =====================================================

    private void addStudent() {

        String roll =
                rollField.getText().trim();

        String name =
                nameField.getText().trim();

        String ageText =
                ageField.getText().trim();

        String course =
                courseField.getText().trim();


        if (roll.isEmpty()
                || name.isEmpty()
                || ageText.isEmpty()
                || course.isEmpty()
                || mark1Field.getText().trim().isEmpty()
                || mark2Field.getText().trim().isEmpty()
                || mark3Field.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }


        // Check duplicate roll number
        for (int i = 0; i < studentCount; i++) {

            if (students[i]
                    .getRollNumber()
                    .equalsIgnoreCase(roll)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Roll number already exists!"
                );

                return;
            }
        }


        try {

            int age =
                    Integer.parseInt(ageText);

            int mark1 =
                    Integer.parseInt(
                            mark1Field.getText().trim()
                    );

            int mark2 =
                    Integer.parseInt(
                            mark2Field.getText().trim()
                    );

            int mark3 =
                    Integer.parseInt(
                            mark3Field.getText().trim()
                    );


            if (age <= 0 || age > 100) {

                JOptionPane.showMessageDialog(
                        this,
                        "Enter a valid age."
                );

                return;
            }


            if (mark1 < 0 || mark1 > 100
                    || mark2 < 0 || mark2 > 100
                    || mark3 < 0 || mark3 > 100) {

                JOptionPane.showMessageDialog(
                        this,
                        "Marks must be between 0 and 100."
                );

                return;
            }


            if (studentCount >= students.length) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student storage is full."
                );

                return;
            }


            // Create Student object
            students[studentCount] =
                    new Student(
                            roll,
                            name,
                            age,
                            course,
                            mark1,
                            mark2,
                            mark3
                    );


            studentCount++;


            JOptionPane.showMessageDialog(
                    this,
                    "Student added successfully!"
            );


            displayAllStudents();

            clearFields();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Age and marks must be numbers."
            );
        }
    }


    // =====================================================
    // DISPLAY ALL STUDENTS
    // =====================================================

    private void displayAllStudents() {

        tableModel.setRowCount(0);


        for (int i = 0; i < studentCount; i++) {

            addStudentToTable(students[i]);
        }
    }


    // =====================================================
    // ADD STUDENT TO TABLE
    // =====================================================

    private void addStudentToTable(Student s) {

        int[] marks =
                s.getMarks();


        tableModel.addRow(
                new Object[] {

                        s.getRollNumber(),

                        s.getName(),

                        s.getAge(),

                        s.getCourse(),

                        marks[0] + ", "
                                + marks[1] + ", "
                                + marks[2],

                        s.getTotal(),

                        String.format(
                                "%.2f",
                                s.getAverage()
                        ),

                        s.getGrade()
                }
        );
    }


    // =====================================================
    // SEARCH STUDENT
    // =====================================================

    private void searchStudent() {

        String roll =
                searchField.getText().trim();


        if (roll.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a roll number."
            );

            return;
        }


        tableModel.setRowCount(0);


        boolean found = false;


        for (int i = 0; i < studentCount; i++) {

            if (students[i]
                    .getRollNumber()
                    .equalsIgnoreCase(roll)) {

                addStudentToTable(students[i]);

                found = true;

                break;
            }
        }


        if (!found) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student not found."
            );

            displayAllStudents();
        }
    }


    // =====================================================
    // UPDATE STUDENT
    // =====================================================

    private void updateStudent() {

        int row =
                studentTable.getSelectedRow();


        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a student from the table."
            );

            return;
        }


        String roll =
                tableModel
                        .getValueAt(row, 0)
                        .toString();


        for (int i = 0; i < studentCount; i++) {

            if (students[i]
                    .getRollNumber()
                    .equalsIgnoreCase(roll)) {

                try {

                    String name =
                            nameField.getText().trim();

                    String ageText =
                            ageField.getText().trim();

                    String course =
                            courseField.getText().trim();


                    if (name.isEmpty()
                            || ageText.isEmpty()
                            || course.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Enter name, age and course."
                        );

                        return;
                    }


                    int age =
                            Integer.parseInt(ageText);

                    int mark1 =
                            Integer.parseInt(
                                    mark1Field.getText().trim()
                            );

                    int mark2 =
                            Integer.parseInt(
                                    mark2Field.getText().trim()
                            );

                    int mark3 =
                            Integer.parseInt(
                                    mark3Field.getText().trim()
                            );


                    if (age <= 0 || age > 100) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Enter a valid age."
                        );

                        return;
                    }


                    if (mark1 < 0 || mark1 > 100
                            || mark2 < 0 || mark2 > 100
                            || mark3 < 0 || mark3 > 100) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Marks must be between 0 and 100."
                        );

                        return;
                    }


                    students[i].setName(name);

                    students[i].setAge(age);

                    students[i].setCourse(course);

                    students[i].setMarks(
                            mark1,
                            mark2,
                            mark3
                    );


                    displayAllStudents();

                    clearFields();


                    JOptionPane.showMessageDialog(
                            this,
                            "Student updated successfully!"
                    );

                    return;

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Age and marks must be numbers."
                    );

                    return;
                }
            }
        }
    }


    // =====================================================
    // DELETE STUDENT
    // =====================================================

    private void deleteStudent() {

        int row =
                studentTable.getSelectedRow();


        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a student from the table."
            );

            return;
        }


        String roll =
                tableModel
                        .getValueAt(row, 0)
                        .toString();


        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete student " + roll + "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );


        if (choice != JOptionPane.YES_OPTION) {
            return;
        }


        for (int i = 0; i < studentCount; i++) {

            if (students[i]
                    .getRollNumber()
                    .equalsIgnoreCase(roll)) {


                // Shift array elements
                for (int j = i;
                     j < studentCount - 1;
                     j++) {

                    students[j] =
                            students[j + 1];
                }


                students[studentCount - 1] =
                        null;

                studentCount--;

                break;
            }
        }


        displayAllStudents();

        clearFields();


        JOptionPane.showMessageDialog(
                this,
                "Student deleted successfully!"
        );
    }


    // =====================================================
    // CLEAR FIELDS
    // =====================================================

    private void clearFields() {

        rollField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");

        mark1Field.setText("");
        mark2Field.setText("");
        mark3Field.setText("");

        searchField.setText("");

        studentTable.clearSelection();
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new LoginPage()
        );
    }
}


// =====================================================
// LOGIN PAGE
// =====================================================

class LoginPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;


    // =====================================================
    // LOGIN CONSTRUCTOR
    // =====================================================

    LoginPage() {

        setTitle("Student Management System - Login");

        setSize(450, 400);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setResizable(false);


        // Main panel
        JPanel panel =
                new JPanel();

        panel.setLayout(null);

        panel.setBackground(Color.WHITE);


        // =================================================
        // TITLE
        // =================================================

        JLabel title =
                new JLabel(
                        "STUDENT PORTAL",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        title.setBounds(
                90, 35, 270, 40
        );

        panel.add(title);


        // Subtitle
        JLabel subtitle =
                new JLabel(
                        "Student Management System",
                        SwingConstants.CENTER
                );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setBounds(
                90, 75, 270, 25
        );

        panel.add(subtitle);


        // =================================================
        // USERNAME
        // =================================================

        JLabel usernameLabel =
                new JLabel("Username");

        usernameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        usernameLabel.setBounds(
                70, 120, 100, 25
        );

        panel.add(usernameLabel);


        usernameField =
                new JTextField();

        usernameField.setBounds(
                70, 150, 300, 35
        );

        panel.add(usernameField);


        // =================================================
        // PASSWORD
        // =================================================

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        passwordLabel.setBounds(
                70, 195, 100, 25
        );

        panel.add(passwordLabel);


        passwordField =
                new JPasswordField();

        passwordField.setBounds(
                70, 225, 300, 35
        );

        panel.add(passwordField);


        // =================================================
        // LOGIN BUTTON
        // =================================================

        JButton loginButton =
                new JButton("LOGIN");

        loginButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        loginButton.setBounds(
                70, 285, 300, 40
        );

        panel.add(loginButton);


        // Login button action
        loginButton.addActionListener(
                e -> login()
        );


        // Press Enter to login
        passwordField.addActionListener(
                e -> login()
        );


        add(panel);

        setVisible(true);
    }


    // =====================================================
    // LOGIN METHOD
    // =====================================================

    private void login() {

        String username =
                usernameField.getText();


        String password =
                new String(
                        passwordField.getPassword()
                );


        if (username.equals("admin")
                && password.equals("1234")) {


            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful!"
            );


            dispose();


            new StudentManagementSystem();


        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password!",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );


            passwordField.setText("");
        }
    }
}