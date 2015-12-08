
package View;

import Control.QLCanBo;
import Model.CanBo;
import Model.CoSoDuLieu;
import Model.DanhMuc;
import Model.DiaBan;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PnQuanTriNguoiDung extends javax.swing.JPanel {
    private CanBo canbo;
    String sql="";
    public PnQuanTriNguoiDung(CanBo userInfo) {
        this.canbo = userInfo;
        initComponents();
        shownguoidung();
        txtmk.setVisible(false);
        txtmklabel.setVisible(false);
        showbtn();
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
    }
    private void showbtn(){
        if(txtmacb.getText().length()!=0)
        {
            btnsua.setEnabled(true);
            btnxoa.setEnabled(true);
        }
        else 
            {
           btnsua.setEnabled(false);
            btnxoa.setEnabled(false);
        }
    }
    private int getIDInt(JComboBox cbx) {
        if (cbx.getSelectedIndex() == 0)
            return 0;
        return Integer.parseInt(cbx.getSelectedItem().toString().split("\\.")[0]);
    }

    public void loadDanhSachHuyen() {
        ArrayList<DanhMuc> dsHuyen = QLCanBo.layDanhSachHuyen();
        cbxhuyen.removeAllItems();
        cbxhuyen.addItem("Chọn huyện");
        if (dsHuyen != null)
        for (DanhMuc huyen : dsHuyen)
            cbxhuyen.addItem(huyen.id + "." + huyen.ten);
    }
     public void loadDanhSachXa(int huyen) {
        ArrayList<DanhMuc> dsXa = QLCanBo.layDanhSachXa(huyen);
        cbxxa.removeAllItems();
        cbxxa.addItem("Chọn xã");
        if (dsXa != null)
            for (DanhMuc xa : dsXa) 
                cbxxa.addItem(xa.id + "." + xa.ten);
    }
     public void shownguoidung()
     {
        sql ="SELECT     IDCanBo AS 'Mã cán bộ', HoTen AS 'Họ Tên', CapQL AS 'Cấp Quản lý', DiaBanQL AS 'Mã địa bàn', TrangThai AS 'Trạng Thái' FROM         dbo.tbCanBo";
        QLCanBo.LoadData(sql, tbuser);
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbuser = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        cbxcapql = new javax.swing.JComboBox();
        cbxhuyen = new javax.swing.JComboBox();
        cbxxa = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtmacb = new javax.swing.JTextField();
        txtmklabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        CheckBox1 = new javax.swing.JCheckBox();
        txtmk = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN TRỊ NGƯỜI DÙNG");

        tbuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbuserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbuser);

        jButton1.setText("Thêm người dùng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa người dùng");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa thông tin");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        cbxcapql.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chọn cấp quản lý", "Cấp tỉnh", "Cấp huyện", "Cấp xã" }));

        cbxhuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhuyenActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã cán bộ");

        txtmklabel.setText("Mật khẩu");

        jLabel4.setText("Họ tên");

        CheckBox1.setText("Trạng Thái");

        jButton2.setText("Nhập mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxcapql, 0, 212, Short.MAX_VALUE)
                    .addComponent(cbxhuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxxa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmklabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtmacb, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txthoten)
                            .addComponent(txtmk))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnxoa)
                            .addComponent(btnsua)
                            .addComponent(CheckBox1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxcapql, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbxhuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cbxxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmacb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmklabel)
                            .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxhuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxhuyenActionPerformed
        // TODO add your handling code here:
         int idHuyen =getIDInt(cbxhuyen);
        loadDanhSachXa(idHuyen);
    }//GEN-LAST:event_cbxhuyenActionPerformed

    private void tbuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbuserMouseClicked
        // TODO add your handling code here:
        showbtn();
         txtmk.setVisible(false);
        txtmklabel.setVisible(false);
        CheckBox1.setSelected(tbuser.getValueAt(tbuser.getSelectedRow(),4 ).toString().equals("true"));
        txthoten.setText(tbuser.getModel().getValueAt(tbuser.getSelectedRow(), 1).toString());
        txtmacb.setText(tbuser.getModel().getValueAt(tbuser.getSelectedRow(), 0).toString());       
       cbxcapql.setSelectedIndex(Integer.parseInt(tbuser.getModel().getValueAt(tbuser.getSelectedRow(), 2).toString()));
       if(cbxcapql.getSelectedIndex()==2)
       {
           cbxhuyen.setSelectedIndex(Integer.parseInt(tbuser.getModel().getValueAt(tbuser.getSelectedRow(), 3).toString()));
       }
       else if(cbxcapql.getSelectedIndex()==3)
       {
           int idxa=Integer.parseInt(tbuser.getModel().getValueAt(tbuser.getSelectedRow(), 3).toString());
           int idhuyen= CoSoDuLieu.timhuyen(idxa);
           cbxhuyen.setSelectedIndex(idhuyen);
           cbxxa.setSelectedIndex(idxa);
       }
       else 
       {
           cbxhuyen.setSelectedIndex(0);
           cbxxa.setSelectedIndex(0);
       }
    }//GEN-LAST:event_tbuserMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtmk.setVisible(false);
        txtmklabel.setVisible(false);
        showbtn();
        int diaban=0;
        if(cbxcapql.getSelectedIndex()==1){
            diaban=1;
        }
        else if(cbxcapql.getSelectedIndex()==2)
        {
            diaban=cbxhuyen.getSelectedIndex();
        }
        else if(cbxcapql.getSelectedIndex()==3)
        {
            diaban=getIDInt(cbxxa);
        }
        if(diaban==0) JOptionPane.showMessageDialog(null, "Bạn chưa chọn địa bàn quản lý", "Thông báo", 2);
        else if(txtmacb.getText().length()==0) JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã cán bộ", "Thông báo", 2);
        else if(txtmk.getText().length()==0) JOptionPane.showMessageDialog(null, "Bạn chưa nhập mật khẩu", "Thông báo", 2);
        else if(txtmk.getText().length()==0) JOptionPane.showMessageDialog(null, "Bạn chưa nhập họ tên cán bộ", "Thông báo", 2);
        else CoSoDuLieu.themuser(cbxcapql.getSelectedIndex(),txtmacb.getText(), txtmk.getText(),txthoten.getText(),diaban, CheckBox1.isSelected());
        QLCanBo.LoadData(sql, tbuser);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        showbtn();
         txtmk.setVisible(false);
        txtmklabel.setVisible(false);
        if(txtmacb.getText().length()==0) JOptionPane.showMessageDialog(null, "Bạn chưa chọn người dùng cần xóa", "Thông Báo", 2);
        else CoSoDuLieu.xoauser(txtmacb.getText());
        QLCanBo.LoadData(sql, tbuser);
        
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
         txtmk.setVisible(false);
        txtmklabel.setVisible(false);
        showbtn();
        int diaban=0;
        if(cbxcapql.getSelectedIndex()==1){
            diaban=1;
        }
        else if(cbxcapql.getSelectedIndex()==2)
        {
            diaban=cbxhuyen.getSelectedIndex();
        }
        else if(cbxcapql.getSelectedIndex()==3)
        {
            diaban=getIDInt(cbxxa);
        }
        if(txtmacb.getText().length()==0) JOptionPane.showMessageDialog(null, "Bạn chưa chọn người dùng cần sửa", "Thông Báo", 2);
        else CoSoDuLieu.suauser(cbxcapql.getSelectedIndex(),txtmacb.getText(), txtmk.getText(),txthoten.getText(),diaban,CheckBox1.isSelected());
        QLCanBo.LoadData(sql, tbuser);
    }//GEN-LAST:event_btnsuaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtmk.setVisible(true);
        txtmk.setText(null);
        txtmklabel.setVisible(true);
        txthoten.setText(null);
        txtmacb.setText(null);
        CheckBox1.setSelected(false);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox1;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox cbxcapql;
    private javax.swing.JComboBox cbxhuyen;
    private javax.swing.JComboBox cbxxa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbuser;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmacb;
    private javax.swing.JPasswordField txtmk;
    private javax.swing.JLabel txtmklabel;
    // End of variables declaration//GEN-END:variables
}
