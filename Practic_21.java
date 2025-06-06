public class Main {
    public static void main(String[] args) {
        Logistics roadDelivery = new RoadLogistics();
        Logistics seaDelivery = new SeaLogistics();
        Logistics airDelivery = new AirLogistics();

        roadDelivery.planDelivery();
        seaDelivery.planDelivery();
        airDelivery.planDelivery();
    }
}
//===================================================================================================
interface Transport {
    void deliver();
}

abstract class Logistics {
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
//===================================================================================================
class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

class AirLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Airplane();
    }
}
//===================================================================================================
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivered by road by truck");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivered by sea by ship");
    }
}

class Airplane implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivered by air by airplane");
    }
}
