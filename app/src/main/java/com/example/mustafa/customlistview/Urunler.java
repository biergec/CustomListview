package com.example.mustafa.customlistview;

public class Urunler {

    public Urunler(String s) {
        this.siparis_isim = s;
    }

    public String getSiparis_isim() {
        return siparis_isim;
    }

    public int getSiparis_miktar() {
        return siparis_miktar;
    }

    public void setSiparis_miktar(int siparis_miktar) {
        this.siparis_miktar = siparis_miktar;
    }

    private String siparis_isim;
    private int siparis_miktar=0;
}
