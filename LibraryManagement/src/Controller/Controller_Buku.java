package Controller;
import java.util.ArrayList;
import Entity.Entity_Buku;
import Model.Model_Buku;
import javax.swing.table.DefaultTableModel;
import view.All_Object_Controller;

public class Controller_Buku {
    public Model_Buku m_buku = new Model_Buku();
    
    public Controller_Buku() {
        
    }
    
    public ArrayList<Entity_Buku> view() {
        return m_buku.getDataBuku();
    }
    
    public void insert(String kodebuku, String judul, String penerbit, String genre, int harga) {
        Entity_Buku buku = new Entity_Buku();
        buku.setKode(kodebuku);
        buku.setJudul(judul);
        buku.setPenerbit(penerbit);
        buku.setPenerbit(penerbit);
        buku.setGenre(genre);
        buku.setHarga(harga);
        m_buku.insert(buku);
    }

    public void create(Entity_Buku buku) {
        m_buku.create(buku);
    }

    public void update(int index, Entity_Buku buku) {
        m_buku.update(index, buku);
    }
    
    public void update(int index,String kodebuku, String judul, String penerbit, String genre, int harga) {
        Entity_Buku buku = new Entity_Buku();
        buku.setKode(kodebuku);
        buku.setJudul(judul);
        buku.setPenerbit(penerbit);
        buku.setPenerbit(penerbit);
        buku.setGenre(genre);
        buku.setHarga(harga);
        m_buku.update(index,buku);
    }

    public void delete(int index) {
        m_buku.delete(index);
    }
    
    public DefaultTableModel listbuku() {
        DefaultTableModel dtmlistbuku = new DefaultTableModel();
        Object[] kolom ={"Kode Buku","Judul","Penerbit","Genre","Harga"};
        dtmlistbuku.setColumnIdentifiers(kolom);
        int size = All_Object_Controller.buku.view().size();
        for (int i=0; i<size; i++){
            Object [] buku =new Object[7];
            buku[0] = All_Object_Controller.buku.view().get(i).getKode();
            buku[1] = All_Object_Controller.buku.view().get(i).getJudul();
            buku[2] = All_Object_Controller.buku.view().get(i).getPenerbit();
            buku[3] = All_Object_Controller.buku.view().get(i).getGenre();
            buku[4] = All_Object_Controller.buku.view().get(i).getHarga();
            dtmlistbuku.addRow(buku);
        }
        return dtmlistbuku;
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
