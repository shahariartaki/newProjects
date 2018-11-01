package com.example.taki.newproject.semister;

public class select_semister_model  {
    private String semester;
    private String year;

    public select_semister_model() {
    }

    public select_semister_model(String semester, String year) {
        this.semester = semester;
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
