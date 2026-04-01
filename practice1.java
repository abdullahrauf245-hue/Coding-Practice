public class practice1 {

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void speak() {
            System.out.println(name + " makes a sound");
        }
    }

    static class Dog extends Animal {
        Dog(String name) {
            super(name);
        }

        @Override
        void speak() {
            System.out.println(name + " barks!");
        }
    }

    static class Cat extends Animal {
        Cat(String name) {
            super(name);
        }

        @Override
        void speak() {
            System.out.println(name + " meows!");
        }
    }

    // main directly in practice1, not inside another class
    public static void main(String[] args) {
        Animal a = new Animal("Generic Animal");
        Dog d = new Dog("Buddy");
        Cat c = new Cat("Whiskers");

        a.speak();
        d.speak();
        c.speak();
    }
}