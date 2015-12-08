package View;

import Control.QLCanBo;
import Model.CanBo;
import Model.CoSoDuLieu;
import Model.DanhMuc;
import Model.DiaBan;
import Model.HeThong;
import java.util.ArrayList;


public class PnBaoCaoSoLieu extends javax.swing.JPanel {
    private static CanBo canbo;
    public PnBaoCaoSoLieu(CanBo canbo) {
        PnBaoCaoSoLieu.canbo = canbo;
        initComponents();
        
        cbxgiatri.setEnabled(false);
        for (int i = HeThong.namNgheo; i>2010; i--) {
            cbxnam.addItem(""+i);
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbbaocaosl = new javax.swing.JTable();
        txttieude = new javax.swing.JLabel();
        cbxloaibc = new javax.swing.JComboBox<String>();
        cbxnam = new javax.swing.JComboBox<String>();
        cbxgiatri = new javax.swing.JComboBox<String>();
        btxuatbc = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbbaocaosl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbbaocaosl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbbaocaosl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 1109, 362));

        txttieude.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttieude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttieude.setText("Bảng báo cáo số liệu");
        add(txttieude, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 1109, -1));

        cbxloaibc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tổng hợp số liệu hộ nghèo", "Tổng hợp số liệu theo đối tượng", "Tổng hợp số liệu theo khu vực", "Tổng hợp số liệu theo dân tộc", "Tổng hợp số liệu theo tình hình nhà ở", "Tổng hợp số liệu hộ nghèo theo nguyên nhân nghèo", "Tổng hợp số liệu hộ nghèo và cận nghèo theo năm" }));
        cbxloaibc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxloaibcActionPerformed(evt);
            }
        });
        add(cbxloaibc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 383, -1));

        add(cbxnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 12, 65, -1));

        cbxgiatri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxgiatriActionPerformed(evt);
            }
        });
        add(cbxgiatri, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 12, 204, -1));

        btxuatbc.setText("Xuất báo cáo");
        btxuatbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxuatbcActionPerformed(evt);
            }
        });
        add(btxuatbc, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 11, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cbxloaibcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxloaibcActionPerformed
        if (cbxloaibc.getSelectedIndex() != 0 || cbxloaibc.getSelectedIndex() != 8)
            cbxgiatri.setVisible(true);
        switch (cbxloaibc.getSelectedIndex() + 1) {
            case 1:
            case 8:
                cbxgiatri.setVisible(false);
                break;
            case 2:
                cbxgiatri.removeAllItems();
                cbxgiatri.addItem("0.Tất cả");
                for (DanhMuc i : HeThong.dmDoiTuong)
                    cbxgiatri.addItem(i.ten);
                break;
            case 3:
                cbxgiatri.removeAllItems();
                cbxgiatri.addItem("0.Tất cả");
                for (DanhMuc i : HeThong.dmKhuVuc)
                    cbxgiatri.addItem(i.ten);
                break;
            case 4:
                cbxgiatri.removeAllItems();
                cbxgiatri.addItem("0.Tất cả");
                for (DanhMuc i : HeThong.dmDanToc)
                    cbxgiatri.addItem(i.ten);
                break;
            case 5:
                cbxgiatri.removeAllItems();
                cbxgiatri.addItem("0.Tất cả");
                for (DanhMuc i : HeThong.dmNhaO)
                    cbxgiatri.addItem(i.ten);
                break;
            case 6:
                cbxgiatri.removeAllItems();
                cbxgiatri.addItem("0.Tất cả");
                for (DanhMuc i : HeThong.dmDoiTuong)
                    cbxgiatri.addItem(i.ten);
                break;
            case 7:
                cbxgiatri.removeAllItems();
                cbxgiatri.addItem("0.Tất cả");
                for (DanhMuc i : HeThong.dmNguyenNhan)
                    cbxgiatri.addItem(i.ten);
                break;
        }
    }//GEN-LAST:event_cbxloaibcActionPerformed

       

    private void btxuatbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxuatbcActionPerformed
