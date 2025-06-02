public class TransaksiPemesanan {
    private String kode;
    private String nama;
    private int harga;
    private int jumlah;

    public TransaksiPemesanan(String kode, String nama, int harga, int jumlah) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return harga * jumlah;
    }

    @Override
    public String toString() {
        return jumlah + " x " + nama + " = Rp" + getSubtotal();
    }
}
