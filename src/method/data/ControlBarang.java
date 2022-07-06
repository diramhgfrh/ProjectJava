package method.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlBarang {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    private List LogBarang;

    public ControlBarang() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbwarung", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal, Terjadi Kesalahan Pada :\n" + e);
        }
    }

    public ArrayList tampil() {
        ArrayList LogBarang = new ArrayList();
        sql = "select kode_barang, namabarang, satuan, stok, hargajual, hargabeli from tbbarang order by idbarang asc";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                databarang DO = new databarang();
                DO.setkdbarang(rs.getString("kode_barang"));
                DO.setnmbarang(rs.getString("namabarang"));
                DO.setsatuan(rs.getString("satuan"));
                DO.setharga_jual(rs.getInt("hargajual"));
                DO.setharga_beli(rs.getInt("hargabeli"));
                DO.setstok(rs.getInt("stok"));
                LogBarang.add(DO);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada :\n" + e);
        }
        return LogBarang;
    }

    public int tambahbarang(databarang e) {
        sql = "insert into tbbarang (kode_barang, namabarang, satuan, hargajual, hargabeli, stok)values('" + e.getkdbarang() + "','" + e.getnmbarang() + "','" + e.getsatuan() + "','" + e.getharga_jual() + "','" + e.getharga_beli() + "','" + e.getstok() + "')";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada :\n" + a);
        }
        return hasil;
    }

    public int editbarang(databarang e) {
        sql = "update tbbarang set namabarang='" + e.getnmbarang() + "',satuan='" + e.getsatuan() + "',stok='" + e.getstok() + "',hargajual='" + e.getharga_jual() + "',"
                + " hargabeli='" + e.getharga_beli() + "'where kode_barang='" + e.getkdbarang() + "'";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada :\n" + a);
        }
        return hasil;
    }

    public ArrayList cariBarang(String cari) {
        ArrayList LogBarang = new ArrayList();
        sql = "select kode_barang, namabarang, satuan, stok, hargajual, hargabeli from tbbarang where kode_barang " + "like '%" + cari + "%' or namabarang like '%"+cari+"%'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                databarang DO = new databarang();
                DO.setkdbarang(rs.getString("kode_barang"));
                DO.setnmbarang(rs.getString("namabarang"));
                DO.setsatuan(rs.getString("satuan"));
                DO.setharga_jual(rs.getInt("hargajual"));
                DO.setharga_beli(rs.getInt("hargabeli"));
                DO.setstok(rs.getInt("stok"));
                LogBarang.add(DO);
            }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada :\n" + a);
        }
        return LogBarang;
    }

    public int deletebarang(databarang e) {
        sql = "delete from tbbarang where kode_barang='" + e.getkdbarang() + "'";
        int hasil = 0;
        try {
            hasil = st.executeUpdate(sql);
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada :\n" + a);
        }
        return hasil;
    }

    public int getJumlahbarang() {
        sql = "select count(*) as jumlah_barang " + "from tbbarang";
        int jumlah;
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                jumlah = rs.getInt("jumlah_barang");
                return jumlah;
            }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada :\n" + a);
        }
        return 0;
    }

    public ArrayList tampilSatuan() {
        ArrayList LogBarang = new ArrayList();
        sql = "select ditinct(satuan) from tbbarang order by id_barang asc";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()) {
                databarang eb = new databarang();
                eb.setsatuan(rs.getString("satuan"));
                LogBarang.add(eb);
            }
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada :\n" + a);
        }
        return LogBarang;
    }
public int updateStock(int stok, String kdbarang){
    sql= "update tbbarang set stok= '"+stok+"' where kode_barang='"+kdbarang+"'";
    int hasil=0;
try{
    hasil=st.executeUpdate(sql);
}catch(Exception a){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada :\n" + a);
    }return hasil;
}   


public ArrayList caribarangdengancode(String kdbarang){
    ArrayList LogBarang= new ArrayList();
sql = "select kode_barang, namabarang,satuan, stok, harga_kontrak,hargabeli from tbbarang where kode_barang='"+kdbarang+"' ";
        try{
rs= st.executeQuery(sql);
        while (rs.next()){
        databarang DB =new databarang();
        DB.setkdbarang(rs.getString("kode_barang"));
        DB.setnmbarang(rs.getString("namabarang"));
        DB.setsatuan(rs.getString("satuan"));
        DB.setstok(rs.getInt("stok"));
        DB.setharga_beli(rs.getInt("harga_beli"));
        LogBarang.add(DB);
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada:  "+e);
        }
        return LogBarang;
        }

    }



