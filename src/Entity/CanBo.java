
package Entity;

public class CanBo {
    private String idCanBo;
    private String matKhau;
    private String hoTen;
    private int capQL;
    private int diaBanQL;
    private boolean trangThai;
    private int idKhuVuc;

    public CanBo(String IDCanBo, String matKhau, String HoTen, int CapQL, int DiaBanQL, boolean TrangThai) {
        this.idCanBo = IDCanBo;
        this.matKhau = matKhau;
        this.hoTen = HoTen;
        this.capQL = CapQL;
        this.diaBanQL = DiaBanQL;
        this.trangThai = TrangThai;
    }

    public void setIdKhuVuc(int idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public String getIdCanBo() {
        return idCanBo;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getCapQL() {
        return capQL;
    }

    public int getDiaBanQL() {
        return diaBanQL;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public int getIdKhuVuc() {
        return idKhuVuc;
    }

    
    
    
}
