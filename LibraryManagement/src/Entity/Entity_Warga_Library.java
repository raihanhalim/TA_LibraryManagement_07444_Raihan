package Entity;

public class Entity_Warga_Library {
    protected String no_id, nama, alamat;
    
    public Entity_Warga_Library() {}
    
    public Entity_Warga_Library(String no_id, String nama, String alamat) {
        this.no_id = no_id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public void setNo_id(String no_id) {
        this.no_id = no_id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_id() {
        return no_id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}
