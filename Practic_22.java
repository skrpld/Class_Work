public class Main {
    public static void main(String[] args) {
        Charger220V charger = new Charger220V();
        Source380V source = new Source380V();
        I380V adapter = new Adapter(charger);

        charger.Voltage220();
        source.Voltage380();

        System.out.println("\nUsing adapter:");
        adapter.Voltage380();
    }
}
//===================================================================================================
interface I220V {
    void Voltage220();
}
interface I380V {
    void Voltage380();
}

class Charger220V implements I220V {
    public void Voltage220() {
        System.out.println("Charging: 220V");
    }
}
class Source380V implements I380V {
    @Override
    public void Voltage380() {
        System.out.println("Source: 380V");
    }
}
//===================================================================================================
class Adapter implements I380V {
    private final Charger220V charger220V;

    public Adapter(Charger220V charger220V) {
        this.charger220V = charger220V;
    }

    @Override
    public void Voltage380() {
        System.out.println("Converting: 380V to 220V");
        charger220V.Voltage220();
    }
}