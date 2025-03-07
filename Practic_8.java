public class Main {
    public static void main(String[] args) {
        Person person = new Person("Андрэй", "Балконски", (short)2000);
        Car car = new Car("Бананакар", (short)2020, (short)2);
        Book book = new Book("Ышкербелдынбинденбек", "Шаман-Якут", (short) 123);
        person.output(book, car);
    }

    static class Person {
        private String firstname;
        private String secondname;
        private short birthYear;

        Person(String firstname, String secondname, short birthYear) {
            this.firstname = firstname;
            this.secondname = secondname;
            this.birthYear = birthYear;
        }

        void getAll() {
            System.out.printf(this.firstname, this.secondname, this.birthYear);
        }

        void output(Book book, Car car) {
            System.out.printf("%s читает книгу %s про машину %s", this.firstname, book.name, car.brand);
        }
    }

    static class Car {
        private String brand;
        private short releaseYear;
        private short engineVolume;

        Car(String brand, short releaseYear, short engineVolume) {
            this.brand = brand;
            this.releaseYear = releaseYear;
            this.engineVolume = engineVolume;
        }

        void getAll() {
            System.out.printf(this.brand, this.releaseYear, this.engineVolume);
        }
    }

    static class Book {
        private String name;
        private String author;
        private short releaseYear;

        Book(String name, String author, short releaseYearYear) {
            this.name = name;
            this.author = author;
            this.releaseYear = releaseYearYear;
        }

        void getAll() {
            System.out.printf(this.name, this.author, this.releaseYear);
        }
    }
}