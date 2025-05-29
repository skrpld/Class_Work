public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.S, 25.99, "Красный"),
                new Pants(Size.M, 49.99, "Черный"),
                new Skirt(Size.XS, 39.99, "Синий"),
                new Tie(Size.L, 19.99, "Зеленый")};

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        atelier.dressMen(clothes);
    }
}

//================================================================================================================================
enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    }, XS(34), S(36), M(38), L(40);

    private int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }

    public int getEuroSize() {
        return euroSize;
    }
}

//================================================================================================================================
interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWoman();
}

//================================================================================================================================
abstract class Clothes {
    private Size size;
    private double cost;
    private String color;

    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Размер: %s (EUR %d), Цвет: %s, Стоимость: %.2f", size, size.getEuroSize(), color, cost);
    }
}

//================================================================================================================================
class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("- Футболка: " + this);
    }

    @Override
    public void dressWoman() {
        System.out.println("- Футболка: " + this);
    }
}

class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("- Штаны: " + this);
    }

    @Override
    public void dressWoman() {
        System.out.println("- Штаны: " + this);
    }
}

class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("- Юбка: " + this);
    }
}

class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("- Галстук: " + this);
    }
}

//================================================================================================================================
class Atelier {
    public void dressWomen(Clothes[] clothes) {
        System.out.println("\nЖенская одежда в ателье:");
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                ((WomenClothing) item).dressWoman();
            }
        }
    }

    public void dressMen(Clothes[] clothes) {
        System.out.println("\nМужская одежда в ателье:");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                ((MenClothing) item).dressMan();
            }
        }
    }
}
