public class InterfaceInheritance {
    abstract static class Shape {
        abstract double area();
    }

    static class Triangle extends Shape {
        double base, height;
        Triangle(double b, double h) { base = b; height = h; }

        @Override
        double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(6, 4);
        System.out.println("Area: " + t.area());
    }
}