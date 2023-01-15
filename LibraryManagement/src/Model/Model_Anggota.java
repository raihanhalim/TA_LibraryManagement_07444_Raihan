package Model;
import java.util.ArrayList;
import Entity.Entity_Anggota;

public class Model_Anggota implements Model_Interface {
    private ArrayList<Entity_Anggota> data_anggota;
    
    public Model_Anggota() {
        data_anggota = new ArrayList<>();
    }

    public ArrayList<Entity_Anggota> getDataAnggota() {
        return data_anggota;
    }
    
    @Override
    public void create(Object x) {
        data_anggota.add((Entity_Anggota) x);
    }
    
    @Override
    public void view() {
        
    }
    
    @Override
    public void update(int index, Object x) {
        data_anggota.set(index, (Entity_Anggota) x);
    }
    
    @Override
    public void delete(int index) {
        data_anggota.remove(index);
    }
}
