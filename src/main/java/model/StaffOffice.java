package model;

import java.util.*;

/* StaffOffice class is composed of Principal, Teachers and non-academic Staff
 * It has method "addTeacher" to add new teacher to the list of teachers in school
 * It has method "addNonAcademicStaff" to add new non-academic staff to list of non-academic staffs in school
 */
public class StaffOffice {
    Principal principal;
    List<Teacher> teachers;
    List<NonAcademicStaff> nonAcademicStaffs;

    public StaffOffice() {
        this.principal = null;
        this.teachers = new ArrayList<>();
        this.nonAcademicStaffs = new ArrayList<>();
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public List<NonAcademicStaff> getNonAcademicStaffs() {
        return nonAcademicStaffs;
    }

    public void setNonAcademicStaffs(List<NonAcademicStaff> nonAcademicStaffs) {
        this.nonAcademicStaffs = nonAcademicStaffs;
    }

    public void addNonAcademicStaff(NonAcademicStaff nonAcademicStaff) {
        this.nonAcademicStaffs.add(nonAcademicStaff);
    }
}
