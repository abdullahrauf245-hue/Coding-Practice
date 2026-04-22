class StudentDefaultsDemo {
    int age;
    double gpa;
    boolean passed;
    String name;

    StudentDefaultsDemo() {
        // no assignments
    }

    public static void main(String[] args) {
        StudentDefaultsDemo s = new StudentDefaultsDemo();
        System.out.println(s.age);     // 0
        System.out.println(s.gpa);     // 0.0
        System.out.println(s.passed);  // false
        System.out.println(s.name);    // null
    }
}
