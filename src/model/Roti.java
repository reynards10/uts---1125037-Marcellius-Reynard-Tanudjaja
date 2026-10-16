package model;

import java.util.List;

public class Roti extends MenuItem implements Customizable {
    private int gula;
    private int meses;
    private int karamel;

    public Roti(String id, String nama, double harga, int stock) {
        super(id, nama, harga, stock);
        this.gula = 0;
        this.meses = 0;
        this.karamel = 0;
    }

    @Override
    public void customize(List<Integer> customizations) {
        if (customizations.size() >= 3) {
            this.gula = customizations.get(0);
            this.meses = customizations.get(1);
            this.karamel = customizations.get(2);
        }
    }

    @Override
    public void customize(int[] customizations) {
        if (customizations.length >= 3) {
            this.gula = customizations[0];
            this.meses = customizations[1];
            this.karamel = customizations[2];
        }
    }

    private double hitungTambahanKustomisasi() {
        return (meses * 500) + (karamel * 3000);
    }

    @Override
    public double hitungHargaTotal() {
        return getHarga() + hitungTambahanKustomisasi();
    }

    @Override
    public double hitungHargaTotal(int jumlah) {
        return (getHarga() + hitungTambahanKustomisasi()) * jumlah;
    }

    @Override
    public double hitungHargaTotal(int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);
        if (kodePromo != null && kodePromo.equalsIgnoreCase("ROTI")) {
            total *= 0.9;
        }
        return total;
    }

    @Override
    public double hitungHargaTotal(int jumlah, EnumUkuran ukuran) {
        return hitungHargaTotal(jumlah);
    }

    @Override
    public String getOrderDetail() {
        return "Roti: " + getNama() + " | Custom -> Gula: " + gula + ", Meses: " + meses + ", Karamel: " + karamel;
    }
}