package com.example.doantotnghiep.Models;

import java.io.Serializable;

//public class ViewSubject implements Serializable {
//    String MaMon;
//    String TenMon;
//    String TKB;
//    String gv_id;
//
//    public ViewSubject(String maMon, String tenMon, String TKB, String gv_id) {
//        MaMon = maMon;
//        TenMon = tenMon;
//        this.TKB = TKB;
//        this.gv_id = gv_id;
//    }
//
//    public String getMaMon() {
//        return MaMon;
//    }
//
//    public void setMaMon(String maMon) {
//        MaMon = maMon;
//    }
//
//    public String getTenMon() {
//        return TenMon;
//    }
//
//    public void setTenMon(String tenMon) {
//        TenMon = tenMon;
//    }
//
//    public String getTKB() {
//        return TKB;
//    }
//
//    public void setTKB(String TKB) {
//        this.TKB = TKB;
//    }
//
//    public String getGv_id() {
//        return gv_id;
//    }
//
//    public void setGv_id(String gv_id) {
//        this.gv_id = gv_id;
//    }
//}

public class ViewSubject implements Serializable{
    String tenmon;
    String monhoc_id;
    String tkb;
    String sotinchi;
    String gv_id;
    String lich;

    public ViewSubject(String tenmon, String monhoc_id, String tkb, String sotinchi, String gv_id, String lich) {
        this.tenmon = tenmon;
        this.monhoc_id = monhoc_id;
        this.tkb = tkb;
        this.sotinchi = sotinchi;
        this.gv_id = gv_id;
        this.lich = lich;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getMonhoc_id() {
        return monhoc_id;
    }

    public void setMonhoc_id(String monhoc_id) {
        this.monhoc_id = monhoc_id;
    }

    public String getTkb() {
        return tkb;
    }

    public void setTkb(String tkb) {
        this.tkb = tkb;
    }

    public String getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(String sotinchi) {
        this.sotinchi = sotinchi;
    }

    public String getGv_id() {
        return gv_id;
    }

    public void setGv_id(String gv_id) {
        this.gv_id = gv_id;
    }

    public String getLich() {
        return lich;
    }

    public void setLich(String lich) {
        this.lich = lich;
    }
}
