public class InterfacePolymorphism {
    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        public void play() {
            System.out.println("Strumming the Guitar!");
        }
    }

    public static void main(String[] args) {
        Guitar g = new Guitar();
        g.play();
    }
}