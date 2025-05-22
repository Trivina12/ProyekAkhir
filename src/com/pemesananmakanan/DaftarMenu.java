package com.pemesananmakanan;

import java.util.ArrayList;
import java.util.List;

public class DaftarMenu {
    private List<Menu> daftar;

    public DaftarMenu() {
        daftar = new ArrayList<>();
        
        daftar.add(new Menu("C1", "Nasi Goreng", 30000));
        daftar.add(new Menu("C2", "Mi Goreng", 28000));
        daftar.add(new Menu("C3", "Mi Rebus", 28000));
        
        daftar.add(new Menu("D1", "Jus Mangga", 15000));
        daftar.add(new Menu("D2", "Air Mineral", 5000));
        daftar.add(new Menu("D3", "Es Campur", 12000));
    }

    public void tambahMenu(Menu m) {
        daftar.add(m);
    }

    public Menu cariMenu(String kode) {
        return daftar.stream()
                   .filter(m -> m.getKode().equalsIgnoreCase(kode))
                   .findFirst()
                   .orElse(null);
    }

    public List<Menu> getSemuaMenu() {
        return new ArrayList<>(daftar);
    }
}
