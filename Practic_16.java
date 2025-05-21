import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File source = new File("Example.java");
        File result = new File("Result.java");


        try (FileWriter writer = new FileWriter(result); BufferedReader bReader = new BufferedReader(new FileReader(source))) {
            String line;
            boolean inComment = false;

            Pattern pattern = Pattern.compile("\\w");

            while ((line = bReader.readLine()) != null) {
                if (line.contains("//") && !inComment) {
                    Matcher matcher = pattern.matcher(line = line.substring(0, line.indexOf("//")));
                    if (matcher.find()) {
                        writer.write(line + "\n");
                    }
                }
                else if (line.contains("/*")) {
                    Matcher matcher = pattern.matcher(line = line.substring(0, line.indexOf("//")));
                    if (matcher.find()) {
                        writer.write(line + "\n");
                    }
                    inComment = true;
                }
                else if (line.contains("*/")) {
                    Matcher matcher = pattern.matcher(line = line.substring(0, line.indexOf("//")));
                    if (matcher.find()) {
                        writer.write(line + "\n");
                    }
                    inComment = false;
                }
                else if (!inComment) {
                    writer.write(line + "\n");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}