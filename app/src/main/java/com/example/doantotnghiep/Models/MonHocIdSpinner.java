package com.example.doantotnghiep.Models;

public class MonHocIdSpinner {
    private String lop_id;
    private String sv_id;
    private String monhoc_id;
    private String diem_gk;

    public MonHocIdSpinner(String lop_id, String sv_id, String monhoc_id, String diem_gk) {
        this.lop_id = lop_id;
        this.sv_id = sv_id;
        this.monhoc_id = monhoc_id;
        this.diem_gk = diem_gk;
    }

    public String getLop_id() {
        return lop_id;
    }

    public void setLop_id(String lop_id) {
        this.lop_id = lop_id;
    }

    public String getSv_id() {
        return sv_id;
    }

    public void setSv_id(String sv_id) {
        this.sv_id = sv_id;
    }

    public String getMonhoc_id() {
        return monhoc_id;
    }

    public void setMonhoc_id(String monhoc_id) {
        this.monhoc_id = monhoc_id;
    }

    public String getDiem_gk() {
        return diem_gk;
    }

    public void setDiem_gk(String diem_gk) {
        this.diem_gk = diem_gk;
    }
}
