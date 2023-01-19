package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Pengembalian {
    JFrame pengembalian = new JFrame();
    JLabel top, noPinjam, tglSekarang;
    JTextField textNoPinjam, textTglSekarang;
    JButton btnKembalianBuku, btnBack;
    int indexPinjam, no_pinjam, tgl_sekarang, lama, denda, total;
    
    public GUI_Pengembalian() {
        pengembalian.setSize(500, 400);
        pengembalian.setLayout(null);
        pengembalian.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Data Pengembalian");
        top.setBounds(83, 10, 334, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        pengembalian.add(top);
        
        // Input No Pinjam
        noPinjam = new JLabel("No Pinjam");
        noPinjam.setBounds(90, 130, 104, 30);
        noPinjam.setForeground(new Color(255, 234, 0));
        pengembalian.add(noPinjam);
        
        textNoPinjam = new JTextField();
        textNoPinjam.setBounds(200, 130, 170, 30);
        textNoPinjam.setBackground(new Color(0, 255, 0));
        textNoPinjam.setForeground(new Color(255, 0, 0));
        textNoPinjam.setBorder(null);
        pengembalian.add(textNoPinjam);
        
        // Input Tanggal Sekarang
        tglSekarang = new JLabel("Tanggal Sekarang");
        tglSekarang.setBounds(90, 170, 104, 30);
        tglSekarang.setForeground(new Color(255, 234, 0));
        pengembalian.add(tglSekarang);
        
        textTglSekarang = new JTextField();
        textTglSekarang.setBounds(200, 170, 170, 30);
        textTglSekarang.setBackground(new Color(0, 255, 0));
        textTglSekarang.setForeground(new Color(255, 0, 0));
        textTglSekarang.setBorder(null);
        pengembalian.add(textTglSekarang);
        
        // Button Kembalian Buku
        btnKembalianBuku = new JButton("Kembalian Buku");
        btnKembalianBuku.setBounds(165, 210, 130, 30);
        btnKembalianBuku.setBackground(new Color(0, 255, 0));
        btnKembalianBuku.setForeground(new Color(255, 0, 0));
        btnKembalianBuku.setBorder(null);
        pengembalian.add(btnKembalianBuku);
        
        // Button Back
        btnBack = new JButton("Back");
        btnBack.setBounds(18, 310, 100, 30);
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setBorder(null);
        pengembalian.add(btnBack);
        
        // Close
        pengembalian.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pengembalian.setVisible(true);
        pengembalian.setLocationRelativeTo(null);
        
        // Action Button Kembalian Buku
        btnKembalianBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String no_pinjam1 = textNoPinjam.getText();
                
                if(no_pinjam1.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Pinjam Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_pinjam1.equals(no_pinjam1)) {
                    no_pinjam = Integer.valueOf(textNoPinjam.getText());
                    indexPinjam = All_Object_Controller.c_peminjaman.cek_peminjaman(no_pinjam);
                    
                    if(All_Object_Controller.c_peminjaman.cek_peminjaman(no_pinjam) == -1) {
                        JOptionPane.showMessageDialog(null, "Data Peminjaman Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String tgl_sekarang1 = textTglSekarang.getText();
                        
                        if(tgl_sekarang1.equals("")) {
                            JOptionPane.showMessageDialog(null, "Tanggal Sekarang Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                        } else if(tgl_sekarang1.equals(tgl_sekarang1)) {
                            tgl_sekarang = Integer.valueOf(textTglSekarang.getText());
                            lama = tgl_sekarang - All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getTgl_kembali();
                            denda = lama * All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getBuku().getHarga();
                            total = denda + All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getTotal();
                            
                            if(tgl_sekarang > All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getTgl_kembali()) {
                                JOptionPane.showMessageDialog(null, "Kamu terkena denda sebesar " + denda + " dengan total yang harus dibayar " + total + "\n Dan silahkan dikembalian buku yang di pinjam", "Information", JOptionPane.INFORMATION_MESSAGE);
                                All_Object_Controller.c_peminjaman.delete(indexPinjam);
                                pengembalian.dispose();
                                GUI_Peminjaman guiPeminjaman = new GUI_Peminjaman();
                                guiPeminjaman.tabelPeminjaman.setModel(All_Object_Controller.c_peminjaman.listPeminjaman());
                            } else if(tgl_sekarang > All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getTgl_pinjam() && tgl_sekarang <= All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getTgl_kembali()) {
                                JOptionPane.showMessageDialog(null, "Silahkan dibayar sebesar " + All_Object_Controller.c_peminjaman.showDaftarPeminjaman(indexPinjam).getTotal() + "\n Dan dikembalikan buku yang di pinjam", "Information", JOptionPane.INFORMATION_MESSAGE);
                                All_Object_Controller.c_peminjaman.delete(indexPinjam);
                                pengembalian.dispose();
                                GUI_Peminjaman guiPeminjaman = new GUI_Peminjaman();
                                guiPeminjaman.tabelPeminjaman.setModel(All_Object_Controller.c_peminjaman.listPeminjaman());
                            }
                        }
                    }
                }
            }
        });
        
        // Action Button Back
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pengembalian.dispose();
                GUI_Peminjaman guiPeminjaman = new GUI_Peminjaman();
            }
        });
    }
    
    // Reset Input
    void reset() {
        textNoPinjam.setText(null);
        textTglSekarang.setText(null);
    }
}
