/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author phong
 */
public class DiaBan {
    
    private int cap;
    private String tinh;
    private String huyen;
    private String xa;

    public DiaBan(int cap, String tinh, String huyen, String xa) {
        this.cap = cap;
        this.tinh = tinh;
        this.huyen = huyen;
        this.xa = xa;
    }

    
    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }
    
    
    
}
