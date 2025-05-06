import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input string: ");
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Correct IP: " + matcher.group());
        }
    }
}