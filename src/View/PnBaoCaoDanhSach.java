
package View;
import Control.QLCanBo;
import Model.CanBo;
import Model.DanhMuc;
import Model.DiaBan;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class PnBaoCaoDanhSach extends javax.swing.JPanel {
    private CanBo userInfo;
    private  String sql ="";
    String strhuyen;
    String strxa;
    public PnBaoCaoDanhSach(CanBo userInfo) {
      this.userInfo = userInfo;
        initComponents();
        loadDanhSachHuyen();
       ShowCT();       
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
    public void ShowCT()
    {
       
        if(userInfo.getCapQL()==1){
        this.txtbaocaods.setText("BÁO CÁO DANH SÁCH HỘ NGHÈO TỈNH ");
        sql = "SELECT     dbo.tbHoNgheo.IDHoNgheo as 'Mã hộ nghèo', dbo.tbHoNgheo.TenCH as 'Tên chủ hộ', dbo.tbHoNgheo.Xom as 'Thôn/Xóm', dbo.tbXa.TenXa as 'Xã', dbo.tbHuyen.TenHuyen as 'Huyện', dbo.tbKhuVuc.TenKhuVuc as 'Khu vực', dbo.tbPhanLoai.TenPL as 'Phân loại', \n" +
"                      dbo.tbDanToc.TenDT as 'Dân tộc',dbo.tbDanhSachHN.NamNgheo as 'Năm nghèo'\n" +
"FROM         dbo.tbDanhSachHN INNER JOIN\n" +
"                      dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
"                      dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
"                      dbo.tbPhanLoai ON dbo.tbHoNgheo.IDPhanLoai = dbo.tbPhanLoai.IDPhanLoai INNER JOIN\n" +
"                      dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
"                      dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc INNER JOIN\n" +
"                      dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen " ;
        }
        else if(userInfo.getCapQL()==2)
        {
            cbxhuyen.setEnabled(false);
            cbxhuyen.setSelectedIndex(userInfo.getDiaBanQL());
            strhuyen = getIDStr(cbxhuyen).toUpperCase();
            this.txtbaocaods.setText("BÁO CÁO DANH SÁCH HỘ NGHÈO HUYỆN "+strhuyen);
          sql = "SELECT     dbo.tbHoNgheo.IDHoNgheo as 'Mã hộ nghèo', dbo.tbHoNgheo.TenCH as 'Tên chủ hộ', dbo.tbHoNgheo.Xom as 'Thôn/Xóm', dbo.tbXa.TenXa as 'Xã', dbo.tbKhuVuc.TenKhuVuc as 'Khu vực', dbo.tbPhanLoai.TenPL as 'Phân loại', \n" +
"                      dbo.tbDanToc.TenDT as 'Dân tộc',dbo.tbDanhSachHN.NamNgheo as 'Năm nghèo'\n" +
"FROM         dbo.tbDanhSachHN INNER JOIN\n" +
"                      dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
"                      dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
"                      dbo.tbPhanLoai ON dbo.tbHoNgheo.IDPhanLoai = dbo.tbPhanLoai.IDPhanLoai INNER JOIN\n" +
"                      dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
"                      dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc INNER JOIN\n" +
"                      dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen\n" +
"                      and dbo.tbHuyen.IDHuyen = "+userInfo.getDiaBanQL();
        }
        else {
            sql = "SELECT     dbo.tbHoNgheo.IDHoNgheo as 'Mã hộ nghèo', dbo.tbHoNgheo.TenCH as 'Tên chủ hộ', dbo.tbHoNgheo.Xom as 'Thôn/Xóm', dbo.tbXa.TenXa as 'Xã', dbo.tbKhuVuc.TenKhuVuc as 'Khu vực', dbo.tbPhanLoai.TenPL as 'Phân loại', \n" +
"                      dbo.tbDanToc.TenDT as 'Dân tộc',dbo.tbDanhSachHN.NamNgheo as 'Năm nghèo'\n" +
"FROM         dbo.tbDanhSachHN INNER JOIN\n" +
"                      dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
"                      dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
"                      dbo.tbPhanLoai ON dbo.tbHoNgheo.IDPhanLoai = dbo.tbPhanLoai.IDPhanLoai INNER JOIN\n" +
"                      dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
"                      dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc INNER JOIN\n" +
"                      dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen\n" +
"                      and dbo.tbXa.IDXa ="+userInfo.getDiaBanQL();
        cbxhuyen.setEnabled(false);
            DiaBan db = QLCanBo.layDiaBan(3, userInfo.getDiaBanQL());
            cbxhuyen.setSelectedIndex(db.getHuyen().id);
            cbxxa.setSelectedIndex(userInfo.getDiaBanQL());
            cbxxa.setEnabled(false);
            strxa= getIDStr(cbxxa).toUpperCase();;
            this.txtbaocaods.setText("BÁO CÁO DANH SÁCH HỘ NGHÈO XÃ");
        }
                QLCanBo.LoadData(sql, tbbaocaodanhsach);
                this.txtnam.setText(""+Model.HeThong.namNgheo);
    }
  
    public void ShowBaoCao()
    {
        String huyen, xa, nam;
        if (txtnam.getText().equals(""))
            nam = "";
        else
            nam = "NamNgheo = " + Integer.parseInt(txtnam.getText()) + " AND ";
        
        if (cbxhuyen.getSelectedIndex() == 0)
            huyen = "";
        else
            huyen = "dbo.tbHuyen.IDHuyen = " + getIDInt(cbxhuyen) + " AND ";
        
        if (cbxxa.getSelectedIndex() == 0)
            xa = "";
        else
            xa = "dbo.tbXa.IDXa = " + getIDInt(cbxxa) + " AND ";
        
        String sql = "SELECT     dbo.tbHoNgheo.IDHoNgheo, dbo.tbHoNgheo.TenCH, dbo.tbHoNgheo.Xom, dbo.tbXa.TenXa, dbo.tbHuyen.TenHuyen, dbo.tbKhuVuc.TenKhuVuc, dbo.tbPhanLoai.TenPL, \n" +
"                      dbo.tbDanhSachHN.NamNgheo, dbo.tbDanToc.TenDT\n" +
"FROM         dbo.tbDanhSachHN INNER JOIN\n" +
"                      dbo.tbHoNgheo ON dbo.tbDanhSachHN.IDHoNgheo = dbo.tbHoNgheo.IDHoNgheo INNER JOIN\n" +
"                      dbo.tbDanToc ON dbo.tbHoNgheo.IDDanToc = dbo.tbDanToc.IDDanToc INNER JOIN\n" +
"                      dbo.tbPhanLoai ON dbo.tbHoNgheo.IDPhanLoai = dbo.tbPhanLoai.IDPhanLoai INNER JOIN\n" +
"                      dbo.tbXa ON dbo.tbHoNgheo.IDXa = dbo.tbXa.IDXa INNER JOIN\n" +
"                      dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc INNER JOIN\n" +
"                      dbo.tbHuyen ON dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen "
                + "WHERE " + xa + huyen + nam + " 1=1";
        QLCanBo.LoadData(sql, tbbaocaodanhsach);
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
        txtnam = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        tbbaocaodanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbbaocaodanhsach);

        cbxhuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhuyenActionPerformed(evt);
            }
        });

        jLabel3.setText("Huyện");

        jLabel4.setText("Xã");

        btnxuatbc.setText("Xuất báo cáo");
        btnxuatbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatbcActionPerformed(evt);
            }
        });

        txtbaocaods.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtbaocaods.setText("BẢNG BÁO CÁO DANH SÁCH");

        jLabel6.setText("Năm");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Báo cáo danh sách hộ nghèo", "Báo cáo danh sách hộ nghèo mới", "Báo cáo danh sách hộ thoát nghèo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxhuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxxa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnxuatbc, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtbaocaods, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxhuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cbxxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxuatbc)
                    .addComponent(jLabel6)
                    .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(txtbaocaods, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnxuatbc;
    private javax.swing.JComboBox cbxhuyen;
    private javax.swing.JComboBox cbxxa;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbaocaodanhsach;
    private javax.swing.JLabel txtbaocaods;
    private javax.swing.JTextField txtnam;
    // End of variables declaration//GEN-END:variables
}
