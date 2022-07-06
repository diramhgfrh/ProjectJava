/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Farah Salsabila
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class dlm_data_karyawan {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    private String sql;

    public String nip;
    public String nama;
    public String jabatan;
    public String jenis_kelamin;
    public String agama;
    public String status;
    public String alamat;
    public String tempat_lahir;
    public String tanggal_lahir;
    public String email;
    public String no_telpon;
    public String level;
    public String username;
    public String passwoard;
    public String gaji_karyawan;

    public void simpan() throws SQLException {
        conn = koneksi.getkoneksi();
        sql = "INSERT INTO input_data_karyawan(nip,nama,jabatan,jenis_kelamin,agama,status,alamat,gaji_karyawan,tempat_lahir,tanggal_lahir,email,no_telpon,level,username,passwoard)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nip);
        pst.setString(2, nama);
        pst.setString(3, jabatan);
        pst.setString(4, jenis_kelamin);
        pst.setString(5, agama);
        pst.setString(6, status);
        pst.setString(7, alamat);
        pst.setString(8, gaji_karyawan);
        pst.setString(9, tempat_lahir);
        pst.setString(10,tanggal_lahir);
        pst.setString(11, email);
        pst.setString(12, no_telpon);
        pst.setString(13, level);
        pst.setString(14, username);
        pst.setString(15, passwoard);
        pst.execute();
        pst.close();
    }

    public void edit() throws SQLException {
        System.out.println(nip);
        System.out.println(nama);
        System.out.println(jabatan);
        System.out.println(jenis_kelamin);
        System.out.println(agama);
        System.out.println(status);
        System.out.println(alamat);
        System.out.println(gaji_karyawan);
        System.out.println(tempat_lahir);
        System.out.println(tanggal_lahir);
        System.out.println(email);
        System.out.println(no_telpon);
        System.out.println(level);
        System.out.println(username);
        

        
        conn = koneksi.getkoneksi();
        String sql = "UPDATE input_data_karyawan set nama=?, jabatan=?, jenis_kelamin=?, agama=?, status=?, alamat=?,gaji_karyawan=?,tempat_lahir=?,tanggal_lahir=?,email=?,no_telpon=?,level=?,username=?,passwoard=? where nip=?";
        pst = conn.prepareStatement(sql);

        pst.setString(1, nama);
        pst.setString(2, jabatan);
        pst.setString(3, jenis_kelamin);
        pst.setString(4, agama);
        pst.setString(5, status);
        pst.setString(6, alamat);
        pst.setString(7, gaji_karyawan);
        pst.setString(8, tempat_lahir);
        pst.setString(9,tanggal_lahir);
        pst.setString(10, email);
        pst.setString(11, no_telpon);
        pst.setString(12, level);
        pst.setString(13, username);
        pst.setString(14, passwoard);
        pst.setString(15, nip);
        pst.executeUpdate();
        pst.close();
    }

    public void hapus() throws SQLException {
        conn = koneksi.getkoneksi();
        String sql = "DELETE from input_data_karyawan where nip=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nip);
            pst.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet UpdateTable() throws SQLException {
        conn = koneksi.getkoneksi();
        sql = "select nip,nama,jabatan,jenis_kelamin,agama,status, alamat,gaji_karyawan, tempat_lahir,tanggal_lahir,email,no_telpon,level,username from input_data_karyawan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    }
    

