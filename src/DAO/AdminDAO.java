/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Connect;
import Model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author pvsla
 */
public class AdminDAO extends Connect {

    public Admin dangnhap(String username, String password) {
        Admin ad = null;
        try {
            String sql = "Select * from Admin where Username=? and Password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ad = new Admin();
                ad.setUsername(rs.getString(1));
                ad.setPassword(rs.getString(2));
                ad.setTen(rs.getString(3));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return ad;
    }

    public ArrayList<Admin> LoadMa(String username) {
        ArrayList<Admin> lists = new ArrayList<Admin>();
        try {
            String sql = "SELECT * FROM ADMIN WHERE Username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin ad = new Admin();
                ad.setUsername(rs.getString(1));
                ad.setPassword(rs.getString(2));
                ad.setTen(rs.getString(3));
                lists.add(ad);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public int doiMK(Admin ad) {
        try {
            String sql = "Update Admin set Password=? WHERE Username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ad.getPassword());
            ps.setString(2, ad.getUsername());
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
}
