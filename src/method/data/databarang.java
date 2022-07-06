package method.data;

public class databarang {

    public String kode_barang, namabarang, satuan;
    public int hargajual, hargabeli, stok;

    public String getkdbarang() {
        return kode_barang;
    }

    public void setkdbarang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getnmbarang() {
        return namabarang;
    }

    public void setnmbarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getsatuan() {
        return satuan;
    }

    public void setsatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getstok() {
        return stok;
    }

    public void setstok(int stok) {
        this.stok = stok;
    }

    public int getharga_jual() {
        return hargajual;
    }

    public void setharga_jual(int harga_jual) {
        this.hargajual = harga_jual;
    }

    public int getharga_beli() {
        return hargabeli;
    }

    public void setharga_beli(int harga_beli) {
        this.hargabeli = harga_beli;
    }
}
