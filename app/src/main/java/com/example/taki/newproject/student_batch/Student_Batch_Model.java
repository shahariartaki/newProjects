package com.example.taki.newproject.student_batch;

public class Student_Batch_Model {
    private String batch_name;
    private String section;

    public Student_Batch_Model(){

    }

    public Student_Batch_Model(String batch_name,String section){
        this.batch_name=batch_name;
        this.section=section;

    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
