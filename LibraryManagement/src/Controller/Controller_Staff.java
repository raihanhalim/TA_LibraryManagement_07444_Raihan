package Controller;
import java.util.ArrayList;
import Entity.Entity_Staff;
import Model.Model_Staff;

public class Controller_Staff {
    public Model_Staff m_staff = new Model_Staff();
    int loginStaff = 0;
    
    public Controller_Staff() {
        
    }
    
    public ArrayList<Entity_Staff> view() {
        return m_staff.getDataStaff();
    }
    
    public void insert(Entity_Staff staff){
        m_staff.insert(staff);
    }
    
    public void create(Entity_Staff staff) {
        m_staff.create(staff);
    }
    
    public void delete(int index) {
        m_staff.delete(index);
    }
    
    public void dataStaff(){
        String no_id [] = {"001","002","003"};
        String nama [] = {"Raihan","Gofur","Halim"};
        String alamat [] = {"Gubeng","Sidoarjo","Surabaya"};
        String password [] = {"001","002","003"};
       
        for(int i = 0; i<nama.length; i++){
        m_staff.insert(new Entity_Staff(no_id[i],nama[i],alamat[i],
                password[i]));
        }
    }
    
    public void cekStaff(String id, String password) {
        loginStaff = m_staff.cekStaff(id,password);
     }
    
    public Entity_Staff staffEntity(){
        return m_staff.showDataStaff(loginStaff);
    }
}
