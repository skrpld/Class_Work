import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Student[] people = {
                new Student( 30, "Иван", "123", "второй", "компьютеры", 2000),
                new Student( 30, "Антон", "456", "третий", "коипьютеры", 2007),
                new Student( 30, "Серёга", "789", "первый", "языки", 20008),
        };

        for (Student student : people) {
            System.out.printf("Ф.И.О.: %s | Возраст: %s\n", student.name, student.getAge());
        }

        String faculty = scan.next();
        for (Student student : people) {
            if (faculty == student.faculty) {
                System.out.printf("Ф.И.О.: %s | Возраст: %s\n", student.name, student.getAge());
            }
        }

        int enterYear = scan.nextInt();
        for (Student student : people) {
            if (enterYear > student.getEnterYear()) {
                System.out.printf("Ф.И.О.: %s | Возраст: %s\n", student.name, student.getAge());
            }
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
