package com.pemesananmakanan;
import java.util.*;
import javax.swing.JOptionPane;

public class FormMenu extends javax.swing.JFrame {
    public FormMenu() {
        initComponents();
    }
    
    private void prosesPesanan() {
    String input = jTextArea1.getText().trim();


    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Silakan masukkan pesanan terlebih dahulu.");
        return;
    }

    Map<String, Integer> daftarHarga = new HashMap<>();
    daftarHarga.put("C1", 30000); // Nasi Goreng
    daftarHarga.put("C2", 28000); // Mi Goreng
    daftarHarga.put("C3", 28000); // Mi Rebus
    daftarHarga.put("D1", 10000); // Jus Mangga
    daftarHarga.put("D2", 5000);  // Air Mineral
    daftarHarga.put("D3", 12000); // Es Campur

    int total = 0;
    StringBuilder struk = new StringBuilder();
    struk.append("Struk Pemesanan:\n");

    try {
        String[] pesanan = input.split(";"); 
        for (String item : pesanan) {
            String[] detail = item.trim().split(",");
            if (detail.length != 2) continue;

            String kode = detail[0].trim().toUpperCase();
            int jumlah = Integer.parseInt(detail[1].trim());

            if (daftarHarga.containsKey(kode)) {
                int harga = daftarHarga.get(kode);
                int subtotal = harga * jumlah;
                total += subtotal;
                struk.append(kode).append(" x ").append(jumlah)
                     .append(" = Rp").append(subtotal).append("\n");
            } else {
                struk.append("Kode tidak dikenal: ").append(kode).append("\n");
            }
        }

        struk.append("\nTotal Bayar: Rp").append(total);
        JOptionPane.showMessageDialog(this, struk.toString());

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Format input salah. Gunakan format: C1,2;D3,1");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextField();
        btnPesan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/menu.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel3.setText("Masukkan  Kode dan Jumlah makanan (Contoh C1,1)");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Minuman.jpeg"))); // NOI18N
        jLabel4.setText("jLabel4");

        btnPesan.setText("Pesan");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3))
                            .addComponent(btnPesan)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesan)
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
         prosesPesanan();
    }//GEN-LAST:event_btnPesanActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextArea1;
    // End of variables declaration//GEN-END:variables
}
