public class Main {
    public static void main(String[] args) {
        Reader[] readers = {
                new Reader("Лешенко Л. Л.", "001", "Програмистский", "06.03.2007", "+79999999999"),
                new Reader("Крюков К. К.", "002", "Програмистский", "20.06.2007", "+78888888888"),
                new Reader("Иванов И. И.", "003", "Физический", "99.99.1999", "+77777777777"),
                new Reader("Чайников Ч. Ч.", "004", "Математический", "77.77.777", "+76666666666"),
                new Reader("Ярик Ла. Па.", "005", "Майнкрафт", "10.09.1992", "+75555555555")
        };

        readers[3].takeBook(3);
        readers[2].takeBook("Приключения", "Словарь", "Энциклопедия");
        readers[1].returnBook(2147483647);
        readers[0].returnBook("Разработка программных модулей", "Java за 10 часов");
    }
}
class Reader {
    private String name;
    private String CardNumber;
    private String faculty;
    private String birthDate;
    private String phone;

    public Reader(String name, String CardNumber, String faculty, String birthDate, String phone) {
        this.name = name;
        this.CardNumber = CardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public void takeBook(int count) {
        System.out.printf("%s взял книги в количестве %d шт.\n", name, count);
    }

    public void takeBook(String... Titles) {
        System.out.printf("%s взял книги: %s\n", name, String.join(", ", Titles));
    }

    public void returnBook(int count) {
        System.out.printf("%s вернул книги в количестве %d шт.\n", name, count);
    }

    public void returnBook(String... Titles) {
        System.out.printf("%s вернул книги: %s\n", name, String.join(", ", Titles));
    }
}