import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateArea() {
        return calculateArea(radius);
    }
}

class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    public double calculateArea(double side) {
        return side * side;
    }

    @Override
    public double calculateArea() {
        return calculateArea(side);
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea(double base, double height) {
        return 0.5 * base * height;
    }

    @Override
    public double calculateArea() {
        return calculateArea(base, height);
    }
}

enum Gender {
    MALE,
    FEMALE
}

class Patient {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate admissionDate;
    private String report;
    private Doctor treatingDoctor;
    private int daysStay;

    Patient(String name, LocalDate birthDate, Gender gender, LocalDate admissionDate, String report, int daysStay) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.admissionDate = admissionDate;
        this.report = report;
        this.daysStay = daysStay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Doctor getTreatingDoctor() {
        return treatingDoctor;
    }

    public void setTreatingDoctor(Doctor treatingDoctor) {
        this.treatingDoctor = treatingDoctor;
    }

    public int getDaysStay() {
        return daysStay;
    }

    public void setDaysStay(int daysStay) {
        this.daysStay = daysStay;
    }

    @Override
    public String toString() {
        String doctorName = treatingDoctor == null ? "none" : treatingDoctor.getName();
        return "Patient{name='" + name + "', gender=" + gender + ", doctor=" + doctorName + ", stay=" + daysStay + " days}";
    }
}

abstract class TeamMember {
    private String name;
    private String id;
    private Gender gender;
    private LocalDate dateJoined;
    private final int maxWorkingHours = 12;

    TeamMember(String name, String id, Gender gender, LocalDate dateJoined) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.dateJoined = dateJoined;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }
}

class Nurse extends TeamMember {
    Nurse(String name, String id, Gender gender, LocalDate dateJoined) {
        super(name, id, gender, dateJoined);
    }

    @Override
    public String toString() {
        return "Nurse{name='" + getName() + "', id='" + getId() + "'}";
    }
}

abstract class Doctor extends TeamMember {
    private String specialty;
    private final List<Patient> patients = new ArrayList<>();

    Doctor(String name, String id, Gender gender, LocalDate dateJoined, String specialty) {
        super(name, id, gender, dateJoined);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.setTreatingDoctor(this);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        if (patient.getTreatingDoctor() == this) {
            patient.setTreatingDoctor(null);
        }
    }

    public String checkPatientReport(Patient patient) {
        return "Doctor " + getName() + " checked report for " + patient.getName() + ": " + patient.getReport();
    }

    public abstract void treatPatient(Patient patient);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + getName() + "', specialty='" + specialty + "'}";
    }
}

class SeniorDoctor extends Doctor {
    SeniorDoctor(String name, String id, Gender gender, LocalDate dateJoined, String specialty) {
        super(name, id, gender, dateJoined, specialty);
    }

    @Override
    public void treatPatient(Patient patient) {
        patient.setReport("Senior doctor treatment plan created for " + patient.getName());
        addPatient(patient);
        System.out.println(getName() + " reviews diagnosis and prepares the treatment plan for " + patient.getName());
    }
}

class Surgeon extends Doctor {
    Surgeon(String name, String id, Gender gender, LocalDate dateJoined, String specialty) {
        super(name, id, gender, dateJoined, specialty);
    }

    @Override
    public void treatPatient(Patient patient) {
        patient.setReport("Surgery completed by " + getName() + " for " + patient.getName());
        addPatient(patient);
        System.out.println(getName() + " performs surgery for " + patient.getName());
    }
}

class Intern extends Doctor {
    private SeniorDoctor supervisor;

    Intern(String name, String id, Gender gender, LocalDate dateJoined, String specialty, SeniorDoctor supervisor) {
        super(name, id, gender, dateJoined, specialty);
        this.supervisor = supervisor;
    }

    public SeniorDoctor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SeniorDoctor supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void treatPatient(Patient patient) {
        patient.setReport("Intern examined " + patient.getName() + " and referred the case to " + supervisor.getName());
        addPatient(patient);
        System.out.println(getName() + " examines " + patient.getName() + " and reports to supervisor " + supervisor.getName());
    }
}

