package model;

public class Applicant extends Person {
    private String grade;

    public Applicant(String name, String gender, int age, String contact, String address, String grade) {
        super(name, gender, age, contact, address);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String info() {
        return super.info() + "\n"
                + "Grade: " + getGrade();
    }
}
