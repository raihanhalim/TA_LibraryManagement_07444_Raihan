package view;

import Controller.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.*;


public class GUI_Buku {
    private static Controller_Buku c_buku = new Controller_Buku();
    JFrame Buku = new JFrame();
    JLabel top,tambahbuku,labelkodebuku,labeljudul,labelpenerbit,labelgenre,labelharga,labelKodebuku;
    JTextField textkodebuku,textjudul,textpenerbit,textgenre,textharga,hapustext;
    JButton btnubahbuku,btnhapus,btnback,btntambahbuku; 
    JTable tabelbuku = new JTable();
    JScrollPane scrolbuku = new JScrollPane(tabelbuku);
    int index;
     
    public GUI_Buku() {
        
        Buku.setSize(900,700);
        Buku.setLayout(null);
        Buku.getContentPane().setBackground(Color.BLUE);
        top = new JLabel("DATA BUKU");
        top.setBounds(130,10,600,50);
        top.setFont(new Font("Times New Roman", Font.BOLD,40));
        Buku.add(top);
            
        scrolbuku.setBounds(300,180,600,270);
        tabelbuku.setModel(c_buku.listbuku());
        Buku.add(scrolbuku);
        
        labelkodebuku = new JLabel("KODE BUKU");
        labelkodebuku.setBounds(30,150,100,30);
        Buku.add(labelkodebuku);
        
        textkodebuku = new JTextField();
        textkodebuku.setBounds(30,180,200,30);
        Buku.add(textkodebuku);
                
        labeljudul = new JLabel("JUDUL BUKU");
        labeljudul.setBounds(30,210,100,30);
        Buku.add(labeljudul);
        
        textjudul = new JTextField();
        textjudul.setBounds(30,240,200,30);
        Buku.add(textjudul);
        
        labelpenerbit = new JLabel("PENERBIT");
        labelpenerbit.setBounds(30,270,100,30);
        Buku.add(labelpenerbit);
        
        textpenerbit = new JTextField();
        textpenerbit.setBounds(30,300,200,30);
        Buku.add(textpenerbit);
        
        labelgenre = new JLabel("GENRE");
        labelgenre.setBounds(30,330,200,30);
        Buku.add(labelgenre);
        
        textgenre = new JTextField();
        textgenre.setBounds(30,360,200,30);
        Buku.add(textgenre);
        
        labelharga = new JLabel("HARGA");
        labelharga.setBounds(30,390,200,30);
        Buku.add(labelharga);
        
        textharga = new JTextField();
        textharga.setBounds(30,420,200,30);
        Buku.add(textharga);
        
        btntambahbuku = new JButton("Tambah Buku");
        btntambahbuku.setBounds(50,470,150,30);
        Buku.add(btntambahbuku);
        
        btnubahbuku = new JButton("Ubah Buku");
        btnubahbuku.setBounds(50,510,150,30);
        Buku.add(btnubahbuku);
        
        btnhapus = new JButton("Hapus Buku");
        btnhapus.setBounds(50,550,150,30);
        Buku.add(btnhapus);              
               
        btnback = new JButton("back");
        btnback.setBounds(30, 600, 100, 30);
        btnback.setBackground(Color.red);
        Buku.add(btnback);
               
        Buku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Buku.setVisible(true);
        Buku.setLocationRelativeTo(null);
        
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buku.dispose();
                GUI_Staff staff = new GUI_Staff();
            }
        });
        
        btntambahbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String kodebuku = textkodebuku.getText();
                    String judul =  textjudul.getText();
                    String penerbit = textpenerbit.getText();
                    String genre = textgenre.getText();
                    int harga = Integer.valueOf(textharga.getText());
                    All_Object_Controller.buku.insert(kodebuku,judul,penerbit,genre,harga);
                    JOptionPane.showMessageDialog(null,"Input Buku Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelbuku.setModel(All_Object_Controller.buku.listbuku());
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } );
        
        btnubahbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String kodebuku = textkodebuku.getText();
                    String judul =  textjudul.getText();
                    String penerbit = textpenerbit.getText();
                    String genre = textgenre.getText();
                    int harga = Integer.valueOf(textharga.getText());
                    All_Object_Controller.buku.update(index,kodebuku,judul,penerbit,genre,harga);
                    JOptionPane.showMessageDialog(null,"Ubah Buku Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelbuku.setModel(All_Object_Controller.buku.listbuku());
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } );
        tabelbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelbuku.getSelectedRow();
                index=i;
                textkodebuku.setText(All_Object_Controller.buku.listbuku().getValueAt(i, 0).toString());
                textjudul.setText(All_Object_Controller.buku.listbuku().getValueAt(i, 1).toString());
                textpenerbit.setText(All_Object_Controller.buku.listbuku().getValueAt(i, 2).toString());
                textgenre.setText(All_Object_Controller.buku.listbuku().getValueAt(i, 3).toString());
                textharga.setText(All_Object_Controller.buku.listbuku().getValueAt(i, 4).toString()); 
            }            
        });
        
        btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    
                    All_Object_Controller.buku.delete(index);
                    JOptionPane.showMessageDialog(null,"Hapus Buku Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    tabelbuku.setModel(All_Object_Controller.buku.listbuku());
                    reset();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
    }
    void reset(){
        textkodebuku.setText(null);//ISI
        textjudul.setText(null);
        textpenerbit.setText(null);
        textgenre.setText(null);
        textharga.setText(null);
    }
}
