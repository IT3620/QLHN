/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.QLCanBo;
import Model.CanBo;
import Model.CanBoXa;
import Model.DanhMuc;
import Model.DiaBan;
import Model.HeThong;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;

/**
 *
 * @author thong
 */
public final class PnTimKiemHoNgheo extends javax.swing.JPanel {

    /**
     * Creates new form PnTimKiemHoNgheo
     */
    private static CanBo canbo;
    public PnTimKiemHoNgheo(CanBo canbo) {
        PnTimKiemHoNgheo.canbo = canbo;
        initComponents();
        loadComboBox();
        loadDanhSachHuyen();
        if (canbo.getCapQL() == 2) {
            cbxhuyen.setEnabled(false);
            cbxhuyen.setSelectedIndex(canbo.getDiaBanQL());
        }
        if (canbo.getCapQL() == 3) {
            cbxhuyen.setEnabled(false);
            DiaBan db = QLCanBo.layDiaBan(3, canbo.getDiaBanQL());
            cbxhuyen.setSelectedIndex(db.getHuyen().id);
            cbxxa.setSelectedIndex(canbo.getDiaBanQL());
            cbxxa.setEnabled(false);
        }
        
        btsua.setEnabled(false);
        btxoa.setEnabled(false);
        
     
       
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbtench = new javax.swing.JLabel();
        txtchuho = new javax.swing.JTextField();
        lbhuyen = new javax.swing.JLabel();
        lbxa = new javax.swing.JLabel();
        lbkhuvuc = new javax.swing.JLabel();
        lbthunhap = new javax.swing.JLabel();
        lbtttu = new javax.swing.JLabel();
        lbtttoi = new javax.swing.JLabel();
        cbxhuyen = new javax.swing.JComboBox<>();
        cbxxa = new javax.swing.JComboBox<>();
        cbxkhuvuc = new javax.swing.JComboBox<>();
        txtthunhaptu = new javax.swing.JTextField();
        lbdvtu = new javax.swing.JLabel();
        bttimkiem = new javax.swing.JButton();
        lbphanloai = new javax.swing.JLabel();
        cbxphanloai = new javax.swing.JComboBox<>();
        lbnguyennhan = new javax.swing.JLabel();
        cbxnguyennhan = new javax.swing.JComboBox<>();
        lbnam = new javax.swing.JLabel();
        txtnam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdstimkiem = new javax.swing.JTable();
        btsua = new javax.swing.JButton();
        btxoa = new javax.swing.JButton();
        txtthunhaptoi = new javax.swing.JTextField();
        lbdvtoi = new javax.swing.JLabel();
        lbdantoc = new javax.swing.JLabel();
        cbxdantoc = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbtench.setText("Tên chủ hộ");
        add(lbtench, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 170, -1));

