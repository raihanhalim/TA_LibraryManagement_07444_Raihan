package Controller;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entity.Entity_Anggota;
import Model.Model_Anggota;
import View.All_Object_Controller;

public class Controller_Anggota {
    public Model_Anggota m_anggota = new Model_Anggota();
    
    public Controller_Anggota() {
        
    }
    
    public ArrayList<Entity_Anggota> view() {
        return m_anggota.getDataAnggota();
    }
    
    public void create(Entity_Anggota anggota) {
        m_anggota.create(anggota);
    }
    
    public void update(int index, Entity_Anggota anggota) {
        m_anggota.update(index, anggota);
    }
    
    public void delete(int index) {
        m_anggota.delete(index);
    }
    
    public DefaultTableModel listAnggota() {
        DefaultTableModel dataListAnggota = new DefaultTableModel();
        Object[] kolom = {"No Id", "Nama", "Alamat", "No Telp"};
        dataListAnggota.setColumnIdentifiers(kolom);
        int size = All_Object_Controller.c_anggota.view().size();
        for (int i = 0; i < size; i++) {
            Object [] anggota = new Object[7];
            anggota[0] = All_Object_Controller.c_anggota.view().get(i).getNo_id();
            anggota[1] = All_Object_Controller.c_anggota.view().get(i).getNama();
            anggota[2] = All_Object_Controller.c_anggota.view().get(i).getAlamat();
            anggota[3] = All_Object_Controller.c_anggota.view().get(i).getNo_telp();
            dataListAnggota.addRow(anggota);
        }
        return dataListAnggota;
    }
    
    public int cek_anggota(String no_id) {
        int keterangan = -1;
        if(m_anggota.getDataAnggota().size() > 0) {
            for(int i = 0; i < m_anggota.getDataAnggota().size(); i++) {
                if(no_id.equals(m_anggota.getDataAnggota().get(i).getNo_id())) {
                    keterangan = i;
                    break;
                } else {
                    keterangan = -1;
                }
            }
        }
        return keterangan;
    }
    
    public Entity_Anggota searchById(String no_id) {
        Entity_Anggota temp = null;
        for(Entity_Anggota anggota : m_anggota.getDataAnggota()) {
            if(no_id.equals(anggota.getNo_id())) {
                temp = anggota;
            }
        }
        return temp;
    }
    
    public Entity_Anggota showDaftarAnggota(int index) {
        return m_anggota.getDataAnggota().get(index);
    }
}
