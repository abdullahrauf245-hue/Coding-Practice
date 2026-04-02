public class Student {
    int age;
    double gpa;
    boolean passed;
    String name;

    Student() {
        // no assignments
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.age);     // 0
        System.out.println(s.gpa);     // 0.0
        System.out.println(s.passed);  // false
        System.out.println(s.name);    // null
    }
}
