/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Control.DKCanBo;
import Entity.CanBo;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author thong
 */
public class FormCanBo extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private static PnThongTinHeThong pnThongTin;
    private static CanBo userInfo;
    private static PnThemHoNgheo pnThemHoNgheo;
    private static PnTimKiemHoNgheo pnTimKiem;

    public FormCanBo(CanBo userInfo) {
        this.userInfo = userInfo;
        initComponents();

        DKCanBo.layThongTinHeThong();
        if (userInfo.getCapQL() == 3)
            userInfo.setIdKhuVuc(DKCanBo.layKhuVuc(userInfo.getDiaBanQL()).id);
        
        for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }

        if (pnThongTin == null) {
            pnThongTin = new PnThongTinHeThong();
            pnNoiDung.add(pnThongTin);
            pnThongTin.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnThongTin.setVisible(true);
            pnNoiDung.validate();

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

        jMenuItem5 = new javax.swing.JMenuItem();
        pnNoiDung = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuThemHoNgheo = new javax.swing.JMenuItem();
        menuDieuChinhHoNgheo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(1920, 1280));
        setMinimumSize(new java.awt.Dimension(1044, 668));

        pnNoiDung.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnNoiDung.setMinimumSize(new java.awt.Dimension(893, 604));
        pnNoiDung.setPreferredSize(new java.awt.Dimension(900, 600));
        pnNoiDung.setLayout(new javax.swing.BoxLayout(pnNoiDung, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Thêm hộ nghèo");

        jButton2.setText("Tìm kiếm");

        jButton4.setText("Báo cáo");

        jButton5.setText("Báo cáo số liệu");

        jButton6.setText("Quản trị hệ thống");

        jMenu1.setText("Quản lý");

        menuThemHoNgheo.setText("Thêm hộ nghèo");
        menuThemHoNgheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThemHoNgheoActionPerformed(evt);
            }
        });
        jMenu1.add(menuThemHoNgheo);

        menuDieuChinhHoNgheo.setText("Điều chỉnh hộ nghèo");
        jMenu1.add(menuDieuChinhHoNgheo);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Tìm kiếm");

        jMenuItem2.setText("Tìm kiếm hộ nghèo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem4.setText("Tìm kiếm khẩu nghèo");
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("BC Danh sách");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("BC Số liệu");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("Quản trị");

        jMenuItem1.setText("Thông tin hệ thống");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnNoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, 1137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnNoiDung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addContainerGap(445, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuThemHoNgheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThemHoNgheoActionPerformed
        // TODO add your handling code here:

        if (userInfo.getCapQL() < 3 || !userInfo.isTrangThai()) {
            JOptionPane.showMessageDialog(this, "Bạn không có thêm hộ nghèo");
            return;
        }
        for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }

        if (pnThemHoNgheo == null) {
            pnThemHoNgheo = new PnThemHoNgheo(userInfo);
            pnNoiDung.add(pnThemHoNgheo);
            pnThemHoNgheo.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnThemHoNgheo.setVisible(true);
            pnNoiDung.validate();
        }
    }//GEN-LAST:event_menuThemHoNgheoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }

        if (pnThongTin == null) {
            pnThongTin = new PnThongTinHeThong();
            pnNoiDung.add(pnThongTin);
            pnThongTin.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnThongTin.setVisible(true);
            pnNoiDung.validate();

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }
        
        if (pnTimKiem == null) {
            pnTimKiem = new PnTimKiemHoNgheo(userInfo);
            pnNoiDung.add(pnTimKiem);
            pnTimKiem.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnTimKiem.setVisible(true);
            pnNoiDung.validate();
        } 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormCanBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCanBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCanBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCanBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCanBo(userInfo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menuDieuChinhHoNgheo;
    private javax.swing.JMenuItem menuThemHoNgheo;
    private javax.swing.JPanel pnNoiDung;
    // End of variables declaration//GEN-END:variables
}
