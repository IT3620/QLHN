package View;

import Model.CanBo;
import Model.CoSoDuLieu;


public class PnBaoCaoSoLieu extends javax.swing.JPanel {
    private static CanBo canbo;
    private String where,showhuyen,showxa;
    public PnBaoCaoSoLieu(CanBo canbo) {
        PnBaoCaoSoLieu.canbo = canbo;
        initComponents();
        loadcombox();
    }
    public void loadcombox()
    {
        String[] menu = {"Tổng hợp số liệu hộ nghèo","Tổng hợp số liệu theo mức thu nhập",
                "Tổng hợp số liệu theo khu vực","Tổng hợp số liệu theo dân tộc",
                "Tổng hợp số liệu theo tình hình nhà ở","Tổng hợp số liệu theo đối tượng",
                "Tổng hợp số liệu theo đối tượng","Tổn hợp số liệu theo nguyên nhân nghèo",
                "Tổng hợp số liệu theo nguyện vọng"};
          for (int i=0; i<menu.length;i++)  
          {
              //cbxmenu.addItem(menu[i]);
          }
        for(int i=2015; i>= 1980 ;i-- )
        {
            //cbxnam.addItem(i);
        }       
    }
    public void loadDieuKienLoadDiaBan()
    {
        if(canbo.getCapQL()==1){
            where = "";
        }
        
        else if(canbo.getCapQL()==2)
            where = "dbo.tbHuyen.IDHuyen = "+canbo.getDiaBanQL();
        else where = "dbo.tbXa.IDxa = "+canbo.getDiaBanQL();
    }
    public void loaddulieu(String diaban)
    {
        String sql="";
//        if(cbxmenu.getSelectedIndex()==0)
//            sql="SELECT ";
        CoSoDuLieu.LoadData(sql, tbbaocaosl);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbbaocaosl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bảng báo cáo số liệu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbbaocaosl;
    // End of variables declaration//GEN-END:variables
}
