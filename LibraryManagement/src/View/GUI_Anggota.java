package View;
import Entity.Entity_Anggota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Anggota {
    JFrame anggota = new JFrame();
    JLabel top, noIdAnggota, namaAnggota, alamatAnggota, noTelpAnggota;
    JTextField textNoIdAnggota, textNamaAnggota, textAlamatAnggota, textNoTelpAnggota;
    JButton btnTambahAnggota, btnUbahAnggota, btnHapusAnggota, btnBack; 
    JTable tabelAnggota = new JTable();
    JScrollPane scrollAnggota = new JScrollPane(tabelAnggota);
    int index;
    
    public GUI_Anggota() {
        anggota.setSize(900, 500);
        anggota.setLayout(null);
        anggota.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Data Anggota");
        top.setBounds(358, 10, 234, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        anggota.add(top);
        
        // Tabel Anggota
        scrollAnggota.setBounds(320, 120, 550, 315);
        tabelAnggota.setModel(All_Object_Controller.c_anggota.listAnggota());
        tabelAnggota.setBackground(Color.GREEN);
        tabelAnggota.setForeground(new Color(255, 0, 0));
        anggota.add(scrollAnggota);
        
        // Input No Id Anggota
        noIdAnggota = new JLabel("No Id Anggota");
        noIdAnggota.setBounds(20, 120, 92, 30);
        noIdAnggota.setForeground(new Color(255, 234, 0));
        anggota.add(noIdAnggota);
        
        textNoIdAnggota = new JTextField();
        textNoIdAnggota.setBounds(120, 120, 180, 30);
        textNoIdAnggota.setBackground(new Color(0, 255, 0));
        textNoIdAnggota.setForeground(new Color(255, 0, 0));
        textNoIdAnggota.setBorder(null);
        anggota.add(textNoIdAnggota);
        
        // Input Nama Anggota
        namaAnggota = new JLabel("Nama Anggota");
        namaAnggota.setBounds(20, 160, 92, 30);
        namaAnggota.setForeground(new Color(255, 234, 0));
        anggota.add(namaAnggota);
        
        textNamaAnggota = new JTextField();
        textNamaAnggota.setBounds(120, 160, 180, 30);
        textNamaAnggota.setBackground(new Color(0, 255, 0));
        textNamaAnggota.setForeground(new Color(255, 0, 0));
        textNamaAnggota.setBorder(null);
        anggota.add(textNamaAnggota);
        
        // Input Alamat Anggota
        alamatAnggota = new JLabel("Alamat Anggota");
        alamatAnggota.setBounds(20, 200, 92, 30);
        alamatAnggota.setForeground(new Color(255, 234, 0));
        anggota.add(alamatAnggota);
        
        textAlamatAnggota = new JTextField();
        textAlamatAnggota.setBounds(120, 200, 180, 30);
        textAlamatAnggota.setBackground(new Color(0, 255, 0));
        textAlamatAnggota.setForeground(new Color(255, 0, 0));
        textAlamatAnggota.setBorder(null);
        anggota.add(textAlamatAnggota);
        
        // Input No Telp Anggota
        noTelpAnggota = new JLabel("No Telp Anggota");
        noTelpAnggota.setBounds(20, 240, 92, 30);
        noTelpAnggota.setForeground(new Color(255, 234, 0));
        anggota.add(noTelpAnggota);
        
        textNoTelpAnggota = new JTextField();
        textNoTelpAnggota.setBounds(120, 240, 180, 30);
        textNoTelpAnggota.setBackground(new Color(0, 255, 0));
        textNoTelpAnggota.setForeground(new Color(255, 0, 0));
        textNoTelpAnggota.setBorder(null);
        anggota.add(textNoTelpAnggota);
        
        // Button Tambah Anggota
        btnTambahAnggota = new JButton("Tambah Anggota");
        btnTambahAnggota.setBounds(85, 280, 130, 30);
        btnTambahAnggota.setBackground(new Color(0, 255, 0));
        btnTambahAnggota.setForeground(new Color(255, 0, 0));
        btnTambahAnggota.setBorder(null);
        anggota.add(btnTambahAnggota);
        
        // Button Ubah Anggota
        btnUbahAnggota = new JButton("Ubah Anggota");
        btnUbahAnggota.setBounds(25, 320, 120, 30);
        btnUbahAnggota.setBackground(new Color(0, 255, 0));
        btnUbahAnggota.setForeground(new Color(255, 0, 0));
        btnUbahAnggota.setBorder(null);
        anggota.add(btnUbahAnggota);
        
        // Button Hapus Anggota
        btnHapusAnggota = new JButton("Hapus Anggota");
        btnHapusAnggota.setBounds(170, 320, 120, 30);
        btnHapusAnggota.setBackground(new Color(0, 255, 0));
        btnHapusAnggota.setForeground(new Color(255, 0, 0));
        btnHapusAnggota.setBorder(null);
        anggota.add(btnHapusAnggota);
        
        // Button Back
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 410, 100, 30);
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setBorder(null);
        anggota.add(btnBack);
        
        // Close
        anggota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anggota.setVisible(true);
        anggota.setLocationRelativeTo(null);
        
        // Action Button Tambah Anggota
        btnTambahAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noId = textNoIdAnggota.getText();
                String nama =  textNamaAnggota.getText();
                String alamat = textAlamatAnggota.getText();
                String noTelp = textNoTelpAnggota.getText();
                
                if(noId.equals("") && nama.equals("") && alamat.equals("") && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "Semua Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals(noId) && nama.equals("") && alamat.equals("") && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama, Alamat, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals("") && nama.equals(nama) && alamat.equals("") && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Id, Alamat, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals("") && nama.equals("") && alamat.equals(alamat) && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Id, Nama, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals("") && nama.equals("") && alamat.equals("") && noTelp.equals(noTelp)) {
                    JOptionPane.showMessageDialog(null, "No Id, Nama, Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals(noId) && nama.equals(nama) && alamat.equals("") && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "Alamat, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals("") && nama.equals(nama) && alamat.equals(alamat) && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Id, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals("") && nama.equals("") && alamat.equals(alamat) && noTelp.equals(noTelp)) {
                    JOptionPane.showMessageDialog(null, "No Id, Nama Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals(noId) && nama.equals("") && alamat.equals("") && noTelp.equals(noTelp)) {
                    JOptionPane.showMessageDialog(null, "Nama, Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals(noId) && nama.equals(nama) && alamat.equals(alamat) && noTelp.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals("") && nama.equals(nama) && alamat.equals(alamat) && noTelp.equals(noTelp)) {
                    JOptionPane.showMessageDialog(null, "No Id Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals(noId) && nama.equals("") && alamat.equals(alamat) && noTelp.equals(noTelp)) {
                    JOptionPane.showMessageDialog(null, "Nama Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(noId.equals(noId) && nama.equals(nama) && alamat.equals("") && noTelp.equals(noTelp)) {
                    JOptionPane.showMessageDialog(null, "Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else {
                    All_Object_Controller.c_anggota.create(new Entity_Anggota(noId, nama, alamat, noTelp));
                    JOptionPane.showMessageDialog(null, "Tambah Anggota Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelAnggota.setModel(All_Object_Controller.c_anggota.listAnggota());
                }
            }
        });
        
        // Action Button Ubah Anggota
        btnUbahAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(All_Object_Controller.c_anggota.view().size() > 0) {
                    String noId = textNoIdAnggota.getText();
                    String nama =  textNamaAnggota.getText();
                    String alamat = textAlamatAnggota.getText();
                    String noTelp = textNoTelpAnggota.getText();
                    index = All_Object_Controller.c_anggota.cek_anggota(noId);
                    
                    if(noId.equals("") && nama.equals("") && alamat.equals("") && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "Semua Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId) && nama.equals("") && alamat.equals("") && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "Nama, Alamat, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals("") && nama.equals(nama) && alamat.equals("") && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Id, Alamat, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals("") && nama.equals("") && alamat.equals(alamat) && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Id, Nama, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals("") && nama.equals("") && alamat.equals("") && noTelp.equals(noTelp)) {
                        JOptionPane.showMessageDialog(null, "No Id, Nama, Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId) && nama.equals(nama) && alamat.equals("") && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "Alamat, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals("") && nama.equals(nama) && alamat.equals(alamat) && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Id, No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals("") && nama.equals("") && alamat.equals(alamat) && noTelp.equals(noTelp)) {
                        JOptionPane.showMessageDialog(null, "No Id, Nama Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId) && nama.equals("") && alamat.equals("") && noTelp.equals(noTelp)) {
                        JOptionPane.showMessageDialog(null, "Nama, Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId) && nama.equals(nama) && alamat.equals(alamat) && noTelp.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Telp Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals("") && nama.equals(nama) && alamat.equals(alamat) && noTelp.equals(noTelp)) {
                        JOptionPane.showMessageDialog(null, "No Id Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId) && nama.equals("") && alamat.equals(alamat) && noTelp.equals(noTelp)) {
                        JOptionPane.showMessageDialog(null, "Nama Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId) && nama.equals(nama) && alamat.equals("") && noTelp.equals(noTelp)) {
                        JOptionPane.showMessageDialog(null, "Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(All_Object_Controller.c_anggota.cek_anggota(noId) == -1) {
                        JOptionPane.showMessageDialog(null, "Data Anggota Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        All_Object_Controller.c_anggota.update(index, new Entity_Anggota(noId, nama, alamat, noTelp));
                        JOptionPane.showMessageDialog(null, "Ubah Anggota Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                        reset();
                        tabelAnggota.setModel(All_Object_Controller.c_anggota.listAnggota());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data Anggota Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Action Button Hapus Anggota
        btnHapusAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(All_Object_Controller.c_anggota.view().size() > 0) {
                    String noId = textNoIdAnggota.getText();
                    
                    if(noId.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Id Anggota Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                    } else if(noId.equals(noId)) {
                        index = All_Object_Controller.c_anggota.cek_anggota(noId);
                        
                        if(All_Object_Controller.c_anggota.cek_anggota(noId) == -1) {
                            JOptionPane.showMessageDialog(null, "Data Anggota Tidak Ada", "Information", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            All_Object_Controller.c_anggota.delete(index);
                            JOptionPane.showMessageDialog(null, "Hapus Anggota Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                            tabelAnggota.setModel(All_Object_Controller.c_anggota.listAnggota());
                            reset();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data Anggota Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Action Tabel Anggota
        tabelAnggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelAnggota.getSelectedRow();
                index = i;
                textNoIdAnggota.setText(All_Object_Controller.c_anggota.listAnggota().getValueAt(i, 0).toString());
                textNamaAnggota.setText(All_Object_Controller.c_anggota.listAnggota().getValueAt(i, 1).toString());
                textAlamatAnggota.setText(All_Object_Controller.c_anggota.listAnggota().getValueAt(i, 2).toString());
                textNoTelpAnggota.setText(All_Object_Controller.c_anggota.listAnggota().getValueAt(i, 3).toString());
            }            
        });
        
        // Action Button Back
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anggota.dispose();
                GUI_Staff guiStaff = new GUI_Staff();
            }
        });
    }
    
    // Reset Input
    void reset() {
        textNoIdAnggota.setText(null); // Isi
        textNamaAnggota.setText(null);
        textAlamatAnggota.setText(null);
        textNoTelpAnggota.setText(null);
    }
}
