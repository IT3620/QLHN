

package Control;

import java.sql.*;
import javax.swing.*;
import Database.*;
import net.proteanit.sql.*; // thư viện này lấy từ thằng mình mới add vào rs2xml
public class UpdataTable {
    public  static  PreparedStatement pst=null; // biến thực thi sql
    public  static ResultSet rs = null; // kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu
    public  static  Connection conn = Connect.getConnect(); // hấy từ lớp cơ bản kết nối Data
    
    //viết 1 hàm nạp dữ liệu cho bản
    public static void LoadData(String sql, JTable tb)
    {
        try
        {
            pst= conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
            // ngay chỗ này là nạp dữ liệu lên bảng mà mình truyền vào
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Thông báo lỗi",1);
        }
    }
    // Tiếp theo ta viết 1 hàm đỗ 1 dòng dữ liệu từ bảng lên texfield
    public static ResultSet ShowTextField(String sql)
    {
        try
        {
            pst= conn.prepareStatement(sql);
            return pst.executeQuery();
            // Trả về 1 dòng dữ liệu đọc được
        }
        catch(Exception e)
        {
            return null;
            //JOptionPane.showMessageDialog(null, e,"Thông báo lỗi",1);
            // với Java tất cả mọi thứ dều nằm vào try catch , bạn nên lưu ý đều này
        }
        
    }
}
