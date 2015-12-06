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
public class DiaBanInt {
    int tinh;
    int huyen;
    int xa;
    int cap;
    public DiaBanInt(int cap, int tinh, int huyen, int xa) {
        this.cap = cap;
        this.tinh = tinh;
        this.huyen = huyen;
        this.xa = xa;
    }

    public int getCap() {
        return cap;
    }

    
    public int getTinh() {
        return tinh;
    }

    public int getHuyen() {
        return huyen;
    }

    public int getXa() {
        return xa;
    }
    
    
    
}
