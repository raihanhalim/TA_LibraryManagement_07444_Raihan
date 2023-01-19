package View;
import Entity.Entity_Staff;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Registrasi {
    JFrame staffRegis = new JFrame();
    JLabel top, noIdRegis, namaRegis, alamatRegis, passRegis;
    JTextField textNoIdRegis, textNamaRegis, textAlamatRegis;
    JPasswordField textPassRegis;
    JButton btnRegis, btnBack;
    
    public GUI_Registrasi() {
        staffRegis.setSize(300, 500);
        staffRegis.setLayout(null);
        staffRegis.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Registrasi");
        top.setBounds(64, 10, 172, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        staffRegis.add(top);
        
        // Input No Id
        noIdRegis = new JLabel("No Id");
        noIdRegis.setBounds(18, 130, 58, 30);
        noIdRegis.setForeground(new Color(255, 234, 0));
        staffRegis.add(noIdRegis);
        
        textNoIdRegis = new JTextField();
        textNoIdRegis.setBounds(90, 130, 170, 30);
        textNoIdRegis.setBackground(new Color(0, 255, 0));
        textNoIdRegis.setForeground(new Color(255, 0, 0));
        textNoIdRegis.setBorder(null);
        staffRegis.add(textNoIdRegis);
        
        // Input Nama
        namaRegis = new JLabel("Nama");
        namaRegis.setBounds(18, 170, 58, 30);
        namaRegis.setForeground(new Color(255, 234, 0));
        staffRegis.add(namaRegis);
        
        textNamaRegis = new JTextField();
        textNamaRegis.setBounds(90, 170, 170, 30);
        textNamaRegis.setBackground(new Color(0, 255, 0));
        textNamaRegis.setForeground(new Color(255, 0, 0));
        textNamaRegis.setBorder(null);
        staffRegis.add(textNamaRegis);
        
        // Input Alamat
        alamatRegis = new JLabel("Alamat");
        alamatRegis.setBounds(18, 210, 58, 30);
        alamatRegis.setForeground(new Color(255, 234, 0));
        staffRegis.add(alamatRegis);
        
        textAlamatRegis = new JTextField();
        textAlamatRegis.setBounds(90, 210, 170, 30);
        textAlamatRegis.setBackground(new Color(0, 255, 0));
        textAlamatRegis.setForeground(new Color(255, 0, 0));
        textAlamatRegis.setBorder(null);
        staffRegis.add(textAlamatRegis);
        
        // Input Password
        passRegis = new JLabel("Password");
        passRegis.setBounds(18, 250, 58, 30);
        passRegis.setForeground(new Color(255, 234, 0));
        staffRegis.add(passRegis);
        
        textPassRegis = new JPasswordField();
        textPassRegis.setBounds(90, 250, 170, 30);
        textPassRegis.setBackground(new Color(0, 255, 0));
        textPassRegis.setForeground(new Color(255, 0, 0));
        textPassRegis.setBorder(null);
        staffRegis.add(textPassRegis);
        
        // Button Registrasi
        btnRegis = new JButton("Registrasi");
        btnRegis.setBounds(90, 300, 120, 40);
        btnRegis.setBackground(new Color(0, 255, 0));
        btnRegis.setForeground(new Color(255, 0, 0));
        btnRegis.setBorder(null);
        staffRegis.add(btnRegis);
        
        // Button Back
        btnBack = new JButton("Back");
        btnBack.setBounds(18, 410, 72, 30);
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setForeground(new Color(255, 0, 0));
        btnBack.setBorder(null);
        staffRegis.add(btnBack);
        
        // Close
        staffRegis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staffRegis.setVisible(true);
        staffRegis.setLocationRelativeTo(null);
        
        // Action Button Registrasi
        btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String no_id = textNoIdRegis.getText();
                String nama = textNamaRegis.getText();
                String alamat = textAlamatRegis.getText();
                String password = textPassRegis.getText();
                
                if(no_id.equals("") && nama.equals("") && alamat.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Semua Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals(no_id) && nama.equals("") && alamat.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama, Alamat, Password Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals("") && nama.equals(nama) && alamat.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Id, Alamat, Password Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals("") && nama.equals("") && alamat.equals(alamat) && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Id, Nama, Password Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals("") && nama.equals("") && alamat.equals("") && password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "No Id, Nama, Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals(no_id) && nama.equals(nama) && alamat.equals("") && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Alamat, Password Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals("") && nama.equals(nama) && alamat.equals(alamat) && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "No Id, Password Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals("") && nama.equals("") && alamat.equals(alamat) && password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "No Id, Nama Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals(no_id) && nama.equals("") && alamat.equals("") && password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Nama, Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals(no_id) && nama.equals(nama) && alamat.equals(alamat) && password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Password Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals("") && nama.equals(nama) && alamat.equals(alamat) && password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "No Id Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals(no_id) && nama.equals("") && alamat.equals(alamat) && password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Nama Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else if(no_id.equals(no_id) && nama.equals(nama) && alamat.equals("") && password.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Alamat Masih Kosong", "Information", JOptionPane.ERROR_MESSAGE);
                } else {
                    All_Object_Controller.c_staff.create(new Entity_Staff(no_id, nama, alamat, password));
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    staffRegis.dispose();
                    GUI_Login guiLogin = new GUI_Login();
                }
            }
        });
        
        // Action Button Back
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffRegis.dispose();
                GUI_Login guiLogin = new GUI_Login();
            }
        });
    }
    
    // Reset Input
    public void reset() {
        textNoIdRegis.setText(null);
        textNamaRegis.setText(null);
        textAlamatRegis.setText(null);
        textPassRegis.setText(null);
    }
}
