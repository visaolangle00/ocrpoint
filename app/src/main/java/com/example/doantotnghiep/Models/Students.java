package com.example.doantotnghiep.Models;

public class Students {
     private String svidsp,tensvsp,lopqlsp,diemgk;

    public Students(String svidsp, String tensvsp, String lopqlsp, String diemgk) {
        this.svidsp = svidsp;
        this.tensvsp = tensvsp;
        this.lopqlsp = lopqlsp;
        this.diemgk = diemgk;
    }

    public String getSvidsp() {
        return svidsp;
    }

    public void setSvidsp(String svidsp) {
        this.svidsp = svidsp;
    }

    public String getTensvsp() {
        return tensvsp;
    }

    public void setTensvsp(String tensvsp) {
        this.tensvsp = tensvsp;
    }

    public String getLopqlsp() {
        return lopqlsp;
    }

    public void setLopqlsp(String lopqlsp) {
        this.lopqlsp = lopqlsp;
    }

    public String getDiemgk() {
        return diemgk;
    }

    public void setDiemgk(String diemgk) {
        this.diemgk = diemgk;
    }
}
