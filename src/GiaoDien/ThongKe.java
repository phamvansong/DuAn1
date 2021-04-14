/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.SinhVienDAO;
import DAO.TheLoaiSachDAO;
import DAO.ThongKeDAO;
import Model.PhieuMuon;
import Model.Sach;
import Model.SinhVien;
import Model.TheLoaiSach;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pvsla
 */
public class ThongKe extends javax.swing.JFrame {

    ThongKeDAO tkdao = new ThongKeDAO();
    TheLoaiSachDAO tlsdao = new TheLoaiSachDAO();
    SinhVienDAO svdao = new SinhVienDAO();
    SachDAO sdao = new SachDAO();
    PhieuMuonDAO pmdao = new PhieuMuonDAO();
    ArrayList<TheLoaiSach> listtls;
    ArrayList<SinhVien> listsv;
    ArrayList<Sach> lists;
    ArrayList<PhieuMuon> listpm;
    String key;
    boolean gt;

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        setLocationRelativeTo(null);
        loadcbbTenTheLoai();
        loadcbbViTriTheLoai();
        loadcbbTenSV();
        loadcbbTenSach();
        loadTableTLS();
        loadTableSV();
        loadTableSach();
        loadTablePM();
    }

    ThongKe(int index) {
        initComponents();
        setLocationRelativeTo(null);
        loadcbbTenTheLoai();
        loadcbbViTriTheLoai();
        loadcbbTenSV();
        loadcbbTenSach();
        loadTableTLS();
        loadTableSV();
        loadTableSach();
        loadTablePM();
        jTabbedPane1.setSelectedIndex(index);
    }

    public void loadcbbTenTheLoai() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboTenTLS.getModel();
        listtls = tlsdao.load();
        for (TheLoaiSach tls : listtls) {
            model.addElement(tls);
        }
        cboTenTLS.setModel(model);
    }

    public void loadcbbViTriTheLoai() {
        TheLoaiSachDAO tlsdao = new TheLoaiSachDAO();
        ArrayList<String> listcbo = tlsdao.listcbovitri();
        for (String tls : listcbo) {
            cboViTriTLS.addItem(tls);
        }
    }

    public void loadcbbTenSV() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboTenSVPM.getModel();
        listsv = svdao.load();
        for (SinhVien sv : listsv) {
            model.addElement(sv);
        }
        cboTenSVPM.setModel(model);
    }

    public void loadcbbTenSach() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboSachPM.getModel();
        lists = sdao.load();
        for (Sach s : lists) {
            model.addElement(s);
        }
        cboSachPM.setModel(model);
    }

    public void loadTableTLS() {
        DefaultTableModel model = (DefaultTableModel) tblTLS.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKTheLoaiSach();
        for (Object[] row : list) {
            model.addRow(row);
        }
        TongTheLoaiTLS();
    }

    public void loadTableMaTLS() {
        DefaultTableModel model = (DefaultTableModel) tblTLS.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKMaTheLoaiSach(key);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void loadTableViTriTLS() {
        DefaultTableModel model = (DefaultTableModel) tblTLS.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKViTriTheLoaiSach(key);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void loadTableGioiTinhSV() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        listsv = tkdao.TKGioiTinhSV(gt);
        for (SinhVien sv : listsv) {
            Object[] row = new Object[8];
            row[0] = sv.getMaSV();
            row[1] = sv.getPassword();
            row[2] = sv.getHoTen();
            row[3] = sv.getNgaySinh();
            if (sv.isGioiTinh() == true) {
                row[4] = "Nam";
            } else {
                row[4] = "Nữ";
            }
            row[5] = sv.getDiaChi();
            row[6] = sv.getSdt();
            row[7] = sv.getEmail();
            model.addRow(row);
        }
    }

    public void loadTableSV() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        listsv = svdao.load();
        for (SinhVien sv : listsv) {
            Object[] row = new Object[8];
            row[0] = sv.getMaSV();
            row[1] = sv.getPassword();
            row[2] = sv.getHoTen();
            row[3] = sv.getNgaySinh();
            if (sv.isGioiTinh() == false) {
                row[4] = "Nam";
            } else {
                row[4] = "Nữ";
            }
            row[5] = sv.getDiaChi();
            row[6] = sv.getSdt();
            row[7] = sv.getEmail();
            model.addRow(row);
        }
        TongSV();
    }

    public void loadTableSVChuaMuonSach() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        listsv = tkdao.TKSVChuaMuonSach();
        for (SinhVien sv : listsv) {
            Object[] row = new Object[8];
            row[0] = sv.getMaSV();
            row[1] = sv.getPassword();
            row[2] = sv.getHoTen();
            row[3] = sv.getNgaySinh();
            if (sv.isGioiTinh() == false) {
                row[4] = "Nam";
            } else {
                row[4] = "Nữ";
            }
            row[5] = sv.getDiaChi();
            row[6] = sv.getSdt();
            row[7] = sv.getEmail();
            model.addRow(row);
        }
        TongSVChuaMuonSach();
    }

    public void loadTableSVDaMuonSach() {
        DefaultTableModel model = (DefaultTableModel) tblSV.getModel();
        model.setRowCount(0);
        listsv = tkdao.TKSVDaMuonSach();
        for (SinhVien sv : listsv) {
            Object[] row = new Object[8];
            row[0] = sv.getMaSV();
            row[1] = sv.getPassword();
            row[2] = sv.getHoTen();
            row[3] = sv.getNgaySinh();
            if (sv.isGioiTinh() == false) {
                row[4] = "Nam";
            } else {
                row[4] = "Nữ";
            }
            row[5] = sv.getDiaChi();
            row[6] = sv.getSdt();
            row[7] = sv.getEmail();
            model.addRow(row);
        }
        TongSVDaMuonSach();
    }

    public void loadTableSach() {
        SachDAO sdao = new SachDAO();
        lists = sdao.load();
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        for (Sach s : lists) {
            Object[] row = new Object[]{
                s.getMaSach(), s.getTenSach(), s.getMaTheLoai(), s.getTacGia(), s.getSoLuong(), s.getNxb(), s.getNgayNhap(), s.getNdtt(), s.getHinh()
            };
            model.addRow(row);
        }
        TongSach();
    }

    public void loadTableSachGiam() {
        Date date = jDateChooser1.getDate();
        String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Date date1 = jDateChooser2.getDate();
        String dff = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKNgaySachGiam(df, dff);
        for (Object[] row : list) {
            model.addRow(row);
        }
        SoSachNgaySach();
    }

    public void loadTableSachTang() {
        Date date = jDateChooser1.getDate();
        String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Date date1 = jDateChooser2.getDate();
        String dff = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        DefaultTableModel model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKNgaySachTang(df, dff);
        for (Object[] row : list) {
            model.addRow(row);
        }
        SoSachNgaySach();
    }

    public void loadTablePM() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
        TongSVPM();
        TongSachPM();
        TongPM();
    }

    public void loadTableMaSVPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKMaSVPM(key);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void loadTableMaSachPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKMaSachPM(key);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void loadTableSVMuonNhieuSachNhatPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM1.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKSVMuonNhieuSachNhatPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
        TongSVPM();
        TongSachPM();
    }

    public void loadTableSVMuonItSachNhatPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM1.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKSVMuonItSachNhatPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
        TongSVPM();
        TongSachPM();
    }

    public void loadTableSachMuonNhieuNhatPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM2.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKSachMuonNhieuNhatPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
        TongSVPM();
        TongSachPM();
    }

    public void loadTableSachMuonItNhatPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM2.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKSachMuonItNhatPM();
        for (Object[] row : list) {
            model.addRow(row);
        }
        TongSVPM();
        TongSachPM();
    }

    public void loadTableSVConHanTraSachPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKSVConHanTraSachPM();
        for (Object[] row : list) {
            model.addRow(row);
        }

    }

    public void loadTableSVQuaHanTraSachPM() {
        DefaultTableModel model = (DefaultTableModel) tblPM.getModel();
        model.setRowCount(0);
        List<Object[]> list = tkdao.TKSVQuaHanTraSachPM();
        for (Object[] row : list) {
            model.addRow(row);
        }

    }

    public void SoSachTLS() {
        int tongso = tkdao.TKsoSachTLS(key);
        lblsoSachTLS.setText("Tổng số lượng Sách trong Thể Loại [ " + cboTenTLS.getSelectedItem().toString() + " ] là: " + String.valueOf(tongso));
    }

    public void SoSachViTriTLS() {
        int tongso = tkdao.TKsoSachViTriTLS(key);
        lblsoSachTLS.setText("Tổng Sách ở Vị trí [ " + cboViTriTLS.getSelectedItem().toString() + " ] là: " + String.valueOf(tongso));
    }

    public void SoTheLoaiTLS() {
        int tongso = tkdao.TKsoTheLoaiTLS(key);
        lblsoTheLoaiTLS.setText("Tổng số Mã Sách trong Thể Loại [ " + cboTenTLS.getSelectedItem().toString() + " ] là: " + String.valueOf(tongso));
    }

    public void SoTheLoaiViTriTLS() {
        int tongso = tkdao.TKsoTheLoaiViTriTLS(key);
        lblsoTheLoaiTLS.setText("Tổng Thể Loại ở Vị trí [ " + cboViTriTLS.getSelectedItem().toString() + " ] là: " + String.valueOf(tongso));
    }

    public void TongTheLoaiTLS() {
        int tongso = tkdao.TKsoTheLoaiTLS();
        lblsoTheLoaiTLS.setText("");
        lblsoSachTLS.setText("Tổng Thể Loại là: " + String.valueOf(tongso));
    }

    public void SoGioiTinhSV() {
        int tongso = tkdao.TKsoGioiTinhSV(gt);
        lblSoGioiTinhSV.setText("Tổng Sinh Viên Giới tính [ " + cboGioiTinhSV.getSelectedItem().toString() + " ] là: " + String.valueOf(tongso));
    }

    public void TongSV() {
        int tongso = tkdao.TKsoSV();
        lblSoGioiTinhSV.setText("Tổng Sinh Viên là: " + String.valueOf(tongso));
    }

    public void SoSachNgaySach() {
        Date date = jDateChooser1.getDate();
        String df = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Date date1 = jDateChooser2.getDate();
        String dff = new SimpleDateFormat("yyyy-MM-dd").format(date1);
        int tongso = tkdao.TKsoSachNgaySach(df, dff);
        lblTongSachS.setText("Tổng Sách từ ngày [ " + df + " ] đến ngày [ " + dff + " ] là: " + String.valueOf(tongso));
    }

    public void TongSach() {
        int tongso = tkdao.TKsoSach();
        lblTongSachS.setText("Tổng Sách là: " + String.valueOf(tongso));
    }

    public void TongSVPM() {
        int tongso = tkdao.TKsoSV();
        lblTongSVPM.setText("Tổng Sinh Viên mượn Sách là: " + String.valueOf(tongso));
    }

    public void TongSachPM() {
        int tongso = tkdao.TKsoSachSVMuon();
        lblTongSachPM.setText("Tổng Sách đã mượn là: " + String.valueOf(tongso));
    }

    public void SoSachSVPM() {
        int tongso = tkdao.TKsoSachSVPM(key);
        lblTongSVPM.setText("Tổng số Sách Sinh Viên [ " + cboTenSVPM.getSelectedItem().toString() + " ] đã mượn là: " + String.valueOf(tongso));
    }

    public void SoSVMuonSachPM() {
        int tongso = tkdao.TKsoSVMuonSachPM(key);
        lblTongSVPM.setText("Tổng Sinh Viên mượn Sách [ " + cboSachPM.getSelectedItem().toString() + " ] là: " + String.valueOf(tongso));
    }

    public void TongPM() {
        int tongso = tkdao.TKTongPM();
        lblTongPM.setText("Tổng Phiếu mượn là: " + String.valueOf(tongso));
    }

    public void TongSVChuaMuonSach() {
        int tongso = tkdao.TKTongSVChuaMuonSach();
        lblSoGioiTinhSV.setText("Tổng Sinh Viên chưa mượn Sách là: " + String.valueOf(tongso));
    }

    public void TongSVDaMuonSach() {
        int tongso = tkdao.TKTongSVDaMuonSach();
        lblSoGioiTinhSV.setText("Tổng Sinh Viên đã mượn Sách là: " + String.valueOf(tongso));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnQuanLy = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboGioiTinhSV = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboSapXepSV = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSV = new javax.swing.JTable();
        lblSoGioiTinhSV = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboSach = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        lblTongSachS = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cboTenTLS = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboViTriTLS = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTLS = new javax.swing.JTable();
        lblsoSachTLS = new javax.swing.JLabel();
        lblsoTheLoaiTLS = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cboTenSVPM = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboSachPM = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboSapXepPM = new javax.swing.JComboBox<>();
        lblTongSVPM = new javax.swing.JLabel();
        lblTongSachPM = new javax.swing.JLabel();
        lblTongPM = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPM = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPM1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPM2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("THỐNG KÊ");

        btnQuanLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinh/Home.png"))); // NOI18N
        btnQuanLy.setText("Quản Lý");
        btnQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyActionPerformed(evt);
            }
        });

        jLabel2.setText("Giới Tính");

        cboGioiTinhSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        cboGioiTinhSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhSVActionPerformed(evt);
            }
        });

        jLabel3.setText("Thống kê Theo");

        cboSapXepSV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sinh Viên Chưa Mượn Sách", "Sinh Viên Đã Mượn Sách" }));
        cboSapXepSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepSVActionPerformed(evt);
            }
        });

        tblSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Mật Khẩu", "Họ và Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "SĐT", "Email"
            }
        ));
        jScrollPane1.setViewportView(tblSV);

        lblSoGioiTinhSV.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblSoGioiTinhSV.setForeground(new java.awt.Color(51, 51, 255));
        lblSoGioiTinhSV.setText("Tổng Số Sinh Viên");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboGioiTinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSapXepSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblSoGioiTinhSV)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboGioiTinhSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboSapXepSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblSoGioiTinhSV)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sinh Viên", jPanel2);

        jLabel4.setText("Từ Ngày");

        jLabel5.setText("Đến Ngày");

        jLabel6.setText("Sắp Xếp Theo");

        cboSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Số lượng Sách giảm dần", "Số lượng Sách tăng dần" }));
        cboSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSachActionPerformed(evt);
            }
        });

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Mã Thể Loại", "Tác Giả", "Số Lượng", "NXB", "Ngày Nhập", "Nội Dung", "Hình"
            }
        ));
        jScrollPane2.setViewportView(tblSach);

        lblTongSachS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTongSachS.setForeground(new java.awt.Color(51, 51, 255));
        lblTongSachS.setText("Tổng số sách");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongSachS)
                .addGap(0, 745, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblTongSachS)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sách", jPanel3);

        jLabel7.setText("Thể Loại");

        cboTenTLS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cboTenTLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenTLSActionPerformed(evt);
            }
        });

        jLabel8.setText("Vị Trí");

        cboViTriTLS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cboViTriTLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboViTriTLSActionPerformed(evt);
            }
        });

        tblTLS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Thể Loại", "Tên Thể Loại", "Vị Trí", "Mã Sách", "Tên Sách", "Số Lượng"
            }
        ));
        jScrollPane3.setViewportView(tblTLS);

        lblsoSachTLS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblsoSachTLS.setForeground(new java.awt.Color(51, 51, 255));
        lblsoSachTLS.setText("Tổng");

        lblsoTheLoaiTLS.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblsoTheLoaiTLS.setForeground(new java.awt.Color(51, 51, 255));
        lblsoTheLoaiTLS.setText("Tổng");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTenTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cboViTriTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblsoSachTLS, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                            .addComponent(lblsoTheLoaiTLS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboTenTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboViTriTLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblsoSachTLS)
                .addGap(18, 18, 18)
                .addComponent(lblsoTheLoaiTLS)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thể Loại", jPanel4);

        jLabel9.setText("Tên SV");

        cboTenSVPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cboTenSVPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenSVPMActionPerformed(evt);
            }
        });

        jLabel10.setText("Sách");

        cboSachPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cboSachPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSachPMActionPerformed(evt);
            }
        });

        jLabel11.setText("Thống Kê Theo");

        cboSapXepPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Phiếu Mượn còn hạn trả sách", "Phiếu Mượn quá hạn trả sách", "Sinh Viên mượn nhiều sách nhất", "Sinh Viên mượn ít sách nhất", "Sách mượn nhiều nhất", "Sách mượn ít nhất" }));
        cboSapXepPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepPMActionPerformed(evt);
            }
        });

        lblTongSVPM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTongSVPM.setForeground(new java.awt.Color(51, 51, 255));
        lblTongSVPM.setText("Tổng SV:");

        lblTongSachPM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTongSachPM.setForeground(new java.awt.Color(51, 51, 255));
        lblTongSachPM.setText("Tổng Sách");

        lblTongPM.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTongPM.setForeground(new java.awt.Color(51, 51, 255));
        lblTongPM.setText("Tổng Phiếu Mượn");

        jPanel10.setLayout(new java.awt.CardLayout());

        tblPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Mượn", "Mã SV", "Tên SV", "Mã Sách", "Tên Sách", "Số Lượng", "Ngày Mượn", "Ngày Hẹn Trả"
            }
        ));
        jScrollPane4.setViewportView(tblPM);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11, "card2");

        tblPM1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SV", "Tên SV", "Số Lượng"
            }
        ));
        jScrollPane5.setViewportView(tblPM1);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel12, "card3");

        tblPM2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Số Lượng"
            }
        ));
        jScrollPane6.setViewportView(tblPM2);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.add(jPanel13, "card4");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongSachPM)
                            .addComponent(lblTongSVPM)
                            .addComponent(lblTongPM))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTenSVPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboSachPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboSapXepPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboTenSVPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cboSapXepPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cboSachPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongSVPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSachPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongPM)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phiếu Mượn", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(320, 320, 320)
                .addComponent(btnQuanLy)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnQuanLy, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSapXepSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepSVActionPerformed
        // TODO add your handling code here:
        if (cboSapXepSV.getSelectedItem().equals("Tất cả")) {
            loadTableSV();
        } else if (cboSapXepSV.getSelectedItem().equals("Sinh Viên Chưa Mượn Sách")) {
            cboGioiTinhSV.setSelectedIndex(0);
            loadTableSVChuaMuonSach();
        } else {
            cboGioiTinhSV.setSelectedIndex(0);
            loadTableSVDaMuonSach();
        }
    }//GEN-LAST:event_cboSapXepSVActionPerformed

    private void btnQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyActionPerformed
        // TODO add your handling code here:
        QuanLyUI qlui = new QuanLyUI();
        qlui.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnQuanLyActionPerformed

    private void cboGioiTinhSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhSVActionPerformed
        // TODO add your handling code here:
        if (cboGioiTinhSV.getSelectedItem().equals("Tất cả")) {
            loadTableSV();
        } else if (cboGioiTinhSV.getSelectedItem().equals("Nữ")) {
            cboSapXepSV.setSelectedIndex(0);
            gt = false;
            loadTableGioiTinhSV();
            SoGioiTinhSV();
        } else {
            cboSapXepSV.setSelectedIndex(0);
            gt = true;
            loadTableGioiTinhSV();
            SoGioiTinhSV();
        }
    }//GEN-LAST:event_cboGioiTinhSVActionPerformed

    private void cboSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSachActionPerformed
        // TODO add your handling code here:
        if (cboSach.getSelectedItem().equals("Số lượng Sách giảm dần")) {
            loadTableSachGiam();
        } else if (cboSach.getSelectedItem().equals("Số lượng Sách tăng dần")) {
            loadTableSachTang();
        } else {
            loadTableSach();
            TongSach();
        }
    }//GEN-LAST:event_cboSachActionPerformed

    private void cboTenTLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenTLSActionPerformed
        // TODO add your handling code here:
        if (cboTenTLS.getSelectedItem().equals("Tất cả")) {
            loadTableTLS();
        } else {
            cboViTriTLS.setSelectedIndex(0);
            key = ((TheLoaiSach) cboTenTLS.getSelectedItem()).getMaTheLoai();
            loadTableMaTLS();
            SoSachTLS();
            SoTheLoaiTLS();
        }
    }//GEN-LAST:event_cboTenTLSActionPerformed

    private void cboViTriTLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboViTriTLSActionPerformed
        // TODO add your handling code here:
        if (cboViTriTLS.getSelectedItem().equals("Tất cả")) {
            loadTableTLS();
        } else {
            cboTenTLS.setSelectedIndex(0);
            key = cboViTriTLS.getSelectedItem().toString();
            loadTableViTriTLS();
            SoSachViTriTLS();
            SoTheLoaiViTriTLS();
        }
    }//GEN-LAST:event_cboViTriTLSActionPerformed

    private void cboTenSVPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenSVPMActionPerformed
        // TODO add your handling code here:
        if (cboTenSVPM.getSelectedItem().equals("Tất cả")) {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            loadTablePM();
        } else {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            cboSachPM.setSelectedIndex(0);
            cboSapXepPM.setSelectedIndex(0);
            key = ((SinhVien) cboTenSVPM.getSelectedItem()).getMaSV();
            loadTableMaSVPM();
            lblTongSachPM.setText(null);
            lblTongPM.setText(null);
            SoSachSVPM();
        }
    }//GEN-LAST:event_cboTenSVPMActionPerformed

    private void cboSachPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSachPMActionPerformed
        // TODO add your handling code here:
        if (cboSachPM.getSelectedItem().equals("Tất cả")) {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            loadTablePM();
        } else {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            cboTenSVPM.setSelectedIndex(0);
            cboSapXepPM.setSelectedIndex(0);
            key = ((Sach) cboSachPM.getSelectedItem()).getMaSach();
            loadTableMaSachPM();
            lblTongPM.setText(null);
            lblTongSachPM.setText(null);
            SoSVMuonSachPM();
        }
    }//GEN-LAST:event_cboSachPMActionPerformed

    private void cboSapXepPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepPMActionPerformed
        // TODO add your handling code here:
        if (cboSapXepPM.getSelectedItem().equals("Phiếu Mượn còn hạn trả sách")) {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            cboTenSVPM.setSelectedIndex(0);
            cboSachPM.setSelectedIndex(0);
            loadTableSVConHanTraSachPM();
            int TongPM = tkdao.TKTongSoPhieuConHanTraSach();
            int TongSV = tkdao.TKTongSVConHanTraSach();
            lblTongPM.setText(null);
            lblTongSVPM.setText("Tổng Phiếu mượn còn hạn trả sách là: " + String.valueOf(TongPM));
            lblTongSachPM.setText("Tổng Sinh Viên còn hạn trả sách là: " + String.valueOf(TongSV));
        } else if (cboSapXepPM.getSelectedItem().equals("Phiếu Mượn quá hạn trả sách")) {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            cboTenSVPM.setSelectedIndex(0);
            cboSachPM.setSelectedIndex(0);
            loadTableSVQuaHanTraSachPM();
            int TongPM = tkdao.TKTongSoPhieuQuaHanTraSach();
            int TongSV = tkdao.TKTongSVQuaHanTraSach();
            lblTongPM.setText(null);
            lblTongSVPM.setText("Tổng Phiếu mượn quá hạn trả sách là: " + String.valueOf(TongPM));
            lblTongSachPM.setText("Tổng Sinh Viên quá hạn trả sách là: " + String.valueOf(TongSV));
        } else if (cboSapXepPM.getSelectedItem().equals("Sinh Viên mượn nhiều sách nhất")) {
            jPanel11.setVisible(false);
            jPanel13.setVisible(false);
            jPanel12.setVisible(true);
            loadTableSVMuonNhieuSachNhatPM();
            lblTongPM.setText(null);
        } else if (cboSapXepPM.getSelectedItem().equals("Sinh Viên mượn ít sách nhất")) {
            jPanel11.setVisible(false);
            jPanel13.setVisible(false);
            jPanel12.setVisible(true);
            loadTableSVMuonItSachNhatPM();
            lblTongPM.setText(null);
        } else if (cboSapXepPM.getSelectedItem().equals("Sách mượn nhiều nhất")) {
            jPanel11.setVisible(false);
            jPanel12.setVisible(false);
            jPanel13.setVisible(true);
            loadTableSachMuonNhieuNhatPM();
            lblTongPM.setText(null);
        } else if (cboSapXepPM.getSelectedItem().equals("Sách mượn ít nhất")) {
            jPanel11.setVisible(false);
            jPanel12.setVisible(false);
            jPanel13.setVisible(true);
            loadTableSachMuonItNhatPM();
            lblTongPM.setText(null);
        } else {
            jPanel12.setVisible(false);
            jPanel13.setVisible(false);
            jPanel11.setVisible(true);
            loadTablePM();
        }
    }//GEN-LAST:event_cboSapXepPMActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuanLy;
    private javax.swing.JComboBox<String> cboGioiTinhSV;
    private javax.swing.JComboBox<String> cboSach;
    private javax.swing.JComboBox<String> cboSachPM;
    private javax.swing.JComboBox<String> cboSapXepPM;
    private javax.swing.JComboBox<String> cboSapXepSV;
    private javax.swing.JComboBox<String> cboTenSVPM;
    private javax.swing.JComboBox<String> cboTenTLS;
    private javax.swing.JComboBox<String> cboViTriTLS;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSoGioiTinhSV;
    private javax.swing.JLabel lblTongPM;
    private javax.swing.JLabel lblTongSVPM;
    private javax.swing.JLabel lblTongSachPM;
    private javax.swing.JLabel lblTongSachS;
    private javax.swing.JLabel lblsoSachTLS;
    private javax.swing.JLabel lblsoTheLoaiTLS;
    private javax.swing.JTable tblPM;
    private javax.swing.JTable tblPM1;
    private javax.swing.JTable tblPM2;
    private javax.swing.JTable tblSV;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblTLS;
    // End of variables declaration//GEN-END:variables
}
