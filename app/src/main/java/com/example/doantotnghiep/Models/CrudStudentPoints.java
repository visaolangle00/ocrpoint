package com.example.doantotnghiep.Models;

import java.io.Serializable;

//public class CrudStudentPoints implements Serializable {
//    private int id;
//    private int Diem_Gk;
//    private int MaSV;
//    private String MaMon;
//
//    public CrudStudentPoints(int id, int diem_Gk, int maSV, String maMon) {
//        this.id = id;
//        Diem_Gk = diem_Gk;
//        MaSV = maSV;
//        MaMon = maMon;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getDiem_Gk() {
//        return Diem_Gk;
//    }
//
//    public void setDiem_Gk(int diem_Gk) {
//        Diem_Gk = diem_Gk;
//    }
//
//    public int getMaSV() {
//        return MaSV;
//    }
//
//    public void setMaSV(int maSV) {
//        MaSV = maSV;
//    }
//
//    public String getMaMon() {
//        return MaMon;
//    }
//
//    public void setMaMon(String maMon) {
//        MaMon = maMon;
//    }
//}


public class CrudStudentPoints implements Serializable {
    private int id;
    private int Diem_Gk;
    private String SinhVienID;
    private String LopID;

    public CrudStudentPoints(int id, int diem_Gk, String sinhVienID, String lopID) {
        this.id = id;
        Diem_Gk = diem_Gk;
        SinhVienID = sinhVienID;
        LopID = lopID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiem_Gk() {
        return Diem_Gk;
    }

    public void setDiem_Gk(int diem_Gk) {
        Diem_Gk = diem_Gk;
    }

    public String getSinhVienID() {
        return SinhVienID;
    }

    public void setSinhVienID(String sinhVienID) {
        SinhVienID = sinhVienID;
    }

    public String getLopID() {
        return LopID;
    }

    public void setLopID(String lopID) {
        LopID = lopID;
    }
}