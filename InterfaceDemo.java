public class InterfaceDemo {
    interface Printable {
        void print();
    }

    interface Saveable {
        void save();
    }

    static class Document implements Printable, Saveable {
        String content;

        Document(String content) {
            this.content = content;
        }

        @Override
        public void print() {
            System.out.println("Printing: " + content);
        }

        @Override
        public void save() {
            System.out.println("Saving: " + content);
        }
    }

    public static void main(String[] args) {
        Document doc = new Document("OOP Notes");
        doc.print();
        doc.save();
    }
}