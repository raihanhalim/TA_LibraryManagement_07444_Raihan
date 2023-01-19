package View;
import Entity.Entity_Buku;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Buku {
    JFrame buku = new JFrame();
    JLabel top, kodeBuku, judulBuku, penerbitBuku, genreBuku, hargaBuku;
    JTextField textKodeBuku, textJudulBuku, textPenerbitBuku, textGenreBuku, textHargaBuku;
    JButton btnTambahBuku, btnUbahBuku, btnHapusBuku, btnBack; 
    JTable tabelBuku = new JTable();
    JScrollPane scrollBuku = new JScrollPane(tabelBuku);
    int index;
    
    public GUI_Buku() {
        buku.setSize(900, 500);
        buku.setLayout(null);
        buku.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Data Buku");
        top.setBounds(358, 10, 184, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        buku.add(top);
        
        // Tabel Buku
        scrollBuku.setBounds(320, 90, 550, 345);
        tabelBuku.setModel(All_Object_Controller.c_buku.listBuku());
        tabelBuku.setBackground(new Color(0, 255, 0));
        tabelBuku.setForeground(new Color(255, 0, 0));
        buku.add(scrollBuku);
        
        // Input Kode Buku
        kodeBuku = new JLabel("Kode Buku");
        kodeBuku.setBounds(20, 90, 80, 30);
        kodeBuku.setForeground(new Color(255, 234, 0));
        buku.add(kodeBuku);
        
        textKodeBuku = new JTextField();
        textKodeBuku.setBounds(120, 90, 180, 30);
        textKodeBuku.setBackground(new Color(0, 255, 0));
        textKodeBuku.setForeground(new Color(255, 0, 0));
        textKodeBuku.setBorder(null);
        buku.add(textKodeBuku);
        
        // Input Judul Buku
        judulBuku = new JLabel("Judul Buku");
        judulBuku.setBounds(20, 130, 80, 30);
        judulBuku.setForeground(new Color(255, 234, 0));
        buku.add(judulBuku);
        
        textJudulBuku = new JTextField();
        textJudulBuku.setBounds(120, 130, 180, 30);
        textJudulBuku.setBackground(new Color(0, 255, 0));
        textJudulBuku.setForeground(new Color(255, 0, 0));
        textJudulBuku.setBorder(null);
        buku.add(textJudulBuku);
        
        // Input Penerbit Buku
        penerbitBuku = new JLabel("Penerbit Buku");
        penerbitBuku.setBounds(20, 170, 80, 30);
        penerbitBuku.setForeground(new Color(255, 234, 0));
        buku.add(penerbitBuku);
        
        textPenerbitBuku = new JTextField();
        textPenerbitBuku.setBounds(120, 170, 180, 30);
        textPenerbitBuku.setBackground(new Color(0, 255, 0));
        textPenerbitBuku.setForeground(new Color(255, 0, 0));
        textPenerbitBuku.setBorder(null);
        buku.add(textPenerbitBuku);
        
        // Input Genre Buku
        genreBuku = new JLabel("Genre Buku");
        genreBuku.setBounds(20, 210, 80, 30);
        genreBuku.setForeground(new Color(255, 234, 0));
        buku.add(genreBuku);
        
        textGenreBuku = new JTextField();
        textGenreBuku.setBounds(120, 210, 180, 30);
        textGenreBuku.setBackground(new Color(0, 255, 0));
        textGenreBuku.setForeground(new Color(255, 0, 0));
        textGenreBuku.setBorder(null);
        buku.add(textGenreBuku);
        
        // Input Harga Buku
        hargaBuku = new JLabel("Harga Buku");
        hargaBuku.setBounds(20, 250, 80, 30);
        hargaBuku.setForeground(new Color(255, 234, 0));
        buku.add(hargaBuku);
        
        textHargaBuku = new JTextField();
        textHargaBuku.setBounds(120, 250, 180, 30);
        textHargaBuku.setBackground(new Color(0, 255, 0));
        textHargaBuku.setForeground(new Color(255, 0, 0));
        textHargaBuku.setBorder(null);
        buku.add(textHargaBuku);
        
        // Button Tambah Buku
        btnTambahBuku = new JButton("Tambah Buku");
        btnTambahBuku.setBounds(94, 290, 112, 30);
        btnTambahBuku.setBackground(new Color(0, 255, 0));
        btnTambahBuku.setForeground(new Color(255, 0, 0));
        btnTambahBuku.setBorder(null);
        buku.add(btnTambahBuku);
        
        // Button Ubah Buku
        btnUbahBuku = new JButton("Ubah Buku");
        btnUbahBuku.setBounds(25, 330, 120, 30);
        btnUbahBuku.setBackground(new Color(0, 255, 0));
        btnUbahBuku.setForeground(new Color(255, 0, 0));
        btnUbahBuku.setBorder(null);
        buku.add(btnUbahBuku);
        
        // Button Hapus Buku
        btnHapusBuku = new JButton("Hapus Buku");
        btnHapusBuku.setBounds(170, 330, 120, 30);
        btnHapusBuku.setBackground(new Color(0, 255, 0));
        btnHapusBuku.setForeground(new Color(255, 0, 0));
        btnHapusBuku.setBorder(null);
        buku.add(btnHapusBuku);
        
        // Button Back
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 410, 100, 30);
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setBorder(null);
        buku.add(btnBack);
        
        // Close
        buku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buku.setVisible(true);
        buku.setLocationRelativeTo(null);
        
        // Action Button Tambah Buku
        btnTambahBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String kode = textKodeBuku.getText();
                    String judul =  textJudulBuku.getText();
                    String penerbit = textPenerbitBuku.getText();
                    String genre = textGenreBuku.getText();
                    int harga = Integer.valueOf(textHargaBuku.getText());
                    All_Object_Controller.c_buku.create(new Entity_Buku(kode, judul, penerbit, genre, harga));
                    JOptionPane.showMessageDialog(null, "Tambah Buku Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelBuku.setModel(All_Object_Controller.c_buku.listBuku());
                } catch(Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Information", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Action Button Ubah Buku
        btnUbahBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(All_Object_Controller.c_buku.view().size() > 0) {
                        String kode = textKodeBuku.getText();
                        String judul =  textJudulBuku.getText();
                        String penerbit = textPenerbitBuku.getText();
                        String genre = textGenreBuku.getText();
                        int harga = Integer.valueOf(textHargaBuku.getText());
                        index = All_Object_Controller.c_buku.cek_buku(kode);
                        
                        if(All_Object_Controller.c_buku.cek_buku(kode) == -1) {
                            JOptionPane.showMessageDialog(null, "Data Buku Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            All_Object_Controller.c_buku.update(index, new Entity_Buku(kode, judul, penerbit, genre, harga));
                            JOptionPane.showMessageDialog(null, "Ubah Buku Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                            reset();
                            tabelBuku.setModel(All_Object_Controller.c_buku.listBuku());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Buku Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    }
                } catch(Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Information", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Action Button Hapus Buku
        btnHapusBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(All_Object_Controller.c_buku.view().size() > 0) {
                    String kode = textKodeBuku.getText();
                    
                    if(kode.equals("")) {
                        JOptionPane.showMessageDialog(null, "Kode Buku Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(kode.equals(kode)) {
                        index = All_Object_Controller.c_buku.cek_buku(kode);
                        
                        if(All_Object_Controller.c_buku.cek_buku(kode) == -1) {
                            JOptionPane.showMessageDialog(null, "Data Buku Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            All_Object_Controller.c_buku.delete(index);
                            JOptionPane.showMessageDialog(null, "Hapus Buku Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                            tabelBuku.setModel(All_Object_Controller.c_buku.listBuku());
                            reset();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data Buku Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Action Tabel Buku
        tabelBuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelBuku.getSelectedRow();
                index = i;
                textKodeBuku.setText(All_Object_Controller.c_buku.listBuku().getValueAt(i, 0).toString());
                textJudulBuku.setText(All_Object_Controller.c_buku.listBuku().getValueAt(i, 1).toString());
                textPenerbitBuku.setText(All_Object_Controller.c_buku.listBuku().getValueAt(i, 2).toString());
                textGenreBuku.setText(All_Object_Controller.c_buku.listBuku().getValueAt(i, 3).toString());
                textHargaBuku.setText(All_Object_Controller.c_buku.listBuku().getValueAt(i, 4).toString()); 
            }            
        });
        
        // Action Button Back
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buku.dispose();
                GUI_Staff guiStaff = new GUI_Staff();
            }
        });
    }
    
    // Reset Input
    void reset() {
        textKodeBuku.setText(null); // Isi
        textJudulBuku.setText(null);
        textPenerbitBuku.setText(null);
        textGenreBuku.setText(null);
        textHargaBuku.setText(null);
    }
}