        txtchuho.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtchuho, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 170, -1));

        lbhuyen.setText("Quận huyện");
        add(lbhuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 51, 170, -1));

        lbxa.setText("Xã phường");
        add(lbxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 107, 170, -1));

        lbkhuvuc.setText("Khu vực");
        add(lbkhuvuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 158, 170, -1));

        lbthunhap.setText("Thu nhập");
        add(lbthunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 379, 170, -1));

        lbtttu.setText("Từ");
        add(lbtttu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 402, 35, -1));

        lbtttoi.setText("Tới");
        add(lbtttoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 428, 35, -1));

        cbxhuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhuyenActionPerformed(evt);
            }
        });
        add(cbxhuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 71, 170, -1));

        add(cbxxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 127, 170, -1));

        add(cbxkhuvuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 183, 170, -1));

        txtthunhaptu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtthunhaptu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 52, -1));

        lbdvtu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbdvtu.setText("000 VNĐ");
        add(lbdvtu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 50, 20));
        lbdvtu.getAccessibleContext().setAccessibleName("000  VNĐ");

        bttimkiem.setText("Tìm kiếm");
        bttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimkiemActionPerformed(evt);
            }
        });
        add(bttimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 490, 170, -1));

        lbphanloai.setText("Phân loại");
        add(lbphanloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 270, 170, -1));

        add(cbxphanloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 290, 170, -1));

        lbnguyennhan.setText("Nguyên nhân");
        add(lbnguyennhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 321, 170, -1));

        add(cbxnguyennhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 341, 170, -1));

        lbnam.setText("Năm");
        add(lbnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 466, 35, -1));

        txtnam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 52, -1));

        tbdstimkiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ nghèo", "Tên chủ hộ", "Xã", "Huyện", "Thu nhập", "Phân loại", "Nguyên nhân", "Khu vực", "Dân tộc", "Năm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbdstimkiem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tbdstimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdstimkiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdstimkiem);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 0, 920, 570));

        btsua.setText("Chỉnh sửa");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });
        add(btsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, -1, -1));

        btxoa.setText("Xóa");
        btxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoaActionPerformed(evt);
            }
        });
        add(btxoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 580, -1, -1));

        txtthunhaptoi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtthunhaptoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 52, -1));

        lbdvtoi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbdvtoi.setText("000 VNĐ");
        add(lbdvtoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 50, 20));
        lbdvtoi.getAccessibleContext().setAccessibleName("000  VNĐ");

        lbdantoc.setText("Dân tộc");
        add(lbdantoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 214, 170, -1));

        add(cbxdantoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 239, 170, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cbxhuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxhuyenActionPerformed
        // TODO add your handling code here:
        int idHuyen =getIDInt(cbxhuyen);
        loadDanhSachXa(idHuyen);
    }//GEN-LAST:event_cbxhuyenActionPerformed

    private void bttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimkiemActionPerformed
        // TODO add your handling code here:
        try {
            int tu = 0, toi = 0, nam = 0;
            if (!txtthunhaptu.getText().equals(""))
              tu  = Integer.parseInt(txtthunhaptu.getText());
            if (!txtthunhaptoi.getText().equals(""))
              toi  = Integer.parseInt(txtthunhaptoi.getText());
            
            if (tu != 0 && toi != 0)
            if (tu > toi || tu < 0 || toi < 0) {
                JOptionPane.showMessageDialog(bttimkiem, "Hạn mức thu nhập không hợp lệ", "Thông báo lỗi", 2);
                return;
            }
            
             if (!txtnam.getText().equals(""))
                nam  = Integer.parseInt(txtnam.getText());
        } catch(NumberFormatException | HeadlessException ex) {
            JOptionPane.showMessageDialog(bttimkiem, "Hạn mức thu nhập hoặc năm không hợp lệ", "Thông báo lỗi", 2);
            return;
        }
        
        String tenChuHo = txtchuho.getText();
        int idHuyen = cbxhuyen.getSelectedIndex();
        int idXa =cbxxa.getSelectedIndex();
        int idKhuVuc = cbxkhuvuc.getSelectedIndex();
        int idDanToc = cbxdantoc.getSelectedIndex();
        int idPhanLoai = cbxphanloai.getSelectedIndex();
        int idNguyenNhan = cbxnguyennhan.getSelectedIndex();
        int thuNhapTu, thuNhapToi, nam;
        if (txtthunhaptu.getText().equals(""))
            thuNhapTu = 0;
        else
            thuNhapTu = Integer.parseInt(txtthunhaptu.getText())*1000;
        if (txtthunhaptoi.getText().equals(""))
            thuNhapToi = 0;
        else
            thuNhapToi = Integer.parseInt(txtthunhaptoi.getText())*1000; 
        
        if (txtnam.getText().equals(""))
            nam = HeThong.namNgheo;
        else
            nam = Integer.parseInt(txtnam.getText());
        timKiemHoNgheo(tenChuHo, idHuyen, idXa, idKhuVuc, idDanToc, idPhanLoai, idNguyenNhan, thuNhapTu, thuNhapToi, nam);
    }//GEN-LAST:event_bttimkiemActionPerformed

    private void tbdstimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdstimkiemMouseClicked
        // TODO add your handling code here:
        int index = tbdstimkiem.getSelectedRow();
        if (index <0)
            return;
        
        btsua.setEnabled(true);
        btxoa.setEnabled(true);
    }//GEN-LAST:event_tbdstimkiemMouseClicked

    private void btxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoaActionPerformed
        // TODO add your handling code here:
        int index = tbdstimkiem.getSelectedRow();
        if (index < 0)
            return;
        int idHoNgheo = (int)tbdstimkiem.getValueAt(index, 0);
        int nam = (int)tbdstimkiem.getValueAt(index, 8);
        if (nam != HeThong.namNgheo) {
            JOptionPane.showMessageDialog(bttimkiem, "Không thể xóa hộ nghèo cũ", "Thông báo lỗi", 2);
            return;
        }
            
        ((CanBoXa)canbo).xoaKhoiDanhSachHN(idHoNgheo, nam);
        tbdstimkiemMouseClicked(null);
        btsua.setEnabled(false);
        btxoa.setEnabled(false);
    }//GEN-LAST:event_btxoaActionPerformed

    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed
        // TODO add your handling code here:
        int index = tbdstimkiem.getSelectedRow();
        if (canbo.getCapQL() < 3 || !canbo.isTrangThai()) {
            JOptionPane.showMessageDialog(bttimkiem, "Bạn không có quyền chỉnh sửa hộ nghèo", "Thông báo lỗi", 2);
            return;
        }
        if (index < 0)
            return;
        int idHoNgheo = (int)tbdstimkiem.getValueAt(index, 0);
        FormChinhSuaHoNgheo frChinhSuaHoNgheo = new FormChinhSuaHoNgheo(canbo, idHoNgheo);
        frChinhSuaHoNgheo.setVisible(true);
    }//GEN-LAST:event_btsuaActionPerformed

    
    
    private void timKiemHoNgheo(String tenChuHo, int idHuyen, int idXa, int idKhuVuc, int idDanToc, int idPhanLoai, int idNguyenNhan, int thuNhapTu, int thuNhapToi, int namNgheo) {
        String sql;
        String ten, huyen, xa, khuvuc, dantoc, phanloai, nguyennhan, thunhap, nam;
        if (tenChuHo.equals(""))
            ten = "";
        else
            ten = "TenCH LIKE N'%" + tenChuHo + "%' AND ";
        
        if (idHuyen == 0)
            huyen = "";
        else
            huyen = "dbo.tbHuyen.IDHuyen = " + idHuyen + " AND ";
        
        if (idXa == 0)
            xa = "";
        else
            xa = "dbo.tbXa.IDXa = " + idXa + " AND ";
        
        if (idKhuVuc == 0)
            khuvuc = "";
        else
            khuvuc = "dbo.tbKhuVuc.IDKhuVuc = " + idKhuVuc + " AND ";
        
        if (idDanToc == 0)
            dantoc = "";
        else
            dantoc = "dbo.tbDanToc.IDDanToc = " + idDanToc + " AND ";
        
        if  (idPhanLoai == 0)
            phanloai = "";
        else
            phanloai = "dbo.tbPhanLoai.IDPhanLoai = " + idPhanLoai + " AND ";
        
        if (idNguyenNhan == 0)
            nguyennhan = "";
        else
            nguyennhan = "dbo.tbNguyenNhan.IDNguyenNhan = " + idNguyenNhan + " AND ";
        
        if (thuNhapTu == 0 && thuNhapToi == 0)
            thunhap = "";
        else if (thuNhapTu ==0 && thuNhapToi != 0)
            thunhap = "dbo.tbHoNgheo.ThuNhapTB <= " + thuNhapToi + " AND ";
        else if (thuNhapTu != 0 && thuNhapToi == 0)
            thunhap = "ThuNhapTB >= " + thuNhapTu + " AND ";
        else
            thunhap = "ThuNhapTB <= " + thuNhapToi + " AND ThuNhapTB >= " + thuNhapTu + " AND ";
        
        if (namNgheo == 0)
            nam = "";
        else
            nam = "dbo.tbDanhSachHN.NamNgheo = " + namNgheo + " AND ";
            
        sql = "SELECT       dbo.tbHoNgheo.IDHoNgheo AS 'Mã hộ nghèo',  dbo.tbHoNgheo.TenCH AS 'Tên chủ hộ', dbo.tbXa.TenXa AS 'Xã', dbo.tbHuyen.TenHuyen AS 'Huyện'"+
                ", dbo.tbPhanLoai.TenPL AS 'Phân loại', dbo.tbNguyenNhan.TenNN AS 'Nguyên nhân', dbo.tbKhuVuc.TenKhuVuc AS 'Khu vực' , dbo.tbHoNgheo.ThuNhapTB AS 'Thu nhập'" +
                ", dbo.tbDanToc.TenDT AS 'Dân tộc'\n" + ", dbo.tbDanhSachHN.NamNgheo AS Năm " +
                "FROM            dbo.tbDanhSachHN INNER JOIN\n" +
                "                         dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
                "                         dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
                "                         dbo.tbNguyenNhan ON dbo.tbHoNgheo.IDnguyenNhan = dbo.tbNguyenNhan.IDNguyenNhan INNER JOIN\n" +
                "                         dbo.tbPhanLoai ON dbo.tbHoNgheo.IDPhanLoai = dbo.tbPhanLoai.IDPhanLoai INNER JOIN\n" +
                "                         dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
                "                         dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen INNER JOIN\n" +
                "                         dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc\n" +
               "WHERE " + ten + huyen + xa + khuvuc + dantoc + phanloai + nguyennhan + thunhap + nam + " 1=1 " +
                "ORDER BY dbo.tbHuyen.TenHuyen, dbo.tbXa.TenXa, dbo.tbHoNgheo.TenCH";
        
        QLCanBo.LoadData(sql, tbdstimkiem);
    }
     private String getIDStr(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return null;
        return cbx.getSelectedItem().toString().split("\\.")[0];
    }

    private int getIDInt(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return 0;
        return Integer.parseInt(cbx.getSelectedItem().toString().split("\\.")[0]);
    }
    public void loadComboBox() {
        cbxdantoc.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmDanToc) {
            cbxdantoc.addItem(i.id + "." + i.ten);
        }
        
        cbxkhuvuc.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmKhuVuc) {
            cbxkhuvuc.addItem(i.id + "." + i.ten);
        }
        
        cbxnguyennhan.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmNguyenNhan) {
            cbxnguyennhan.addItem(i.id + "." + i.ten);
        }
        
        cbxphanloai.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmPhanLoai) {
            cbxphanloai.addItem(i.id + "." + i.ten);
        }
    }
    
    public void loadDanhSachHuyen() {
        ArrayList<DanhMuc> dsHuyen = QLCanBo.layDanhSachHuyen();
        cbxhuyen.removeAllItems();
        cbxhuyen.addItem("Tất cả");
        if (dsHuyen != null)
        for (DanhMuc huyen : dsHuyen)
            cbxhuyen.addItem(huyen.id + "." + huyen.ten);
    }

    public void loadDanhSachXa(int huyen) {
        ArrayList<DanhMuc> dsXa = QLCanBo.layDanhSachXa(huyen);
        cbxxa.removeAllItems();
        cbxxa.addItem("Tất cả");
        if (dsXa != null)
            for (DanhMuc xa : dsXa) 
                cbxxa.addItem(xa.id + "." + xa.ten);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsua;
    private javax.swing.JButton bttimkiem;
    private javax.swing.JButton btxoa;
    private javax.swing.JComboBox<String> cbxdantoc;
    private javax.swing.JComboBox<String> cbxhuyen;
    private javax.swing.JComboBox<String> cbxkhuvuc;
    private javax.swing.JComboBox<String> cbxnguyennhan;
    private javax.swing.JComboBox<String> cbxphanloai;
    private javax.swing.JComboBox<String> cbxxa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbdantoc;
    private javax.swing.JLabel lbdvtoi;
    private javax.swing.JLabel lbdvtu;
    private javax.swing.JLabel lbhuyen;
    private javax.swing.JLabel lbkhuvuc;
    private javax.swing.JLabel lbnam;
    private javax.swing.JLabel lbnguyennhan;
    private javax.swing.JLabel lbphanloai;
    private javax.swing.JLabel lbtench;
    private javax.swing.JLabel lbthunhap;
    private javax.swing.JLabel lbtttoi;
    private javax.swing.JLabel lbtttu;
    private javax.swing.JLabel lbxa;
    private javax.swing.JTable tbdstimkiem;
    private javax.swing.JTextField txtchuho;
    private javax.swing.JTextField txtnam;
    private javax.swing.JTextField txtthunhaptoi;
    private javax.swing.JTextField txtthunhaptu;
    // End of variables declaration//GEN-END:variables
}
