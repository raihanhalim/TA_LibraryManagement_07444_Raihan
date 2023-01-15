package Entity;

public class Entity_Buku {
    private String kode, judul, penerbit, genre;
    private int harga;
    
    public Entity_Buku() {}
    
    public Entity_Buku(String kode, String judul, String penerbit, String genre, int harga) {
        this.kode = kode;
        this.judul = judul;
        this.penerbit = penerbit;
        this.genre = genre;
        this.harga = harga;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getGenre() {
        return genre;
    }

    public int getHarga() {
        return harga;
    }
}
