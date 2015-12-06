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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.*;

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
            JOptionPane.showMessageDialog(null, "Ket noi co so du lieu that bai", "Thong bao", 2);
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

    public static void LoadData(String sql, JTable tb) {
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
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
                    sql = "SELECT TenCH, Xom, IDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, TrangThai, IDNhaO "
                            + "FROM dbo.tbHoNgheo, dbo.tbTinh, dbo.tbHuyen, dbo.tbXa "
                            + "WHERE dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen AND dbo.tbTinh.IDTinh = dbo.tbHuyen.IDTinh AND dbo.tbXa.IDXa = " + maDiaBan
                            + " AND dbo.tbHoNgheo.IDHoNgheo = " + idHoNgheo;
                    break;
                case 2:
                    sql = "SELECT TenCH, Xom, IDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, TrangThai, IDNhaO "
                            + "FROM dbo.tbHoNgheo, dbo.tbTinh, dbo.tbHuyen, dbo.tbXa "
                            + "WHERE dbo.tbXa.IDHuyen = dbo.tbHuyen.IDHuyen AND dbo.tbTinh.IDTinh = dbo.tbHuyen.IDTinh AND dbo.tbHuyen.IDHuyen = " + maDiaBan
                            + " AND dbo.tbHoNgheo.IDHoNgheo = " + idHoNgheo;
                    break;
                default:
                    sql = "SELECT TenCH, Xom, IDXa, IDDanToc, IDPhanLoai, ThuNhapTB, IDNuoc, IDnguyenNhan, TrangThai, IDNhaO "
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
