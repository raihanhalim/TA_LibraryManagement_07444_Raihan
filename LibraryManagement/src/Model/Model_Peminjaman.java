package Model;
import java.util.ArrayList;
import Entity.Entity_Peminjaman;

public class Model_Peminjaman {
    private ArrayList<Entity_Peminjaman> data_peminjaman;
    
    public Model_Peminjaman() {
        data_peminjaman = new ArrayList<>();
    }

    public ArrayList<Entity_Peminjaman> getDataPeminjaman() {
        return data_peminjaman;
    }
    
    public void create(Object x) {
        data_peminjaman.add((Entity_Peminjaman) x);
    }
    
    public void delete(int index) {
        data_peminjaman.remove(index);
    }
}
