import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int korean = scanner.nextInt();
            int english = scanner.nextInt();
            int math = scanner.nextInt();

            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students, (s1, s2) -> {
            if (s1.korean != s2.korean) {
                return s2.korean - s1.korean;
            }
            if (s1.english != s2.english) {
                return s1.english - s2.english;
            }
            if (s1.math != s2.math) {
                return s2.math - s1.math;
            }
            return s1.name.compareTo(s2.name);
        });

        for (Student student : students) {
            System.out.println(student.name);
        }

        scanner.close();
    }
}
