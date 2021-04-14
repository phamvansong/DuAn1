/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Connect;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.SinhVien;
import java.util.ArrayList;

/**
 *
 * @author pvsla
 */
public class ThongKeDAO extends Connect {

    public List<Object[]> TKTheLoaiSach() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_TheLoaiSach}";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaTheLoai"),
                    rs.getString("TenTheLoai"),
                    rs.getString("ViTri"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKMaTheLoaiSach(String maTheLoai) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_MaTheLoaiSach (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maTheLoai);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaTheLoai"),
                    rs.getString("TenTheLoai"),
                    rs.getString("ViTri"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKViTriTheLoaiSach(String viTri) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_ViTriTheLoaiSach (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, viTri);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaTheLoai"),
                    rs.getString("TenTheLoai"),
                    rs.getString("ViTri"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int TKsoSachTLS(String maTheLoai) {
        int tongSachTLS = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_soSachTLS (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maTheLoai);
            rs = pstm.executeQuery();
            while (rs.next()) {

                tongSachTLS = rs.getInt("tongSachTLS");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongSachTLS;
    }

    public int TKsoSachViTriTLS(String viTri) {
        int tongSachViTriTLS = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_soSachViTriTLS (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, viTri);
            rs = pstm.executeQuery();
            while (rs.next()) {

                tongSachViTriTLS = rs.getInt("tongSachViTriTLS");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongSachViTriTLS;
    }

    public int TKsoTheLoaiTLS(String maTheLoai) {
        int tongTheLoaiTLS = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_soTheLoaiTLS (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maTheLoai);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tongTheLoaiTLS = rs.getInt("soTheLoaiTLS");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongTheLoaiTLS;
    }

    public int TKsoTheLoaiViTriTLS(String viTri) {
        int tongTheLoaiViTriTLS = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_soTheLoaiViTriTLS (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, viTri);
            rs = pstm.executeQuery();
            while (rs.next()) {

                tongTheLoaiViTriTLS = rs.getInt("soTheLoaiViTriTLS");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongTheLoaiViTriTLS;
    }

    public int TKsoTheLoaiTLS() {
        int tongTheLoaiTLS = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongTheLoaiTLS }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tongTheLoaiTLS = rs.getInt("TongTheLoaiTLS");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongTheLoaiTLS;
    }
// Thống kê SINH VIÊN    

    public ArrayList<SinhVien> TKSVChuaMuonSach() {
        ArrayList<SinhVien> lists = new ArrayList<SinhVien>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SVChuaMuonSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                lists.add(sv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public ArrayList<SinhVien> TKSVDaMuonSach() {
        ArrayList<SinhVien> lists = new ArrayList<SinhVien>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SVDaMuonSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                lists.add(sv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public ArrayList<SinhVien> TKGioiTinhSV(boolean gioiTinh) {
        ArrayList<SinhVien> lists = new ArrayList<SinhVien>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_GioiTinhSV (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setBoolean(1, gioiTinh);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                lists.add(sv);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lists;
    }

    public int TKsoGioiTinhSV(boolean gioiTinh) {
        int tongGioiTinhSV = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_tongGioiTinhSV (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setBoolean(1, gioiTinh);
            rs = pstm.executeQuery();
            while (rs.next()) {

                tongGioiTinhSV = rs.getInt("tongGioiTinhSV");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongGioiTinhSV;
    }

    public int TKsoSV() {
        int tongSV = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_tongSV }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tongSV = rs.getInt("tongSV");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongSV;
    }

    public int TKTongSVChuaMuonSach() {
        int TongSVChuaMuonSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSVChuaMuonSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSVChuaMuonSach = rs.getInt("TongSVChuaMuonSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSVChuaMuonSach;
    }

    public int TKTongSVDaMuonSach() {
        int TongSVDaMuonSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSVDaMuonSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSVDaMuonSach = rs.getInt("TongSVDaMuonSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSVDaMuonSach;
    }
// Thống kê SACH  

    public List<Object[]> TKNgaySachGiam(String ngayBD, String ngayKT) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_NgaySachGiam (?,?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, ngayBD);
            pstm.setString(2, ngayKT);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getString("MaTheLoai"),
                    rs.getString("TacGia"),
                    rs.getInt("SoLuong"),
                    rs.getString("NXB"),
                    rs.getString("NgayNhap"),
                    rs.getString("NDTT"),
                    rs.getString("Hinh"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKNgaySachTang(String ngayBD, String ngayKT) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_NgaySachTang (?,?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, ngayBD);
            pstm.setString(2, ngayKT);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getString("MaTheLoai"),
                    rs.getString("TacGia"),
                    rs.getInt("SoLuong"),
                    rs.getString("NXB"),
                    rs.getString("NgayNhap"),
                    rs.getString("NDTT"),
                    rs.getString("Hinh"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int TKsoSachNgaySach(String ngayBD, String ngayKT) {
        int TongNgaySach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSachNgaySach (?,?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, ngayBD);
            pstm.setString(2, ngayKT);
            rs = pstm.executeQuery();
            while (rs.next()) {

                TongNgaySach = rs.getInt("TongNgaySach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongNgaySach;
    }

    public int TKsoSach() {
        int tongSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                tongSach = rs.getInt("TongSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongSach;
    }
// Thống kê PHIẾU MƯỢN   

    public List<Object[]> TKPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_PhieuMuon }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKMaSVPM(String maSV) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_MaSVPM (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maSV);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int TKsoSachSVPM(String maSV) {
        int soSachSVPM = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_soSachSVPM (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maSV);
            rs = pstm.executeQuery();
            while (rs.next()) {
                soSachSVPM = rs.getInt("soSachSVPM");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return soSachSVPM;
    }

    public List<Object[]> TKMaSachPM(String maSach) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_MaSachPM (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maSach);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int TKsoSVMuonSachPM(String maSach) {
        int tongSVMuonSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_soSVMuonSachPM (?)}";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setString(1, maSach);
            rs = pstm.executeQuery();
            while (rs.next()) {

                tongSVMuonSach = rs.getInt("tongSVMuonSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tongSVMuonSach;
    }

    public int TKsoSachSVMuon() {
        int TongSachSVMuon = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSachSVMuon }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSachSVMuon = rs.getInt("TongSachSVMuon");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSachSVMuon;
    }

    public List<Object[]> TKSVMuonNhieuSachNhatPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SVMuonNhieuSachNhat }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getInt("SVMuonNhieuSachNhat"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKSVMuonItSachNhatPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SVMuonItSachNhat }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getInt("SVMuonItSachNhat"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKSachMuonNhieuNhatPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SachMuonNhieuNhat }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SachMuonNhieuNhat"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKSachMuonItNhatPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SachMuonItNhat }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SachMuonItNhat"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKSVConHanTraSachPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SVConHanTraSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Object[]> TKSVQuaHanTraSachPM() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            String sql = "{call sp_SVQuaHanTraSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Object[] model = {
                    rs.getString("MaPhieuMuon"),
                    rs.getString("MaSV"),
                    rs.getString("HoTen"),
                    rs.getString("MaSach"),
                    rs.getString("TenSach"),
                    rs.getInt("SoLuong"),
                    rs.getString("NgayMuon"),
                    rs.getString("NgayHenTra"),};
                list.add(model);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public int TKTongSVConHanTraSach() {
        int TongSVConHanTraSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSVConHanTraSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSVConHanTraSach = rs.getInt("TongSVConHanTraSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSVConHanTraSach;
    }

    public int TKTongSVQuaHanTraSach() {
        int TongSVQuaHanTraSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSVQuaHanTraSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSVQuaHanTraSach = rs.getInt("TongSVQuaHanTraSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSVQuaHanTraSach;
    }

    public int TKTongSoPhieuConHanTraSach() {
        int TongSoPhieuConHanTraSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSoPhieuConHanTraSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSoPhieuConHanTraSach = rs.getInt("TongSoPhieuConHanTraSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSoPhieuConHanTraSach;
    }

    public int TKTongSoPhieuQuaHanTraSach() {
        int TongSoPhieuQuaHanTraSach = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongSoPhieuQuaHanTraSach }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongSoPhieuQuaHanTraSach = rs.getInt("TongSoPhieuQuaHanTraSach");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongSoPhieuQuaHanTraSach;
    }

    public int TKTongPM() {
        int TongPM = 0;
        try {
            ResultSet rs = null;
            String sql = "{call sp_TongPM }";
            PreparedStatement pstm = con.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                TongPM = rs.getInt("TongPM");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TongPM;
    }
}
