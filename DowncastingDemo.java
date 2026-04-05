public class DowncastingDemo {
    static class Vehicle {
        void start() {
            System.out.println("Vehicle starting...");
        }
    }

    static class Car extends Vehicle {
        void playMusic() {
            System.out.println("Playing music in Car!");
        }
    }

    public static void main(String[] args) {
        Vehicle v = new Car();

        v.start();

        if (v instanceof Car) {
            Car c = (Car) v;
            c.playMusic();
        }
    }
}