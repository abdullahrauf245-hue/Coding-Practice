public class PolymorphismDemo {
    static class Student {
        void computeCourseGrade() {
            System.out.println("Generic grade");
        }
    }

    static class UndergraduateStudent extends Student {
        @Override
        void computeCourseGrade() {
            System.out.println("Undergrad grade computed");
        }
    }

    static class GraduateStudent extends Student {
        @Override
        void computeCourseGrade() {
            System.out.println("Grad grade computed");
        }
    }

    public static void main(String[] args) {
        Student[] roster = new Student[3];
        roster[0] = new GraduateStudent();
        roster[1] = new UndergraduateStudent();
        roster[2] = new UndergraduateStudent();

        for (Student s : roster) {
            s.computeCourseGrade();
        }
    }
}