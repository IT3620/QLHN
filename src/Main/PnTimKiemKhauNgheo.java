/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Control.DKCanBo;
import Control.DKCanBo;
import Entity.CanBo;
import Entity.DanhMuc;
import Entity.DiaBanInt;
import Entity.HeThong;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public final class PnTimKiemKhauNgheo extends javax.swing.JPanel {

    private static CanBo userInfo;
    public PnTimKiemKhauNgheo(CanBo userInfo) {
        PnTimKiemKhauNgheo.userInfo = userInfo;
        initComponents();
        
        loadComboBox();
        loadDanhSachHuyen();
        if (userInfo.getCapQL() == 2) {
            cbxhuyen.setEnabled(false);
            cbxhuyen.setSelectedIndex(userInfo.getDiaBanQL());
        }
        if (userInfo.getCapQL() == 3) {
            cbxhuyen.setEnabled(false);
            DiaBanInt db = DKCanBo.layDiaBanInt(3, userInfo.getDiaBanQL());
            cbxhuyen.setSelectedIndex(db.getHuyen());
            cbxxa.setSelectedIndex(userInfo.getDiaBanQL());
            cbxxa.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txthoten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxhuyen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxxa = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtnamsinhtu = new javax.swing.JTextField();
        txtnamsinhtoi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bttim = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxquanhe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbxdantoc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxdoituong = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxnghe = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtnam = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdskn = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txthoten.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txthoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 30, 170, -1));

        jLabel2.setText("Quận huyện");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 170, -1));

        cbxhuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhuyenActionPerformed(evt);
            }
        });
        add(cbxhuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 170, -1));

        jLabel3.setText("Xã phường");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 120, 170, -1));

        add(cbxxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 140, 170, -1));

        jLabel16.setText("Năm sinh");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 410, 170, -1));

        txtnamsinhtu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtnamsinhtu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 430, 70, -1));

        txtnamsinhtoi.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtnamsinhtoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 30, 20));

        bttim.setText("Tìm kiếm");
        bttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimActionPerformed(evt);
            }
        });
        add(bttim, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 540, 170, -1));

        jLabel5.setText("Quan hệ với chủ hộ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 170, 170, -1));

        jLabel6.setText("Họ tên");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 170, -1));
        add(cbxquanhe, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 190, 170, -1));

        jLabel1.setText("Dân tộc");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 250, 170, -1));

        add(cbxdantoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 270, 170, -1));

        jLabel7.setText("Đối tượng");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 300, 170, -1));

        add(cbxdoituong, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 320, 170, -1));

        jLabel8.setText("Nghề nghiệp");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 350, 170, -1));

        add(cbxnghe, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 370, 170, -1));

        jLabel9.setText("Năm");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 470, 50, -1));

        txtnam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        add(txtnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 70, -1));

        tbdskn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hộ nghèo", "Họ tên", "Năm sinh", "Xã", "Huyện", "Dân tộc", "Đối tượng", "Nghề nghiệp"
            }
        ));
        jScrollPane2.setViewportView(tbdskn);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 920, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void cbxhuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxhuyenActionPerformed
        // TODO add your handling code here:                                     
        // TODO add your handling code here:
        int idHuyen =getIDInt(cbxhuyen);
        loadDanhSachXa(idHuyen);
    }//GEN-LAST:event_cbxhuyenActionPerformed

    private void bttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimActionPerformed
        // TODO add your handling code here:
         try {
            int tu = 0, toi = 0, nam = 0;
            if (!txtnamsinhtu.getText().equals(""))
              tu  = Integer.parseInt(txtnamsinhtu.getText());
            if (!txtnamsinhtoi.getText().equals(""))
              toi  = Integer.parseInt(txtnamsinhtoi.getText());
            
            if (tu != 0 && toi != 0)
            if (tu > toi || tu < 0 || toi < 0) {
                JOptionPane.showMessageDialog(bttim, "Giới hạn độ tuổi không hợp lệ", "Thông báo lỗi", 2);
                return;
            }
            
             if (!txtnam.getText().equals(""))
                nam  = Integer.parseInt(txtnam.getText());
        } catch(NumberFormatException | HeadlessException ex) {
            JOptionPane.showMessageDialog(bttim, "Hạn độ tuổi hoặc năm không hợp lệ", "Thông báo lỗi", 2);
            return;
        }
        
        String tenKhauNgheo = txthoten.getText();
        int idHuyen = cbxhuyen.getSelectedIndex();
        int idXa =cbxxa.getSelectedIndex();
        int idDanToc = cbxdantoc.getSelectedIndex();
        int idQuanHe = cbxquanhe.getSelectedIndex();
        int idDoiTuong = cbxdoituong.getSelectedIndex();
        int namsinhtu, namsinhtoi, nam;
        
        if (txtnamsinhtu.getText().equals(""))
            namsinhtu = 0;
        else
            namsinhtu = Integer.parseInt(txtnamsinhtu.getText());
        
        if (txtnamsinhtoi.getText().equals(""))
            namsinhtoi = 0;
        else
            namsinhtoi = Integer.parseInt(txtnamsinhtoi.getText()); 
        
        if (txtnam.getText().equals(""))
            nam = HeThong.namNgheo;
        else
            nam = Integer.parseInt(txtnam.getText());
        
        timKiemKhauNgheo(tenKhauNgheo, idHuyen, idXa, idDanToc, idQuanHe, idDoiTuong, namsinhtu, namsinhtoi, nam);
    }//GEN-LAST:event_bttimActionPerformed

    public void loadComboBox() {
        cbxdantoc.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmDanToc) {
            cbxdantoc.addItem(i.id + "." + i.ten);
        }
        
        cbxquanhe.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmQuanHe) {
            cbxquanhe.addItem(i.id + "." + i.ten);
        }
        
        cbxdoituong.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmDoiTuong) {
            cbxdoituong.addItem(i.id + "." + i.ten);
        }
        
        cbxnghe.addItem("Tất cả");
        for (DanhMuc i : HeThong.dmPhanLoai) {
            cbxnghe.addItem(i.id + "." + i.ten);
        }
    }
    
    public void loadDanhSachHuyen() {
        ArrayList<DanhMuc> dsHuyen = DKCanBo.layDanhSachHuyen();
        cbxhuyen.removeAllItems();
        cbxhuyen.addItem("Tất cả");
        if (dsHuyen != null)
        for (DanhMuc huyen : dsHuyen)
            cbxhuyen.addItem(huyen.id + "." + huyen.ten);
    }

    public  void loadDanhSachXa(int huyen) {
        ArrayList<DanhMuc> dsXa = DKCanBo.layDanhSachXa(huyen);
        cbxxa.removeAllItems();
        cbxxa.addItem("Tất cả");
        if (dsXa != null)
            for (DanhMuc xa : dsXa) 
                cbxxa.addItem(xa.id + "." + xa.ten);
    }
    
    private static int getIDInt(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return 0;
        return Integer.parseInt(cbx.getSelectedItem().toString().split("\\.")[0]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttim;
    private javax.swing.JComboBox<String> cbxdantoc;
    private javax.swing.JComboBox<String> cbxdoituong;
    private javax.swing.JComboBox<String> cbxhuyen;
    private javax.swing.JComboBox<String> cbxnghe;
    private javax.swing.JComboBox<String> cbxquanhe;
    private javax.swing.JComboBox<String> cbxxa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbdskn;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtnam;
    private javax.swing.JTextField txtnamsinhtoi;
    private javax.swing.JTextField txtnamsinhtu;
    // End of variables declaration//GEN-END:variables

    private void timKiemKhauNgheo(String tenKhauNgheo, int idHuyen, int idXa, int idDanToc, int idQuanHe, int idDoiTuong, int namsinhtu, int namsinhtoi, int namNgheo) {
        String ten, huyen, xa, dantoc, quanhe, doituong, ns, nam;
        
         if (tenKhauNgheo.equals(""))
            ten = "";
        else
            ten = "dbo.tbKhauNgheo.HoTen LIKE N'%" + tenKhauNgheo + "%' AND ";
        
        if (idHuyen == 0)
            huyen = "";
        else
            huyen = "dbo.tbHuyen.IDHuyen = " + idHuyen + " AND ";
        
        if (idXa == 0)
            xa = "";
        else
            xa = "dbo.tbXa.IDXa = " + idXa + " AND ";
        
        if (idQuanHe == 0)
            quanhe = "";
        else
            quanhe = "dbo.tbKhauNgheo.IDQuanHeCH = " + idQuanHe + " AND ";
        
        if (idDanToc == 0)
            dantoc = "";
        else
            dantoc = "dbo.tbDanToc.IDDanToc = " + idDanToc + " AND ";
        
        if  (idDoiTuong == 0)
            doituong = "";
        else
            doituong = "dbo.tbKhauNgheo.IDDoiTuong = " + idDoiTuong + " AND ";
        
        
        if (namsinhtu == 0 && namsinhtoi == 0)
            ns = "";
        else if (namsinhtu ==0 && namsinhtoi != 0)
            ns = "dbo.tbKhauNgheo.NamSinh <= " + namsinhtoi + " AND ";
        else if (namsinhtu != 0 && namsinhtoi == 0)
            ns = "dbo.tbKhauNgheo.NamSinh >= " + namsinhtu + " AND ";
        else
            ns = "dbo.tbKhauNgheo.NamSinh <= " + namsinhtoi + " AND dbo.tbKhauNgheo.NamSinh >= " + namsinhtu + " AND ";
        
        if (namNgheo == 0)
            nam = "";
        else
            nam = "dbo.tbDanhSachHN.NamNgheo = " + namNgheo + " AND ";
        
        String sql = "SELECT        dbo.tbKhauNgheo.IDHoNgheo AS 'Mã hộ nghèo', dbo.tbKhauNgheo.HoTen AS 'Họ tên', dbo.tbKhauNgheo.NamSinh AS 'Năm sinh', \n" +
                    "                         dbo.tbXa.TenXa AS Xã, dbo.tbHuyen.TenHuyen AS Huyện, dbo.tbDanToc.TenDT AS 'Dân tộc', dbo.tbDoiTuong.TenDoiTuong AS 'Đối tượng', dbo.tbNgheNghiep.TenNN AS 'Nghề nghiệp'\n" +
                    "FROM            dbo.tbDanhSachHN INNER JOIN\n" +
                    "                         dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
                    "                         dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
                    "                         dbo.tbKhauNgheo ON dbo.tbHoNgheo.IDHoNgheo = dbo.tbKhauNgheo.IDHoNgheo AND dbo.tbDanToc.IDDanToc = dbo.tbKhauNgheo.IDDanToc INNER JOIN\n" +
                    "                         dbo.tbDoiTuong ON dbo.tbKhauNgheo.IDDoiTuong = dbo.tbDoiTuong.IDDoiTuong INNER JOIN\n" +
                    "                         dbo.tbNgheNghiep ON dbo.tbKhauNgheo.IDNgheNghiep = dbo.tbNgheNghiep.IDNgheNghiep INNER JOIN\n" +
                    "                         dbo.tbQuanHe ON dbo.tbKhauNgheo.IDQuanHeCH = dbo.tbQuanHe.IDQuanHeCH INNER JOIN\n" +
                    "                         dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
                    "                         dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen\n" +
                    " WHERE " + ten+ huyen + xa + dantoc + quanhe + doituong + ns + nam + " 1 = 1 " +
                    "ORDER BY Huyện, Xã, dbo.tbKhauNgheo.HoTen";
        DKCanBo.LoadData(sql, tbdskn);
    }
}
