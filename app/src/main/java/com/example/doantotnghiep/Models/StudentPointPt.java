package com.example.doantotnghiep.Models;

public class StudentPointPt {
    String stpoint,classman,namept,lopidpt,diempt;

    public StudentPointPt(String stpoint, String classman, String namept, String lopidpt, String diempt) {
        this.stpoint = stpoint;
        this.classman = classman;
        this.namept = namept;
        this.lopidpt = lopidpt;
        this.diempt = diempt;
    }

    public String getStpoint() {
        return stpoint;
    }

    public void setStpoint(String stpoint) {
        this.stpoint = stpoint;
    }

    public String getClassman() {
        return classman;
    }

    public void setClassman(String classman) {
        this.classman = classman;
    }

    public String getNamept() {
        return namept;
    }

    public void setNamept(String namept) {
        this.namept = namept;
    }

    public String getLopidpt() {
        return lopidpt;
    }

    public void setLopidpt(String lopidpt) {
        this.lopidpt = lopidpt;
    }

    public String getDiempt() {
        return diempt;
    }

    public void setDiempt(String diempt) {
        this.diempt = diempt;
    }
}
