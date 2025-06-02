package pemesananmakanan;
import java.util.HashMap;
public class Pemesanan {
    private HashMap<String, Makanan> daftarMakanan = new HashMap<>();
    private HashMap<String, Minuman> daftarMinuman = new HashMap<>();
    private HashMap<String, Integer> daftarPesanan = new HashMap<>();

    public Pemesanan() {
        daftarMakanan.put("C1", new Makanan("C1", "Nasi Goreng", 30000));
        daftarMakanan.put("C2", new Makanan("C2", "Mi Goreng", 28000));
        daftarMakanan.put("C3", new Makanan("C3", "Mi Rebus", 28000));

        daftarMinuman.put("D1", new Minuman("D1", "Jus Mangga", 15000));
        daftarMinuman.put("D2", new Minuman("D2", "Air Mineral", 10000));
        daftarMinuman.put("D3", new Minuman("D3", "Es Campur", 18000));
    }

  public void tambahPesanan(String kode, int jumlah) {
    if (daftarMakanan.containsKey(kode) || daftarMinuman.containsKey(kode)) {
        int jumlahLama = daftarPesanan.getOrDefault(kode, 0);
        daftarPesanan.put(kode, jumlahLama + jumlah);
    } else {
        throw new IllegalArgumentException("Kode tidak ditemukan: " + kode);
    }
}

public String getStruk() {
    StringBuilder struk = new StringBuilder("Struk Pemesanan:\n");
    int total = 0;

    for (String kode : daftarPesanan.keySet()) {
        int jumlah = daftarPesanan.get(kode);
        String nama = "";
        int harga = 0;

        if (daftarMakanan.containsKey(kode)) {
            Makanan m = daftarMakanan.get(kode);
            nama = m.getNama();
            harga = m.getHarga();
        } else if (daftarMinuman.containsKey(kode)) {
            Minuman m = daftarMinuman.get(kode);
            nama = m.getNama();
            harga = m.getHarga();
        }

        int subtotal = jumlah * harga;
        struk.append(jumlah).append("x ").append(nama).append(" = Rp").append(subtotal).append("\n");
        total += subtotal;
    }

    struk.append("\nTotal Bayar: Rp").append(total);
    return struk.toString();
    }
}
