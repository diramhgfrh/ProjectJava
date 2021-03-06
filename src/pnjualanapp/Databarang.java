package pnjualanapp;


import MenuUtama.MenuUtama;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import method.data.ControlBarang;
import method.data.databarang;

public class Databarang extends javax.swing.JFrame {
    int x = 0;
    private DefaultTableModel model;
        ControlBarang ob = new ControlBarang();
        databarang DO = new databarang();
        List<databarang> ListBarang = new ArrayList<databarang>(); 
        
    public Databarang() {
        initComponents();
        buatTable();
        showTable();
        bersih();
        siapIsi(false);
        tombolNormal();
        this.setLocationRelativeTo(null);
    }
    private void buatTable(){
        model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Satuan");
        model.addColumn("Harga Jual");
        model.addColumn("Harga Beli");
        model.addColumn("Stok");
        tbdatabarang.setModel(model);
    }
    private void showTable(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListBarang.clear();
        ListBarang=ob.tampil();
        for (x=0; x<ListBarang.size(); x++) {
        Object[] data=new Object[6];
        data[0]=ListBarang.get(x).getkdbarang();
        data[1]=ListBarang.get(x).getnmbarang();
        data[2]=ListBarang.get(x).getsatuan();
        data[3]=ListBarang.get(x).getharga_jual();
        data[4]=ListBarang.get(x).getharga_beli();
        data[5]=ListBarang.get(x).getstok();
        model.addRow(data);
        }
    }
    private void buatkdbarang(){
        ListBarang=ob.tampil();
        int a=ListBarang.size()-1;
        int no=Integer.parseInt(ListBarang.get(a).getkdbarang().replace("A", ""))+1;
        kdbarang.setText("A"+no);
        kdbarang.setEnabled(false);
    }
    private void siapIsi(boolean a){
            kdbarang.setEnabled(a);
            nmbarang.setEnabled(a);
            cmbsatuan.setEnabled(a);
            stok.setEnabled(a);
            hrgjual.setEnabled(a);
            hrgbeli.setEnabled(a);
    }
    private void bersih(){
        kdbarang.setText("");
        nmbarang.setText("");
        cmbsatuan.setSelectedItem("Pilih");
        stok.setText("");
        hrgjual.setText("");
        hrgbeli.setText("");
    }
    private void tombolNormal(){
        btnsimpan.setEnabled(false);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
    }
    private void tombolKembali(){
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        lbdatabarang = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatabarang = new javax.swing.JTable();
        carikd = new javax.swing.JLabel();
        kodebr = new javax.swing.JLabel();
        labelnamabarang = new javax.swing.JLabel();
        labelsatuan = new javax.swing.JLabel();
        labelhargajual = new javax.swing.JLabel();
        labelhargabeli = new javax.swing.JLabel();
        labelstok = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        stok = new javax.swing.JTextField();
        kdbarang = new javax.swing.JTextField();
        nmbarang = new javax.swing.JTextField();
        cmbsatuan = new javax.swing.JComboBox();
        hrgjual = new javax.swing.JTextField();
        hrgbeli = new javax.swing.JTextField();
        tcari = new javax.swing.JTextField();
        kembali = new javax.swing.JToggleButton();
        Keluar = new javax.swing.JToggleButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(0, 102, 0));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbdatabarang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbdatabarang.setForeground(new java.awt.Color(255, 255, 255));
        lbdatabarang.setText("DATA BARANG");
        panel1.add(lbdatabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 40));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 80));

        panel2.setBackground(new java.awt.Color(0, 102, 0));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbdatabarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdatabarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdatabarang);

        panel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 100));

        carikd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        carikd.setForeground(new java.awt.Color(255, 255, 255));
        carikd.setText("Cari berdasarkan kode barang");
        panel2.add(carikd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 240, 30));

        kodebr.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        kodebr.setForeground(new java.awt.Color(255, 255, 255));
        kodebr.setText("Kode Barang");
        panel2.add(kodebr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 20));

        labelnamabarang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelnamabarang.setForeground(new java.awt.Color(255, 255, 255));
        labelnamabarang.setText("Nama Barang");
        panel2.add(labelnamabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 20));

        labelsatuan.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelsatuan.setForeground(new java.awt.Color(255, 255, 255));
        labelsatuan.setText("Satuan");
        panel2.add(labelsatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, 20));

        labelhargajual.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelhargajual.setForeground(new java.awt.Color(255, 255, 255));
        labelhargajual.setText("Harga Jual");
        panel2.add(labelhargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 20));

        labelhargabeli.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelhargabeli.setForeground(new java.awt.Color(255, 255, 255));
        labelhargabeli.setText("Harga Beli");
        panel2.add(labelhargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 20));

        labelstok.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelstok.setForeground(new java.awt.Color(255, 255, 255));
        labelstok.setText("Stok");
        panel2.add(labelstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 20));

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        panel2.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        panel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        panel2.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        panel2.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokActionPerformed(evt);
            }
        });
        panel2.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 140, 30));

        kdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdbarangActionPerformed(evt);
            }
        });
        panel2.add(kdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 140, 30));

        nmbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmbarangActionPerformed(evt);
            }
        });
        panel2.add(nmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 140, 30));

        cmbsatuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Dus", "Pcs", "Pack", "Sachet", " " }));
        panel2.add(cmbsatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 90, -1));

        hrgjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrgjualActionPerformed(evt);
            }
        });
        panel2.add(hrgjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 140, 30));

        hrgbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrgbeliActionPerformed(evt);
            }
        });
        panel2.add(hrgbeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 140, 30));

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });
        panel2.add(tcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 240, 30));

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        panel2.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        Keluar.setText("Keluar");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });
        panel2.add(Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, -1, -1));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 770, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
    DO.setkdbarang(kdbarang.getText());
    int pesan = JOptionPane.showConfirmDialog(null, "Data akan dihapus?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (ob.deletebarang(DO)==1) {
        JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
            bersih();
            siapIsi(false);
            tombolNormal();
            buatTable();
            showTable();
        }else{
        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if (btnedit.getText().equalsIgnoreCase("Edit")) {
        btnedit.setText("Batal");
        siapIsi(true);
        kdbarang.setEnabled(false);
        nmbarang.requestFocus();
        btntambah.setEnabled(false);
        btnsimpan.setEnabled(true);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(true);
        }else{
            btnedit.setText("Edit");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokActionPerformed

    private void kdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kdbarangActionPerformed

    private void nmbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmbarangActionPerformed

    private void hrgjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrgjualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrgjualActionPerformed

    private void hrgbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrgbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrgbeliActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed

    }//GEN-LAST:event_tcariActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
    if (nmbarang.getText().isEmpty() || cmbsatuan.getSelectedItem().equals("") || stok.getText().isEmpty()
         || hrgjual.getText().isEmpty() || hrgbeli.getText().isEmpty()) {
         JOptionPane.showMessageDialog(null, "Data Harus Lengkap", "Aplikasi Penjualan", JOptionPane.INFORMATION_MESSAGE);
     }else{
        DO.setkdbarang(kdbarang.getText());
        DO.setnmbarang(nmbarang.getText());
        DO.setsatuan(cmbsatuan.getSelectedItem().toString());
        DO.setstok(Integer.parseInt(stok.getText()));
        DO.setharga_jual(Integer.parseInt(hrgjual.getText()));
        DO.setharga_beli(Integer.parseInt(hrgbeli.getText()));
    if (btntambah.getText().equalsIgnoreCase("Batal")) {
    if (ob.tambahbarang(DO)==1) {
          JOptionPane.showMessageDialog(null, "Data Telah Di Simpan", "Aplikasi Penjualan", JOptionPane.INFORMATION_MESSAGE);
          buatTable();
          showTable();
     }else{
          JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan", "Aplikasi Penjualan", JOptionPane.INFORMATION_MESSAGE);
          }
          }
    if (btnedit.getText().equalsIgnoreCase("Batal")) {
    if (ob.editbarang(DO)==1) {
          JOptionPane.showMessageDialog(null, "Data Telah Diubah", "Aplikasi Penjualan", JOptionPane.INFORMATION_MESSAGE);
          buatTable();
          showTable();
     }else{
          JOptionPane.showMessageDialog(null, "Data Gagal Diubah", "Aplikasi Penjualan", JOptionPane.INFORMATION_MESSAGE);
           }
            }
            bersih();
            siapIsi(false);
            btntambah.setText("Tambah");
            btnedit.setText("Edit");
            tombolNormal();
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        if (btntambah.getText().equalsIgnoreCase("Tambah")) {
        btntambah.setText("Batal");
        bersih();
        siapIsi(true);
        buatkdbarang();
        nmbarang.requestFocus();
        tombolKembali();
        }else{
            btntambah.setText("Tambah");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void tbdatabarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdatabarangMouseClicked
    int baris=tbdatabarang.getSelectedRow();
    kdbarang.setText(tbdatabarang.getModel().getValueAt(baris, 0).toString());
    nmbarang.setText(tbdatabarang.getModel().getValueAt(baris, 1).toString());
    cmbsatuan.setSelectedItem(tbdatabarang.getModel().getValueAt(baris, 2).toString());
    hrgjual.setText(tbdatabarang.getModel().getValueAt(baris, 3).toString());
    hrgbeli.setText(tbdatabarang.getModel().getValueAt(baris, 4).toString());
    stok.setText(tbdatabarang.getModel().getValueAt(baris, 5).toString());
        siapIsi(false);
        btnhapus.setEnabled(true);
        btnedit.setEnabled(true); 
    }//GEN-LAST:event_tbdatabarangMouseClicked

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
    String cari=null;
    cari=tcari.getText();
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    ListBarang.clear();
    ListBarang=ob.cariBarang(cari);
        for (x=0; x<ListBarang.size(); x++) {
        Object[] data=new Object[6];
        data[0]=ListBarang.get(x).getkdbarang();
        data[1]=ListBarang.get(x).getnmbarang();
        data[2]=ListBarang.get(x).getsatuan();
        data[3]=ListBarang.get(x).getharga_jual();
        data[4]=ListBarang.get(x).getharga_beli();
        data[5]=ListBarang.get(x).getstok();
        model.addRow(data);
        }
    }//GEN-LAST:event_tcariKeyReleased

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
         MenuUtama fb = new MenuUtama();
        fb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_kembaliActionPerformed

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_KeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Databarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Keluar;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel carikd;
    private javax.swing.JComboBox cmbsatuan;
    private javax.swing.JTextField hrgbeli;
    private javax.swing.JTextField hrgjual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kdbarang;
    private javax.swing.JToggleButton kembali;
    private javax.swing.JLabel kodebr;
    private javax.swing.JLabel labelhargabeli;
    private javax.swing.JLabel labelhargajual;
    private javax.swing.JLabel labelnamabarang;
    private javax.swing.JLabel labelsatuan;
    private javax.swing.JLabel labelstok;
    private javax.swing.JLabel lbdatabarang;
    private javax.swing.JTextField nmbarang;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTextField stok;
    private javax.swing.JTable tbdatabarang;
    private javax.swing.JTextField tcari;
    // End of variables declaration//GEN-END:variables
}
