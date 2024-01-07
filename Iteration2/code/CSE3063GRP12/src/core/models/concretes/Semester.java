package core.models.concretes;

import java.util.Map;

import core.enums.CourseGrade;

public class Semester {
    private String id;
    private Map<String, CourseGrade> listOfCoursesTaken;
    private int creditsTaken;
    private int creditsCompleted;
    private double yano;
    private double gano;
    private int semesterNo;

    public Semester(String id, Map<String, CourseGrade> listOfCoursesTaken,
            int creditsTaken, double yano, int semesterNo) {
        this.id = id;
        this.listOfCoursesTaken = listOfCoursesTaken;
        this.creditsTaken = creditsTaken;
        this.yano = yano;
        this.semesterNo = semesterNo;
    }

    public String getId() {
        return id;
    }

    public Map<String, CourseGrade> getListOfCoursesTaken() {
        return listOfCoursesTaken;
    }

    public int getCreditsTaken() {
        return creditsTaken;
    }

    public int getCreditsCompleted() {
        return creditsCompleted;
    }

    public double getYano() {
        return yano;
    }

    public double getGano() {
        return gano;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setListOfCoursesTaken(Map<String, CourseGrade> listOfCoursesTaken) {
        this.listOfCoursesTaken = listOfCoursesTaken;
    }

    public void setCreditsTaken(int creditsTaken) {
        this.creditsTaken = creditsTaken;
    }

    public void setCreditsCompleted(int creditsCompleted) {
        this.creditsCompleted = creditsCompleted;
    }

    public void setYano(double yano) {
        this.yano = yano;
    }

    public void setGano(double gano) {
        this.gano = gano;
    }

    public int getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(int semesterNo) {
        this.semesterNo = semesterNo;
    }

}
