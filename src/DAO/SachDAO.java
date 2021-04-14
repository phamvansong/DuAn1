/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Connect;
import Model.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author pvsla
 */
public class SachDAO extends Connect {

    public ArrayList<Sach> load() {
        ArrayList<Sach> lists = new ArrayList<Sach>();
        try {
            String sql = "SELECT * FROM Sach";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lists.clear();
            while (rs.next()) {
                Sach s = new Sach(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                lists.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public int insert(Sach s) {
        try {
            String sql = "Insert into Sach values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getMaTheLoai());
            ps.setString(4, s.getTacGia());
            ps.setInt(5, s.getSoLuong());
            ps.setString(6, s.getNxb());
            ps.setString(7, s.getNgayNhap());
            ps.setString(8, s.getNdtt());
            ps.setString(9, s.getHinh());
            return ps.executeUpdate();
        } catch (Exception ex) {

        }
        return -1;
    }

    public int update(Sach s) {
        try {
            String sql = "Update Sach set TenSach=?, MaTheLoai=?, TacGia=?, SoLuong=?, NXB=?, NgayNhap=?, NDTT=?, Hinh=? Where MaSach=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getMaTheLoai());
            ps.setString(3, s.getTacGia());
            ps.setInt(4, s.getSoLuong());
            ps.setString(5, s.getNxb());
            ps.setString(6, s.getNgayNhap());
            ps.setString(7, s.getNdtt());
            ps.setString(8, s.getHinh());
            ps.setString(9, s.getMaSach());
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public boolean delete(String maSach) {
        try {
            String sql = "DELETE FROM SACH WHERE MASACH=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maSach);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Sach> SearchTen(String tenSach) {
        ArrayList<Sach> lists = new ArrayList<Sach>();
        try {
            String sql = "SELECT * FROM SACH WHERE TenSach like N'%" + tenSach + "%' or MaTheLoai like '%" + tenSach + "%' or MaSach like '%" + tenSach + "%'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setMaTheLoai(rs.getString(3));
                s.setTacGia(rs.getString(4));
                s.setSoLuong(rs.getInt(5));
                s.setNxb(rs.getString(6));
                s.setNgayNhap(rs.getString(7));
                s.setNdtt(rs.getString(8));
                s.setHinh(rs.getString(9));
                lists.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public ArrayList<Sach> SearchTenSachMTL(String tenSach) {
        ArrayList<Sach> lists = new ArrayList<Sach>();
        try {
            String sql = "SELECT * FROM SACH WHERE TenSach like N'%" + tenSach + "%' or MaTheLoai like '%" + tenSach + "%'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Sach s = new Sach();
                s.setMaSach(rs.getString(1));
                s.setTenSach(rs.getString(2));
                s.setMaTheLoai(rs.getString(3));
                s.setTacGia(rs.getString(4));
                s.setSoLuong(rs.getInt(5));
                s.setNxb(rs.getString(6));
                s.setNgayNhap(rs.getString(7));
                s.setNdtt(rs.getString(8));
                s.setHinh(rs.getString(9));
                lists.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }
}
