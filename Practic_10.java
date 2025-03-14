public class Main {
    public static void main(String[] args) {
        Veterinarian vet = new Veterinarian();

        Animal[] animals = {
                new Dog("Кости", "Будка", "Хаски"),
                new Cat("Рыба", "Квартира", "Зелёный"),
                new Horse("Сено", "Поле", 55.5)
        };

        for (Animal animal : animals) {
            vet.treatAnimal(animal);
            animal.makeNoise();
            animal.eat();
            System.out.println();
        }
    }
}

class Animal {
    private String food;
    private String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("Животное издает звук");
    }

    public void eat() {
        System.out.println("Животное ест");
    }

    public void sleep() {
        System.out.println("Животное спит");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String food, String location, String breed) {
        super(food, location);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    public void eat() {
        System.out.println("Собака грызет кость");
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String food, String location, String color) {
        super(food, location);
        this.color = color;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кошка мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка ест рыбу");
    }
}

class Horse extends Animal {
    private double maxSpeed;

    public Horse(String food, String location, double maxSpeed) {
        super(food, location);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь ржет");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь жует сено");
    }
}

class Veterinarian {
    public void treatAnimal(Animal animal) {
        System.out.println("Еда: " + animal.getFood() + ", Место обитания: " + animal.getLocation());
    }
}
