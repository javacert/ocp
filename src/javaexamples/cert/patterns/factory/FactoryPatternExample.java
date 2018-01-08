package javaexamples.cert.patterns.factory;

// Notes
// The factory pattern is a creational pattern based on the idea of using a factory class to produce instances of objects
// based on input criteria. It is focused on supporting class polymorphism.
public class FactoryPatternExample {

    public static void main(String[] args) {
        Food food = FoodFactory.getFood("human");
        food.consumed(); // Sausage Food eaten!
    }
}

class FoodFactory{

    public static Food getFood(String consumerName){
        switch(consumerName){
            case "human": return new Sausages();
            case "fish": return new Pellets();
            case "horse": return new Hay();
        }
        throw new UnsupportedOperationException("Consumer not found!");
    }

}

abstract class Food {

    public abstract void consumed();
}

class Pellets extends Food {

    @Override
    public void consumed() {
        System.out.println("Pellet Food eaten!");
    }
}

class Hay extends Food {

    @Override
    public void consumed() {
        System.out.println("Hay Food eaten!");
    }
}

class Sausages extends Food {

    @Override
    public void consumed() {
        System.out.println("Sausage Food eaten!");
    }
}