import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Student[] people = {
                new Student(30, "Иван", "123", "второй", "компьютеры", 2000),
                new Student(30, "Антон", "456", "третий", "компьютеры", 2007),
                new Student(30, "Серёга", "789", "первый", "языки", 2008),
        };

        for (Student student : people) {
            System.out.printf("Ф.И.О.: %s | Возраст: %s\n", student.name, student.getAge());
        }

        System.out.print("Введите факультет: ");
        String faculty = scan.next();
        boolean facultyFound = false;
        for (Student student : people) {
            if (faculty.equals(student.faculty)) {
                System.out.printf("Ф.И.О.: %s | Возраст: %s\n", student.name, student.getAge());
                facultyFound = true;
            }
        }
        if (!facultyFound) {
            System.out.println("Студентов на факультете '" + faculty + "' не найдено.");
        }

        System.out.print("Введите год: ");
        int enterYear = scan.nextInt();
        boolean yearFound = false;
        for (Student student : people) {
            if (student.getEnterYear() > enterYear) {
                System.out.printf("Ф.И.О.: %s | Возраст: %s\n", student.name, student.getAge());
                yearFound = true;
            }
        }
        if (!yearFound) {
            System.out.println("Нет студентов, поступивших после " + enterYear + " года.");
        }
    }
}

class Person {
    private int age;
    public String name;
    public String phone;

    public Person(int age, String name, String phone) {
        this.age = age;
        this.name = name;
        this.phone = phone;
    }

    int getAge() {
        return age;
    }
}

class Student extends Person {
    public String course;
    public String faculty;
    private int enterYear;

    public Student(int age, String name, String phone, String course, String faculty, int enterYear) {
        super(age, name, phone);
        this.course = course;
        this.faculty = faculty;
        this.enterYear = enterYear;
    }

    int getEnterYear() {
        return enterYear;
    }
}