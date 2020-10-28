package Views;

import Helpers.InputHelper;
import Models.Inventory;

public class Inventory_View {

    public static Inventory setObject (Inventory inventory) {
        inventory.setQuantity(InputHelper.outputInt("Insert the quantity: "));
        inventory.setOutlet_outlet_number(InputHelper.outputInt("Insert your outlet number: "));
        inventory.setProduct_product_code(InputHelper.outputInt("Insert the product code: "));
        return inventory;
    }
}
