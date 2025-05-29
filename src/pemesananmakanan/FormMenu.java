package pemesananmakanan;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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

    Map<String, Object> daftarMenu = new HashMap<>();
    daftarMenu.put("C1", new Makanan("C1", "Nasi Goreng", 30000));
    daftarMenu.put("C2", new Makanan("C2", "Mi Goreng", 28000));
    daftarMenu.put("C3", new Makanan("C3", "Mi Rebus", 28000));
    daftarMenu.put("D1", new Minuman("D1", "Jus Mangga", 10000));
    daftarMenu.put("D2", new Minuman("D2", "Air Mineral", 5000));
    daftarMenu.put("D3", new Minuman("D3", "Es Campur", 12000));

    int total = 0;
    List<Pemesanan> daftarPesanan = new ArrayList<>();
    StringBuilder struk = new StringBuilder("Struk Pemesanan:\n");

        try {
            String[] pesananArray = input.split(";");
            for (String item : pesananArray) {
                String[] detail = item.trim().split(",");
                if (detail.length != 2) continue;

                String kode = detail[0].trim().toUpperCase();
                int jumlah = Integer.parseInt(detail[1].trim());

                if (daftarMenu.containsKey(kode)) {
                    Object menu = daftarMenu.get(kode);
                    String nama = "";
                    int harga = 0;

                    if (menu instanceof Makanan m) {
                        nama = m.getNama();
                        harga = m.getHarga();
                    } else if (menu instanceof Minuman m) {
                        nama = m.getNama();
                        harga = m.getHarga();
                    }

                    Pemesanan pesanan = new Pemesanan(kode, nama, harga, jumlah);
                    daftarPesanan.add(pesanan);
                    total += pesanan.getSubtotal();
                    struk.append(pesanan.toString()).append("\n");
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
    // </editor-fold>

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
    
   private void initComponents() {
        jLabel1 = new JLabel("Masukkan Kode dan Jumlah (misal: C1,2;D1,1)");
        jTextArea1 = new JTextField(30);
        btnPesan = new JButton("Pesan");

        btnPesan.addActionListener(evt -> prosesPesanan());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Form Pemesanan");

        JPanel panel = new JPanel();
        panel.add(jLabel1);
        panel.add(jTextArea1);
        panel.add(btnPesan);

        add(panel);
        pack();
        setLocationRelativeTo(null); // Tengah layar
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new FormMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextArea1;
    // End of variables declaration//GEN-END:variables
}
