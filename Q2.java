import java.util.Scanner;

public class Q2 {
    static Scanner scanner = new Scanner(System.in);
    static int[][] marks;
    static int n;

    public static void main(String[] args) {
        System.out.print("Enter number of students: ");
        n = scanner.nextInt();
        scanner.nextLine();
        marks = new int[n + 1][4];

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addMarks(); break;
                case 2: updateMark(); break;
                case 3: averageSubject(); break;
                case 4: averageStudent(); break;
                case 5: totalStudent(); break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                case 7: displayGradesForStudent(); break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add student marks");
        System.out.println("2. Update student mark");
        System.out.println("3. Get average for a subject");
        System.out.println("4. Get average for a student");
        System.out.println("5. Get total mark of a student");
        System.out.println("6. Exit");
        System.out.println("7. Display grades for a student");
        System.out.print("Enter your choice: ");
    }

    static void addMarks() {
        System.out.print("Enter student ID (1 to " + n + "): ");
        int id = scanner.nextInt();
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        System.out.print("Enter marks for Mathematics: ");
        marks[id][1] = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        marks[id][2] = scanner.nextInt();
        System.out.print("Enter marks for Physics: ");
        marks[id][3] = scanner.nextInt();
        System.out.println("Marks added for student " + id);
    }

    static void updateMark() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }
        System.out.print("Enter subject ID (1=Math, 2=Chemistry, 3=Physics): ");
        int subject = scanner.nextInt();
        if (subject < 1 || subject > 3) {
            System.out.println("Invalid subject ID.");
            return;
        }
        System.out.print("Enter new mark: ");
        marks[id][subject] = scanner.nextInt();
        System.out.println("Mark updated successfully.");
    }

    static void averageSubject() {
        System.out.print("Enter subject ID (1=Math, 2=Chemistry, 3=Physics): ");
        int subject = scanner.nextInt();
        if (subject < 1 || subject > 3) {
            System.out.println("Invalid subject ID.");
            return;
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += marks[i][subject];
        }
        double avg = total / (double) n;
        System.out.println("Average marks for subject " + subjectName(subject) + ": " + avg);
    }

    static void averageStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }

        int total = marks[id][1] + marks[id][2] + marks[id][3];
        double avg = total / 3.0;
        System.out.println("Average marks for student " + id + ": " + avg);
    }

    static void totalStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }

        int total = marks[id][1] + marks[id][2] + marks[id][3];
        System.out.println("Total marks for student " + id + ": " + total);
    }

    static void displayGradesForStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID.");
            return;
        }

        System.out.println("Grades for student " + id + ":");
        for (int i = 1; i <= 3; i++) {
            int mark = marks[id][i];
            String grade = getGrade(mark);
            System.out.println(subjectName(i) + ": " + mark + " - Grade " + grade);
        }
    }

    static String subjectName(int id) {
        return switch (id) {
            case 1 -> "Mathematics";
            case 2 -> "Chemistry";
            case 3 -> "Physics";
            default -> "Unknown";
        };
    }

    static String getGrade(int score) {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
}
