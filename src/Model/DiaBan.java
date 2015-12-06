package Model;


public class DiaBan {
    
    private int cap;
    private DanhMuc tinh = null, huyen = null, xa = null;

    public DiaBan(DanhMuc tinh, DanhMuc huyen, DanhMuc xa) {
        this.tinh = tinh;
        if (huyen == null) {
            cap = 1;
            return;
        }
        this.huyen = huyen;
        if (xa == null) {
            cap = 2;
            return;
        }
        this.xa = xa;
        cap = 3;
    }
    
    
    public int getCap() {
        return cap;
    }

    public DanhMuc getTinh() {
        return tinh;
    }

    public DanhMuc getHuyen() {
        return huyen;
    }

    public DanhMuc getXa() {
        return xa;
    }
    
    

}