//        int loai = cbxloaibc.getSelectedIndex() + 1;
//        int nam = Integer.parseInt(cbxnam.getSelectedItem().toString());
//        int giatri = Integer.parseInt(cbxgiatri.getSelectedItem().toString().split(".")[0]);
//        String sql = canbo.layTruyVanBaoCaoSL(loai, nam, giatri);
        String sql="";
        String diaban="";
        String tieude="";
        DiaBan db = QLCanBo.layDiaBan(canbo.getCapQL(), canbo.getDiaBanQL());
        if(canbo.getCapQL()==1)
        {
            tieude=" TỈNH "+db.getTinh().ten.toUpperCase()+" ";
        }
            else if(canbo.getCapQL()==2) {
            tieude=" HUYỆN "+db.getHuyen().ten.toUpperCase()+" ";
        }
        else if(canbo.getCapQL()==3) {
            diaban=" AND dbo.tbXa.IDXa="+canbo.getDiaBanQL();
            tieude=" XÃ "+db.getXa().ten.toUpperCase()+" HUYỆN "+db.getHuyen().ten.toUpperCase()+" ";;
        }
        switch (cbxloaibc.getSelectedIndex())
        {
            case 0: sql="SELECT     dbo.tbPhanLoai.TenPL as 'Phân loại',COUNT(distinct dbo.tbHoNgheo.IDHoNgheo) as 'Số Hộ ',COUNT(distinct IDKhauNgheo) as 'Số Khẩu '\n" +
"FROM       dbo.tbDanhSachHN,dbo.tbHoNgheo,dbo.tbPhanLoai,dbo.tbKhauNgheo,dbo.tbHuyen,dbo.tbXa\n" +
"WHERE		dbo.tbDanhSachHN.IDHoNgheo=dbo.tbHoNgheo.IDHoNgheo\n" +
"and			dbo.tbPhanLoai.IDPhanLoai=dbo.tbHoNgheo.IDPhanLoai\n" +
"and			dbo.tbXa.IDHuyen=dbo.tbHuyen.IDHuyen\n" +
"and			dbo.tbHoNgheo.IDXa=dbo.tbXa.IDXa\n" +
"and			NamNgheo=" +Integer.parseInt(cbxnam.getSelectedItem().toString())+diaban+
" GROUP BY dbo.tbPhanLoai.TenPL,dbo.tbDanhSachHN.NamNgheo";
            txttieude.setText("BÁO CÁO SỐ HỘ NGHÈO VÀ KHẨU NGHÈO "+tieude+ cbxnam.getSelectedItem());
                break;
            case 1: sql ="SELECT     dbo.tbDoiTuong.TenDoiTuong as 'Đối Tượng',COUNT(distinct IDKhauNgheo) as 'Số Người '\n" +
"FROM       dbo.tbDanhSachHN,dbo.tbHoNgheo,dbo.tbDoiTuong,dbo.tbKhauNgheo,dbo.tbHuyen,dbo.tbXa\n" +
"WHERE		dbo.tbDanhSachHN.IDHoNgheo=dbo.tbHoNgheo.IDHoNgheo\n" +
"and			dbo.tbDoiTuong.IDDoiTuong=dbo.tbKhauNgheo.IDDoiTuong\n" +
"and			dbo.tbXa.IDHuyen=dbo.tbHuyen.IDHuyen\n" +
"and			dbo.tbHoNgheo.IDXa=dbo.tbXa.IDXa\n" +
"and			NamNgheo=" +Integer.parseInt(cbxnam.getSelectedItem().toString())+diaban+
"GROUP BY dbo.tbDoiTuong.TenDoiTuong,dbo.tbDanhSachHN.NamNgheo";
            txttieude.setText("BÁO CÁO SỐ NGƯỜI NGHÈO THEO ĐỐI TƯỢNG "+tieude+ cbxnam.getSelectedItem());
                break;
            case 2 :sql ="SELECT     dbo.tbKhuVuc.TenKhuVuc as 'Tên khu vực',COUNT(distinct dbo.tbHoNgheo.IDHoNgheo) as 'Số Hộ ',COUNT(distinct IDKhauNgheo) as 'Số Khẩu '\n" +
"FROM       dbo.tbDanhSachHN,dbo.tbHoNgheo,dbo.tbKhuVuc,dbo.tbKhauNgheo,dbo.tbHuyen,dbo.tbXa\n" +
"WHERE		dbo.tbDanhSachHN.IDHoNgheo=dbo.tbHoNgheo.IDHoNgheo\n" +
"and			dbo.tbKhuVuc.IDKhuVuc=dbo.tbXa.IDKhuVuc\n" +
"and			dbo.tbXa.IDHuyen=dbo.tbHuyen.IDHuyen\n" +
"and			dbo.tbHoNgheo.IDXa=dbo.tbXa.IDXa\n" +
"and			NamNgheo=" +Integer.parseInt(cbxnam.getSelectedItem().toString())+diaban+
"GROUP BY dbo.tbKhuVuc.TenKhuVuc,dbo.tbDanhSachHN.NamNgheo";
            txttieude.setText("BÁO CÁO SỐ HỘ NGHÈO VÀ KHẨU NGHÈO THEO KHU VỰC "+tieude+ cbxnam.getSelectedItem());
                break;
            case 3 : sql ="SELECT     dbo.tbDanToc.TenDT as 'Tên Dân Tộc',COUNT(distinct dbo.tbHoNgheo.IDHoNgheo) as 'Số Hộ ',COUNT(distinct IDKhauNgheo) as 'Số Khẩu '\n" +
"FROM       dbo.tbDanhSachHN,dbo.tbHoNgheo,dbo.tbDanToc,dbo.tbKhauNgheo,dbo.tbHuyen,dbo.tbXa\n" +
"WHERE		dbo.tbDanhSachHN.IDHoNgheo=dbo.tbHoNgheo.IDHoNgheo\n" +
"and			dbo.tbDanToc.IDDanToc=dbo.tbHoNgheo.IDDanToc\n" +
"and			dbo.tbXa.IDHuyen=dbo.tbHuyen.IDHuyen\n" +
"and			dbo.tbHoNgheo.IDXa=dbo.tbXa.IDXa\n" +
"and			NamNgheo=" +Integer.parseInt(cbxnam.getSelectedItem().toString())+diaban+
"GROUP BY dbo.tbDanToc.TenDT,dbo.tbDanhSachHN.NamNgheo";
        txttieude.setText("BÁO CÁO SỐ HỘ NGHÈO VÀ KHẨU NGHÈO THEO DÂN TỘC "+tieude+ cbxnam.getSelectedItem());
                break;
                case 4 : sql ="SELECT     dbo.tbNhaO.TenNhaO as 'Tên Nhà Ở',COUNT(distinct dbo.tbHoNgheo.IDHoNgheo) as 'Số Hộ ',COUNT(distinct IDKhauNgheo) as 'Số Khẩu '\n" +
"FROM       dbo.tbDanhSachHN,dbo.tbHoNgheo,dbo.tbNhaO,dbo.tbKhauNgheo,dbo.tbHuyen,dbo.tbXa\n" +
"WHERE		dbo.tbDanhSachHN.IDHoNgheo=dbo.tbHoNgheo.IDHoNgheo\n" +
"and			dbo.tbNhaO.IDNhaO=dbo.tbHoNgheo.IDNhaO\n" +
"and			dbo.tbXa.IDHuyen=dbo.tbHuyen.IDHuyen\n" +
"and			dbo.tbHoNgheo.IDXa=dbo.tbXa.IDXa\n" +
"and			NamNgheo=" +Integer.parseInt(cbxnam.getSelectedItem().toString())+diaban+
"GROUP BY dbo.tbNhaO.TenNhaO,dbo.tbDanhSachHN.NamNgheo";
                txttieude.setText("BÁO CÁO SỐ HỘ NGHÈO VÀ KHẨU NGHÈO THEO NHÀ Ở "+tieude+ cbxnam.getSelectedItem());
                break;
                case 5 : sql ="SELECT     dbo.tbNguyenNhan.TenNN as 'Tên Nguyên Nhân Nghèo',COUNT(distinct dbo.tbHoNgheo.IDHoNgheo) as 'Số Hộ ',COUNT(distinct IDKhauNgheo) as 'Số Khẩu '\n" +
"FROM       dbo.tbDanhSachHN,dbo.tbHoNgheo,dbo.tbNguyenNhan,dbo.tbKhauNgheo,dbo.tbHuyen,dbo.tbXa\n" +
"WHERE		dbo.tbDanhSachHN.IDHoNgheo=dbo.tbHoNgheo.IDHoNgheo\n" +
"and			dbo.tbNguyenNhan.IDNguyenNhan=dbo.tbHoNgheo.IDnguyenNhan\n" +
"and			dbo.tbXa.IDHuyen=dbo.tbHuyen.IDHuyen\n" +
"and			dbo.tbHoNgheo.IDXa=dbo.tbXa.IDXa\n" +
"and			NamNgheo=" +Integer.parseInt(cbxnam.getSelectedItem().toString())+diaban+
"GROUP BY dbo.tbNguyenNhan.TenNN,dbo.tbDanhSachHN.NamNgheo";
                txttieude.setText("BÁO CÁO SỐ HỘ NGHÈO VÀ KHẨU NGHÈO THEO NGUYÊN NHÂN NGHÈO "+tieude+ cbxnam.getSelectedItem());
                    break;
                default : break;
        }
        QLCanBo.LoadData(sql, tbbaocaosl);
    }//GEN-LAST:event_btxuatbcActionPerformed

    private void cbxgiatriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxgiatriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxgiatriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btxuatbc;
    private javax.swing.JComboBox<String> cbxgiatri;
    private javax.swing.JComboBox<String> cbxloaibc;
    private javax.swing.JComboBox<String> cbxnam;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbaocaosl;
    private javax.swing.JLabel txttieude;
    // End of variables declaration//GEN-END:variables
}
