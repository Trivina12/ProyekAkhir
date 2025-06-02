package pemesananmakanan;
import java.util.HashMap;
public class Pemesanan {
    private HashMap<String, Makanan> daftarMakanan = new HashMap<>();
    private HashMap<String, Minuman> daftarMinuman = new HashMap<>();

    public Pemesanan() {
        daftarMakanan.put("C1", new Makanan("C1", "Nasi Goreng", 30000));
        daftarMakanan.put("C2", new Makanan("C2", "Mi Goreng", 28000));
        daftarMakanan.put("C3", new Makanan("C3", "Mi Rebus", 28000));

        daftarMinuman.put("D1", new Minuman("D1", "Jus Mangga", 15000));
        daftarMinuman.put("D2", new Minuman("D2", "Air Mineral", 10000));
        daftarMinuman.put("D3", new Minuman("D3", "Es Campur", 18000));
    }

    public String prosesPesanan(String kode, int jumlah) {
        if (daftarMakanan.containsKey(kode)) {
            Makanan m = daftarMakanan.get(kode);
            return jumlah + "x " + m.getNama() + " = Rp" + (jumlah * m.getHarga());
        } else if (daftarMinuman.containsKey(kode)) {
            Minuman m = daftarMinuman.get(kode);
            return jumlah + "x " + m.getNama() + " = Rp" + (jumlah * m.getHarga());
        } else {
            return "Kode tidak ditemukan: " + kode;
        }
    }
}

