import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int choise = 0;
        int num = 0;

        Bus[] buses = {
                new Bus("Иванов И.И.", "А123ВС", 10, "Mercedes", 2015, 150000),
                new Bus("Петров П.П.", "Х001Х", 5, "Volvo", 2018, 80000),
                new Bus("Сидоров С.С.", "З333ЗЗ", 10, "MAN", 2017, 120000),
                new Bus("Камбербульбизбек Н. С.", "А777АА", 15, "Gazel", 2020, 50000)
        };

        System.out.print("1. Out buses by route number\n2. Out busses by minimal mileage\nEnter number of the operation: ");
        choise = scan.nextInt();

        switch (choise) {
            case 1:
                System.out.print("Enter route number: ");
                num = scan.nextInt();
                byRoute(buses, num);
                break;
            case 2:
                System.out.print("Enter route number: ");
                num = scan.nextInt();
                byMileage(buses, num);
                break;
            default:
                break;
        }

    }

    static void byRoute(Bus[] buses, int route) {
        System.out.println("\nBusses of route №" + route + ":");
        for (Bus bus : buses) {
            if (bus.getRouteNumber() == route) {
                System.out.println(bus);
            }
        }
    }

    static void byMileage(Bus[] buses, int mileage) {
        System.out.println("\nBuses with mileage bigger than " + mileage + " km:");
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                System.out.println(bus);
            }
        }
    }
}

class Bus {
    private String driverName;
    private String busNumber;
    private int routeNumber;
    private String brand;
    private int startYear;
    private int mileage;

    public Bus(String driverName, String busNumber, int routeNumber,
               String brand, int startYear, int mileage) {
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.startYear = startYear;
        this.mileage = mileage;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public String toString() {
        return "Driver: " + driverName +
                " | Bus number: " + busNumber +
                " | Route number: " + routeNumber +
                " | Brand: " + brand +
                " | Start year: " + startYear +
                " | Mileage: " + mileage + " km";
    }
}