package Entity;

public class Entity_Anggota extends Entity_Warga_Library {
    private String no_telp;
    
    public Entity_Anggota() {}
    
    public Entity_Anggota(String no_id, String nama, String alamat, String no_telp) {
        super(no_id, nama, alamat);
        this.no_telp = no_telp;
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

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
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

    public String getNo_telp() {
        return no_telp;
    }
}
