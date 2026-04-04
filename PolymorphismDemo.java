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
    static class TeachingAssistant extends GraduateStudent {
        @Override
        void computeCourseGrade() {
            System.out.println("TA grade computed");
        }
    }

    public static void main(String[] args) {
        Student[] roster = new Student[4];
        roster[0] = new GraduateStudent();
        roster[1] = new UndergraduateStudent();
        roster[2] = new UndergraduateStudent();
        roster[3] = new TeachingAssistant();

        for (Student s : roster) {
            s.computeCourseGrade();
        }
    }
}