import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Input string: ");
        String text=in.nextLine();

        File file = new File("ip_logs.txt");

        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm:ss"));

        Pattern pattern = Pattern.compile("(\\s+(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)");
        Matcher matcher = pattern.matcher(text);

        try (FileWriter writer = new FileWriter(file, file.exists())){
            if (matcher.find()) {
                writer.write(dateTime + " - Correct IP: " + matcher.group() + "\n");
                System.out.print("Success");
            } else {
                writer.write(dateTime + " - Correct IP wasn't found" + "\n");
                System.out.print("Failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}