package model;

public abstract class MenuItem {
    private String id;
    private String nama;
    private double harga;
    private int stock;

    public MenuItem (String id,String nama,double harga,int stock) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStock() {
        return stock;
    }

    public abstract double hitungHargaTotal();
    public abstract double hitungHargaTotal(int jumlah);
    public abstract double hitungHargaTotal(int jumlah, String kodePromo);
    public abstract double hitungHargaTotal(int jumlah, EnumUkuran ukuran);
    public abstract String getOrderDetail();

}
