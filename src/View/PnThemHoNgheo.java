/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DanhMuc;
import Model.KhauNgheo;
import Model.CanBo;
import Model.HeThong;
import Model.DiaBan;
import Control.QLCanBo;
import Model.CanBoXa;
import Model.HoNgheo;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thong
 */
public final class PnThemHoNgheo extends javax.swing.JPanel {

    /**
     * Creates new form PnThemHoNgheo
     */
    private static CanBo canbo;
    private static JFrame father;
    private static HoNgheo hoNgheo;
    private static final ArrayList<KhauNgheo> listkn = new ArrayList<>();
    private static boolean themMoi = true;

    public PnThemHoNgheo(CanBo canbo) {
        this.canbo = canbo;

        initComponents();
        loadComBox();
        loadDiaBan();
        xemDanhSachKN();

        txtnamngheo.setText("" + HeThong.namNgheo);
        btchinhsua.setEnabled(false);

        if (canbo.isTrangThai() == false) {
            btchinhsua.setVisible(false);
            btthemhn.setVisible(false);
            btthemkn.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bạn hiện không có quyền thêm, liên hệ cấp quản trị cao hơn để biết thêm thông tin", "Thông báo", 2);
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

        cbxdantockn = new javax.swing.JComboBox();
        lbnghe = new javax.swing.JLabel();
        lbnamsinh = new javax.swing.JLabel();
        lbdantockn = new javax.swing.JLabel();
        lbgioitinh = new javax.swing.JLabel();
        cbxgioitinh = new javax.swing.JComboBox();
        cbxquanhe = new javax.swing.JComboBox();
        lbquanhe = new javax.swing.JLabel();
        txthotenkn = new javax.swing.JTextField();
        lbhotenkn = new javax.swing.JLabel();
        lbdskn = new javax.swing.JLabel();
        lbnhao = new javax.swing.JLabel();
        cbxnhao = new javax.swing.JComboBox();
        lbnguyennhan = new javax.swing.JLabel();
        cbxnguyennhan = new javax.swing.JComboBox();
        cbxnuoc = new javax.swing.JComboBox();
        cbDaCapThe = new javax.swing.JCheckBox();
        lbnuoc = new javax.swing.JLabel();
        txtthunhap = new javax.swing.JTextField();
        lbthunhap = new javax.swing.JLabel();
        txtnamngheo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbxkhuvuc = new javax.swing.JComboBox();
        cbxphanloai = new javax.swing.JComboBox();
        lbphanloai = new javax.swing.JLabel();
        cbxdantocch = new javax.swing.JComboBox();
        lbdantoc = new javax.swing.JLabel();
        lbhuyen = new javax.swing.JLabel();
        txtxa = new javax.swing.JTextField();
        txtxom = new javax.swing.JTextField();
        lbxa = new javax.swing.JLabel();
        txthuyen = new javax.swing.JTextField();
        lbkhuvuc = new javax.swing.JLabel();
        txthotench = new javax.swing.JTextField();
        lbhuy = new javax.swing.JButton();
        txtnamsinhkn = new javax.swing.JTextField();
        lbtench = new javax.swing.JLabel();
        lbdvthunhap = new javax.swing.JLabel();
        txtmahn = new javax.swing.JTextField();
        lbtieude = new javax.swing.JLabel();
        lbxom = new javax.swing.JLabel();
        btchinhsua = new javax.swing.JButton();
        lbxoakn = new javax.swing.JButton();
        btthemhn = new javax.swing.JButton();
        btthemkn = new javax.swing.JButton();
        lbdoituongcs = new javax.swing.JLabel();
        cbxnghenghiep = new javax.swing.JComboBox();
        cbxdoituong = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdanhsachkn = new javax.swing.JTable();
        lbmahn = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add(cbxdantockn, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 305, 125, -1));

        lbnghe.setText("Nghề nghiệp");
        add(lbnghe, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 308, 73, -1));

        lbnamsinh.setText("Năm Sinh");
        add(lbnamsinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(884, 270, -1, -1));

