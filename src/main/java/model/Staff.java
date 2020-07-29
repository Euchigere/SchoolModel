package model;

public class Staff extends Person {
    String jobTitle;

    public Staff(String name, String gender, int age, String contact, String address, String jobTitle) {
        super(name, gender, age, contact, address);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String info() {
        return super.info() + "\n"
                + "Job title: " + getJobTitle();
    }
}
