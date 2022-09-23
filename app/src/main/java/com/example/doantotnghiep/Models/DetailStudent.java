package com.example.doantotnghiep.Models;

import com.android.volley.toolbox.StringRequest;

public class DetailStudent {
    private  String sv_id;
    private String tensv;
    private  String lopql;
    private String lop_id;
    private String diem_gk;

    public DetailStudent(String sv_id, String tensv, String lopql, String lop_id, String diem_gk) {
        this.sv_id = sv_id;
        this.tensv = tensv;
        this.lopql = lopql;
        this.lop_id = lop_id;
        this.diem_gk = diem_gk;
    }




    public String getSv_id() {
        return sv_id;
    }

    public void setSv_id(String sv_id) {
        this.sv_id = sv_id;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getLopql() {
        return lopql;
    }

    public void setLopql(String lopql) {
        this.lopql = lopql;
    }

    public String getLop_id() {
        return lop_id;
    }

    public void setLop_id(String lop_id) {
        this.lop_id = lop_id;
    }

    public String getDiem_gk() {
        return diem_gk;
    }

    public void setDiem_gk(String diem_gk) {
        this.diem_gk = diem_gk;
    }

}