        lbdantockn.setText("Dân tộc");
        add(lbdantockn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 308, 81, -1));

        lbgioitinh.setText("Giới tính");
        add(lbgioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 270, 58, -1));

        cbxgioitinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1.Nam", "2.Nữ" }));
        add(cbxgioitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 267, 71, -1));

        add(cbxquanhe, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 267, 139, -1));

        lbquanhe.setText("Quan hệ với chủ hộ");
        add(lbquanhe, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 270, 109, -1));
        add(txthotenkn, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 267, 125, -1));

        lbhotenkn.setText("Họ tên");
        add(lbhotenkn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 81, -1));

        lbdskn.setBackground(new java.awt.Color(0, 0, 153));
        lbdskn.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbdskn.setText("Danh sách khẩu nghèo");
        add(lbdskn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 226, 1071, -1));

        lbnhao.setText("Nhà ở");
        add(lbnhao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, 81, -1));

        add(cbxnhao, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 125, 128, -1));

        lbnguyennhan.setText("Nguyên nhân nghèo");
        add(lbnguyennhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 128, -1, -1));

        add(cbxnguyennhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 125, 220, -1));

        add(cbxnuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 125, 154, -1));

        cbDaCapThe.setText("Đã cấp thẻ");
        add(cbDaCapThe, new org.netbeans.lib.awtextra.AbsoluteConstraints(827, 178, 100, -1));

        lbnuoc.setText("Nước sạch");
        add(lbnuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 128, 78, -1));

        txtthunhap.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtthunhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtthunhapFocusLost(evt);
            }
        });
        add(txtthunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 87, 100, -1));

        lbthunhap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbthunhap.setText("Thu nhập");
        add(lbthunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 90, 97, -1));

        txtnamngheo.setEditable(false);
        txtnamngheo.setBackground(new java.awt.Color(204, 204, 204));
        txtnamngheo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnamngheo.setEnabled(false);
        txtnamngheo.setFocusable(false);
        add(txtnamngheo, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 179, 128, -1));

        jLabel12.setText("Năm nghèo");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 81, -1));

        cbxkhuvuc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxkhuvuc.setEnabled(false);
        cbxkhuvuc.setFocusable(false);
        cbxkhuvuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxkhuvucActionPerformed(evt);
            }
        });
        add(cbxkhuvuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 87, 128, -1));

        cbxphanloai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxphanloai.setEnabled(false);
        cbxphanloai.setFocusable(false);
        add(cbxphanloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 139, -1));

        lbphanloai.setText("Phân Loại");
        add(lbphanloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 58, -1));

        add(cbxdantocch, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 87, 154, -1));

        lbdantoc.setText("Dân Tộc");
        add(lbdantoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 90, 78, -1));

        lbhuyen.setText("Huyện");
        add(lbhuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 52, -1));

        txtxa.setEditable(false);
        txtxa.setBackground(new java.awt.Color(204, 204, 204));
        txtxa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtxa.setEnabled(false);
        txtxa.setFocusable(false);
        add(txtxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 49, 108, -1));
        add(txtxom, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 49, 63, -1));

        lbxa.setText("Xã");
        add(lbxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 52, 32, -1));

        txthuyen.setEditable(false);
        txthuyen.setBackground(new java.awt.Color(204, 204, 204));
        txthuyen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txthuyen.setEnabled(false);
        txthuyen.setFocusable(false);
        add(txthuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 139, -1));

        lbkhuvuc.setText("Khu Vực");
        add(lbkhuvuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 81, -1));

        txthotench.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txthotenchFocusLost(evt);
            }
        });
        add(txthotench, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 49, 154, -1));

        lbhuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhuy.setText("Hủy");
        lbhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbhuyActionPerformed(evt);
            }
        });
        add(lbhuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 103, -1));
        add(txtnamsinhkn, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 267, 100, -1));

        lbtench.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbtench.setText("Tên chủ hộ");
        add(lbtench, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 52, 78, -1));

        lbdvthunhap.setText("000 VNĐ/Người/Tháng");
        add(lbdvthunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 110, -1));

        txtmahn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmahnFocusLost(evt);
            }
        });
        add(txtmahn, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 49, 128, -1));

        lbtieude.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtieude.setText("Thêm hộ nghèo");
        add(lbtieude, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 161, 27));

        lbxom.setText("Thôn/Xóm");
        add(lbxom, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 52, 97, -1));

        btchinhsua.setText("Chỉnh sửa");
        btchinhsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchinhsuaActionPerformed(evt);
            }
        });
        add(btchinhsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 343, 113, -1));

        lbxoakn.setText("Xóa");
        lbxoakn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbxoaknActionPerformed(evt);
            }
        });
        add(lbxoakn, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 343, 97, -1));

        btthemhn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btthemhn.setText("Thêm");
        btthemhn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemhnActionPerformed(evt);
            }
        });
        add(btthemhn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 562, 100, -1));

        btthemkn.setText("Thêm khẩu nghèo");
        btthemkn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemknActionPerformed(evt);
            }
        });
        add(btthemkn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 343, 129, -1));

        lbdoituongcs.setText("Đối tượng chính sách");
        add(lbdoituongcs, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 308, 126, -1));

        add(cbxnghenghiep, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 305, 139, -1));

        add(cbxdoituong, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 305, 220, -1));

        tbdanhsachkn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbdanhsachkn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdanhsachknMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdanhsachkn);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 384, 1090, 167));

        lbmahn.setText("Mã hộ nghèo");
        add(lbmahn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 81, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtthunhapFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtthunhapFocusLost
        // TODO add your handling code here:
        int tn;
        if (txtthunhap.getText().equals("")) {
            return;
        }
        try {
            tn = Integer.parseInt(txtthunhap.getText()) * 1000;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thu nhập phải là số nguyên theo đơn vị VNĐ");
            txtthunhap.setText("");
            return;
        }

        if (tn < 0) {
            JOptionPane.showMessageDialog(this, "Thu nhập không hợp lệ");
            txtthunhap.setText("");
            return;
        }

        if (canbo.getIdKhuVuc() == 1) {
            if (tn > HeThong.canNgheoNT) {
                JOptionPane.showMessageDialog(this, "Thu nhập không nằm trong đối tượng hộ nghèo hoặc cận nghèo");
                txtthunhap.setText("");
            } else if (tn <= HeThong.ngheoNT) {
                cbxphanloai.setSelectedIndex(0); //Ngheo NT
            } else {
                cbxphanloai.setSelectedIndex(1); //Can Ngheo NT
            }
        } else if (tn > HeThong.canNgheoTT) {
            JOptionPane.showMessageDialog(this, "Thu nhập không nằm trong đối tượng hộ nghèo hoặc cận nghèo");
            txtthunhap.setText("");
        } else if (tn <= HeThong.ngheoTT) {
            cbxphanloai.setSelectedIndex(2);
        } else {
            cbxphanloai.setSelectedIndex(3);
        }
    }//GEN-LAST:event_txtthunhapFocusLost

    private void cbxkhuvucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxkhuvucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkhuvucActionPerformed

    private void txthotenchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txthotenchFocusLost
        // TODO add your handling code here:
        txthotenkn.setText(txthotench.getText());
        cbxquanhe.setSelectedIndex(0);
    }//GEN-LAST:event_txthotenchFocusLost

    private void lbhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbhuyActionPerformed
        // TODO add your handling code here:
        xoaHienThi();
    }//GEN-LAST:event_lbhuyActionPerformed

    private void txtmahnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmahnFocusLost
        // TODO add your handling code here:
        if (txtmahn.getText().equals("")) {
            themMoi = false;
            btthemhn.setText("Thêm Mới");
            //lbkieuthem.setText("Thêm hộ nghèo mới");
        }

        try {
            int idHoNgheo = Integer.parseInt(txtmahn.getText());
            HoNgheo hoNgheo = canbo.layThongTinHN(idHoNgheo);
            if (hoNgheo == null) {
                JOptionPane.showMessageDialog(this, "Mã hộ nghèo không tồn tại", "Thông báo lỗi", 2);
                xoaHienThi();
            }
            hienThiHoNgheo(hoNgheo, idHoNgheo);

            themMoi = false;
            btthemhn.setText("Thêm Cũ");
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_txtmahnFocusLost

    private void btchinhsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btchinhsuaActionPerformed
        // TODO add your handling code here:
        if (txthotenkn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên khẩu nghèo");
            return;
        }
        if (txtnamsinhkn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập năm sinh khẩu nghèo");
            return;
        }

        try {
            if (Integer.parseInt(txtnamsinhkn.getText()) < HeThong.namNgheo - 130) {
                JOptionPane.showMessageDialog(this, "Năm sinh khẩu nghèo không hợp lệ");
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Năm sinh phải là số");
            txtnamsinhkn.setText("");
            return;
        }

        KhauNgheo khauNgheo = new KhauNgheo(txthotenkn.getText(), getIDInt(cbxquanhe), (getIDInt(cbxgioitinh) == 1), getIDInt(cbxdantocch),
                getIDInt(cbxnghenghiep), getIDInt(cbxdoituong), Integer.parseInt(txtnamsinhkn.getText()));

        int index = tbdanhsachkn.getSelectedRow();
        listkn.set(index, khauNgheo);
        xemDanhSachKN();
        tbdanhsachkn.clearSelection();
        btchinhsua.setEnabled(false);
    }//GEN-LAST:event_btchinhsuaActionPerformed

    private void lbxoaknActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbxoaknActionPerformed
        // TODO add your handling code here:
        int index = tbdanhsachkn.getSelectedRow();
        listkn.remove(index);
        xemDanhSachKN();
    }//GEN-LAST:event_lbxoaknActionPerformed

    private void btthemhnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemhnActionPerformed
        // TODO add your handling code here:
        try {
            if (txthotench.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chưa nhập họ tên chủ hộ");
                return;
            }

            if (txtxom.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chưa nhập xóm");
                return;
            }

            if (txtthunhap.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Chưa nhập mức thu nhập");
                return;
            }

            HoNgheo hoNgheo = new HoNgheo(txthotench.getText(), txtxom.getText(), canbo.getDiaBanQL(), getIDInt(cbxdantocch), getIDInt(cbxphanloai), Integer.parseInt(txtthunhap.getText()) * 1000, getIDInt(cbxnuoc), getIDInt(cbxnguyennhan), cbDaCapThe.isSelected() ? true : false, getIDInt(cbxnhao));
            for (KhauNgheo kn : listkn) {
                hoNgheo.themKN(kn);
            }

            if ((canbo instanceof CanBoXa) && canbo.isTrangThai()) {
                if (themMoi) {
                    int idHoNgheo = ((CanBoXa)canbo).themHoNgheo(hoNgheo);
                    if (idHoNgheo >= 0) {
                        if (((CanBoXa)canbo).themVaoDanhSachHN(idHoNgheo, HeThong.namNgheo)) {
                            JOptionPane.showMessageDialog(this, "Đã thêm thành công hộ nghèo, mã hộ nghèo là:  " + idHoNgheo, "Thêm hộ nghèo thành công", 1);
                            txtmahn.setText("" + idHoNgheo);
                            listkn.clear();
                        }
                    }
                } else {
                    int idHoNgheo = Integer.parseInt(txtmahn.getText());
                    if (!((CanBoXa)canbo).themVaoDanhSachHN(idHoNgheo, HeThong.namNgheo)) {
                        JOptionPane.showMessageDialog(this, "Hộ nghèo đã được thêm lại từ trước.", "Thất bại", 1);
                    } else if (((CanBoXa)canbo).suaHoNgheo(hoNgheo, idHoNgheo)) {
                        JOptionPane.showMessageDialog(this, "Đã thêm hộ nghèo cũ thành công", "Thành công", 1);
                    } else {
                        ((CanBoXa)canbo).xoaKhoiDanhSachHN(idHoNgheo, HeThong.namNgheo);
                        JOptionPane.showMessageDialog(this, "Kiểm tra lại thông tin hộ nghèo", "Thất bại", 1);
                    }

                }
            }

        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi xảy ra, không thể thêm hộ nghèo", "Thông báo lỗi", 2);
        }
    }//GEN-LAST:event_btthemhnActionPerformed

    private void btthemknActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemknActionPerformed
        // TODO add your handling code here:
        if (txthotenkn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên khẩu nghèo");
            return;
        }
        if (txtnamsinhkn.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập năm sinh khẩu nghèo");
            return;
        }

        try {
            if (Integer.parseInt(txtnamsinhkn.getText()) < HeThong.namNgheo - 130) {
                JOptionPane.showMessageDialog(this, "Năm sinh khẩu nghèo không hợp lệ");
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Năm sinh phải là số");
            txtnamsinhkn.setText("");
            return;
        }

        KhauNgheo khauNgheo = new KhauNgheo(txthotenkn.getText(), getIDInt(cbxquanhe), (getIDInt(cbxgioitinh) == 1), getIDInt(cbxdantocch),
                getIDInt(cbxnghenghiep), getIDInt(cbxdoituong), Integer.parseInt(txtnamsinhkn.getText()));
        listkn.add(khauNgheo);
        xemDanhSachKN();
    }//GEN-LAST:event_btthemknActionPerformed

    private void tbdanhsachknMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdanhsachknMouseClicked
        // TODO add your handling code here:
        int index = tbdanhsachkn.getSelectedRow();
        KhauNgheo khauNgheo = listkn.get(index);
        hienThiKhauNgheo(khauNgheo);
        btchinhsua.setEnabled(true);
    }//GEN-LAST:event_tbdanhsachknMouseClicked

    private void hienThiKhauNgheo(KhauNgheo khauNgheo) {
        txthotenkn.setText(khauNgheo.getHoTen());
        cbxquanhe.setSelectedIndex(khauNgheo.getIdQuanHeCH() - 1);
        cbxgioitinh.setSelectedIndex(khauNgheo.isGioiTinh() ? 0 : 1);
        txtnamsinhkn.setText("" + khauNgheo.getNamSinh());
        cbxdantockn.setSelectedIndex(khauNgheo.getIdDanToc() - 1);
        cbxnghenghiep.setSelectedIndex(khauNgheo.getIdNgheNghiep() - 1);
        cbxdoituong.setSelectedIndex(khauNgheo.getIdDoiTuong() - 1);
    }

    private void xoaHienThi() {
        txthotenkn.setText("");
        cbxquanhe.setSelectedIndex(0);
        cbxgioitinh.setSelectedIndex(0);
        txtnamsinhkn.setText("");
        cbxdantockn.setSelectedIndex(0);
        cbxnghenghiep.setSelectedIndex(0);
        cbxdoituong.setSelectedIndex(0);

        txtmahn.setText("");
        txthotench.setText("");
        txtxom.setText("");
        txtxa.setText("");
        txthuyen.setText("");
        cbxkhuvuc.setSelectedIndex(0);
        cbxdantocch.setSelectedIndex(0);
        txtthunhap.setText("");
        cbxphanloai.setSelectedIndex(0);
        cbxnhao.setSelectedIndex(0);
        cbxnuoc.setSelectedIndex(0);
        cbxnguyennhan.setSelectedIndex(0);
        txtnamngheo.setText("");
        cbDaCapThe.setSelected(false);

        listkn.clear();
        xemDanhSachKN();
    }

    public void hienThiHoNgheo(HoNgheo hoNgheo, int idHoNgheo) {
        if (idHoNgheo != 0) {
            txtmahn.setText("" + idHoNgheo);
        }
        txthotench.setText(hoNgheo.getTenCH());
        txtxom.setText(hoNgheo.getXom());
        DiaBan db = QLCanBo.layDiaBan(3, hoNgheo.getIdXa());
        txtxa.setText(db.getXa().ten);
        txthuyen.setText(db.getHuyen().ten);
        cbxkhuvuc.setSelectedIndex(canbo.getIdKhuVuc() - 1);
        cbxdantocch.setSelectedIndex(hoNgheo.getIdDanToc() - 1);
        txtthunhap.setText("" + hoNgheo.getThuNhapTB() / 1000);
        cbxphanloai.setSelectedIndex(hoNgheo.getIdPhanLoai() - 1);
        cbxnhao.setSelectedIndex(hoNgheo.getIdNhaO() - 1);
        cbxnuoc.setSelectedIndex(hoNgheo.getIdNuoc() - 1);
        cbxnguyennhan.setSelectedIndex(hoNgheo.getIdNguyenNhan() - 1);
        txtnamngheo.setText("" + HeThong.namNgheo);
        cbDaCapThe.setSelected(hoNgheo.isTrangThai());

        listkn.clear();
        listkn.addAll(hoNgheo.getListKN());
        xemDanhSachKN();
    }

    public void xemDanhSachKN() {
        Vector cols = new Vector();
        cols.addElement("Họ Tên");
        cols.addElement("Giới Tính");
        cols.addElement("Năm Sinh");
        cols.addElement("QH Với Chủ Hộ");
        cols.addElement("Đối tượng");
        cols.addElement("Nghề Nghiệp");

        Vector data = new Vector();
        for (KhauNgheo i : listkn) {
            Vector user = new Vector();
            user.addElement(i.getHoTen());
            user.addElement(i.isGioiTinh() ? "Nam" : "Nữ");
            user.addElement("" + i.getNamSinh());

            //-1 vi danh muc bat dau tu 0
            user.addElement(HeThong.dmQuanHe.get(i.getIdQuanHeCH() - 1).ten);
            user.addElement(HeThong.dmDoiTuong.get(i.getIdDoiTuong() - 1).ten);
            user.addElement(HeThong.dmNgheNghiep.get(i.getIdNgheNghiep() - 1).ten);

            data.add(user);
        }

        tbdanhsachkn.setModel(new MyTableModel(data, cols));
    }

    private String getIDStr(JComboBox cbx) {
        return cbx.getSelectedItem().toString().split("\\.")[0];
    }

    private int getIDInt(JComboBox cbx) {
        return Integer.parseInt(cbx.getSelectedItem().toString().split("\\.")[0]);
    }

    public void loadComBox() {
        for (DanhMuc i : HeThong.dmDanToc) {
            cbxdantocch.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmDoiTuong) {
            cbxdoituong.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmKhuVuc) {
            cbxkhuvuc.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmNgheNghiep) {
            cbxnghenghiep.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmNguyenNhan) {
            cbxnguyennhan.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmNhaO) {
            cbxnhao.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmNuoc) {
            cbxnuoc.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmPhanLoai) {
            cbxphanloai.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmQuanHe) {
            cbxquanhe.addItem(i.id + "." + i.ten);
        }
        for (DanhMuc i : HeThong.dmDanToc) {
            cbxdantockn.addItem(i.id + "." + i.ten);
        }
    }

    public void loadDiaBan() {
        DiaBan db = QLCanBo.layDiaBan(canbo.getCapQL(), canbo.getDiaBanQL());
        txthuyen.setText(db.getHuyen().ten);
        txtxa.setText(db.getXa().ten);
        cbxkhuvuc.setSelectedIndex(canbo.getIdKhuVuc() - 1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btchinhsua;
    private javax.swing.JButton btthemhn;
    private javax.swing.JButton btthemkn;
    private javax.swing.JCheckBox cbDaCapThe;
    private javax.swing.JComboBox cbxdantocch;
    private javax.swing.JComboBox cbxdantockn;
    private javax.swing.JComboBox cbxdoituong;
    private javax.swing.JComboBox cbxgioitinh;
    private javax.swing.JComboBox cbxkhuvuc;
    private javax.swing.JComboBox cbxnghenghiep;
    private javax.swing.JComboBox cbxnguyennhan;
    private javax.swing.JComboBox cbxnhao;
    private javax.swing.JComboBox cbxnuoc;
    private javax.swing.JComboBox cbxphanloai;
    private javax.swing.JComboBox cbxquanhe;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbdantoc;
    private javax.swing.JLabel lbdantockn;
    private javax.swing.JLabel lbdoituongcs;
    private javax.swing.JLabel lbdskn;
    private javax.swing.JLabel lbdvthunhap;
    private javax.swing.JLabel lbgioitinh;
    private javax.swing.JLabel lbhotenkn;
    private javax.swing.JButton lbhuy;
    private javax.swing.JLabel lbhuyen;
    private javax.swing.JLabel lbkhuvuc;
    private javax.swing.JLabel lbmahn;
    private javax.swing.JLabel lbnamsinh;
    private javax.swing.JLabel lbnghe;
    private javax.swing.JLabel lbnguyennhan;
    private javax.swing.JLabel lbnhao;
    private javax.swing.JLabel lbnuoc;
    private javax.swing.JLabel lbphanloai;
    private javax.swing.JLabel lbquanhe;
    private javax.swing.JLabel lbtench;
    private javax.swing.JLabel lbthunhap;
    private javax.swing.JLabel lbtieude;
    private javax.swing.JLabel lbxa;
    private javax.swing.JButton lbxoakn;
    private javax.swing.JLabel lbxom;
    private javax.swing.JTable tbdanhsachkn;
    private javax.swing.JTextField txthotench;
    private javax.swing.JTextField txthotenkn;
    private javax.swing.JTextField txthuyen;
    private javax.swing.JTextField txtmahn;
    private javax.swing.JTextField txtnamngheo;
    private javax.swing.JTextField txtnamsinhkn;
    private javax.swing.JTextField txtthunhap;
    private javax.swing.JTextField txtxa;
    private javax.swing.JTextField txtxom;
    // End of variables declaration//GEN-END:variables
}

class MyTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public MyTableModel(Vector data, Vector cols) {
        super(data, cols);
    }
}
