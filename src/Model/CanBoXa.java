/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author thong
 */
public class CanBoXa extends CanBo {
    
    public CanBoXa(String IDCanBo, String matKhau, String HoTen, int DiaBanQL, boolean TrangThai) {
        super(IDCanBo, matKhau, HoTen, DiaBanQL, TrangThai);
    }
    
    public boolean suaHoNgheo(HoNgheo hoNgheo, int idHoNgheo) {
        return CoSoDuLieu.suaHoNgheo(hoNgheo, idHoNgheo);
    }

    public boolean themVaoDanhSachHN(int idHoNgheo, int NamNgheo) {
        return CoSoDuLieu.themVaoDanhSachHN(idHoNgheo, NamNgheo);
    }
    
    public void xoaKhoiDanhSachHN(int idHoNgheo, int namNgheo) {
        CoSoDuLieu.xoaKhoiDanhSachHN(idHoNgheo, namNgheo);
    }
    
    public  void themKhauNgheo(KhauNgheo khauNgheo, int idHoNgheo) {
        CoSoDuLieu.themKhauNgheo(khauNgheo, idHoNgheo);
    }
    
    public static int themHoNgheo(HoNgheo hoNgheo) {
        return CoSoDuLieu.themHoNgheo(hoNgheo);
    }
    

    @Override
    public HoNgheo layThongTinHN(int idHoNgheo) {
       return CoSoDuLieu.layThongTinHN(idHoNgheo, getCapQL(), diaBanQL);
    }

    @Override
    public String layTruyVanBaoCaoSL(int loai, int nam, int giatri) {
        String sql = "";
        return sql;
    }

    @Override
    public int getCapQL() {
        return 3;
    }
}
