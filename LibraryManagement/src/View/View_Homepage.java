package View;
import java.util.Scanner;
import Entity.*;
import Controller.*;

public class View_Homepage {
    Scanner input = new Scanner(System.in);
    public Controller_Anggota c_anggota = new Controller_Anggota();
    public Controller_Buku c_buku = new Controller_Buku();
    public Controller_Peminjaman c_peminjaman = new Controller_Peminjaman();
    public Controller_Staff c_staff = new Controller_Staff();
    
    public View_Homepage() {}
    
    public void menu_login() {
        int pilihan;
        
        do {
            System.out.println("====================");
            System.out.println("     Menu Login     ");
            System.out.println("====================");
            System.out.println("1. Registrasi");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("--------------------");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            System.out.println("--------------------");
            
            switch(pilihan) {
                case 1 :
                    register();
                    break;
                case 2 :
                    input.nextLine();
                    System.out.print("No Id    : ");
                    String no_id = input.nextLine();
                    System.out.print("Password : ");
                    String password = input.nextLine();
                    System.out.println("--------------------");
                    login(no_id, password);
                    break;
                case 3 :
                    System.out.println("Anda Sudah Keluar");
                    System.out.println("-------------------- \n");
                    break;
                default :
                    System.out.println("Pilihan Tidak Ada");
                    System.out.println("-------------------- \n");
                    break;
            }
        } while(pilihan != 3);
    }
    
    
    public void register() {
        input.nextLine();
        System.out.print("No Id Staff    : ");
        String no_id = input.nextLine();
        System.out.print("Nama Staff     : ");
        String nama = input.nextLine();
        System.out.print("Alamat Staff   : ");
        String alamat = input.nextLine();
        System.out.print("Password Staff : ");
        String password = input.nextLine();
        c_staff.create(new Entity_Staff(no_id, nama, alamat, password));
        System.out.println("-------------------- \n");
    }
    
    public void login(String no_id, String password) {
        boolean cek_login = false;
        int i;
        
        for(i = 0; i < c_staff.m_staff.getDataStaff().size(); i++) {
            if((no_id.equals(c_staff.m_staff.getDataStaff().get(i).getNo_id())) && (password.equals(c_staff.m_staff.getDataStaff().get(i).getPassword()))) {
                cek_login = true;
                break;
            } else {
                cek_login = false;
            }
        }
        
        if(cek_login) {
            System.out.println("Hallo " + c_staff.m_staff.getDataStaff().get(i).getNama() + " Selamat Datang Di Library Management");
            System.out.println("-------------------- \n");
            menu_utama();
        } else {
            System.out.println("Maaf No Id Atau Password Salah");
            System.out.println("-------------------- \n");
        }
    }
    
    public void menu_utama() {
        int pilihan;
        
        do {
            System.out.println("====================");
            System.out.println("     Menu Utama     ");
            System.out.println("====================");
            System.out.println("1. Data Buku");
            System.out.println("2. Data Anggota");
            System.out.println("3. Data Peminjaman");
            System.out.println("4. Exit");
            System.out.println("--------------------");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            System.out.println("--------------------");
            
            switch(pilihan) {
                case 1 :
                    menu_buku();
                    break;
                case 2 :
                    menu_anggota();
                    break;
                case 3 :
                    menu_peminjaman();
                    break;
                case 4 :
                    System.out.println("Anda Sudah Keluar");
                    System.out.println("-------------------- \n");
                    break;
                default :
                    System.out.println("Pilihan Tidak Ada");
                    System.out.println("-------------------- \n");
                    break;
            }
        } while(pilihan != 4);
    }
    
