package Model;

public class DanhMuc {
    public int id;
    public String ten;
    public DanhMuc(int id, String ten)
    {
        this.id = id;
        this.ten = ten;
    }

    DanhMuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString()
    {
        return ten;
    }
}
