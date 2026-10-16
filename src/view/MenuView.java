package view;
import java.util.Scanner;


public class MenuView {
    private Scanner scanner;

    public MenuView () {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Tambah Produk");
    }
}