    public void menu_buku() {
        int pilihan;
        
        do {
            System.out.println("");
            System.out.println("====================");
            System.out.println("      Menu Buku     ");
            System.out.println("====================");
            System.out.println("1. Create Buku");
            System.out.println("2. View Buku");
            System.out.println("3. Update Buku");
            System.out.println("4. Delete Buku");
            System.out.println("5. Exit");
            System.out.println("--------------------");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            System.out.println("--------------------");
            
            switch(pilihan) {
                case 1 :
                    create();
                    break;
                case 2 :
                    view();
                    break;
                case 3 :
                    update();
                    break;
                case 4 :
                    delete();
                    break;
                case 5 :
                    System.out.println("Anda Sudah Keluar");
                    System.out.println("-------------------- \n");
                    break;
                default :
                    System.out.println("Pilihan Tidak Ada");
                    System.out.println("--------------------");
                    break;
            }
        } while(pilihan != 5);
    }
    
    public void create() {
        input.nextLine();
        System.out.print("Kode Buku     : ");
        String kode = input.nextLine();
        System.out.print("Judul Buku    : ");
        String judul = input.nextLine();
        System.out.print("Penerbit Buku : ");
        String penerbit = input.nextLine();
        System.out.print("Genre Buku    : ");
        String genre = input.nextLine();
        System.out.print("Harga Buku    : ");
        int harga = input.nextInt();
        c_buku.create(new Entity_Buku(kode, judul, penerbit, genre, harga));
        System.out.println("--------------------");
        System.out.println("Data Buku Berhasil Disimpan");
        System.out.println("--------------------");
    }
    
