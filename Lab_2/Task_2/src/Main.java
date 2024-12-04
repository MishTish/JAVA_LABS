import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the university: ");
        String universityName = scanner.nextLine();
        University university = new University(universityName);

        while (true) {
            System.out.println("\nUniversity Management System");
            System.out.println("1. Add Department");
            System.out.println("2. Add Teacher to Department");
            System.out.println("3. Display Departments");
            System.out.println("4. Display Teachers in a Department");
            System.out.println("5. Manage Events");
            System.out.println("6. Calculate Average Grade");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter department name: ");
                    String departmentName = scanner.nextLine();
                    university.addDepartment(departmentName);
                    System.out.println("Department added.");
                    break;

                case "2":
                    System.out.print("Enter department name: ");
                    String deptName = scanner.nextLine();
                    University.Department department = null;
                    for (University.Department dept : university.getDepartments()) {
                        if (dept.getDepartmentName().equalsIgnoreCase(deptName)) {
                            department = dept;
                            break;
                        }
                    }
                    if (department == null) {
                        System.out.println("Department not found.");
                    } else {
                        System.out.print("Enter teacher name: ");
                        String teacherName = scanner.nextLine();
                        department.addTeacher(teacherName);
                        System.out.println("Teacher added.");
                    }
                    break;

                case "3":
                    university.displayDepartments();
                    break;

                case "4":
                    System.out.print("Enter department name: ");
                    String deptToView = scanner.nextLine();
                    University.Department deptToDisplay = null;
                    for (University.Department dept : university.getDepartments()) {
                        if (dept.getDepartmentName().equalsIgnoreCase(deptToView)) {
                            deptToDisplay = dept;
                            break;
                        }
                    }
                    if (deptToDisplay == null) {
                        System.out.println("Department not found.");
                    } else {
                        deptToDisplay.displayTeachers();
                    }
                    break;

                case "5":
                    university.manageEvents();
                    break;

                case "6":
                    try {
                        System.out.print("Enter the number of grades: ");
                        int numGrades = scanner.nextInt();
                        ArrayList<Integer> grades = new ArrayList<>();
                        System.out.println("Enter grades:");
                        for (int i = 0; i < numGrades; i++) {
                            grades.add(scanner.nextInt());
                        }
                        double average = University.Helper.calculateAverageGrade(grades);
                        System.out.println("Average grade: " + average);

                        break;

                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                    }
                    scanner.nextLine();
                    break;

                case "7":
                    System.out.println("Exiting.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
}
