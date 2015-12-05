package Entity;

public class DanhMuc {
    public int id;
    public String ten;
    public DanhMuc(int id, String ten)
    {
        this.id = id;
        this.ten = ten;
    }
    
    @Override
    public String toString()
    {
        return ten;
    }
}