    public void view() {
        if(c_buku.m_buku.getDataBuku().size() > 0) {
            int no_urut = 0;
            for(int i = 0; i < c_buku.m_buku.getDataBuku().size(); i++) {
                no_urut++;
                System.out.println("[Buku " + no_urut + "]");
                System.out.println("Kode Buku     : " + c_buku.m_buku.getDataBuku().get(i).getKode());
                System.out.println("Judul Buku    : " + c_buku.m_buku.getDataBuku().get(i).getJudul());
                System.out.println("Penerbit Buku : " + c_buku.m_buku.getDataBuku().get(i).getPenerbit());
                System.out.println("Genre Buku    : " + c_buku.m_buku.getDataBuku().get(i).getGenre());
                System.out.println("Harga Buku    : " + c_buku.m_buku.getDataBuku().get(i).getHarga());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Data Buku Kosong");
            System.out.println("--------------------");
        }
    }

    public void update() {
        if(c_buku.m_buku.getDataBuku().size() > 0) {
            for (int i = 0; i < c_buku.m_buku.getDataBuku().size(); i++) {
                System.out.println("[" + i + "] " + c_buku.m_buku.getDataBuku().get(i).getJudul());
            }
            
            System.out.println("--------------------");
            System.out.print("Index Buku : ");
            int index = input.nextInt();
            System.out.println("--------------------");
            input.nextLine();
            System.out.print("Kode Buku     : ");
            String kode = input.nextLine();
            System.out.print("Judul Buku    : ");
            String judul = input.nextLine();
            System.out.print("Penerbit Buku : ");
            String penerbit = input.nextLine();
            System.out.print("Genre Buku    : ");
            String genre = input.nextLine();
            System.out.print("Harga Buku    : ");
            int harga = input.nextInt();
            c_buku.update(index, new Entity_Buku(kode, judul, penerbit, genre, harga));
            System.out.println("--------------------");
            System.out.println("Data Buku Berhasil Di Ubah");
            System.out.println("--------------------");
        } else {
            System.out.println("Data Buku Kosong");
            System.out.println("--------------------");
        }
    }

    public void delete() {
        if(c_buku.m_buku.getDataBuku().size() > 0) {
            for (int i = 0; i < c_buku.m_buku.getDataBuku().size(); i++) {
                System.out.println("[" + i + "] " + c_buku.m_buku.getDataBuku().get(i).getJudul());
            }
            
            System.out.println("--------------------");
            System.out.print("Index Buku : ");
            int index = input.nextInt();
            c_buku.delete(index);
            System.out.println("--------------------");
            System.out.println("Data Buku Berhasil Di Hapus");
            System.out.println("--------------------");
        }else{
            System.out.println("Data Buku Kosong");
            System.out.println("--------------------");
        }
    }
    
    public void menu_anggota() {
        int pilihan;
        
        do {
            System.out.println("");
            System.out.println("====================");
            System.out.println("    Menu Anggota    ");
            System.out.println("====================");
            System.out.println("1. Create Anggota");
            System.out.println("2. View Anggota");
            System.out.println("3. Update Anggota");
            System.out.println("4. Delete Anggota");
            System.out.println("5. Exit");
            System.out.println("--------------------");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            System.out.println("--------------------");
            
            switch(pilihan) {
                case 1 :
                    create_anggota();
                    break;
                case 2 :
                    view_anggota();
                    break;
                case 3 :
                    update_anggota();
                    break;
                case 4 :
                    delete_anggota();
                    break;
                case 5 :
                    System.out.println("Anda Sudah Keluar");
                    System.out.println("-------------------- \n");
                    break;
                default :
                    System.out.println("Pilihan Tidak Ada");
                    System.out.println("--------------------");
                    break;
            }
        } while(pilihan != 5);
    }
    
    public void create_anggota() {
        input.nextLine();
        System.out.print("No Id Anggota      : ");
        String no_id = input.nextLine();
        System.out.print("Nama Anggota       : ");
        String nama = input.nextLine();
        System.out.print("Alamat Anggota     : ");
        String alamat = input.nextLine();
        System.out.print("No Telepon Anggota : ");
        String no_telp = input.nextLine();
        c_anggota.create(new Entity_Anggota(no_id, nama, alamat, no_telp));
        System.out.println("--------------------");
        System.out.println("Data Anggota Berhasil Disimpan");
        System.out.println("--------------------");
    }
    
    public void view_anggota() {
        if(c_anggota.m_anggota.getDataAnggota().size() > 0) {
            int no_urut = 0;
            for(int i = 0; i < c_anggota.m_anggota.getDataAnggota().size(); i++) {
                no_urut++;
                System.out.println("[Anggota " + no_urut + "]");
                System.out.println("No Id Anggota      : " + c_anggota.m_anggota.getDataAnggota().get(i).getNo_id());
                System.out.println("Nama Anggota       : " + c_anggota.m_anggota.getDataAnggota().get(i).getNama());
                System.out.println("Alamat Anggota     : " + c_anggota.m_anggota.getDataAnggota().get(i).getAlamat());
                System.out.println("No Telepon Anggota : " + c_anggota.m_anggota.getDataAnggota().get(i).getNo_telp());
                System.out.println("--------------------");
            }
        }else{
            System.out.println("Data Anggota Kosong");
            System.out.println("--------------------");
        }
    }
    
    public void update_anggota() {
        if(c_anggota.m_anggota.getDataAnggota().size() > 0) {
            for (int i = 0; i < c_anggota.m_anggota.getDataAnggota().size(); i++) {
                System.out.println("[" + i + "] " + c_anggota.m_anggota.getDataAnggota().get(i).getNama());
            }
            
            System.out.println("--------------------");
            System.out.print("Index Anggota : ");
            int index = input.nextInt();
            System.out.println("--------------------");
            input.nextLine();
            System.out.print("No Id Anggota      : ");
            String no_id = input.nextLine();
            System.out.print("Nama Anggota       : ");
            String nama = input.nextLine();
            System.out.print("Alamat Anggota     : ");
            String alamat = input.nextLine();
            System.out.print("No Telepon Anggota : ");
            String no_telp = input.nextLine();
            c_anggota.update(index, new Entity_Anggota(no_id, nama, alamat, no_telp));
            System.out.println("--------------------");
            System.out.println("Data Anggota Berhasil Di Ubah");
            System.out.println("--------------------");
        } else {
            System.out.println("Data Anggota Kosong");
            System.out.println("--------------------");
        }
    }
    
    public void delete_anggota() {
        if(c_anggota.m_anggota.getDataAnggota().size() > 0) {
            for (int i = 0; i < c_anggota.m_anggota.getDataAnggota().size(); i++) {
                System.out.println("[" + i + "] " + c_anggota.m_anggota.getDataAnggota().get(i).getNama());
            }
            
            System.out.println("--------------------");
            System.out.print("Index Anggota : ");
            int index = input.nextInt();
            c_anggota.delete(index);
            System.out.println("--------------------");
            System.out.println("Data Anggota Berhasil Di Hapus");
            System.out.println("--------------------");
        }else{
            System.out.println("Data Anggota Kosong");
            System.out.println("--------------------");
        }
    }
    
    public void menu_peminjaman() {
        int pilihan;
        
        do {
            System.out.println("");
            System.out.println("====================");
            System.out.println("   Menu Peminjaman  ");
            System.out.println("====================");
            System.out.println("1. Pinjaman Buku");
            System.out.println("2. View Peminjaman");
            System.out.println("3. Kembalian Buku");
            System.out.println("4. Exit");
            System.out.println("--------------------");
            System.out.print("Pilihan : ");
            pilihan = input.nextInt();
            System.out.println("--------------------");
            
            switch(pilihan) {
                case 1 :
                    pinjaman_buku();
                    break;
                case 2 :
                    view_peminjaman();
                    break;
                case 3 :
                    kembalian_buku();
                    break;
                case 4 :
                    System.out.println("Anda Sudah Keluar");
                    System.out.println("-------------------- \n");
                    break;
                default :
                    System.out.println("Pilihan Tidak Ada");
                    System.out.println("--------------------");
                    break;
            }
        } while(pilihan != 4);
    }
    
    public void pinjaman_buku() {
        if(c_anggota.m_anggota.getDataAnggota().size() > 0 && c_buku.m_buku.getDataBuku().size()>0) {
            String no_id, kode, pilih = "";
            int index_buku, index_anggota, lama, total;
            
            input.nextLine();
            System.out.print("No Id     : ");
            no_id = input.nextLine();
            index_anggota = c_anggota.cek_anggota(no_id);
            c_anggota.cek_anggota(no_id);
            
            if(c_anggota.cek_anggota(no_id) == -1) {
                System.out.println("--------------------");
                System.out.println("Data Tidak Ada");
                System.out.println("--------------------");
            } else {
                do {
                    System.out.print("Kode Buku : ");
                    kode = input.nextLine();
                    index_buku = c_buku.cek_buku(kode);
                    
                    if(c_buku.cek_buku(kode) == -1) {
                        System.out.println("--------------------");
                        System.out.println("Kode Tersebut Tidak Ada");
                        System.out.println("--------------------");
                        System.out.print("Memilih Kode Buku Lagi (y/t) ? ");
                        pilih = input.next();
                        input.nextLine();
                        System.out.println("--------------------");
                    } else {
                        System.out.println("--------------------");
                        System.out.println("    Data Peminjam   ");
                        System.out.println("--------------------");
                        System.out.println("Judul Buku    : " + c_buku.showDaftarBuku(index_buku).getJudul());
                        System.out.println("Nama Peminjam : " + c_anggota.showDaftarAnggota(index_anggota).getNama());
                        System.out.println("--------------------");
                        break;
                     
                    }
                } while(pilih.equals("y"));
                
                //if, jika cek kode bku != -1 ==> isi menginputkan tanggan dan jumlah, lalu simpan/tidak
                if(c_buku.cek_buku(kode) != -1) {
                    System.out.print("No Pinjam       : ");
                    int no_pinjam = input.nextInt();
                    System.out.print("Tanggal Pinjam  : ");
                    int tgl_pinjam = input.nextInt();
                    System.out.print("Tanggal Kembali : ");
                    int tgl_kembali = input.nextInt();
                    if(tgl_kembali > tgl_pinjam) {
                        lama = tgl_kembali - tgl_pinjam;
                    } else {
                        lama = tgl_pinjam + 31 - tgl_kembali;
                    }
                    total = lama * c_buku.showDaftarBuku(index_buku).getHarga();
                    Entity_Anggota anggota = c_anggota.searchById(no_id);
                    Entity_Buku buku = c_buku.searchByKode(kode);
                    c_peminjaman.create(new Entity_Peminjaman(no_pinjam, anggota, buku, tgl_pinjam, tgl_kembali, lama, total));
                    System.out.println("--------------------");
                }
            }
        } else {
           System.out.println("Data Buku Atau Anggota Kosong");
           System.out.println("--------------------");
        }
    }
    
    public void view_peminjaman() {
        if(c_peminjaman.m_peminjaman.getDataPeminjaman().size() > 0) {
            int no_urut = 0;
            for(int i = 0; i < c_peminjaman.m_peminjaman.getDataPeminjaman().size(); i++) {
                no_urut++;
                System.out.println("[Peminjaman " + no_urut + "]");
                System.out.println("No Pinjam       : " + c_peminjaman.showDaftarPeminjaman(i).getNo_pinjam());
                System.out.println("Nama Peminjam   : " + c_peminjaman.showDaftarPeminjaman(i).getAnggota().getNama());
                System.out.println("Judul Buku      : " + c_peminjaman.showDaftarPeminjaman(i).getBuku().getJudul());
                System.out.println("Penerbit Buku   : " + c_peminjaman.showDaftarPeminjaman(i).getBuku().getPenerbit());
                System.out.println("Harga Buku      : " + c_peminjaman.showDaftarPeminjaman(i).getBuku().getHarga());
                System.out.println("Tanggal Pinjam  : " + c_peminjaman.showDaftarPeminjaman(i).getTgl_pinjam());
                System.out.println("Tanggal Kembali : " + c_peminjaman.showDaftarPeminjaman(i).getTgl_kembali());
                System.out.println("Lama Pinjam     : " + c_peminjaman.showDaftarPeminjaman(i).getLama() + " Hari");
                System.out.println("Total Pinjam    : " + c_peminjaman.showDaftarPeminjaman(i).getTotal());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Data Peminjaman Kosong");
            System.out.println("--------------------");
        }
    }
    
    public void kembalian_buku() {
        if(c_peminjaman.m_peminjaman.getDataPeminjaman().size() > 0) {
            int no_pinjam, tgl_skrng, lama, denda, total, index_pinjam;
            
            System.out.print("No Pinjam : ");
            no_pinjam = input.nextInt();
            index_pinjam = c_peminjaman.cek_peminjaman(no_pinjam);
            
            if(c_peminjaman.cek_peminjaman(no_pinjam) == -1) {
                System.out.println("--------------------");
                System.out.println("Data Tidak Ada");
                System.out.println("--------------------");
            } else {
                System.out.print("Tanggal Sekarang : ");
                tgl_skrng = input.nextInt();
                lama = tgl_skrng - c_peminjaman.showDaftarPeminjaman(index_pinjam).getTgl_kembali();
                denda = lama * c_peminjaman.showDaftarPeminjaman(index_pinjam).getBuku().getHarga();
                total = denda + c_peminjaman.showDaftarPeminjaman(index_pinjam).getTotal();
                
                if(tgl_skrng > c_peminjaman.showDaftarPeminjaman(index_pinjam).getTgl_kembali()) {
                    System.out.println("--------------------");
                    System.out.println("Kamu terkena denda sebesar " + denda + " dengan total yang harus dibayar " + total);
                    System.out.println("Dan silahkan dikembalikan buku yang di pinjam");
                    c_peminjaman.delete(index_pinjam);
                } else if(tgl_skrng > c_peminjaman.showDaftarPeminjaman(index_pinjam).getTgl_pinjam() && tgl_skrng <= c_peminjaman.showDaftarPeminjaman(index_pinjam).getTgl_kembali()) {
                    System.out.println("--------------------");
                    System.out.println("Silahkan dibayar sebesar " + c_peminjaman.showDaftarPeminjaman(index_pinjam).getTotal());
                    System.out.println("Dan dikembalikan buku yang di pinjam");
                    c_peminjaman.delete(index_pinjam);
                }
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Data Peminjaman Kosong");
            System.out.println("--------------------");
        }
    }
}
