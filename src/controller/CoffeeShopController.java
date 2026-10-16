package controller;

import exception.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import view.CoffeeShopView;

public class CoffeeShopController {
    private List<MenuItem> menuList;
    private CoffeeShopView view;

    public CoffeeShopController(CoffeeShopView view) {
        this.view = view;
        this.menuList = new ArrayList<>();
        initData();
    }

    private void initData() {
        menuList.add(new Kopi("M-01", "Kopi Susu", 18000, 5));
        menuList.add(new Teh("M-02", "Teh Tarik", 12000, 10));
        menuList.add(new Roti("M-03", "Roti Cokelat", 15000, 8));
    }

    public void run() {
        int choice;
        do {
            view.displayMenu(menuList);
            System.out.println("1 pesan");
            System.out.println("0 Keluar");
            choice = view.inputInt("Pilih menu: ");

            if (choice == 1) {
                prosesPemesanan();
            } else if (choice == 0) {
                view.displayMessage("keluar program");
            } else {
                view.displayMessage("invalid");
            }
        } while (choice != 0);
    }

    private void prosesPemesanan() {
        try {
            String idMenu = view.inputString("ID PRODUK ");
            MenuItem selectedItem = null;

            for (MenuItem item : menuList) {
                if (item.getId().equals(idMenu)) {
                    selectedItem = item;
                    break;
                }
            }

            if (selectedItem == null) {
                throw new MenuTidakDitemukanException("ID tidak ada");
            }

            int jumlah = view.inputInt("Masukkan Jumlah Pesanan: ");
            if (jumlah <= 0) {
                throw new InputTidakValidException("Pesanan Tidak valid");
            }

            if (jumlah > selectedItem.getStock()) {
                throw new StokTidakCukupException("Stok Tidak cukup");
            }

            handleCustomizationAndCheckout(selectedItem, jumlah);

        } catch (MenuTidakDitemukanException | StokTidakCukupException | InputTidakValidException e) {
            view.displayMessage("ERROR: " + e.getMessage());
        }
    }

    private void handleCustomizationAndCheckout(MenuItem item, int jumlah) {
        if (item instanceof Customizable) {
            List<Integer> customInputs = new ArrayList<>();
            if (item instanceof Kopi) {
                view.displayMessage("Kustomisasi Kopi (Rum [0-1], Es [0-5], Gula [0-5], Karamel [0-5]):");
                customInputs.add(view.inputInt("Rum: "));
                customInputs.add(view.inputInt("Es: "));
                customInputs.add(view.inputInt("Gula: "));
                customInputs.add(view.inputInt("Karamel: "));
            } else if (item instanceof Teh) {
                view.displayMessage("Kustomisasi Teh (Boba [0-3], Es [0-5], Gula [0-5], Karamel [0-5]):");
                customInputs.add(view.inputInt("Boba: "));
                customInputs.add(view.inputInt("Es: "));
                customInputs.add(view.inputInt("Gula: "));
                customInputs.add(view.inputInt("Karamel: "));
            } else if (item instanceof Roti) {
                view.displayMessage("Kustomisasi Roti (Gula [0-5], Meses [0-5], Karamel [0-5]):");
                customInputs.add(view.inputInt("Gula: "));
                customInputs.add(view.inputInt("Meses: "));
                customInputs.add(view.inputInt("Karamel: "));
            }
            ((Customizable) item).customize(customInputs);
        }


     public ukuran 
    }
}