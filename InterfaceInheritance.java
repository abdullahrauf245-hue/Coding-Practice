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

    static class Circle extends Shape {
        double radius;
        Circle(double r) { radius = r; }

        @Override
        double area() { return Math.PI * radius * radius; }
    }
    public static void main(String[] args) {
        Triangle t = new Triangle(6, 4);
        System.out.println("Area: " + t.area());
        Circle c = new Circle(5);
        System.out.println("Area: " + c.area());
    }
}