import java.io.*;
import java.util.Scanner;

class Calculate implements Serializable {
    public double x;
    public double y;

    Calculate(double x) {
        this.x = x;
        this.y = this.calculate();
    }

    public double calculate() {
        return this.x - Math.sin(this.x);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculate result = null;

        while (true) {
            try {System.out.println("\nInput command save/upload or variable x:"); String str = in.next();
                if (str.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                else if (str.equalsIgnoreCase("save")) {
                    if (result == null) {
                        System.out.println("Data for save is null");
                    }
                    else {
                        save(result);
                    }
                }
                else if (str.equalsIgnoreCase("upload")) {
                    Calculate uploaded = upload();
                    if (uploaded == null) {
                        System.out.println("No records");
                    }
                    else {
                        System.out.println(uploaded.x);
                        System.out.println(uploaded.y);
                    }
                }
                else {
                    result = new Calculate(Double.parseDouble(str));
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Incorrect input");
            }
        }
    }

    private static void save(Calculate res) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("log.txt"))) {
            oos.writeObject(res);
            System.out.println("Data saved");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Calculate upload() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("log.txt"))) {
            return (Calculate) ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
        catch (EOFException e) {
            System.out.println("File is null");
            return null;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}