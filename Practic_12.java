interface User {
    void setLogin(String login);
    void setPassword(String password);
    String getLogin ();
    String getPassword ();
}

abstract class People implements User{
    String name;
    int age;
    String position;
    private String login;
    private String password;

    public People(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }
}

class Teacher extends People {
    Teacher(String name, int age, String position) {
        super(name, age, position);
    }
}

class Student extends People {
    Student(String name, int age, String position) {
        super(name, age, position);
    }
}

public class Main {
    public static void main(String args[]) {
        Teacher teacher1 = new Teacher("Червенцов К. И.", 96, "Директор");
        teacher1.setLogin("chervencov");
        teacher1.setPassword("1234");

        Teacher teacher2 = new Teacher("Лакрицина Н. Б.", 69, "Профессор");
        teacher2.setLogin("lakricina");
        teacher2.setPassword("qwerty");

        Student student1 = new Student("Чайников К. В.", 20, "Студент");
        student1.setLogin("chaynikov");
        student1.setPassword("cup_ofTea_2005");

        Student student2 = new Student("Пипкин. Е. А.", 21, "Студент");
        student2.setLogin("pipkin");
        student2.setPassword("Pipkin_52_St.Petersburg");
    }
}