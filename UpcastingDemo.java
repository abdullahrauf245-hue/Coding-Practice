public class UpcastingDemo {
    static class Animal {
        void breathe() {
            System.out.println("Inhale... Exhale...");
        }
    }

    static class Dog extends Animal {
        void fetch() {
            System.out.println("Fetching!");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        Animal a = d;  // upcasting 

        a.breathe();   
        System.out.println(a instanceof Dog);  // true — still a Dog under the hood
    }
}