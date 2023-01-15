package Controller;
import java.util.ArrayList;
import Entity.Entity_Peminjaman;
import Model.Model_Peminjaman;

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
