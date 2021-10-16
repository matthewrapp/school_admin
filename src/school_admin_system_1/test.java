//package school_admin_system_1;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class test {
//
//    // File Prologue
//// Name: Matthew Rapp
//// Course: CSE 310
//// Sprint: #2
//// Project Name: School Administration System
//// Project Description: fkldasjfkldsa
//// Date: October 06, 2021
//
//package school_admin_system_1;
//
//import java.io.*;
//import java.util.Scanner;
//import java.util.ArrayList;
//
//    public class SchoolAdminApp {
//
//        public static void main(String[] args) throws FileNotFoundException {
//
//            // Create new scanner object
//            Scanner in = new Scanner(System.in);
//
//            // prompt the user && store the answer in variable
//            System.out.print("Enter number of new students to enroll: ");
//            int numOfStudents = in.nextInt();
//
//            // create an array of Student objects with numOfStudents being how many objects in the array
//            Student[] students = new Student[numOfStudents];
//
//            // Create n number of new students
//            for (int n = 0; n < numOfStudents; n++) {
//                // for each student, create a new Student object
//                students[n] = new Student();
//                // enroll that student
//                students[n].enroll();
//                // ask to pay tuition
//                students[n].payTuition();
//
//                // create string to save to text file
//                String sToSave = students[n].getStudentFirstName() + " | "
//                        + students[n].getStudentLastName() + " | "
//                        + students[n].getStudentGradeLevel() + " | "
//                        + students[n].getStudentId() + " | "
//                        + students[n].getEnrolledCourses() + " | "
//                        + students[n].getBalance();
//
//                // file name/path
//                String filePath = "students.txt";
//                // check if file already exists and pass it as a boolean for append
//                boolean append = new File(filePath).exists();
//
//                // write to txt file
//                saveToFile(sToSave, filePath, append);
//
//                // read txt file
//                readFromFile(filePath);
//
//            }
//        }
//
//        public static void saveToFile(String sToSave, String filepath, boolean append) {
//            try {
//                // // create file && check if file exists already,
//                File file1 = new File(filepath);
//
//                // create a file writer class
//                FileWriter fw = new FileWriter(file1, append);
//
//                // create a print write class
//                PrintWriter pw = new PrintWriter(fw);
//
//                // print file to new line
//                pw.println(sToSave);
//
//                // close printWriter object
//                pw.close();
//
//            }  catch (FileNotFoundException e) {
//                System.out.println("File not found");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public static ArrayList<Student> readFromFile(String fileName) throws FileNotFoundException {
//            // create new file with file name
//            File file = new File(fileName);
//            // create new scanner obj
//            Scanner s = new Scanner(file);
//
//            // create an empty array list of student objects
//            ArrayList<Student> studentList = new ArrayList<Student>();
//
//            // while the file has another line, keep executing
//            while (s.hasNextLine()) {
//                // read the next line in scanner object
//                String line = s.nextLine();
//
//                // each individual string will be seperated by the | (PIPE) char
//                String[] itemsInLine = line.split("\\|");
//
//                // get each value and put it into the student object
//                String firstName = itemsInLine[0];
//                String lastName = itemsInLine[1];
//                int gradeYear = Integer.parseInt(itemsInLine[2]);
//                String studentId = itemsInLine[3];
//                String courses = itemsInLine[4];
//                int tuitionBal = Integer.parseInt(itemsInLine[5]);
//
//                // read student
//                Student oneStudent = new Student(firstName, lastName, gradeYear, studentId, courses, tuitionBal);
//                studentList.add(oneStudent);
//            }
//
//            return studentList;
//        }
//
//    }
//
//
//
//}
