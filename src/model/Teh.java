package model;

import java.util.ArrayList;
import java.util.List;

public class Teh extends MenuItem implements Customizable {
    private int rum;
    private int gula;
    private int es;
    private int karamel;

    public Teh(String id,String nama,double harga, int stock,int rum,int gula,int es,int karamel) {
        super (id,nama,harga,stock);
        this.rum = rum;
        this.gula = gula;
        this.es = es;
        this.karamel = karamel;
    }

    public void customize(int custom) {
        int add;
        
    }

    public double hitungHargaTotal(int amount) {

    }

    public String getOrderDetail() {

    }
}

  
