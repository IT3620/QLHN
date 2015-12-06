package Model;

import java.util.ArrayList;

public class HoNgheo {
    private String tenCH;
    private String xom;
    private int idXa;
    private int idDanToc;
    private int idPhanLoai;
    private int thuNhapTB;
    private int idNuoc;
    private int idNguyenNhan;
    private boolean trangThai;
    private int idNhaO;
    private ArrayList<KhauNgheo> listKN;

    public HoNgheo(String tenCH, String xom, int idXa, int idDanToc, int idPhanLoai, int thuNhapTB, int idNuoc, int idNguyenNhan, boolean trangThai, int idNhaO) {
        this.tenCH = tenCH;
        this.xom = xom;
        this.idXa = idXa;
        this.idDanToc = idDanToc;
        this.idPhanLoai = idPhanLoai;
        this.thuNhapTB = thuNhapTB;
        this.idNuoc = idNuoc;
        this.idNguyenNhan = idNguyenNhan;
        this.trangThai = trangThai;
        this.idNhaO = idNhaO;
        listKN = new ArrayList<>();
    }

    
    public void themKN(KhauNgheo khauNgheo) {
        listKN.add(khauNgheo);
    }
    
    public boolean xoaKN(int thuTu) {
        if (thuTu < 0 || thuTu >= listKN.size())
            return false;
        listKN.remove(thuTu);
        return true;
    }
    
    public String getTenCH() {
        return tenCH;
    }

    public String getXom() {
        return xom;
    }

    public int getIdXa() {
        return idXa;
    }

    public int getIdDanToc() {
        return idDanToc;
    }

    public int getIdPhanLoai() {
        return idPhanLoai;
    }

    public int getThuNhapTB() {
        return thuNhapTB;
    }


    public int getIdNuoc() {
        return idNuoc;
    }

    public int getIdNguyenNhan() {
        return idNguyenNhan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public int getIdNhaO() {
        return idNhaO;
    }

    public ArrayList<KhauNgheo> getListKN() {
        return listKN;
    }
    
    
    
    
}
