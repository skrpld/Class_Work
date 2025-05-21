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

            Pattern pattern1 = Pattern.compile("\\w");
            Pattern pattern2 = Pattern.compile("(?<!\")//.*$");
            Pattern pattern3 = Pattern.compile("(?<!\")/\\*.*$|(?<!\")\\*/\\s*");

            Matcher matcher1;
            Matcher matcher2;
            Matcher matcher3;

            while ((line = bReader.readLine()) != null) {
                if (!inComment) {
                    if ((matcher2 = pattern2.matcher(line)).find()) {
                        matcher1 = pattern1.matcher(line = line.substring(0, matcher2.start()));
                        if (matcher1.find()) {
                            writer.write(line + "\n");
                        }
                    }
                    else if ((matcher3 = pattern3.matcher(line)).find()) {
                        matcher1 = pattern1.matcher(line = line.substring(0, matcher3.start()));
                        if (matcher1.find()) {
                            writer.write(line + "\n");
                        }
                        inComment = true;
                    }
                    else {
                        writer.write(line + "\n");
                    }
                }
                else if ((matcher3 = pattern3.matcher(line)).find()) {
                    matcher1 = pattern1.matcher(line = line.substring(matcher3.end()));
                    if (matcher1.find()) {
                        writer.write(line + "\n");
                    }
                    inComment = false;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}