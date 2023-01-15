package Model;
import java.util.ArrayList;
import Entity.Entity_Buku;

public class Model_Buku implements Model_Interface {
    public ArrayList<Entity_Buku> data_buku;
    
    public Model_Buku() {
        data_buku = new ArrayList<>();
    }

    public ArrayList<Entity_Buku> getDataBuku() {
        return data_buku;
    }
    
    public void insert(Object x){
        data_buku.add((Entity_Buku) x);
    }
    
    @Override
    public void create(Object x) {
        data_buku.add((Entity_Buku) x);
    }
    
    @Override
    public void view() {
        
    }
    
    @Override
    public void update(int index, Object x) {
        data_buku.set(index, (Entity_Buku) x);
    }
    
    @Override
    public void delete(int index) {
        data_buku.remove(index);
    }
}
