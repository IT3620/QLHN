/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Control.DKCanBo;
import Entity.CanBo;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
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
    private static PnBaoCaoDanhSach pnBaoCao;
    private static PnBaoCaoSoLieu pnBaoCaoSL;
    private static CanBo userInfo;
    private static PnThemHoNgheo pnThemHoNgheo;
    private static PnTimKiemHoNgheo pnTimKiem;

    public FormCanBo(CanBo userInfo) {
        this.userInfo = userInfo;
        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        
        DKCanBo.layThongTinHeThong();
        if (userInfo.getCapQL() == 3)
            userInfo.setIdKhuVuc(DKCanBo.layKhuVuc(userInfo.getDiaBanQL()).id);
        
        for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }

        if (pnThongTin == null) {
            pnThongTin = new PnThongTinHeThong(userInfo);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuThemHoNgheo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menubaocaodanhsach = new javax.swing.JMenuItem();
        menubaocaodanhsach1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý hộ nghèo - Nhóm 2");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(1920, 1280));
        setMinimumSize(new java.awt.Dimension(1044, 668));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnNoiDung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        pnNoiDung.setMinimumSize(new java.awt.Dimension(893, 604));
        pnNoiDung.setPreferredSize(new java.awt.Dimension(900, 600));
        pnNoiDung.setLayout(new javax.swing.BoxLayout(pnNoiDung, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(pnNoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 41, 1137, 631));

        jButton1.setText("Thêm hộ nghèo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 123, -1));

        jButton2.setText("Tìm kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 123, -1));

        jButton4.setText("Báo cáo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 123, -1));

        jButton5.setText("Báo cáo số liệu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, 123, -1));

        jButton6.setText("Quản trị hệ thống");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, 123, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nhóm 2");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 8, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Phần mềm quản lý hộ nghèo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 8, 200, -1));

        jMenu1.setText("Quản lý");

        menuThemHoNgheo.setText("Thêm hộ nghèo");
        menuThemHoNgheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThemHoNgheoActionPerformed(evt);
            }
        });
        jMenu1.add(menuThemHoNgheo);

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
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Báo cáo");

        menubaocaodanhsach.setText("Báo cáo danh sách");
        menubaocaodanhsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubaocaodanhsachActionPerformed(evt);
            }
        });
        jMenu2.add(menubaocaodanhsach);

        menubaocaodanhsach1.setText("Báo cáo số liệu");
        menubaocaodanhsach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubaocaodanhsach1ActionPerformed(evt);
            }
        });
        jMenu2.add(menubaocaodanhsach1);

        jMenuBar1.add(jMenu2);

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
            pnThongTin = new PnThongTinHeThong(userInfo);
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

    private void menubaocaodanhsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubaocaodanhsachActionPerformed
        // TODO add your handling code here:
          for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }
        
        if (pnBaoCao == null) {
            pnBaoCao = new PnBaoCaoDanhSach(userInfo);
            pnNoiDung.add(pnBaoCao);
            pnBaoCao.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnBaoCao.setVisible(true);
            pnNoiDung.validate();
        } 
    }//GEN-LAST:event_menubaocaodanhsachActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
          for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }

        if (pnThongTin == null) {
            pnThongTin = new PnThongTinHeThong(userInfo);
            pnNoiDung.add(pnThongTin);
            pnThongTin.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnThongTin.setVisible(true);
            pnNoiDung.validate();

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
            for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }
        
        if (pnBaoCao == null) {
            pnBaoCao = new PnBaoCaoDanhSach(userInfo);
            pnNoiDung.add(pnBaoCao);
            pnBaoCao.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnBaoCao.setVisible(true);
            pnNoiDung.validate();
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void menubaocaodanhsach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubaocaodanhsach1ActionPerformed
        // TODO add your handling code here:
          for (Component frmChild : pnNoiDung.getComponents()) {
            frmChild.setVisible(false);
        }
        
        if (pnBaoCaoSL == null) {
            pnBaoCaoSL = new PnBaoCaoSoLieu(userInfo);
            pnNoiDung.add(pnBaoCaoSL);
            pnBaoCaoSL.setVisible(true);
            pnNoiDung.validate();
        } else {
            pnBaoCaoSL.setVisible(true);
            pnNoiDung.validate();
        } 
    }//GEN-LAST:event_menubaocaodanhsach1ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem menuThemHoNgheo;
    private javax.swing.JMenuItem menubaocaodanhsach;
    private javax.swing.JMenuItem menubaocaodanhsach1;
    private javax.swing.JPanel pnNoiDung;
    // End of variables declaration//GEN-END:variables
}
