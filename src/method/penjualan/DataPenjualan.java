/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.penjualan;

/**
 *
 * @author TOSHIBA
 */
public class DataPenjualan {

    public String nomor_nota, kode_barang, nama_barang;

    public String getNonota() {
        return nomor_nota;
    }
    public void setNonota(String nomor_nota) {
        this.nomor_nota = nomor_nota;
    }

    public String getkdbarang() {
        return kode_barang;
    }
    public void setkdbarang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getnmbarang() {
        return nama_barang;
    }
    public void setnmbarang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    int hargajual, jumlah_beli, total_bayar;

    public int getharga_jual() {
        return hargajual;
    }
    public void setharga_jual(int harga_jual) {
        this.hargajual = hargajual;
    }
    
    public int getJmlbeli() {
        return jumlah_beli;
    }
    public void setJmlbeli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }

    public int getTbayar() {
        return total_bayar;
    }
    public void setTbayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }

    
}
