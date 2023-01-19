package View;
import Entity.Entity_Anggota;
import Entity.Entity_Buku;
import Entity.Entity_Peminjaman;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Peminjaman {
    JFrame peminjaman = new JFrame();
    JLabel top, noIdAnggota, kodeBuku, noPinjam, tglPinjam, tglKembali;
    JTextField textNoIdAnggota, textKodeBuku, textNoPinjam, textTglPinjam, textTglKembali;
    JButton btnPinjamanBuku, btnKembalianBuku, btnBack;
    JTable tabelPeminjaman = new JTable();
    JScrollPane scrollPeminjaman = new JScrollPane(tabelPeminjaman);
    String noId, kode;
    int index, indexAnggota, indexBuku, lama, total;
    
    public GUI_Peminjaman() {
        peminjaman.setSize(1200, 500);
        peminjaman.setLayout(null);
        peminjaman.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Data Peminjaman");
        top.setBounds(130, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        peminjaman.add(top);
        
        // Tabel Peminjaman
        scrollPeminjaman.setBounds(320, 135, 850, 300);
        tabelPeminjaman.setModel(All_Object_Controller.c_peminjaman.listPeminjaman());
        tabelPeminjaman.setBackground(new Color(0, 255, 0));
        tabelPeminjaman.setForeground(new Color(255, 0, 0));
        peminjaman.add(scrollPeminjaman);
        
        // Input No Id Anggota
        noIdAnggota = new JLabel("No Id Anggota");
        noIdAnggota.setBounds(20, 135, 94, 30);
        noIdAnggota.setForeground(new Color(255, 234, 0));
        peminjaman.add(noIdAnggota);
        
        textNoIdAnggota = new JTextField();
        textNoIdAnggota.setBounds(130, 135, 170, 30);
        textNoIdAnggota.setBackground(new Color(0, 255, 0));
        textNoIdAnggota.setForeground(new Color(255, 0, 0));
        textNoIdAnggota.setBorder(null);
        peminjaman.add(textNoIdAnggota);
        
        // Input Kode Buku
        kodeBuku = new JLabel("Kode Buku");
        kodeBuku.setBounds(20, 175, 94, 30);
        kodeBuku.setForeground(new Color(255, 234, 0));
        peminjaman.add(kodeBuku);
        
        textKodeBuku = new JTextField();
        textKodeBuku.setBounds(130, 175, 170, 30);
        textKodeBuku.setBackground(new Color(0, 255, 0));
        textKodeBuku.setForeground(new Color(255, 0, 0));
        textKodeBuku.setBorder(null);
        peminjaman.add(textKodeBuku);
        
        // Input No Pinjam
        noPinjam = new JLabel("No Pinjam");
        noPinjam.setBounds(20, 215, 94, 30);
        noPinjam.setForeground(new Color(255, 234, 0));
        peminjaman.add(noPinjam);
        
        textNoPinjam = new JTextField();
        textNoPinjam.setBounds(130, 215, 170, 30);
        textNoPinjam.setBackground(new Color(0, 255, 0));
        textNoPinjam.setForeground(new Color(255, 0, 0));
        textNoPinjam.setBorder(null);
        peminjaman.add(textNoPinjam);
        
        // Input Tanggal Pinjam
        tglPinjam = new JLabel("Tanggal Pinjam");
        tglPinjam.setBounds(20, 255, 94, 30);
        tglPinjam.setForeground(new Color(255, 234, 0));
        peminjaman.add(tglPinjam);
        
        textTglPinjam = new JTextField();
        textTglPinjam.setBounds(130, 255, 170, 30);
        textTglPinjam.setBackground(new Color(0, 255, 0));
        textTglPinjam.setForeground(new Color(255, 0, 0));
        textTglPinjam.setBorder(null);
        peminjaman.add(textTglPinjam);
        
        // Input Tanggal Kembali
        tglKembali = new JLabel("Tanggal Kembali");
        tglKembali.setBounds(20, 295, 94, 30);
        tglKembali.setForeground(new Color(255, 234, 0));
        peminjaman.add(tglKembali);
        
        textTglKembali = new JTextField();
        textTglKembali.setBounds(130, 295, 170, 30);
        textTglKembali.setBackground(new Color(0, 255, 0));
        textTglKembali.setForeground(new Color(255, 0, 0));
        textTglKembali.setBorder(null);
        peminjaman.add(textTglKembali);
        
        // Button Pinjaman Buku
        btnPinjamanBuku = new JButton("Pinjaman Buku");
        btnPinjamanBuku.setBounds(25, 335, 120, 30);
        btnPinjamanBuku.setBackground(new Color(0, 255, 0));
        btnPinjamanBuku.setForeground(new Color(255, 0, 0));
        btnPinjamanBuku.setBorder(null);
        peminjaman.add(btnPinjamanBuku);
        
        // Button Kembalian Buku
        btnKembalianBuku = new JButton("Kembalian Buku");
        btnKembalianBuku.setBounds(164, 335, 126, 30);
        btnKembalianBuku.setBackground(new Color(0, 255, 0));
        btnKembalianBuku.setForeground(new Color(255, 0, 0));
        btnKembalianBuku.setBorder(null);
        peminjaman.add(btnKembalianBuku);
        
        // Button Back
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 410, 100, 30);
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setBorder(null);
        peminjaman.add(btnBack);
        
        // Close
        peminjaman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        peminjaman.setVisible(true);
        peminjaman.setLocationRelativeTo(null);
        
        // Action Button Pinjaman Buku
        btnPinjamanBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(All_Object_Controller.c_anggota.view().size() > 0 && All_Object_Controller.c_buku.view().size() > 0) {
                    noId = textNoIdAnggota.getText();
                    
                    if(noId.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Id Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId)) {
                        indexAnggota = All_Object_Controller.c_anggota.cek_anggota(noId);
                        
                        if(All_Object_Controller.c_anggota.cek_anggota(noId) == -1) {
                            JOptionPane.showMessageDialog(null, "Data Anggota Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            kode = textKodeBuku.getText();
                            
                            if(kode.equals("")) {
                                JOptionPane.showMessageDialog(null, "Kode Buku Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                            } else if(kode.equals(kode)) {
                                indexBuku = All_Object_Controller.c_buku.cek_buku(kode);
                                
                                if(All_Object_Controller.c_buku.cek_buku(kode) == -1) {
                                    JOptionPane.showMessageDialog(null, "Data Buku Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    String noPinjam1 = textNoPinjam.getText();
                                    String tgl_pinjam1 = textTglPinjam.getText();
                                    String tgl_kembali1 = textTglKembali.getText();
                                    
                                    if(noPinjam1.equals("") && tgl_pinjam1.equals("") && tgl_kembali1.equals("")) {
                                        JOptionPane.showMessageDialog(null, "No Pinjam, Tanggal Pinjam, Tanggal Kembali Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else if(noPinjam1.equals(noPinjam1) && tgl_pinjam1.equals("") && tgl_kembali1.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Tanggal Pinjam, Tanggal Kembali Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else if(noPinjam1.equals("") && tgl_pinjam1.equals(tgl_pinjam1) && tgl_kembali1.equals("")) {
                                        JOptionPane.showMessageDialog(null, "No Pinjam, Tanggal Kembali Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else if(noPinjam1.equals("") && tgl_pinjam1.equals("") && tgl_kembali1.equals(tgl_kembali1)) {
                                        JOptionPane.showMessageDialog(null, "No Pinjam, Tanggal Pinjam Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else if(noPinjam1.equals(noPinjam1) && tgl_pinjam1.equals(tgl_pinjam1) && tgl_kembali1.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Tanggal Kembali Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else if(noPinjam1.equals("") && tgl_pinjam1.equals(tgl_pinjam1) && tgl_kembali1.equals(tgl_kembali1)) {
                                        JOptionPane.showMessageDialog(null, "No Pinjam Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else if(noPinjam1.equals(noPinjam1) && tgl_pinjam1.equals("") && tgl_kembali1.equals(tgl_kembali1)) {
                                        JOptionPane.showMessageDialog(null, "Tanggal Pinjam Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        int noPinjam = Integer.valueOf(textNoPinjam.getText());
                                        int tgl_pinjam = Integer.valueOf(textTglPinjam.getText());
                                        int tgl_kembali = Integer.valueOf(textTglKembali.getText());
                                        
                                        if(tgl_kembali > tgl_pinjam) {
                                            lama = tgl_kembali - tgl_pinjam;
                                        } else {
                                            lama = tgl_kembali + 31 - tgl_pinjam;
                                        }
                                        total = lama * All_Object_Controller.c_buku.showDaftarBuku(indexBuku).getHarga();
                                        Entity_Anggota anggota = All_Object_Controller.c_anggota.searchById(noId);
                                        Entity_Buku buku = All_Object_Controller.c_buku.searchByKode(kode);
                                        All_Object_Controller.c_peminjaman.create(new Entity_Peminjaman(noPinjam, anggota, buku, tgl_pinjam, tgl_kembali, lama, total));
                                        JOptionPane.showMessageDialog(null, "Peminjaman Buku Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                                        reset();
                                        tabelPeminjaman.setModel(All_Object_Controller.c_peminjaman.listPeminjaman());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data Buku Atau Anggota Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        // Action Button Kembalian Buku
        btnKembalianBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(All_Object_Controller.c_peminjaman.view().size() > 0) {
                    peminjaman.dispose();
                    GUI_Pengembalian guiPengembalian = new GUI_Pengembalian();
                } else {
                    JOptionPane.showMessageDialog(null, "Data Peminjam Kosong", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        // Action Tabel Peminjaman
        tabelPeminjaman.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelPeminjaman.getSelectedRow();
                index = i;
                textNoIdAnggota.setText(All_Object_Controller.c_peminjaman.listPeminjaman().getValueAt(i, 0).toString());
                textKodeBuku.setText(All_Object_Controller.c_peminjaman.listPeminjaman().getValueAt(i, 2).toString());
                textNoPinjam.setText(All_Object_Controller.c_peminjaman.listPeminjaman().getValueAt(i, 6).toString());
                textTglPinjam.setText(All_Object_Controller.c_peminjaman.listPeminjaman().getValueAt(i, 7).toString());
                textTglKembali.setText(All_Object_Controller.c_peminjaman.listPeminjaman().getValueAt(i, 8).toString());
            }            
        });
        
        // Action Button Back
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peminjaman.dispose();
                GUI_Staff guiStaff = new GUI_Staff();
            }
        });
    }
    
    // Reset Input
    void reset() {
        textNoIdAnggota.setText(null);
        textKodeBuku.setText(null);
        textNoPinjam.setText(null); // Isi
        textTglPinjam.setText(null);
        textTglKembali.setText(null);
    }
}
