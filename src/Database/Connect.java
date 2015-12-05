
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Connect {
    public static Connection getConnect()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:6789;instance=SQLEXPRESS;databaseName=QLHN", "sa", "1900100co");
            return conn;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ket noi co so du lieu that bai","Thong bao",2);
            return null;
        }
    }
    
}
