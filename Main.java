import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Student ID    : " + id);
        System.out.println("Student Name  : " + name);
        System.out.println("Student Marks : " + marks);
        System.out.println("----------------------------");
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (Student s : students) {
                        if (s.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Student ID already exists!");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n----- STUDENT DETAILS -----");

                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    id = sc.nextInt();

                    exists = false;

                    for (Student s : students) {
                        if (s.id == id) {
                            System.out.println("\nStudent Found:");
                            s.display();
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    exists = false;

                    for (Student s : students) {
                        if (s.id == id) {
                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextDouble();

                            System.out.println("Student updated successfully!");
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    id = sc.nextInt();

                    exists = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).id == id) {
                            students.remove(i);

                            System.out.println("Student deleted successfully!");
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}