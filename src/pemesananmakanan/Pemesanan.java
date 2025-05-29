package pemesananmakanan;

public class Pemesanan {
    private String kode;
    private String nama;
    private int harga;
    private int jumlah;

    public Pemesanan(String kode, String nama, int harga, int jumlah) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSubtotal() {
        return harga * jumlah;
    }

    @Override
    public String toString() {
        return nama + " (" + kode + ") x " + jumlah + " = Rp" + getSubtotal();
    }
}
