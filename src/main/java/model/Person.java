package model;

public class Person {
    private String name;
    private String gender;
    private int age;
    private String contact;
    private String address;

    private enum Gender {
        MALE("Male"), FEMALE("Female");

        private String gender;
        Gender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return gender;
        }

    };

    public Person(String name, String gender, int age, String contact, String address) {
        this.name = name;
        gender = gender.toLowerCase();
        if ("male".equals(gender) || "m".equals(gender)) {
            this.gender = Gender.MALE.toString();
        } else if ("female".equals(gender) || "f".equals(gender)){
            this.gender = Gender.FEMALE.toString();
        }
        this.age = age;
        this.contact = contact;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        gender = gender.toLowerCase();
        if ("male".equals(gender) || "m".equals(gender)) {
            this.gender = Gender.MALE.toString();
        } else if("female".equals(gender) || "f".equals(gender)) {
            this.gender = Gender.FEMALE.toString();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String info() {
        return "Name: " + getName() + "\n"
                + "Gender: " + getGender() + "\n"
                + "Age: " + getAge() + "\n"
                + "Contact: " + getContact() + "\n"
                + "Address: " + getAddress();
    }
}
