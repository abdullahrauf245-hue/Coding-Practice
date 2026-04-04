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

    static class Square extends Shape {
        double side;
        Square(double s) { side = s; }

        @Override
        double area() { return side * side; }
    }

                static class Rectangle extends Shape{
                    double length;
                    double breadth;
                    Rectangle(double l, double b) { length = l; breadth = b; }

                    @Override
                    double area() { return length * breadth; }
    }
    static class octagon extends Shape{
        double side;
        octagon(double s) { side = s; }

        @Override
        double area() { return 2 * (1 + Math.sqrt(2)) * side * side; }
    }
    public static void main(String[] args) {
        Triangle t = new Triangle(6, 4);
        System.out.println("Area: " + t.area());
        Circle c = new Circle(5);
        Square s = new Square(3);
        Rectangle r = new Rectangle(4, 5);
        octagon o = new octagon(3);
        System.out.println("Area: " + c.area());
        System.out.println("Area: " + s.area());
        System.out.println("Area: " + r.area());
        System.out.println("Area: " + o.area());
    }
}