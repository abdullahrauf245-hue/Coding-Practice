public class typeshit {
    public static void main(String[] args) {

        String input = args.length > 0 ? args[0] : "123";
        try {
            int myint = Integer.parseInt(input);
            System.out.println("Parsed: " + myint);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
