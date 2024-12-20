import java.io.*;
import java.util.*;

class Student {
    private String SID;
    private String firstName;
    private String lastName;

    public Student(String SID, String firstName, String lastName) {
        this.SID = SID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String toString() {
        return this.SID + " " + this.firstName + " " + this.lastName;
    }
}

public class Data {
    private static Vector<Student> students;

    public static void main(String[] args) {
        try {
            File f = new File("/Users/natthapoom/Desktop/Tutorial 2.csv");
            processFile(f);
            DisplayResult();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    private static void processFile(File f) throws FileNotFoundException {
        Scanner in = new Scanner(f);
        students = new Vector<>();

        // Skip the first 7 lines
        for (int i = 0; i < 7; i++) {
            if (in.hasNextLine()) {
                in.nextLine();
            }
        }

        // Process student data
        while (in.hasNextLine()) {
            String dataLine = in.nextLine();
            try {
                StringTokenizer stu = new StringTokenizer(dataLine.trim(), ",");
                stu.nextToken(); // Skip first token
                String sid = stu.nextToken().trim();
                String firstName = stu.nextToken().trim();
                String lastName = stu.nextToken().trim();

                students.addElement(new Student(sid, firstName, lastName));
            } catch (NoSuchElementException e) {
                System.out.println("Warning: Skipping malformed line: " + dataLine);
            }
        }

        in.close();
    }

    public static void DisplayResult() {
        System.out.println("Total students: " + students.size());

        // Count students by first letter
        int[] letterCounts = new int[26];  // A-Z counts

        // First pass: count letters
        for (Student student : students) {
            char firstLetter = student.getFirstName().toUpperCase().charAt(0);
            letterCounts[firstLetter - 'A']++;
        }

        // Second pass: display students
        for (int i = 0; i < 26; i++) {
            if (letterCounts[i] > 0) {
                char letter = (char)('A' + i);
                System.out.println("\n" + letter + ": " + letterCounts[i]);

                // Display all students starting with this letter
                for (Student student : students) {
                    if (student.getFirstName().toUpperCase().charAt(0) == letter) {
                        System.out.println(student.toString());
                    }
                }
            }
        }
    }
}