package View;
import Control.QLCanBo;
import Model.CanBo;
import Model.CoSoDuLieu;
import Model.DanhMuc;
import Model.DiaBan;
import Model.HeThong;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class PnBaoCaoDanhSach extends javax.swing.JPanel {
    private CanBo canbo;
    private  String sql1 ="";
    private  String sql2 ="";
    String strhuyen;
    String strxa;
    String phanloaidanhsach;
    public PnBaoCaoDanhSach(CanBo canbo) {
      this.canbo = canbo;
        initComponents();
        loadDanhSachHuyen();
        //ShowCT();     
        ShowBaoCao();
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
    }
    public int menudsindex(JComboBox cbx){
        return cbx.getSelectedIndex();
    }
    
    public void loadDanhSachHuyen() {
        ArrayList<DanhMuc> dsHuyen = QLCanBo.layDanhSachHuyen();
        cbxhuyen.removeAllItems();
        cbxhuyen.addItem("Tất cả");
        if (dsHuyen != null)
        for (DanhMuc huyen : dsHuyen)
            cbxhuyen.addItem(huyen.id + "." + huyen.ten);
    }
     private String getIDStr(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return null;
        return cbx.getSelectedItem().toString().split("\\.")[1];
    }
     private String getStrHoa(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return null;
        return cbx.getSelectedItem().toString().split("\\.")[1].toUpperCase();
    }
    public void loadDanhSachXa(int huyen) {
        ArrayList<DanhMuc> dsXa = QLCanBo.layDanhSachXa(huyen);
        cbxxa.removeAllItems();
        cbxxa.addItem("Tất cả");
        if (dsXa != null)
            for (DanhMuc xa : dsXa) 
                cbxxa.addItem(xa.id + "." + xa.ten);
    }
    private int getIDInt(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return 0;
        return Integer.parseInt(cbx.getSelectedItem().toString().split("\\.")[0]);
    }
  
    public void ShowBaoCao()
    {
         for (int i=HeThong.namNgheo; i>2010; i--)
             cbxnam.addItem(i);
         int namngheo = Integer.parseInt(cbxnam.getSelectedItem().toString());
        String loadcot="";
        if(canbo.getCapQL()==2)
        {
            loadcot ="dbo.tbXa.TenXa as 'Xã' ,";
        }
        if(canbo.getCapQL()==1)
        {
            loadcot ="dbo.tbXa.TenXa as 'Xã' ,dbo.tbHuyen.TenHuyen as 'Huyện',";
        }
        String showxa, showhuyen, huyen, xa; 
        String shownam = cbxnam.getSelectedItem().toString();
        
            
        
        if (cbxhuyen.getSelectedIndex() == 0)
            
        {
           huyen = "";
           showhuyen = "";
        }
        else
        {
            huyen = "dbo.tbHuyen.IDHuyen = " + getIDInt(cbxhuyen) + " AND ";
            showhuyen=" - HUYỆN " + getStrHoa(cbxhuyen);
        }
        
        if (cbxxa.getSelectedIndex() == 0)
        {
            xa = "";
            showxa ="";
        }
        else
        {
            xa = "dbo.tbXa.IDXa = " + getIDInt(cbxxa) + " AND ";
            showxa=" - XÃ " +getStrHoa(cbxxa);
        }
        String showtieude="";
        if(menudsindex(cbxloadfromds)==1)
        {
            sql2= " AND dbo.tbDanhSachHN.NamNgheo = " +namngheo+
"              AND (dbo.tbHoNgheo.IDHoNgheo NOT IN (SELECT     tbHoNgheo_1.IDHoNgheo\n" +
"							 FROM       dbo.tbDanhSachHN AS tbDanhSachHN_1 INNER JOIN dbo.tbHoNgheo AS tbHoNgheo_1 ON tbDanhSachHN_1.IDHoNgheo = tbHoNgheo_1.IDHoNgheo\n" +
"                            WHERE      tbDanhSachHN_1.NamNgheo ="+(namngheo-1)+"))";
            showtieude=" MỚI ";
        }
        else if(menudsindex(cbxloadfromds)==2)
        {
            sql2= " AND dbo.tbDanhSachHN.NamNgheo = " +(namngheo-1)+
"              AND (dbo.tbHoNgheo.IDHoNgheo NOT IN (SELECT     tbHoNgheo_1.IDHoNgheo\n" +
"							 FROM       dbo.tbDanhSachHN AS tbDanhSachHN_1 INNER JOIN dbo.tbHoNgheo AS tbHoNgheo_1 ON tbDanhSachHN_1.IDHoNgheo = tbHoNgheo_1.IDHoNgheo\n" +
"                            WHERE      tbDanhSachHN_1.NamNgheo ="+namngheo+"))";
            showtieude=" THOÁT NGHÈO ";
        }
        else {
            sql2 = " AND dbo.tbDanhSachHN.NamNgheo = " +namngheo;
        }
        
        sql1 = "SELECT     dbo.tbHoNgheo.IDHoNgheo as 'Mã hộ nghèo', dbo.tbHoNgheo.TenCH as 'Tên chủ hộ', dbo.tbHoNgheo.Xom as 'Thôn/Xóm',"+loadcot+" dbo.tbKhuVuc.TenKhuVuc as 'Khu vực', dbo.tbPhanLoai.TenPL as 'Phân loại',\n" +
"                      dbo.tbDanToc.TenDT as 'Dân tộc',dbo.tbDanhSachHN.NamNgheo as 'Năm nghèo'\n" +
"FROM         dbo.tbDanhSachHN INNER JOIN\n" +
"                      dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
"                      dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
"                      dbo.tbPhanLoai ON dbo.tbHoNgheo.IDPhanLoai = dbo.tbPhanLoai.IDPhanLoai INNER JOIN\n" +
"                      dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
"                      dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc INNER JOIN\n" +
"                    dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen\n" +
"                WHERE " +xa +huyen+ "1=1" +sql2;
        CoSoDuLieu.LoadData(sql1, tbbaocaodanhsach);
        this.txtbaocaods.setText("BẢNG DANH SÁCH HỘ NGHÈO "+showtieude+showxa+showhuyen+"-"+shownam );
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbbaocaodanhsach = new javax.swing.JTable();
        cbxhuyen = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxxa = new javax.swing.JComboBox();
        btnxuatbc = new javax.swing.JButton();
        txtbaocaods = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxloadfromds = new javax.swing.JComboBox();
        cbxnam = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbbaocaodanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tbbaocaodanhsach.setAlignmentX(10.0F);
        jScrollPane1.setViewportView(tbbaocaodanhsach);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, 1109, 475));

        cbxhuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhuyenActionPerformed(evt);
            }
        });
        add(cbxhuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 18, 150, -1));

        jLabel3.setText("Huyện");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 21, 54, -1));

        jLabel4.setText("Xã");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 21, 37, -1));

        cbxxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxxaActionPerformed(evt);
            }
        });
        add(cbxxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 18, 150, -1));

        btnxuatbc.setText("Xuất báo cáo");
        btnxuatbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatbcActionPerformed(evt);
            }
        });
        add(btnxuatbc, new org.netbeans.lib.awtextra.AbsoluteConstraints(974, 17, 145, -1));

        txtbaocaods.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbaocaods.setText("BẢNG BÁO CÁO DANH SÁCH");
        txtbaocaods.setAlignmentX(10.0F);
        add(txtbaocaods, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, 1109, 23));

        jLabel6.setText("Năm");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 21, 35, -1));

        cbxloadfromds.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Báo cáo danh sách hộ nghèo", "Báo cáo danh sách hộ nghèo mới", "Báo cáo danh sách hộ thoát nghèo" }));
        cbxloadfromds.setAlignmentX(10.0F);
        add(cbxloadfromds, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 195, -1));

        add(cbxnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 18, 72, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnxuatbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatbcActionPerformed
        // TODO add your handling code here:
        ShowBaoCao();
        
    }//GEN-LAST:event_btnxuatbcActionPerformed

    private void cbxhuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxhuyenActionPerformed
        // TODO add your handling code here:
        int idHuyen =getIDInt(cbxhuyen);
        loadDanhSachXa(idHuyen);
    }//GEN-LAST:event_cbxhuyenActionPerformed

    private void cbxxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxxaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxxaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnxuatbc;
    private javax.swing.JComboBox cbxhuyen;
    private javax.swing.JComboBox cbxloadfromds;
    private javax.swing.JComboBox cbxnam;
    private javax.swing.JComboBox cbxxa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbaocaodanhsach;
    private javax.swing.JLabel txtbaocaods;
    // End of variables declaration//GEN-END:variables
}
