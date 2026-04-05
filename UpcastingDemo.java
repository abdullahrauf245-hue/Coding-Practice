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
        Animal a = d;  // upcasting — automatic, no cast needed

        a.breathe();   // works — Animal has breathe()
        // a.fetch();  // COMPILE ERROR — Animal ref can't see fetch()

        System.out.println(a instanceof Dog);  // true — still a Dog under the hood
    }
}