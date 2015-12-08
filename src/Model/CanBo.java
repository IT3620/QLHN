package Model;

public abstract class CanBo {

    protected final String idCanBo;
    protected final String matKhau;
    protected final String hoTen;
    protected final int diaBanQL;
    protected final boolean trangThai;
    protected int idKhuVuc;

    public CanBo(String IDCanBo, String matKhau, String HoTen, int DiaBanQL, boolean TrangThai) {
        this.idCanBo = IDCanBo;
        this.matKhau = matKhau;
        this.hoTen = HoTen;
        this.diaBanQL = DiaBanQL;
        this.trangThai = TrangThai;
    }

    public abstract int getCapQL();
     

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

    public int getDiaBanQL() {
        return diaBanQL;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public int getIdKhuVuc() {
        return idKhuVuc;
    }

    public DiaBan getDiaBan() {
        return CoSoDuLieu.layDiaBan(getCapQL(), diaBanQL);
    }
    
    public abstract HoNgheo layThongTinHN(int idHoNgheo);
    public abstract String layTruyVanBaoCaoSL(int loai, int nam, int giatri);
}
