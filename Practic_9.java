import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Student[] array = {
				new Student("Steve", "2007", "NewYork", "+19999999999", "4", "Computer_Science"),
				new Student("John", "2014", "Moskow", "+29999999999", "4", "Computer_Science"),
				new Student("Bob", "2017", "Seatle", "+39999999999", "2", "Russian_Language"),
		};

		System.out.println("Names of all students:");
		for (Student student : array) {
			System.out.printf("%s\n", student.getName());
		}

		System.out.print("Enter faculty: ");
		String faculty = scan.next();
		studentByFaculty(array, faculty);

		System.out.print("Enter year: ");
		String year = scan.next();
		studentAfterYear(array, year);
	}

	static void studentByFaculty (Student[] students, String faculty) {
		System.out.printf("\nStudents from faculty of %s:", faculty);
		for (Student student : students) {
			if (faculty == student.getFaculty()) {
				System.out.printf("| %s | %s | %s |\n", student.getName(), student.getFaculty(), student.getAdress());
			}
		}
	}

	static void studentAfterYear (Student[] students, String year) {
		System.out.printf("\nStudents who enter after %s year:", year);
		for (Student student : students) {
			if (year > student.getEnterDate()) {
				System.out.printf("| %s | %s | %s |\n", student.getName(), student.getFaculty(), student.getAdress());
			}
		}
	}
}
class Student {
	private String name;
	private String enterDate;
	private String adress;
	private String phone;
	private String course;
	private String faculty;

	Student(String name, String enterDate, String adress, String phone, String course, String faculty) {
		this.name = name;
		this.enterDate = enterDate;
		this.adress = adress;
		this.phone = phone;
		this.course = course;
		this.faculty = faculty;
	}

	void setName(String name) {
		this.name = name;
	}
	void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setCourse(String course) {
		this.course = course;
	}

	String getName() {
		return this.name;
	}
	String getAdress() {
		return this.adress;
	}
	String getFaculty() {
		return this.faculty;
	}
	String getEnterDate() {
		return this.enterDate;
	}
}
