package com.example.doantotnghiep.Models;

public class StudentsPointsOCR {
        private String sv_idocr;
        private String lop_idocr;
        private String diem_gk;

    public StudentsPointsOCR(String sv_idocr, String lop_idocr, String diem_gk) {
        this.sv_idocr = sv_idocr;
        this.lop_idocr = lop_idocr;
        this.diem_gk = diem_gk;
    }

    public String getSv_idocr() {
        return sv_idocr;
    }

    public void setSv_idocr(String sv_idocr) {
        this.sv_idocr = sv_idocr;
    }

    public String getLop_idocr() {
        return lop_idocr;
    }

    public void setLop_idocr(String lop_idocr) {
        this.lop_idocr = lop_idocr;
    }

    public String getDiem_gk() {
        return diem_gk;
    }

    public void setDiem_gk(String diem_gk) {
        this.diem_gk = diem_gk;
    }
}
