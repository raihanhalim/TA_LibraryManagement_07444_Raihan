package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Login {
    JFrame staffLogin = new JFrame();
    JLabel top, noIdLogin, passLogin, labelRegis;
    JTextField textNoIdLogin;
    JPasswordField textPassLogin;
    JButton btnLogin, btnRegis;
    
    public GUI_Login() {
        staffLogin.setSize(300, 400);
        staffLogin.setLayout(null);
        staffLogin.getContentPane().setBackground(new Color(102, 179, 255));
        top = new JLabel("Login");
        top.setBounds(100, 10, 100, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        top.setForeground(new Color(255, 234, 0));
        staffLogin.add(top);
        
        // Input No Id
        noIdLogin = new JLabel("No Id");
        noIdLogin.setBounds(18, 130, 58, 30);
        noIdLogin.setForeground(new Color(255, 234, 0));
        staffLogin.add(noIdLogin);
        
        textNoIdLogin = new JTextField();
        textNoIdLogin.setBounds(90, 130, 170, 30);
        textNoIdLogin.setBackground(new Color(0, 255, 0));
        textNoIdLogin.setForeground(new Color(255, 0, 0));
        textNoIdLogin.setBorder(null);
        staffLogin.add(textNoIdLogin);
        
        // Input Password
        passLogin = new JLabel("Password");
        passLogin.setBounds(18, 170, 58, 30);
        passLogin.setForeground(new Color(255, 234, 0));
        staffLogin.add(passLogin);
        
        textPassLogin = new JPasswordField();
        textPassLogin.setBounds(90, 170, 170, 30);
        textPassLogin.setBackground(new Color(0, 255, 0));
        textPassLogin.setForeground(new Color(255, 0, 0));
        textPassLogin.setBorder(null);
        staffLogin.add(textPassLogin);
        
        // Button Login
        btnLogin = new JButton("Login");
        btnLogin.setBounds(90, 210, 120, 40);
        btnLogin.setBackground(new Color(0, 255, 0));
        btnLogin.setForeground(new Color(255, 0, 0));
        btnLogin.setBorder(null);
        staffLogin.add(btnLogin);
        
        // Button Registrasi
        labelRegis = new JLabel("I don't have account ?");
        labelRegis.setBounds(88, 300, 124, 20);
        labelRegis.setForeground(new Color(255, 234, 0));
        staffLogin.add(labelRegis);
        
        btnRegis = new JButton("Registrasi");
        btnRegis.setBounds(121, 320, 58, 20);
        btnRegis.setForeground(new Color(255, 0, 0));
        btnRegis.setBackground(null);
        btnRegis.setBorder(null);
        staffLogin.add(btnRegis);
        
        // Close
        staffLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staffLogin.setVisible(true);
        staffLogin.setLocationRelativeTo(null);
        
        // Action Button Login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String no_id = textNoIdLogin.getText();
                String password = textPassLogin.getText();
                boolean cek_login = false;
                int i;
                
                for(i = 0; i < All_Object_Controller.c_staff.view().size(); i++) {
                    if((no_id.equals(All_Object_Controller.c_staff.view().get(i).getNo_id())) && (password.equals(All_Object_Controller.c_staff.view().get(i).getPassword()))) {
                        cek_login = true;
                        break;
                    } else {
                        cek_login = false;
                    }
                }
                
                if(cek_login) {
                    JOptionPane.showMessageDialog(null, "Hallo " + All_Object_Controller.c_staff.view().get(i).getNama() + " Selamat Datang Di Library Management", "Information", JOptionPane.INFORMATION_MESSAGE);
                    staffLogin.dispose();
                    GUI_Staff guiStaff = new GUI_Staff();
                } else {
                    JOptionPane.showMessageDialog(null, "No Id Atau Password Salah", "Information", JOptionPane.ERROR_MESSAGE);
                    reset();
                }
            }
        });
        
        // Action Button Registrasi
        btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffLogin.dispose();
                GUI_Registrasi guiRegis = new GUI_Registrasi();
            }
        });
    }
    
    // Reset Input
    public void reset() {
        textNoIdLogin.setText(null);
        textPassLogin.setText(null);
    }
}
