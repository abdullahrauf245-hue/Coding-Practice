public class ConstructorDemo {
    static class Parent {
        Parent() {
            show();
        }
        void show() {
            System.out.println("Parent show");
        }
    }

    static class Child extends Parent {
        String message = "Hello";

        Child() {
            super();
        }

        @Override
        void show() {
            System.out.println("Child show: " + message);
        }
    }

    public static void main(String[] args) {
        Child c = new Child();

        System.out.println("Message after constructor: " + c.message);
    }
}
