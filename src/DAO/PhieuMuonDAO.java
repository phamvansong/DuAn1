/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Connect;
import Model.PhieuMuon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author pvsla
 */
public class PhieuMuonDAO extends Connect {

    public ArrayList<PhieuMuon> load() {
        ArrayList<PhieuMuon> lists = new ArrayList<PhieuMuon>();
        try {
            String sql = "SELECT * FROM PhieuMuon";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            lists.clear();
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6));
                lists.add(pm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public int insert(PhieuMuon pm) {
        try {
            String sql = "Insert into PhieuMuon (MaSV,MaSach,SoLuong) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pm.getMaSV());
            ps.setString(2, pm.getMaSach());
            ps.setInt(3, pm.getSoLuong());
            return ps.executeUpdate();
        } catch (Exception ex) {

        }
        return -1;
    }

    public int update(PhieuMuon pm) {
        try {
            String sql = "Update PhieuMuon set MaSV = ? , MaSach = ?, SoLuong = ?, NgayMuon = ?, NgayHenTra = ? Where MaPhieuMuon = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pm.getMaSV());
            ps.setString(2, pm.getMaSach());
            ps.setInt(3, pm.getSoLuong());
            ps.setString(4, pm.getNgayMuon());
            ps.setString(5, pm.getNgayHenTra());
            ps.setString(6, pm.getMaPhieuMuon());
            return ps.executeUpdate();
        } catch (Exception ex) {

        }
        return -1;
    }

    public boolean delete(String maPhieuMuon) {
        try {
            String sql = "DELETE FROM PHIEUMUON WHERE MAPHIEUMUON=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maPhieuMuon);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<PhieuMuon> SearchMaSV(String maSV) {
        ArrayList<PhieuMuon> lists = new ArrayList<PhieuMuon>();
        try {
            String sql = "SELECT * FROM PHIEUMUON WHERE MaSV like '%" + maSV + "%' or MaSach like '%" + maSV + "%'";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPhieuMuon(rs.getString(1));
                pm.setMaSV(rs.getString(2));
                pm.setMaSach(rs.getString(3));
                pm.setSoLuong(rs.getInt(4));
                pm.setNgayMuon(rs.getString(5));
                pm.setNgayHenTra(rs.getString(6));
                lists.add(pm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lists;
    }
    public void inphieumuon(int maPhieu){
        try {
            Hashtable map = new Hashtable();
            JasperReport report = JasperCompileManager.compileReport("src/print/XuatPhieuMuon.jrxml");
            map.put("MaPhieuMuon", maPhieu);
            JasperPrint p = JasperFillManager.fillReport(report,  map, con );
            JasperViewer.viewReport(p, false);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
