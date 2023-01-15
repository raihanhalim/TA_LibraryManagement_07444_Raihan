package Entity;

public class Entity_Staff extends Entity_Warga_Library {
    private String password;
    
    public Entity_Staff() {}
    
    public Entity_Staff(String no_id, String nama, String alamat, String password) {
        super(no_id, nama, alamat);
        this.password = password;
    }

    @Override
    public void setNo_id(String no_id) {
        this.no_id = no_id;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getNo_id() {
        return no_id;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    public String getPassword() {
        return password;
    }
}
