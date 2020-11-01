/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahihi;

class MaSVException extends Exception{
    public String toString(){
        return "ma sv phai co 4 chu so";
    }
}

class TenException extends Exception{
    public String toString(){
        return "ten ko duoc trong";
    }
}

class LopException extends Exception{
    public String toString(){
        return "lop phai dat theo quy tac PTIT";
    }
}

class DtbException extends Exception{
    public String toString(){
        return "dtb phai tu 0-10";
    }
}

public class SinhVien {
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;
    private static String quyChuanDatTen="D\\d{2}CQ(AT||CN||VT)\\d{2}-B";

    public SinhVien() {
    }

    public SinhVien(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }

    public void setMaSV(int maSV) throws MaSVException {
        if(maSV>=1000 && maSV<=9999)
        this.maSV = maSV;
        else throw new MaSVException();
    }

    public void setTen(String ten) throws TenException {
        if(ten.matches("\\s*")) throw new TenException();
        else
        this.ten = ten;
    }

    public void setLop(String lop) throws LopException {
        if(lop.matches(quyChuanDatTen))
        this.lop = lop;
        else throw new LopException();
    }

    public void setDtb(double dtb) throws DtbException {
        if(dtb>=0 && dtb<=10)
        this.dtb = dtb;
        
        else throw new DtbException();
        
    }

    @Override
    public String toString() {
        return maSV+" "+ten+" "+lop+" "+dtb; //To change body of generated methods, choose Tools | Templates.
    }

    public String getTen() {
        return ten;
    }

    public double getDtb() {
        return dtb;
    }
    
    
    
}
