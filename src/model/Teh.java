package model;
import java.util.ArrayList;
import java.util.List;

public class Teh extends MenuItem implements Customizable {
    private double harga;

    public Teh(String id,String nama,double harga, int stock) {
        super (id,nama,harga,stock);
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public void customize(List<Integer> customizations) {
    
    }
    //Rum (+3000) [0-1] Extra Shot (+5000) [0-3] Es (free) [0-5] Gula (free) [0-5] Boba (+1000) [0-3]Meses (+500) [0-5] Karamel (+3000) [0-5]
    public void customize(int[] customizations) {
        int add;
        add = customizations[0] * 3000 + customizations[5] * 3000;
    }

    public double hitungHargaTotal() {
        int total;
        total = harga + add;
    }

    public String getOrderDetail() {
        return "Add on : " +add;
    }
}

  
