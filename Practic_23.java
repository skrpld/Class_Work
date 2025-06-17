import java.util.*;

public class Main {
    public static void main(String[] args) {
        Group group1 = new Group("Java Программисты");
        Group group2 = new Group("Дизайн");
        Group group3 = new Group("Data Science");
        Group group4 = new Group("DevOps");

        User user1 = new User("Иван");
        User user2 = new User("Мария");

        group1.registerObserver(user1);
        group2.registerObserver(user1);
        group3.registerObserver(user1);

        group1.registerObserver(user2);
        group2.registerObserver(user2);
        group3.registerObserver(user2);
        group4.registerObserver(user2);

        group1.sendMessage("Новый урок по Java!");
        group2.sendMessage("Вебинар по UI/UX в среду");
        group3.sendMessage("Соревнование Kaggle началось");
        group4.sendMessage("Обновление серверов в пятницу");

        user1.printNotifications();
        user2.printNotifications();
    }
}
//===================================================================================================
interface Observer {
    void update(String groupName, String message);
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
//===================================================================================================
class Group implements Subject {
    private final String name;
    private final List<Observer> observers = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(name, message);
        }
    }

    public void sendMessage(String message) {
        System.out.println("Группа '" + name + "' отправила: " + message);
        notifyObservers(message);
    }
}
//===================================================================================================
class User implements Observer {
    private final String username;
    private final Map<String, List<String>> notifications = new HashMap<>();

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String groupName, String message) {
        notifications.computeIfAbsent(groupName, k -> new ArrayList<>()).add(message);
    }

    public void printNotifications() {
        System.out.println("\nОповещения для " + username + ":");
        notifications.forEach((group, messages) ->
                messages.forEach(msg ->
                        System.out.println("[" + group + "]: " + msg)
                )
        );
    }
}
