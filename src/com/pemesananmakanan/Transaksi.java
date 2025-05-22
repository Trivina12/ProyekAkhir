package com.pemesananmakanan;

import java.util.ArrayList;
import java.util.List;

public class Transaksi {
    private List<Pesanan> daftarPesanan;

    public Transaksi() {
        daftarPesanan = new ArrayList<>();
    }

    public void tambahPesanan(Pesanan p) {
        daftarPesanan.add(p);
    }

    public double hitungTotalTagihan() {
        return daftarPesanan.stream()
                          .mapToDouble(Pesanan::hitungTotal)
                          .sum();
    }

    public String getDetailTransaksi() {
        StringBuilder sb = new StringBuilder();
        daftarPesanan.forEach(p -> 
            sb.append(p.getDeskripsi()).append("\n"));
        sb.append("\nTotal Tagihan: Rp")
          .append(String.format("%,.0f", hitungTotalTagihan()));
        return sb.toString();
    }
}