class Department {
    private String name;
    private final List<TeamMember> staff = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeamMember> getStaff() {
        return staff;
    }

    public void addStaff(TeamMember member) {
        if (!staff.contains(member)) {
            staff.add(member);
        }
    }

    public void removeStaff(TeamMember member) {
        staff.remove(member);
    }

    @Override
    public String toString() {
        return "Department{name='" + name + "', staffCount=" + staff.size() + "}";
    }
}

class Hospital {
    private String name;
    private String address;
    private final List<Patient> patients = new ArrayList<>();
    private final List<Department> departments = new ArrayList<>();

    Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public void addMemberToDepartment(String departmentName, TeamMember member) {
        Department department = findDepartment(departmentName);
        if (department != null) {
            department.addStaff(member);
        }
    }

    public void removeMemberFromDepartment(String departmentName, TeamMember member) {
        Department department = findDepartment(departmentName);
        if (department != null) {
            department.removeStaff(member);
        }
    }

    private Department findDepartment(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(departmentName)) {
                return department;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Hospital{name='" + name + "', address='" + address + "', patients=" + patients.size() + ", departments=" + departments.size() + "}";
    }
}

public class LabPolymorphism {
    public static void main(String[] args) {
        System.out.println("Task 1: Shape hierarchy");
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Triangle(6, 3)
        };

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " area = " + shape.calculateArea());
        }

        System.out.println();
        System.out.println("Task 2: Hospital model");

        Hospital hospital = new Hospital("City Care Hospital", "Main Road, Downtown");
        Department cardiology = new Department("Cardiology");
        Department pediatrics = new Department("Pediatrics");
        hospital.addDepartment(cardiology);
        hospital.addDepartment(pediatrics);

        SeniorDoctor seniorDoctor = new SeniorDoctor("Dr. Sara", "D100", Gender.FEMALE, LocalDate.of(2018, 2, 10), "Cardiology");
        Surgeon surgeon = new Surgeon("Dr. Omar", "D101", Gender.MALE, LocalDate.of(2017, 6, 18), "Surgery");
        Intern intern = new Intern("Dr. Ali", "D102", Gender.MALE, LocalDate.of(2024, 1, 5), "Cardiology", seniorDoctor);
        Nurse nurse = new Nurse("Nadia", "N200", Gender.FEMALE, LocalDate.of(2023, 4, 1));

        hospital.addMemberToDepartment("Cardiology", seniorDoctor);
        hospital.addMemberToDepartment("Cardiology", intern);
        hospital.addMemberToDepartment("Pediatrics", surgeon);
        hospital.addMemberToDepartment("Pediatrics", nurse);

        Patient patient1 = new Patient("Hassan", LocalDate.of(2001, 8, 12), Gender.MALE, LocalDate.of(2026, 4, 1), "Chest pain", 4);
        Patient patient2 = new Patient("Mona", LocalDate.of(2010, 11, 23), Gender.FEMALE, LocalDate.of(2026, 4, 2), "Appendicitis", 6);

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        seniorDoctor.treatPatient(patient1);
        intern.treatPatient(patient1);
        surgeon.treatPatient(patient2);

        System.out.println(seniorDoctor.checkPatientReport(patient1));
        System.out.println(surgeon.checkPatientReport(patient2));

        System.out.println("Before removal: " + hospital);
        hospital.removePatient(patient2);
        hospital.removeMemberFromDepartment("Cardiology", intern);

        System.out.println("After removal:  " + hospital);
        System.out.println("Department details: " + cardiology);
        System.out.println("Department details: " + pediatrics);

        System.out.println("Encapsulation check: " + patient1.getName() + ", admitted " + patient1.getAdmissionDate());
        patient1.setDaysStay(5);
        System.out.println("Updated stay: " + patient1.getDaysStay() + " days");

        System.out.println("Doctor supervisor: " + intern.getSupervisor().getName());
    }
}