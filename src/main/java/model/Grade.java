package model;

public enum Grade {
    CLASS_1("Js1"),
    CLASS_2("Js2"),
    CLASS_3("Js3"),
    CLASS_4("Ss1"),
    CLASS_5("Ss2"),
    CLASS_6("Ss3");

    String grade;
    Grade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return grade;
    }
}
