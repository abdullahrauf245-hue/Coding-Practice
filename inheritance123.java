import java.util.Date;
public class inheritance123 {

    class Person{
        String name;
        String Address;
        String PhoneNumber;
        String Email;

        Person(String name, String Address, String PhoneNumber, String Email){
            this.name = name;
            this.Address = Address;
            this.PhoneNumber = PhoneNumber;
            this.Email = Email;
        }

        @Override
        public String toString() {
            return "Person[\n" +
                "  name=" + name + "\n" +
                "  address=" + Address + "\n" +
                "  phone=" + PhoneNumber + "\n" +
                "  email=" + Email + "\n" +
                "]";
        }
    }

    class Student extends Person{
        String ClassStatus;

        Student(String name, String Address, String PhoneNumber, String Email, String ClassStatus){
            super(name, Address, PhoneNumber, Email);
            this.ClassStatus = ClassStatus;
        }

        @Override
        public String toString() {
            return "Student[\n" +
                "  name=" + name + "\n" +
                "  address=" + Address + "\n" +
                "  phone=" + PhoneNumber + "\n" +
                "  email=" + Email + "\n" +
                "  status=" + ClassStatus + "\n" +
                "]";
        }
    }

    class Employee extends Person{
        String Office;
        Double Salary;
        Date DateHired;

        Employee(String name, String Address, String PhoneNumber, String Email, String Office, Double Salary, Date DateHired){
            super(name, Address, PhoneNumber, Email);
            this.Office = Office;
            this.Salary = Salary;
            this.DateHired = DateHired;
        }

        @Override
        public String toString() {
            return "Employee[\n" +
                "  name=" + name + "\n" +
                "  address=" + Address + "\n" +
                "  phone=" + PhoneNumber + "\n" +
                "  email=" + Email + "\n" +
                "  office=" + Office + "\n" +
                "  salary=" + Salary + "\n" +
                "  dateHired=" + DateHired + "\n" +
                "]";
        }
        }
    class Faculty extends Employee{
        String OfficeHours;
        String Rank;

        Faculty(String name, String Address, String PhoneNumber, String Email, String Office, Double Salary, Date DateHired, String OfficeHours, String Rank){
            super(name, Address, PhoneNumber, Email, Office, Salary, DateHired);
            this.OfficeHours = OfficeHours;
            this.Rank = Rank;
        }

        @Override
        public String toString() {
            return "Faculty[\n" +
                "  name=" + name + "\n" +
                "  address=" + Address + "\n" +
                "  phone=" + PhoneNumber + "\n" +
                "  email=" + Email + "\n" +
                "  office=" + Office + "\n" +
                "  salary=" + Salary + "\n" +
                "  dateHired=" + DateHired + "\n" +
                "  officeHours=" + OfficeHours + "\n" +
                "  rank=" + Rank + "\n" +
                "]";
        }
    }
        
    class Staff extends Employee{
        String Title;

        Staff(String name, String Address, String PhoneNumber, String Email, String Office, Double Salary, Date DateHired, String Title){
            super(name, Address, PhoneNumber, Email, Office, Salary, DateHired);
            this.Title = Title;
        }

        @Override
        public String toString() {
            return "Staff[\n" +
                "  name=" + name + "\n" +
                "  address=" + Address + "\n" +
                "  phone=" + PhoneNumber + "\n" +
                "  email=" + Email + "\n" +
                "  office=" + Office + "\n" +
                "  salary=" + Salary + "\n" +
                "  dateHired=" + DateHired + "\n" +
                "  title=" + Title + "\n" +
                "]";
        }
    }

    public static void main(String[] args) {
        inheritance123 obj = new inheritance123();
        Student student1 = obj.new Student("John Doe", "123 Main St", "555-1234", "john.doe@example.com", "Full-time ");  
        System.out.println(student1);

        Staff staff1 = obj.new Staff("Alice Johnson", "789 Oak St", "555-9012", "alice.johnson@example.com", "Building B", 45000.0, new Date(), "Administrative Assistant");
        System.out.println(staff1);

        Employee employee1 = obj.new Employee("Jane Smith", "456 Elm St", "555-5678", "jane.smith@example.com", "Building A", 50000.0, new Date());
        System.out.println(employee1);
    }
}
