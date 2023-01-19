package Controller;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entity.Entity_Peminjaman;
import Model.Model_Peminjaman;
import View.All_Object_Controller;

public class Controller_Peminjaman {
    public Model_Peminjaman m_peminjaman = new Model_Peminjaman();
    
    public Controller_Peminjaman() {
        
    }
    
    public ArrayList<Entity_Peminjaman> view() {
        return m_peminjaman.getDataPeminjaman();
    }
    
    public void create(Entity_Peminjaman peminjaman) {
        m_peminjaman.create(peminjaman);
    }
    
    public void delete(int index) {
        m_peminjaman.delete(index);
    }
    
    public DefaultTableModel listPeminjaman() {
        DefaultTableModel dataListPeminjaman = new DefaultTableModel();
        Object[] kolom = {"No Id Peminjam", "Nama Peminjam", "Kode Buku", "Judul Buku", "Penerbit Buku", "Harga Buku", "No Pinjam", "Tanggal Pinjam", "Tanggal Kembali", "Lama Pinjam", "Total Pinjam"};
        dataListPeminjaman.setColumnIdentifiers(kolom);
        int size = All_Object_Controller.c_peminjaman.view().size();
        for (int i = 0; i < size; i++) {
            Object [] peminjaman = new Object[11];
            peminjaman[0] = All_Object_Controller.c_peminjaman.view().get(i).getAnggota().getNo_id();
            peminjaman[1] = All_Object_Controller.c_peminjaman.view().get(i).getAnggota().getNama();
            peminjaman[2] = All_Object_Controller.c_peminjaman.view().get(i).getBuku().getKode();
            peminjaman[3] = All_Object_Controller.c_peminjaman.view().get(i).getBuku().getJudul();
            peminjaman[4] = All_Object_Controller.c_peminjaman.view().get(i).getBuku().getPenerbit();
            peminjaman[5] = All_Object_Controller.c_peminjaman.view().get(i).getBuku().getHarga();
            peminjaman[6] = All_Object_Controller.c_peminjaman.view().get(i).getNo_pinjam();
            peminjaman[7] = All_Object_Controller.c_peminjaman.view().get(i).getTgl_pinjam();
            peminjaman[8] = All_Object_Controller.c_peminjaman.view().get(i).getTgl_kembali();
            peminjaman[9] = All_Object_Controller.c_peminjaman.view().get(i).getLama();
            peminjaman[10] = All_Object_Controller.c_peminjaman.view().get(i).getTotal();
            dataListPeminjaman.addRow(peminjaman);
        }
        return dataListPeminjaman;
    }
    
    public int cek_peminjaman(int no_pinjam) {
        int keterangan = -1;
        
        if(m_peminjaman.getDataPeminjaman().size() > 0) {
            for(int i = 0; i < m_peminjaman.getDataPeminjaman().size(); i++) {
                if(no_pinjam == m_peminjaman.getDataPeminjaman().get(i).getNo_pinjam()){
                    keterangan = i;
                    break;
                } else {
                    keterangan = -1;
                }
            }
        }
        return keterangan;
    }
    
    public Entity_Peminjaman searchByNo(int no_pinjam) {
        Entity_Peminjaman temp = null;
        for(Entity_Peminjaman peminjaman : m_peminjaman.getDataPeminjaman()) {
            if(no_pinjam == peminjaman.getNo_pinjam()) {
                temp = peminjaman;
            }
        }
        return temp;
    }
    
    public Entity_Peminjaman showDaftarPeminjaman(int index) {
        return m_peminjaman.getDataPeminjaman().get(index);
    }
}
