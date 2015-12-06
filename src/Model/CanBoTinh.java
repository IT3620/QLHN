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
public class CanBoTinh extends CanBo {
    
    public CanBoTinh(String IDCanBo, String matKhau, String HoTen, int DiaBanQL, boolean TrangThai) {
        super(IDCanBo, matKhau, HoTen, DiaBanQL, TrangThai);
    }
    
     @Override
    public HoNgheo layThongTinHN(int idHoNgheo) {
       return CoSoDuLieu.layThongTinHN(idHoNgheo, getCapQL(), diaBanQL);
    }
    
}
