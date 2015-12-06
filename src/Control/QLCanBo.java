/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.*;
import java.util.ArrayList;
import javax.swing.JTable;


/**
 *
 * @author thong
 */
public class QLCanBo {
    public static CanBo dangNhap(String user, String passwd) {
       return CoSoDuLieu.dangNhap(user, passwd);
    }
    
     public static DiaBan layDiaBan(int cap, int ma) {
         return CoSoDuLieu.layDiaBan(cap, ma);
     }
     
     public static boolean layThongTinHeThong() {
        return CoSoDuLieu.layThongTinHeThong();
     }
     
     public static DanhMuc layIDKhuVuc(int maxXa) {
         return CoSoDuLieu.layKhuVuc(maxXa);
     }
     
     public static ArrayList<DanhMuc> layDanhSachHuyen() {
         return CoSoDuLieu.layDanhSachHuyen();
     }
     
     public static ArrayList<DanhMuc> layDanhSachXa(int idHuyen) {
         return CoSoDuLieu.layDanhSachXa(idHuyen);
     }
     
    public static void LoadData(String sql, JTable tb) {
        CoSoDuLieu.LoadData(sql, tb);
    }
}
