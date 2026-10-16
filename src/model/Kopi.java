package model;
import java.util.List;

public class Kopi extends MenuItem implements Customizable {
    double harga;
    int rum;
    int gula;
    int es;
    int karamel;
    double add;

    public Kopi(String id,String nama,double harga, int stock,int rum,int gula, int es,int karamel) {
        super (id,nama,harga,stock);
        this.harga = harga;
        this.gula = gula;
        this.es = es;
        this.karamel = karamel;
        this.add = 0;
    }

    @Override
    public void customize(List<Integer> customizations) {
        if (customizations != null && customizations.size() >= 4) {
            this.rum = customizations.get(0);
            this.gula = customizations.get(1);
            this.es = customizations.get(2);
            this.karamel = customizations.get(3);

        }
    }

    @Override
    public void customize(int[] customizations) {
        if (customizations != null && customizations.length >= 4) {
            this.rum = customizations[0];
            this.gula = customizations[1];
            this.es = customizations[2];
            this.karamel = customizations[3];
        }
    }

    @Override
    public double hitungHargaTotal(int jumlah) {
    this.add = (this.rum * 3000) + (this.karamel * 3000);
    return (getHarga() + this.add) * jumlah;
    }

    @Override
    public double hitungHargaTotal() {
        this.add = (this.rum * 1000) + (this.karamel * 3000);
        return getHarga() + this.add;
    }

    @Override
    public double hitungHargaTotal(int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);
        if (kodePromo != null && kodePromo.equalsIgnoreCase("KOPI")) {
            total *= 0.1; 
        }
        return total;
    }

    @Override
    public double hitungHargaTotal(int jumlah, EnumUkuran ukuran) {
        double total = hitungHargaTotal(jumlah);
        if (ukuran == EnumUkuran.MEDIUM) {
            total += (1500 * jumlah);
        } else if (ukuran == EnumUkuran.LARGE) {
            total += (3000 * jumlah);
        }
        return total;
    }

    @Override
    public String getOrderDetail() {
        return "Kopi: " + getNama() + " | Rum: " + rum + ", Es: " + es + ", Gula: " + gula + ", Karamel: " + karamel + " | Tambahan: " + add;
    }
}

  
