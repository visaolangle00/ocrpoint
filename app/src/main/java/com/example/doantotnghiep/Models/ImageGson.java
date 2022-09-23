package com.example.doantotnghiep.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageGson {
    @SerializedName("tentaikhoan")
    @Expose
    private String tentaikhoan;

    @SerializedName("thongtin")
    @Expose
    private String thongtin;

    @SerializedName("thoigian")
    @Expose
    private String thoigian;

    @SerializedName("hinhanh")
    @Expose
    private String hinhanh;

    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("gv_id")
    @Expose
    private String gvId;

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGvId() {
        return gvId;
    }

    public void setGvId(String gvId) {
        this.gvId = gvId;
    }
}
