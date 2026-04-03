public class ImplementationInheritance {
    static class Animal {
        void breathe() {
            System.out.println("Inhale... Exhale...");
        }
    }

    static class Dog extends Animal {
        // breathe() inherited as-is, no need to rewrite
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.breathe();
    }
}