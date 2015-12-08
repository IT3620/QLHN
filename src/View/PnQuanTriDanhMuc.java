
package View;
import Control.QLCanBo;
import Model.CanBo;
import Model.CoSoDuLieu;
import Model.DanhMuc;
import Model.DiaBan;
import Model.HeThong;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class PnQuanTriDanhMuc extends javax.swing.JPanel {
    private static CanBo userInfo;
    String sql;

    public PnQuanTriDanhMuc(CanBo userInfo) {
        this.userInfo = userInfo;
        initComponents();
        QLCanBo.layThongTinHeThong();
        showcbxxa();
        showbtn();
    }
    public int cbxindex(JComboBox cbx){
        return cbx.getSelectedIndex();
    }
    public void showbtn(){
        btnsua.setVisible(false);
        btnthem.setVisible(false);
        btnxoa.setVisible(false);
        tbdanhmuc.setVisible(false);
    }
    public void showcbxxa()
    {
        if(cbxindex(cbxdanhmuc)==1)
        {
            cbxhuyen.setVisible(true);
            cbxkhuvuc.setVisible(true);
        }
            
        else 
        {
            cbxhuyen.setVisible(false);
            cbxkhuvuc.setVisible(false);
        }
        loadDanhSachHuyen();
    }
     public void loadDanhSachHuyen() {
        ArrayList<DanhMuc> dsHuyen = QLCanBo.layDanhSachHuyen();
        cbxhuyen.removeAllItems();        
        if (dsHuyen != null)
        for (DanhMuc huyen : dsHuyen)
            cbxhuyen.addItem(huyen.id + "." + huyen.ten);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxdanhmuc = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdanhmuc = new javax.swing.JTable();
        cbxhuyen = new javax.swing.JComboBox();
        txtid = new javax.swing.JLabel();
        txtnoidungnhan = new javax.swing.JLabel();
        txtid1 = new javax.swing.JTextField();
        txtnoidung = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        cbxkhuvuc = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxdanhmuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Danh mục huyện", "Danh mục xã", "Danh mục dân tộc", "Danh mục đối tượng", "Danh mục khu vực", "Danh mục nghề nghiệp", "Danh mục nguyên nhân nghèo", "Danh mục nhà ở", "Danh mục nước sinh hoạt", "Danh mục quan hệ với chủ hộ" }));
        cbxdanhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxdanhmucActionPerformed(evt);
            }
        });
        add(cbxdanhmuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 43, 355, -1));

        tbdanhmuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbdanhmuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdanhmucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdanhmuc);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 100, 590, 180));

        add(cbxhuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 160, -1));

        txtid.setText("ID danh mục");
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 103, 78, -1));

        txtnoidungnhan.setText("Tên danh mục");
        add(txtnoidungnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 141, 78, -1));

        txtid1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtid1MouseClicked(evt);
            }
        });
        add(txtid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 100, 259, -1));
        add(txtnoidung, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 138, 259, -1));

        btnthem.setText("Thêm danh mục");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        add(btnthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        btnxoa.setText("Sửa danh mục");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });
        add(btnxoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, -1, -1));

        btnsua.setText("Xóa danh mục");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });
        add(btnsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        cbxkhuvuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nông Thôn", "Thành Thị" }));
        add(cbxkhuvuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 160, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN TRỊ DANH MỤC");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 580, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cbxdanhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxdanhmucActionPerformed
        // TODO add your handling code here:
         btnsua.setVisible(true);
        btnthem.setVisible(true);
        btnxoa.setVisible(true);
        tbdanhmuc.setVisible(true);
        btnsua.setEnabled(false);
        btnxoa.setEnabled(false);
        txtnoidung.setText("");
        txtid1.setText("");
        switch(cbxindex(cbxdanhmuc))
        {
            case 0 : 
                txtid.setText("ID Huyện");
                txtnoidungnhan.setText("Tên Huyện");
                break;
            case 1 :
                txtid.setText("ID Xã");
            txtnoidungnhan.setText("Tên Xã");
                break;
            case 2 :
                txtid.setText("ID Dân Tộc");
                txtnoidungnhan.setText("Tên Dân Tộc");
                break;
            case 3 : 
                 txtid.setText("ID Đối Tượng");
                 txtnoidungnhan.setText("Tên Đối Tượng");
                break;
            case 4 : 
                txtid.setText("ID  Khu Vực");
                txtnoidungnhan.setText("Tên Khu Vực");
                break;
            case 5 :
                txtid.setText("ID Nghề Nghiệp");
                txtnoidungnhan.setText("Tên Nghề Nghiệp");
                break;
            case 6 :
                txtid.setText("ID Nguyên Nhân Nghèo");
            txtnoidungnhan.setText("Tên Nguyên Nhân Nghèo");
                break ;
            case 7 :
            txtid.setText("ID Nhà Ở");
            txtnoidungnhan.setText("Tên Nhà Ở");
                break ;
            case 8 :
             txtid.setText("ID Nước SH");
            txtnoidungnhan.setText("Tên Nước SH");  
                break;
            case 9 :
            txtid.setText("ID Quan Hệ Với Chủ Hộ");
            txtnoidungnhan.setText("Tên Quan Hệ");
                break;
        }
        sql=CoSoDuLieu.selectdanhmuc(cbxindex(cbxdanhmuc));
       CoSoDuLieu.LoadData(sql, tbdanhmuc);
       showcbxxa();
    }//GEN-LAST:event_cbxdanhmucActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        if(txtid1.getText().length()==0) JOptionPane.showMessageDialog(this, "Bạn không được bỏ trống ID danh mục ","Thông Báo",2);
        else if(txtnoidung.getText().length()==0) JOptionPane.showMessageDialog(this, "Bạn không được bỏ trống tên danh mục ","Thông Báo",2);
        else {
        boolean rvl = false;
        switch(cbxindex(cbxdanhmuc))
        {
            case 0: rvl = CoSoDuLieu.themhuyen(txtid1.getText(),txtnoidung.getText());
                break ;
            case 1: rvl = CoSoDuLieu.themxa(txtid1.getText(), txtnoidung.getText(), cbxhuyen.getSelectedIndex()+1, cbxkhuvuc.getSelectedIndex()+1);
                break;
            case 2 :
                rvl = CoSoDuLieu.themdanhmuc(2, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 3 :
                rvl = CoSoDuLieu.themdanhmuc(3, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 4 :
                rvl = CoSoDuLieu.themdanhmuc(4, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 5 :
                rvl = CoSoDuLieu.themdanhmuc(5, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 6 :
                rvl = CoSoDuLieu.themdanhmuc(6, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 7 :
                rvl = CoSoDuLieu.themdanhmuc(7, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 8 :
                rvl = CoSoDuLieu.themdanhmuc(8, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            case 9 :
                rvl = CoSoDuLieu.themdanhmuc(9, Integer.parseInt(txtid1.getText()),txtnoidung.getText());
                break ;
            default:
                rvl = false ;
                    break;
        }
       QLCanBo.LoadData(sql, tbdanhmuc);
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        if(txtid1.getText().length()==0) JOptionPane.showMessageDialog(this, "Bạn chưa chọn danh mục cần xóa","Thông Báo",2);
        int ID = Integer.parseInt(tbdanhmuc.getModel().getValueAt(tbdanhmuc.getSelectedRow(), 0).toString());
        
       CoSoDuLieu.xodanhmuc((cbxindex(cbxdanhmuc)), ID);
        QLCanBo.LoadData(sql, tbdanhmuc);
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        if(txtid1.getText().length()==0) JOptionPane.showMessageDialog(this, "Bạn không được bỏ trống ID danh mục ","Thông Báo",2);
        else if(txtnoidung.getText().length()==0) JOptionPane.showMessageDialog(this, "Bạn không được bỏ trống tên danh mục ","Thông Báo",2);
        else {
        int ID = Integer.parseInt(tbdanhmuc.getModel().getValueAt(tbdanhmuc.getSelectedRow(), 0).toString());
        if(cbxdanhmuc.getSelectedIndex()==1)
        CoSoDuLieu.suaxa(ID, txtnoidung.getText(), cbxhuyen.getSelectedIndex()+1, cbxkhuvuc.getSelectedIndex()+1);
        CoSoDuLieu.suadanhmuc(cbxindex(cbxdanhmuc), ID, this.txtnoidung.getText());
        QLCanBo.LoadData(sql, tbdanhmuc);
    }//GEN-LAST:event_btnxoaActionPerformed
    }
    private void tbdanhmucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdanhmucMouseClicked
        // TODO add your handling code here:
        btnsua.setEnabled(true);
        btnxoa.setEnabled(true);
        txtid1.setText(tbdanhmuc.getModel().getValueAt(tbdanhmuc.getSelectedRow(), 0).toString());
        txtnoidung.setText(tbdanhmuc.getModel().getValueAt(tbdanhmuc.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tbdanhmucMouseClicked

    private void txtid1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtid1MouseClicked
        // TODO add your handling code here:
        txtid1.setText("");
        txtnoidung.setText("");
    }//GEN-LAST:event_txtid1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox cbxdanhmuc;
    private javax.swing.JComboBox cbxhuyen;
    private javax.swing.JComboBox cbxkhuvuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbdanhmuc;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtnoidung;
    private javax.swing.JLabel txtnoidungnhan;
    // End of variables declaration//GEN-END:variables
}
