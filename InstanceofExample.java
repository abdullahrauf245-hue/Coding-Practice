public class InstanceofExample {
    static class Animal {}
    static class Dog extends Animal {
        void fetch() { System.out.println("Fetching!"); }
    }
    static class Cat extends Animal {
        void purr() { System.out.println("Purring!"); }
    }
static class Bird extends Animal {
        void fly() { System.out.println("Flying!"); }
    }

    static class cow extends Animal{
        void moo(){System.out.println("Mooing!");}
    }
    public static void main(String[] args) {
        Animal a = new cow();

        System.out.println(a instanceof Dog);     // false
        System.out.println(a instanceof Animal);  // true
        System.out.println(a instanceof Cat);     // false
        System.out.println(a instanceof Bird);     // false
        System.out.println(a instanceof cow);     // true
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.fetch();
        }
    }
}