package com.example.doantotnghiep.Models;

public class Student_Pt {

    String masv_pt;
    String tensv_pt;
    String svid_pt;
    String lopql_pt;

    public Student_Pt(String masv_pt, String tensv_pt, String svid_pt, String lopql_pt) {
        this.masv_pt = masv_pt;
        this.tensv_pt = tensv_pt;
        this.svid_pt = svid_pt;
        this.lopql_pt = lopql_pt;
    }

    public String getMasv_pt() {
        return masv_pt;
    }

    public void setMasv_pt(String masv_pt) {
        this.masv_pt = masv_pt;
    }

    public String getTensv_pt() {
        return tensv_pt;
    }

    public void setTensv_pt(String tensv_pt) {
        this.tensv_pt = tensv_pt;
    }

    public String getSvid_pt() {
        return svid_pt;
    }

    public void setSvid_pt(String svid_pt) {
        this.svid_pt = svid_pt;
    }

    public String getLopql_pt() {
        return lopql_pt;
    }

    public void setLopql_pt(String lopql_pt) {
        this.lopql_pt = lopql_pt;
    }
}
