/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author pvsla
 */
public class Sach {

    private String maSach;
    private String tenSach;
    private String maTheLoai;
    private String tacGia;
    private int soLuong;
    private String nxb;
    private String ngayNhap;
    private String ndtt;
    private String hinh;

    public Sach() {
    }

    public Sach(String maSach) {
        this.maSach = maSach;
    }

    public Sach(String maSach, String tenSach, String maTheLoai, String tacGia, int soLuong, String nxb, String ngayNhap, String ndtt, String hinh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maTheLoai = maTheLoai;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.nxb = nxb;
        this.ngayNhap = ngayNhap;
        this.ndtt = ndtt;
        this.hinh = hinh;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNdtt() {
        return ndtt;
    }

    public void setNdtt(String ndtt) {
        this.ndtt = ndtt;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return tenSach;
    }
}
