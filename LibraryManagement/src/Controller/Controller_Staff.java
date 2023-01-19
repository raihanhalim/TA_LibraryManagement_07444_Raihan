package Controller;
import java.util.ArrayList;
import Entity.Entity_Staff;
import Model.Model_Staff;

public class Controller_Staff {
    public Model_Staff m_staff = new Model_Staff();
    
    public Controller_Staff() {
        
    }
    
    public ArrayList<Entity_Staff> view() {
        return m_staff.getDataStaff();
    }
    
    public void create(Entity_Staff staff) {
        m_staff.create(staff);
    }
    
    public int cekStaff(String id, String password) {
        int loop = 0;
        for(Entity_Staff item : m_staff.getDataStaff()) {
            if(item.getNo_id().equals(id) && item.getPassword().equals(password)){
                break;
            } else {
                loop++;
            }
        }
        return loop;
    };
    
    public Entity_Staff showDaftarStaff(int index) {
        return m_staff.getDataStaff().get(index);
    }
}
