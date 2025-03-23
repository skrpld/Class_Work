// Интерфейсы
interface Product {
    void setName(String name);
    void setPrice(double price);
    void setRating(int rating);
    String getName();
    double getPrice();
    int getRating();
}
interface User {
    void setLogin(String login);
    void setPassword(String password);
    String getLogin ();
    String getPassword ();
}

// Товары
class Tee implements Product {
    private String name;
    private double price;
    private int rating;

    @Override public void setName(String name) { this.name = name; }
    @Override public void setPrice(double price) { this.price = price; }
    @Override public void setRating(int rating) { this.rating = rating; }
    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
    @Override public int getRating() { return rating; }
}
class Cap implements Product {
    private String name;
    private double price;
    private int rating;

    @Override public void setName(String name) { this.name = name; }
    @Override public void setPrice(double price) { this.price = price; }
    @Override public void setRating(int rating) { this.rating = rating; }
    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
    @Override public int getRating() { return rating; }
}
class Chain implements Product {
    private String name;
    private double price;
    private int rating;

    @Override public void setName(String name) { this.name = name; }
    @Override public void setPrice(double price) { this.price = price; }
    @Override public void setRating(int rating) { this.rating = rating; }
    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
    @Override public int getRating() { return rating; }
}

// Пользователи
class Admin implements User {
    private String login;
    private String password;

    @Override public void setLogin(String login) { this.login = login; }
    @Override public void setPassword(String password) { this.password = password; }
    @Override public String getLogin() { return login; }
    @Override public String getPassword() { return password; }
}
class Customer implements User {
    private String login;
    private String password;

    @Override public void setLogin(String login) { this.login = login; }
    @Override public void setPassword(String password) { this.password = password; }
    @Override public String getLogin() { return login; }
    @Override public String getPassword() { return password; }
}
class Guest implements User {
    private String login;
    private String password;

    @Override public void setLogin(String login) { this.login = login; }
    @Override public void setPassword(String password) { this.password = password; }
    @Override public String getLogin() { return login; }
    @Override public String getPassword() { return password; }
}

// Общий класс
class UserProduct implements Product, User {
    private String name;
    private double price;
    private int rating;
    private String login;
    private String password;

    // Товар
    @Override public void setName(String name) { this.name = name; }
    @Override public void setPrice(double price) { this.price = price; }
    @Override public void setRating(int rating) { this.rating = rating; }
    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
    @Override public int getRating() { return rating; }

    // Пользователь
    @Override public void setLogin(String login) { this.login = login; }
    @Override public void setPassword(String password) { this.password = password; }
    @Override public String getLogin() { return login; }
    @Override public String getPassword() { return password; }

    // Вывод
    public void printPurchaseInfo() {
        System.out.printf("%s bought %s for %.2f ₽\n", login, name, price);
    }
}

public class Main {
    public static void main(String args[]) {
        // Товары
        Tee tee = new Tee();
        tee.setName("Vetements - Ecstasy");
        tee.setPrice(7999.90);
        tee.setRating(67);

        Cap cap = new Cap();
        cap.setName("Misprized Possessions - Major Head Trauma");
        cap.setPrice(1499.50);
        cap.setRating(81);

        Chain chain = new Chain();
        chain.setName("Haunted Family chain");
        chain.setPrice(100111.11);
        chain.setRating(63);

        // Пользователи
        User admin = new Admin();
        admin.setLogin("admin");
        admin.setPassword("admin1234");

        User customer = new Customer();
        customer.setLogin("kai_angel_official");
        customer.setPassword("Super_HeavyMetal_Rockstar_Password-13");

        User guest = new Guest();
        guest.setLogin("guest-00028162875487");
        guest.setPassword("");

        // Общий
        UserProduct userProduct = new UserProduct();
        userProduct.setLogin("KirillKiller2007");
        userProduct.setName("Number (N)ine original tee");
        userProduct.setPrice(6990.00);
        userProduct.printPurchaseInfo();
    }
}