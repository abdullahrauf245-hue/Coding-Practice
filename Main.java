class Animal {
    String name;
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called: " + name);
    }
}

class Dog extends Animal {
    String breed;
    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
        System.out.println("Dog constructor called: " + breed);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "Golden Retriever");
        System.out.println("Dog: " + d.name + " is a " + d.breed);
    }
}