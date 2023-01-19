package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Staff {
    JFrame staff = new JFrame();
    JLabel top;
    JButton btnBuku, btnAnggota, btnPeminjaman, btnBack;
    
    public GUI_Staff(){
        staff.setSize(600, 400);
        staff.setLayout(null);
        staff.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Menu Utama");
        top.setBounds(188, 10, 224, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        staff.add(top);
        
        // Data Buku
        btnBuku = new JButton("Data Buku");
        btnBuku.setBounds(150, 105, 300, 40);
        btnBuku.setBackground(new Color(0, 255, 0));
        btnBuku.setForeground(new Color(255, 0, 0));
        btnBuku.setBorder(null);
        staff.add(btnBuku);
        
        // Data Anggota
        btnAnggota = new JButton("Data Anggota");
        btnAnggota.setBounds(150, 165, 300, 40);
        btnAnggota.setBackground(new Color(0, 255, 0));
        btnAnggota.setForeground(new Color(255, 0, 0));
        btnAnggota.setBorder(null);
        staff.add(btnAnggota);
        
        // Data Peminjaman
        btnPeminjaman = new JButton("Data Peminjaman");
        btnPeminjaman.setBounds(150, 225, 300, 40);
        btnPeminjaman.setBackground(new Color(0, 255, 0));
        btnPeminjaman.setForeground(new Color(255, 0, 0));
        btnPeminjaman.setBorder(null);
        staff.add(btnPeminjaman);
        
        // Back
        btnBack = new JButton("Back");
        btnBack.setBounds(20, 310, 100, 30);
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setBorder(null);
        staff.add(btnBack);
        
        // Close
        staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staff.setVisible(true);
        staff.setLocationRelativeTo(null);
        
        // Action Button Data Buku
        btnBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                GUI_Buku guiBuku = new GUI_Buku();
            }
        });
        
        // Action Button Data Anggota
        btnAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                GUI_Anggota guiAnggota = new GUI_Anggota();
            }
        });
        
        // Action Button Data Peminjaman
        btnPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                GUI_Peminjaman guiPeminjaman = new GUI_Peminjaman();
            }
        });
        
        // Action Button Back
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                GUI_Login guiLogin = new GUI_Login();
            }
        });
    }
}
