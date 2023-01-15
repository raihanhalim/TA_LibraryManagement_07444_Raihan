package Entity;

public class Entity_Peminjaman {
    private Entity_Anggota anggota = new Entity_Anggota();
    private Entity_Buku buku = new Entity_Buku();
    private int tgl_pinjam, tgl_kembali, lama, total;
    private int no_pinjam;
    
    public Entity_Peminjaman() {}
    
    public Entity_Peminjaman(int no_pinjam, Entity_Anggota anggota, Entity_Buku buku, int tgl_pinjam, int tgl_kembali, int lama, int total) {
        this.no_pinjam = no_pinjam;
        this.anggota = anggota;
        this.buku = buku;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
        this.lama = lama;
        this.total = total;
    }
    
    public void setNo_pinjam(int no_pinjam) {
        this.no_pinjam = no_pinjam;
    }

    public void setAnggota(Entity_Anggota anggota) {
        this.anggota = anggota;
    }

    public void setBuku(Entity_Buku buku) {
        this.buku = buku;
    }
    
    public void setTgl_pinjam(int tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }
    
    public void setTgl_kembali(int tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public void setLama(int lama) {
        this.lama = lama;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getNo_pinjam() {
        return no_pinjam;
    }

    public Entity_Anggota getAnggota() {
        return anggota;
    }

    public Entity_Buku getBuku() {
        return buku;
    }
    
    public int getTgl_pinjam() {
        return tgl_pinjam;
    }
    
    public int getTgl_kembali() {
        return tgl_kembali;
    }

    public int getLama() {
        return lama;
    }

    public int getTotal() {
        return total;
    }
}
