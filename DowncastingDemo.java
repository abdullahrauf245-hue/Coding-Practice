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
static class Bike extends Vehicle {
        void ringBell() {
            System.out.println("Ringing bell on Bike!");
        }
    }
    public static void main(String[] args) {
        Vehicle v = new Car();

        v.start();

        if (v instanceof Car) {
            Car c = (Car) v;
            c.playMusic();
        }
        if (v instanceof Bike) {
            Bike b = (Bike) v;
            b.ringBell();
        } else {
            System.out.println("v is not an instance of Bike, cannot ring bell.");
        }
    }
}