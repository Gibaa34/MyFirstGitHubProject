package FrameWork;

public class ItemDetails {

    public String itemName;
    public String itemLocator;
    public String price;
    public String quantity;
    public String size;
    public String color;

    public ItemDetails(String itemName,String itemLocator, String price, String quantity, String size, String color) {
        this.itemName = itemName;
        this.itemLocator = itemLocator;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
    }

    public ItemDetails() {

    }
}
