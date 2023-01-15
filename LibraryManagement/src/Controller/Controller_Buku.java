package Controller;
import java.util.ArrayList;
import Entity.Entity_Buku;
import Model.Model_Buku;

public class Controller_Buku {
    public Model_Buku m_buku = new Model_Buku();
    
    public Controller_Buku() {
        
    }
    
    public ArrayList<Entity_Buku> view() {
        return m_buku.getDataBuku();
    }
    
    public void create(Entity_Buku buku) {
        m_buku.create(buku);
    }

    public void update(int index, Entity_Buku buku) {
        m_buku.update(index, buku);
    }
    
    public void delete(int index) {
        m_buku.delete(index);
    }
    
    public int cek_buku(String kode) {
        int keterangan = -1;
        
        if(m_buku.getDataBuku().size() > 0) {
            for(int i = 0; i < m_buku.getDataBuku().size(); i++) {
                if(kode.equals(m_buku.getDataBuku().get(i).getKode())){
                    keterangan = i;
                    break;
                } else {
                    keterangan = -1;
                }
            }
        }
        return keterangan;
    }
    
    public Entity_Buku searchByKode(String kode) {
        Entity_Buku temp = null;
        for(Entity_Buku buku : m_buku.getDataBuku()) {
            if(kode.equals(buku.getKode())) {
                temp = buku;
            }
        }
        return temp;
    }
    
    public Entity_Buku showDaftarBuku(int index) {
        return m_buku.getDataBuku().get(index);
    }
}
