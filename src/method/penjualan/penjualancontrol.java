/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method.penjualan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class penjualancontrol {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public penjualancontrol() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbwarung", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi Kesalahan Pada :\n" + e);
        }
    }

    public List CekBarang(String Nonota, String kdbarang) {
        List logDetailBeli = new ArrayList();
        sql = "select no_nota, kode_barang, nama_barang, hargajual, jumlah_beli, total_bayar from tbpenjualan where no_nota='" + Nonota + "' and kode_barang='" + kdbarang + "'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DataPenjualan dp = new DataPenjualan();
                dp.setkdbarang(rs.getString("kode_barang"));
                dp.setnmbarang(rs.getString("nama_barang"));
                dp.setharga_jual(rs.getInt("hargajual"));
                dp.setJmlbeli(rs.getInt("jumlah_beli"));
                dp.setTbayar(rs.getInt("total_bayar"));
                logDetailBeli.add(dp);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada cek barang : \n" + e);
        }
        return logDetailBeli;
    }

    public int tambahpenjualan(DataPenjualan a) {
        sql="insert into tbpenjualan values (null, '"+a.getNonota()+"','"+a.getkdbarang()+"','"+a.getnmbarang()+"','"+a.getharga_jual()+"','"+a.getJmlbeli()+"','"+a.getTbayar()+"')";
    int hasil = 0;
    try{
        hasil=st.executeUpdate(sql);
    }catch (SQLException e){
               JOptionPane.showMessageDialog(null, "Terjadi Kesalahan : \n"+e + "Error Disini!!");
        }
    return hasil;
    }

    public List cariBarang(String cari) {
        List logCari = new ArrayList();
        sql = "select no_nota, kode_barang, nama_barang, hargajual, jumlah_beli, total_bayar from tbpenjualan where no_nota like '%" + cari + "%' or nama_barang like '%" + cari + "%'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                DataPenjualan dp = new DataPenjualan();
                dp.setkdbarang(rs.getString("kode_barang"));
                dp.setnmbarang(rs.getString("nama_barang"));
                dp.setharga_jual(rs.getInt("hargajual"));
                dp.setJmlbeli(rs.getInt("jumlah_beli"));
                dp.setTbayar(rs.getInt("total_bayar"));
                logCari.add(dp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada cari barang : \n" + e);
        }
        return logCari;
    }
    
    public int deletepenjualan(String nonota, String kdbarang){
    sql = " delete from tbpenjualan where no_nota='"+nonota+"' and kode_barang='"+kdbarang+"' ";
    int hasil =0;
    try{ 
        hasil=st.executeUpdate(sql);
    }catch (Exception e){
      JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada : \n" + e);
    }
    return hasil;
    }
}
