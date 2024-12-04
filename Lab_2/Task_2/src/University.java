import java.util.ArrayList;
import java.util.Scanner;

public class University {
    private String name;
    private ArrayList<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public class Department {

        private String departmentName;
        private ArrayList<String> teachers;

        public Department(String departmentName) {
            this.departmentName = departmentName;
            this.teachers = new ArrayList<>();
        }

        public void addTeacher(String teacherName) {
            teachers.add(teacherName);
        }

        public void displayTeachers() {
            System.out.println("Teachers in " + departmentName + ":");
            for (String teacher : teachers) {
                System.out.println(teacher);
            }
        }

        public String getDepartmentName() {
            return departmentName;
        }
    }

    public static class Helper {
        public static double calculateAverageGrade(ArrayList<Integer> grades) {
            if (grades == null || grades.isEmpty()) {
                return 0.0;
            }
            double sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void displayDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department department : departments) {
            System.out.println(department.getDepartmentName());
        }
    }

    public void manageEvents() {

        EventManager eventManager = new EventManager() {
            @Override
            public void organizeEvent(String eventName) {
                System.out.println("Organizing event: " + eventName + " at " + name);
            }
        };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the event name to organize: ");
        String eventName = scanner.nextLine();
        eventManager.organizeEvent(eventName);
    }
    interface EventManager {
        void organizeEvent(String eventName);
    }
}
