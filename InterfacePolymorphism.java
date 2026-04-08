public class InterfacePolymorphism {
    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        public void play() {
            System.out.println("Strumming the Guitar!");
        }
    }

    static class piano implements Playable {
        public void play() {
            System.out.println("Playing the Piano!");
        }
    }

    static class violin implements Playable {
        public void play() {
            System.out.println("Playing the Violin!");
        }
    }

    public static void main(String[] args) {
        Guitar g = new Guitar();
        g.play();

        piano p = new piano();
        p.play();

        violin v = new violin();
        v.play();
    }
}

