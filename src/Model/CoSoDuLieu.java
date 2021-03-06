package Model;

import Model.DanhMuc;
import Model.HeThong;
import Model.DiaBan;
import Model.HoNgheo;
import Model.KhauNgheo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CoSoDuLieu {

    private static Connection conn = getConnect();
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    public static String capql = null;
    public static String xa = null;
    public static String huyen = null;

    public static Connection getConnect() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:6789;instance=SQLEXPRESS;databaseName=QLHN", "sa", "1900100co");
            return conn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Thong bao", 2);
            return null;
        }
    }

    public static CanBo dangNhap(String ID, String matKhau) {
        String sql = "select * from QLHN.dbo.tbCanBo where IDCanBo='" + ID + "' and MatKhau ='" + matKhau + "'";
        try {
            conn = getConnect();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                int capQL = rs.getInt(4);
                if (capQL == 1) {
                    return new CanBoTinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getBoolean(6));
                } else if (capQL == 2) {
                    return new CanBoHuyen(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getBoolean(6));
                } else if (capQL == 3) {
                    return new CanBoXa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getBoolean(6));
                } else return null;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public static int timhuyen(int idxa)
    {
        int idhuyen=0;
        try
        {
            String sql ="SELECT     dbo.tbXa.IDHuyen FROM  dbo.tbHuyen INNER JOIN\n" +
"            dbo.tbXa ON dbo.tbHuyen.IDHuyen = dbo.tbXa.IDHuyen\n" +
"            where IDXa="+idxa;
            pst = conn.prepareStatement(sql);
            rs= pst.executeQuery();
            rs.next();
            idhuyen= Integer.parseInt(rs.getString(1));
        }
        catch(Exception ex)
        {     
        }
        return idhuyen;
    }
      public static boolean themdanhmuc(int IDbang , int id , String noidung) {
        try {
            String sql = "";
            String tenbang="", tenid="", tennd="";
            switch (IDbang) {              
                case 2:
                    tenbang = "dbo.tbDanToc";
                    tenid = "dbo.tbDanToc.IDDanToc";
                    tennd = "dbo.tbDanToc.TenDT"; 
                    break;
                case 3:
                    tenbang = "dbo.tbDoiTuong";
                    tenid = "dbo.tbDoiTuong.IDDoiTuong";
                    tennd = "dbo.tbDoiTuong.TenDoiTuong"; 
                    break;
                case 4 :
                    tenbang = "dbo.tbKhuVuc";
                    tenid = "dbo.tbKhuVuc.IDKhuVuc";
                    tennd = "dbo.tbKhuVuc.TenKhuVuc"; 
                    break;
                case 5 :
                    tenbang = "dbo.tbNgheNghiep";
                    tenid = "dbo.tbDanToc.IDNgheNghiep";
                    tennd = "dbo.tbDanToc.TenNN"; 
                    break;
                case 6 :
                    tenbang = "dbo.tbNguyenNhan";
                    tenid = "dbo.tbNguyenNhan.IDNguyenNhan";
                    tennd = "dbo.tbNguyenNhan.TenNN";   
                    break;
                case 7 : 
                    tenbang = "dbo.tbNhaO";
                    tenid = "dbo.tbNhaO.IDNhaO";
                    tennd = "dbo.tbNhaO.TenNhaO"; 
                    break;
                case 8 :
                    tenbang = "dbo.tbNuoc";
                    tenid = "dbo.tbNuoc.IDNuoc";
                    tennd = "dbo.tbNuoc.TenNuoc"; 
                    break;
                case 9 :
                    tenbang = "dbo.tbQuanHe";
                    tenid = "dbo.tbQuanHe.IDQuanHeCH";
                    tennd = "dbo.tbQuanHe.TenQH"; 
                    break;
                default :
                    break;
            }
            sql = "INSERT INTO " + tenbang + "(" + tenid + "," + tennd+")" + " values("+id+ ", " + "N'" + noidung+"')";
            pst = conn.prepareStatement(sql);         
            pst.executeUpdate();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static boolean themhuyen(String id , String noidung)
    {
        String sql="INSERT INTO dbo.tbHuyen (IDHuyen,TenHuyen,IDTinh) values ("+id+",N'"+noidung+"',1)";
        try {         
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
   }
    public static boolean themxa(String id, String noidung, int idhuyen, int idkhuvuc)
    {
        String sql ="INSERT INTO dbo.tbXa (IDXa,TenXa,IDHuyen,IDKhuVuc) values ("+id+",N'"+noidung+"',"+idhuyen+","+idkhuvuc+")";
         try {         
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public static String selectdanhmuc(int idbang)
    {
        String sql ="";
        String select=null;
        String tenbang=null;
        try{
                switch(idbang)
                {
                    case 0: select = "IDHuyen as 'Mã Huyện',TenHuyen as 'Tên Huyện'";
                            tenbang ="dbo.tbHuyen";
                        break;
                    case 1: select = "dbo.tbXa.IDXa as 'ID Xã', dbo.tbXa.TenXa as 'Tên Xã', dbo.tbHuyen.TenHuyen as 'Tên Huyện', dbo.tbKhuVuc.TenKhuVuc as 'Tên Khu Vực'";
                            tenbang =" dbo.tbHuyen INNER JOIN dbo.tbXa ON dbo.tbHuyen.IDHuyen = dbo.tbXa.IDHuyen INNER JOIN dbo.tbKhuVuc ON dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc ORDER BY dbo.tbXa.IDXa";
                        break;
                    case 2: select = "IDDanToc AS 'ID Dân Tộc', TenDT AS 'Tên Dân Tộc'";
                            tenbang="dbo.tbDanToc";
                        break;
                    case 3 : select = "IDDoiTuong as 'ID Đối tượng', TenDoiTuong as 'Tên đối tượng'";
                            tenbang= " dbo.tbDoiTuong";
                        break;
                    case 4 : select ="IDKhuVuc as 'ID Khu Vực', TenKhuVuc as 'Tên Khu Vực'";
                            tenbang="dbo.tbKhuVuc";
                        break;
                    case 5 : select ="IDNgheNghiep as 'ID Nghề Nghiệp', TenNN as 'Tên Nghề Nghiệp'";
                               tenbang ="dbo.tbNgheNghiep";
                               break;
                    case 6 : select ="IDNguyenNhan as 'ID Nguyên Nhân Nghèo', TenNN as 'Tên Nguyên Nhân Nghèo'";
                               tenbang ="dbo.tbNguyenNhan";
                               break;
                    case 7 : select ="IDNhaO as 'ID Nhà Ở', TenNhaO as 'Tên Nhà Ở'";
                               tenbang ="dbo.tbNhaO";
                               break;
                    case 8 :  select ="IDNuoc as 'ID Nươc', TenNuoc as 'Tên Loại Nước Sinh Hoạt'";
                               tenbang ="dbo.tbNuoc";
                               break;
                    case 9 :  select ="IDQuanHeCH as 'ID Quan Hệ', TenQH as 'Tên Quan Hệ'";
                               tenbang ="dbo.tbQuanHe";
                               break;
                    default : break;
                }
                 sql="SELECT "+select +"from "+tenbang;
                 pst = conn.prepareStatement(sql);
                pst.executeQuery();
                 return sql;
            }
        catch(Exception ex){
            return sql;
        }    
    }
    public static void xodanhmuc(int idbang, int id)
    {
        String sql="";
        String tenbang="";
          try {
              switch(idbang)
              {
                  case 0 : tenbang="dbo.tbHuyen where IDHuyen=";         
                      break;
                  case 1 : tenbang="dbo.tbXa where IDXa=";         
                      break;
                  case 2 : tenbang="dbo.tbDantoc where IDDanToc=";
                      break;
                  case 3 :  tenbang="dbo.tbDoiTuong where IDDoiTuong=";
                      break;
                  case 4 : tenbang="dbo.tbKhuVuc where IDKhuVuc=";
                      break;
                  case 5 : tenbang="dbo.tbNgheNghiep where IDNgheNghiep=";
                      break;
                  case 6 : tenbang="dbo.tbNguyenNhan where IDNguyenNhan=";
                      break;
                  case 7 : tenbang="dbo.tbNhaO where IDNhaO=";
                      break;
                  case 8 : tenbang="dbo.tbNuoc where IDNuoc=";
                      break;
                  case 9 : tenbang="dbo.tbQuanHe where IDQuanHeCH=";
                      break;
              }
            sql = "DELETE FROM "+tenbang + id;
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
        }
    }
    public static void suadanhmuc(int bang, int idcot, String tendanhmuc)
    {
        String sql="";
        String tenbang="";
        String Tendm="";
        String IDdm="";
        try
        {
            switch(bang)
            {
                case 0 : tenbang="dbo.tbHuyen";
                         Tendm="TenHuyen";
                         IDdm="IDHuyen";
                    break;
                case 2 : tenbang="dbo.tbDanToc";
                        Tendm="TenDT";
                        IDdm="IDDanToc";
                    break;
                case 3 : tenbang="dbo.tbDoiTuong";
                        Tendm="TenDoiTuong";
                        IDdm="IDDoiTuong";
                    break;
                case 4 : tenbang="dbo.tbKhuVuc";
                        Tendm="TenKhuVuc";
                        IDdm="IDKhuVUc";
                    break;
                case 5 : tenbang="dbo.tbNgheNghiep";
                        Tendm="TenNN";
                        IDdm="IDNgheNghiep";
                    break;
                case 6 : tenbang="dbo.tbNguyenNhan";
                        Tendm="TenNN";
                        IDdm="IDNguyenNhan";
                    break;
                 case 7 : tenbang="dbo.tbNhaO";
                        Tendm="TenNhaO";
                        IDdm="IDNhaO";
                    break;
                 case 8 : tenbang="dbo.tbNuoc";
                        Tendm="TenNuoc";
                        IDdm="IDNuoc";
                    break;
                 case 9 : tenbang="dbo.tbQuanHe";
                        Tendm="TenQuanHe";
                        IDdm="IDQuanHeCH";
                    break;
                 default : break;
            }
            sql="UPDATE "+tenbang+" SET "+Tendm+"= N'"+tendanhmuc+"' where "+IDdm+"="+idcot;
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        }
        catch(Exception ex)
        { 
        }
    }
    public static void suaxa(int idxa, String tenxa, int idhuyen, int idkhuvuc)
    {
        try
        {
            String sql ="Update dbo.tbXa set TenXa=N'"+tenxa+"',"+"IDHuyen="+idhuyen+",IDKhuVuc="+idkhuvuc+" where IDXa="+idxa;
            pst= conn.prepareStatement(sql);
            pst.executeUpdate();
        }
        catch(Exception ex)
                {
                    
                }
    }    
//     public static boolean selectDanhMuc()
//     {
//         
//     }
    public static void LoadData(String sql, JTable tb) {
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            int col = rsmd.getColumnCount();
            Vector cols = new Vector();
            for (int i=1; i<= col; i++) {
                cols.add(rsmd.getColumnName(i));
            }
            
            Vector data = new Vector();
            while (rs.next()) {
                Vector row = new Vector();
                for (int i=1; i<= col; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            
            tb.setModel(new MyTableModel(data, cols));
            //tb.setModel((DbUtils.resultSetToTableModel(rs)));
            // ngay chỗ này là nạp dữ liệu lên bảng mà mình truyền vào
        } catch (Exception e) {
        }
    }

    public static int themHoNgheo(HoNgheo hoNgheo) {
        try {
            String sql = "INSERT INTO dbo.tbHoNgheo(TenCH, Xom, IDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, IDNhaO, TrangThai) "
                    + "VALUES(N'" + hoNgheo.getTenCH() + "', N'" + hoNgheo.getXom() + "', " + hoNgheo.getIdXa() + ", " + hoNgheo.getIdDanToc() + ","
                    + hoNgheo.getIdPhanLoai() + ", " + hoNgheo.getThuNhapTB() + ", " + hoNgheo.getIdNuoc() + ", " + hoNgheo.getIdNguyenNhan() + ", "
                    + hoNgheo.getIdNhaO() + ", " + (hoNgheo.isTrangThai() ? 1 : 0) + ")";
            pst = conn.prepareStatement(sql, new String[]{"IDHoNgheo"});
            pst.executeUpdate();

            rs = pst.getGeneratedKeys();
            rs.next();
            int idHoNgheo = rs.getInt(1);

            for (KhauNgheo khauNgheo : hoNgheo.getListKN()) {
                themKhauNgheo(khauNgheo, idHoNgheo);
            }
            return idHoNgheo;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, không thể thêm hộ nghèo vào cơ sở dữ liệu", "Thông báo lỗi", 2);
            return -1;
        }
    }

    public static void themKhauNgheo(KhauNgheo khauNgheo, int idHoNgheo) {
        try {
            String sql = "INSERT INTO dbo.tbKhauNgheo(IDHoNgheo, HoTen, IDQuanHeCH, GioiTinh, NamSinh, IDDanToc, IDNgheNghiep, IDDoiTuong) "
                    + "VALUES (" + idHoNgheo + ", N'" + khauNgheo.getHoTen() + "', " + khauNgheo.getIdQuanHeCH() + ", " + (khauNgheo.isGioiTinh() ? 1 : 0) + ", "
                    + khauNgheo.getNamSinh() + ", " + khauNgheo.getIdDanToc() + ", " + khauNgheo.getIdNgheNghiep() + ", " + khauNgheo.getIdDoiTuong() + ")";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi, không thể thêm khẩu nghèo vào cơ sở dữ liệu", "Thông báo lỗi", 2);
        }
    }

    public static boolean suaHoNgheo(HoNgheo hoNgheo, int idHoNgheo) {
        try {
            String sql = "UPDATE dbo.tbHoNgheo SET "
                    + "TenCH=N'" + hoNgheo.getTenCH() + "', XOM = N'" + hoNgheo.getXom() + "',IDXa = " + hoNgheo.getIdXa() + ", IDDanToc = " + hoNgheo.getIdDanToc()
                    + ",IDPhanLoai = " + hoNgheo.getIdPhanLoai() + ", ThuNhapTB = " + hoNgheo.getThuNhapTB() + ", IDNuoc = " + hoNgheo.getIdNuoc()
                    + ", IDNguyenNhan = " + hoNgheo.getIdNguyenNhan() + ", IDNhaO = " + hoNgheo.getIdNhaO() + ", TrangThai = " + (hoNgheo.isTrangThai() ? 1 : 0)
                    + " WHERE IDHoNgheo = " + idHoNgheo;
            pst = conn.prepareStatement(sql, new String[]{"IDHoNgheo"});
            pst.executeUpdate();

            sql = "DELETE FROM dbo.tbKhauNgheo WHERE IDHoNgheo = " + idHoNgheo;
            pst = conn.prepareStatement(sql, new String[]{"IDHoNgheo"});
            pst.executeUpdate();

            for (KhauNgheo khauNgheo : hoNgheo.getListKN()) {
                themKhauNgheo(khauNgheo, idHoNgheo);
            }
            return true;

        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean themVaoDanhSachHN(int idHoNgheo, int NamNgheo) {
        try {
            String sql = "INSERT INTO dbo.tbDanhSachHN(IDHoNgheo, NamNgheo) VALUES(" + idHoNgheo + ", " + NamNgheo + ")";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void xoaKhoiDanhSachHN(int idHoNgheo, int namNgheo) {
        try {
            String sql = "DELETE FROM dbo.tbDanhSachHN WHERE IDHoNgheo = " + idHoNgheo + " AND NamNgheo = " + namNgheo;
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
        }
    }

    public static HoNgheo layThongTinHN(int idHoNgheo, int cap, int maDiaBan) {
        try {
            String sql;
            switch (cap) {
                case 3:
                    sql = "SELECT TenCH, Xom, dbo.tbXa.IDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, TrangThai, IDNhaO "
                            + "FROM dbo.tbHoNgheo, dbo.tbTinh, dbo.tbHuyen, dbo.tbXa "
                            + "WHERE dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen AND dbo.tbTinh.IDTinh = dbo.tbHuyen.IDTinh AND dbo.tbXa.IDXa = " + maDiaBan
                            + " AND dbo.tbHoNgheo.IDHoNgheo = " + idHoNgheo;
                    break;
                case 2:
                    sql = "SELECT TenCH, Xom, dbo.tbXa.IDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, TrangThai, IDNhaO "
                            + "FROM dbo.tbHoNgheo, dbo.tbTinh, dbo.tbHuyen, dbo.tbXa "
                            + "WHERE dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen AND dbo.tbTinh.IDTinh = dbo.tbHuyen.IDTinh AND dbo.tbHuyen.IDHuyen = " + maDiaBan
                            + " AND dbo.tbHoNgheo.IDHoNgheo = " + idHoNgheo;
                    break;
                default:
                    sql = "SELECT TenCH, Xom, dbo.tbXaIDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, TrangThai, IDNhaO "
                            + "FROM dbo.tbHoNgheo, dbo.tbTinh, dbo.tbHuyen, dbo.tbXa "
                            + "WHERE dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen AND dbo.tbTinh.IDTinh = dbo.tbHuyen.IDTinh AND dbo.tbTinh.IDTinh = " + maDiaBan
                            + " AND dbo.tbHoNgheo.IDHoNgheo = " + idHoNgheo;
                    break;
            }

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();

            HoNgheo hn;

            hn = new HoNgheo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), (rs.getInt(9) != 0), rs.getInt(10));

            sql = "SELECT HoTen, IDQuanHeCH, GioiTinh, IDDanToc, IDNgheNghiep, IDDoiTuong, NamSinh "
                    + "FROM dbo.tbKhauNgheo WHERE dbo.tbKhauNgheo.IDHoNgheo = " + idHoNgheo;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                hn.getListKN().add(new KhauNgheo(rs.getString(1), rs.getInt(2), (rs.getInt(3) != 0), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }

            return hn;
        } catch (Exception ex) {
            return null;
        }
    }

    public static boolean layThongTinHeThong() {

        try {
            HeThong.namNgheo = Calendar.getInstance().get(Calendar.YEAR);
            String sql = "SELECT  NgheoNT, CanNgheoNT, NgheoTT, CanNgheoTT "
                    + "FROM dbo.tbHeThong WHERE dbo.tbHeThong.Nam =" + HeThong.namNgheo;
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.ngheoNT = rs.getInt(1);
                HeThong.canNgheoNT = rs.getInt(2);
                HeThong.ngheoTT = rs.getInt(3);
                HeThong.canNgheoTT = rs.getInt(4);
                break;
            }

            sql = "select * from dbo.tbDoiTuong";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmDoiTuong.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbQuanHe";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmQuanHe.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbDanToc";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmDanToc.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbNgheNghiep";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmNgheNghiep.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbKhuVuc";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmKhuVuc.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbPhanLoai";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmPhanLoai.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbNhaO";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmNhaO.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbNuoc";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmNuoc.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }

            sql = "select * from dbo.tbNguyenNhan";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                HeThong.dmNguyenNhan.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static DanhMuc layKhuVuc(int maxXa) {
        String sql;
        try {
            Statement st = conn.createStatement();
            sql = "SELECT dbo.tbXa.IDKhuVuc, TenKhuVuc FROM dbo.tbXa, dbo.tbKhuVuc "
                    + "WHERE dbo.tbXa.IDKhuVuc = dbo.tbKhuVuc.IDKhuVuc AND IDXa = " + maxXa;
            rs = st.executeQuery(sql);
            rs.next();

            return new DanhMuc(rs.getInt(1), rs.getString(2));
        } catch (Exception ex) {
            return null;
        }
    }

    public static DiaBan layDiaBan(int cap, int ma) {
        String sql;
        try {

            Statement st = conn.createStatement();
            DanhMuc tinh = null, huyen = null, xa = null;
            if (cap == 1) {
                sql = "SELECT dbo.tbTinh.IDTinh, dbo.tbTinh.TenTinh from dbo.tbTinh where IDTinh = " + ma;
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    tinh = new DanhMuc(rs.getInt(1), rs.getString(2));
                }
            } else if (cap == 2) {
                sql = "SELECT dbo.tbTinh.IDTinh, dbo.tbTinh.TenTinh, dbo.tbHuyen.IDHuyen, dbo.tbHuyen.TenHuyen from dbo.tbTinh, dbo.tbHuyen WHERE dbo.tbHuyen.IDTinh = dbo.tbTinh.IDTinh and dbo.tbHuyen.IDHuyen = " + ma;
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    tinh = new DanhMuc(rs.getInt(1), rs.getString(2));
                    huyen = new DanhMuc(rs.getInt(3), rs.getString(4));
                }
            } else {
                sql = "SELECT dbo.tbTinh.IDTinh, dbo.tbTinh.TenTinh, dbo.tbHuyen.IDHuyen, dbo.tbHuyen.TenHuyen, dbo.tbXa.IDXa, dbo.tbXa.TenXa"
                        + " from dbo.tbTinh, dbo.tbHuyen, dbo.tbXa WHERE dbo.tbHuyen.IDTinh = dbo.tbTinh.IDTinh and dbo.tbHuyen.IDHuyen = dbo.tbXa.IDHuyen "
                        + " and dbo.tbXa.IDXa = " + ma;
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    tinh = new DanhMuc(rs.getInt(1), rs.getString(2));
                    huyen = new DanhMuc(rs.getInt(3), rs.getString(4));
                    xa = new DanhMuc(rs.getInt(5), rs.getString(6));
                }
            }
            return new DiaBan(tinh, huyen, xa);

        } catch (Exception ex) {
            return null;
        }
    }

    public static ArrayList<DanhMuc> layDanhSachHuyen() {
        ArrayList<DanhMuc> dsHuyen = null;
        try {
            String sql = "SELECT IDHuyen, TenHuyen FROM dbo.tbHuyen";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            dsHuyen = new ArrayList<>();
            while (rs.next()) {
                dsHuyen.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }
            return dsHuyen;
        } catch (Exception ex) {
            return dsHuyen;
        }
    }
    public static void themuser(int capql, String tendn, String matkhau, String hoten, int diabanql, boolean trangthai)
    {
         String sql ="INSERT INTO dbo.tbCanBo (IDCanBo,MatKhau,HoTen,CapQL,DiaBanQL,TrangThai) values ('"+tendn+"','"+matkhau+"',N'"+hoten+"',"+capql+","+diabanql+",'"+trangthai+"')";
          
         try {
             pst = conn.prepareStatement(sql);
              pst.executeUpdate();
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null,"Lỗi","Thông báo",2);
         }
         
    }
    public static void xoauser(String id)
    {
        String sql ="DELETE FROM dbo.tbCanBo where IDCanBo ='"+id+"'";
        try{
            
              pst = conn.prepareStatement(sql);
              pst.executeUpdate();
                }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Lỗi","Thông báo",2);
        }
    }
    public static void suauser(int capql, String tendn, String matkhau, String hoten, int diabanql, boolean trangthai)
    {
        String sql="Update dbo.tbCanBo set CapQL='"+capql+"',MatKhau='"+matkhau+"',HoTen=N'"+hoten+"',DiaBanQL='"+diabanql+"',TrangThai='"+trangthai+"' where IDCanBo='"+tendn+"'";
          try{
            
              pst = conn.prepareStatement(sql);
              pst.executeUpdate();
                }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Lỗi","Thông báo",2);
        }
    }
    
    public static ArrayList<DanhMuc> layDanhSachXa(int idHuyen) {
        ArrayList<DanhMuc> dsHuyen = null;
        try {
            String sql = "SELECT IDXa, TenXa FROM dbo.tbXa WHERE IDHuyen = " + idHuyen;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            dsHuyen = new ArrayList<>();
            while (rs.next()) {
                dsHuyen.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }
            return dsHuyen;
        } catch (Exception ex) {
            return dsHuyen;

        }
    }
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
