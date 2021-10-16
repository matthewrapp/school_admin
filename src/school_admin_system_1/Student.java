package school_admin_system_1;

import java.util.Scanner;
import java.io.Serializable;

public class Student implements Serializable {
    // private variables
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;

    // constructor: prompt user to enter student's name and year
    public Student(String firstName, String lastName, int gradeYear, String studentId, String courses, int tuitionBal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeYear = gradeYear;
        this.studentID = studentId;
        this.courses = courses;
        this.tuitionBalance = tuitionBal;
    }

    // get student first name
    public String getStudentFirstName() {
        return this.firstName;
    }

    // set student first name
    public void setStudentFirstName(String name) {
        this.firstName = name;
    }

    // get student last name
    public String getStudentLastName() {
        return this.lastName;
    }

    // set student last name
    public void setStudentLastName(String name) {
        this.lastName = name;
    }

    // get student grade level
    public String getStudentGradeLevel() {
        String intToString = String.valueOf(this.gradeYear);
        return intToString;
    }

    // set student grade level
    public void setStudentGradeLevel(int grade) {
        this.gradeYear = grade;
    }

    // get student id
    public String getStudentId() {
        String intToString = String.valueOf(this.studentID);
        return intToString;
    }

    // generate an ID for each student
    private void setStudentID(String studentID) {
        this.studentID = studentID;
    };

    // get student enrolled courses
    public String getEnrolledCourses() {
        return this.courses;
    }

    // get student balance
    public int getBalance() {
        return this.tuitionBalance;
    }

    // pay tuition
    public void payTuition(int payment) {
        tuitionBalance = tuitionBalance - payment;
    }

    // show status
    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
