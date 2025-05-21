package com.pemesananmakanan;

public class Pesanan {
    private Menu menu;
    private int jumlah;

    public Pesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public double hitungTotal() {
        return menu.getHarga() * jumlah;
    }

    public String getDeskripsi() {
        return String.format("%s (%s) x%d = Rp%,.0f", 
               menu.getNama(), menu.getKode(), jumlah, hitungTotal());
    }

    public Menu getMenu() { return menu; }
    public int getJumlah() { return jumlah; }
}