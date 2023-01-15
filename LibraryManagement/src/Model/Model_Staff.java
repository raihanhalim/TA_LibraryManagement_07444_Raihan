package Model;
import java.util.ArrayList;
import Entity.Entity_Staff;

public class Model_Staff implements Model_Interface {
    private ArrayList<Entity_Staff> data_staff;
    
    public Model_Staff() {
        data_staff = new ArrayList<>();
    }

    public ArrayList<Entity_Staff> getDataStaff() {
        return data_staff;
    }
    
    public void insert(Object x){
        data_staff.add((Entity_Staff) x);
    }
    
    @Override
    public void create(Object x) {
        data_staff.add((Entity_Staff) x);
    }
    
    @Override
    public void view() {
        
    }
    
    @Override
    public void update(int index, Object x) {
        data_staff.set(index, (Entity_Staff) x);
    }
    
    @Override
    public void delete(int index) {
        data_staff.remove(index);
    }
    
    public Entity_Staff showDataStaff(int index){
        return data_staff.get(index);
    }

    public int cekStaff(String id, String password){
        int loop = 0;
        for(Entity_Staff staffEntity : getDataStaff()){
            if(staffEntity.getNo_id().equals(id) && staffEntity.getPassword().equals(password)){
                break;
            }else{
                  loop++;
            }
        }
        return loop;
    };
}
