import controller.CoffeeShopController;
import view.CoffeeShopView;

public class Main {
    public static void main(String[] args) {
        CoffeeShopView view = new CoffeeShopView();
        CoffeeShopController controller = new CoffeeShopController(view);
        controller.run();
    }
}
