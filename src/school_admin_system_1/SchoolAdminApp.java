// File Prologue
// Name: Matthew Rapp
// Course: CSE 310
// Sprint: #2
// Project Name: School Administration System
// Project Description: fkldasjfkldsa
// Date: October 06, 2021

package school_admin_system_1;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class SchoolAdminApp {

    public static void main(String[] args) throws FileNotFoundException {
        // Create new scanner object
        Scanner in = new Scanner(System.in);

	    // prompt the user && store the answer in variable
        System.out.print("Enter number of new students to enroll: ");
        int numOfStudents = in.nextInt();

//        // create an array of Student objects with numOfStudents being how many objects in the array
        Student[] students = new Student[numOfStudents];

        // Create n number of new students
        for (int n = 0; n < numOfStudents; n++) {
            // set variables
            int tuitionBal = 0;
            int costOfCourse = 600;

            // prompt user & store answer in variable
            System.out.print("Enter student first name: ");
            String firstName = in.next();

            // needed to add this nextLine() so it didn't automatically skip the firstName
            in.nextLine();

            // prompt user & store answer in variable
            System.out.print("Enter student last name: ");
            String lastName = in.nextLine();

            // prompt user & store answer in variable
            System.out.print("1 - Freshman\n2 - Softmore\n3 - Junior\n4 - Senior\nEnter student class year: ");
            int gradeYear = in.nextInt();

            // needed to add this nextLine() so it didn't automatically skip the first class to enroll
            in.nextLine();

            // get random generated ID
            String studentID = renderId(lastName, firstName, gradeYear);

            // enroll in courses
            // courses string
            String courses = "";
            // do this loop infinitely until the user types 'Q'
            do {
                // prompt user & store answer in variable
                System.out.print("Enter course to enroll (Q to quit): ");
                String course = in.nextLine();
                // if user types in 'Q', break from the loop
                if (course.equals("Q")) { break; }
                // else add new course to courses strubg
                courses += ", " + course;
                // add total balance to the cost of the course
                tuitionBal += costOfCourse;
            } while (1 != 0); // infinite

            // generate Student OBJ
            students[n] = new Student(firstName, lastName, gradeYear, studentID, courses, tuitionBal);

            // pay tuition
            // get current balance of student
            tuitionBal = students[n].getBalance();
            // prompt user & store in variable
            System.out.println("Your balance is $" + tuitionBal);
            System.out.print("Enter your payment: $");
            int payment = in.nextInt();
            // use student object to pay tuition and pass payment as a parameter
            students[n].payTuition(payment);
            // get new balance for the student & prompt the user
            tuitionBal = students[n].getBalance();
            System.out.println("Thank you for your payment of $" + payment + ". Your new balance is $" + tuitionBal + ".");

            // create string to save to text file
            String sToSave = students[n].getStudentFirstName() + " | "
                    + students[n].getStudentLastName() + " | "
                    + students[n].getStudentGradeLevel() + " | "
                    + students[n].getStudentId() + " | "
                    + students[n].getEnrolledCourses() + " | "
                    + students[n].getBalance();

            // file name/path
            String filePath = "students.txt";
            // check if file already exists and pass it as a boolean for append
            boolean append = new File(filePath).exists();

            // write to txt file
            saveToFile(sToSave, filePath, append);
        }
        // file name/path
        String filePath = "students.txt";

        // read txt file
        ArrayList<Student> stuArrList = readFromFile(filePath);
        System.out.println("\nEnrolled Students: \n");
        // print out each student object that was saved in the text file
        for (int count = 0; count < stuArrList.size(); count++) {
            String sToReturn = "Full Name: " + stuArrList.get(count).getStudentFirstName() + " " + stuArrList.get(count).getStudentLastName()
                    + "\nGrade Level: " + stuArrList.get(count).getStudentGradeLevel()
                    + "\nStudent ID: " + stuArrList.get(count).getStudentId()
                    + "\nCourses: " + stuArrList.get(count).getEnrolledCourses()
                    + "\nTuition Balance: " + stuArrList.get(count).getBalance();
            System.out.println(sToReturn + "\n");
        }
    }

    // this method will generate an id for the new student
    public static String renderId(String ln, String fn, int gradeYear) {
        // use first 3 char of last name, plus the grad year (1, 2, 3, 4), plus length of first and last name to create student id
        return ln.substring(0, 3) + "-" + gradeYear + fn.length() + ln.length();
    }

    // this method will save the student object that was turned into a string into a txt file
    public static void saveToFile(String sToSave, String filepath, boolean append) {
        try {
            // // create file && check if file exists already,
            File file1 = new File(filepath);

            // create a file writer class
            FileWriter fw = new FileWriter(file1, append);

            // create a print write class
            PrintWriter pw = new PrintWriter(fw);

            // print file to new line
            pw.println(sToSave);

            // close printWriter object
            pw.close();

        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readFromFile(String fileName) throws FileNotFoundException {
        // create new file with file name
        File file = new File(fileName);
        // create new scanner obj
        Scanner s = new Scanner(file);

        // create an empty array list of student objects
        ArrayList<Student> studentList = new ArrayList<>();

        // while the file has another line, keep executing
        while (s.hasNextLine()) {
            // read the next line in scanner object
            String line = s.nextLine();

            // each individual string will be seperated by the | (PIPE) char
            String[] itemsInLine = line.split("\\|");

            // get each value and put it into the student object & trim the white space around it
            String firstName = itemsInLine[0].trim();
            String lastName = itemsInLine[1].trim();
            String gradeYear = itemsInLine[2].trim();
            String studentId = itemsInLine[3].trim();
            String courses = itemsInLine[4].trim();
            String tuitionBal = itemsInLine[5].trim();

            // create an instance of that student
            Student oneStudent = new Student(firstName, lastName, Integer.parseInt(gradeYear), studentId, courses, Integer.parseInt(tuitionBal));
            // add student to array of students
            studentList.add(oneStudent);
        }

        // once there is no more lines to read in the file, return the array of students to read
        return studentList;
    }

}


