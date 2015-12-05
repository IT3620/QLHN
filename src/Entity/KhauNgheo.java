package Entity;


public class KhauNgheo {
    String hoTen;
    int idQuanHeCH;
    boolean gioiTinh;;
    int idDanToc;
    int idNgheNghiep;
    int idDoiTuong;
    int namSinh;

    public KhauNgheo(String hoTen, int idQuanHeCH, boolean gioiTinh, int idDanToc, int idNgheNghiep, int idDoiTuong, int namSinh) {
        this.hoTen = hoTen;
        this.idQuanHeCH = idQuanHeCH;
        this.gioiTinh = gioiTinh;
        this.idDanToc = idDanToc;
        this.idNgheNghiep = idNgheNghiep;
        this.idDoiTuong = idDoiTuong;
        this.namSinh = namSinh;
    }

    public String getHoTen() {
        return hoTen;
    }


    public int getIdQuanHeCH() {
        return idQuanHeCH;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    
    public int getIdDanToc() {
        return idDanToc;
    }

    public int getIdNgheNghiep() {
        return idNgheNghiep;
    }


    public int getIdDoiTuong() {
        return idDoiTuong;
    }


    public int getNamSinh() {
        return namSinh;
    }

    
    
}
