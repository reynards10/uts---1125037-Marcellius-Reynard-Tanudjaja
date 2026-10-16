package view;

import java.util.List;
import java.util.Scanner;
import model.MenuItem;

public class CoffeeShopView {
    private Scanner scanner;

    public CoffeeShopView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu(List<MenuItem> menuItems) {
        for (MenuItem item : menuItems) {
            System.out.println(item.getId() + ": " + item.getNama() + " (Harga: " + item.getHarga() + ", Stok: " + item.getStock() + ")");
        }
    }

    public String inputString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    public int inputInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(">> " + message);
    }

    public void displayReceipt(MenuItem item, int jumlah, double totalHarga) {
        System.out.println("\n========== STRUK PEMESANAN ==========");
        System.out.println(item.getOrderDetail());
        System.out.println("Jumlah Pesanan: " + jumlah);
        System.out.println("Total Harga   : Rp " + totalHarga);
        System.out.println("=====================================");
    }
}