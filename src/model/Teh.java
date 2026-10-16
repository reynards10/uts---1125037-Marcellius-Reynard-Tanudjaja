package model;
import java.util.ArrayList;
import java.util.List;

public class Teh extends MenuItem implements Customizable {
    double harga;
    int boba;
    int gula;
    int es;
    int karamel;
    double add;
    double total;

    public Teh(String id,String nama,double harga, int stock,int boba,int gula, int es,int karamel) {
        super (id,nama,harga,stock);
        this.harga = harga;
    }

    public void customize(int boba, int karamel) {
    
        if (boba <= 3) {
            add = boba * 1000;
        }

        if (karamel <= 5 ) {
            add = add + (karamel * 3000);
        }
    }
    
    public double hitungHargaTotal(int jumlah) {
        double total;
        total = jumlah * 10000;
        return total;
    }

    public double hitungHargaTotal(int jumlah, String kodePromo, double total) {
        if (kodePromo equals("12345")) {
        total = total-(total * 0.10);
        }
        return total;
    }

    public double hitungHargaTotal(double total) {
        total = total + add;
        return total;
    }

    public String getOrderDetail() {
        return "Add on : " +add;
    }
}

  
