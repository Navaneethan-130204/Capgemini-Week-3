class InventoryNode {
    String itemName;
    String itemId;
    int quantity;
    double price;
    InventoryNode next;

    public InventoryNode(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory{

    InventoryNode head;

    public void addFirst(String itemName, String itemId, int quantity, double price) {
        InventoryNode newItem = new InventoryNode(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addEnd(String itemName, String itemId, int quantity, double price) {
        InventoryNode newItem = new InventoryNode(itemName, itemId, quantity, price);

        if(head == null) {
            head = newItem;
            return;
        }

        InventoryNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addPos(String itemName, String itemId, int quantity, double price, int pos) {
        InventoryNode newItem = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode temp = head;

        if(pos==1) {
            addFirst(itemName, itemId, quantity, price);
            return;
        }
        for(int i = 0; i < pos-1 && temp != null; i++) {
            temp = temp.next;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItem(String itemId) {
        InventoryNode temp = head;
        if (head == null){
            System.out.println("Inventory is empty!");
        }
        if (head.itemId.equalsIgnoreCase(itemId)) {
            head = head.next;
            return;
        }
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void UpdateQuantity(String itemId, int newQuantity) {
        InventoryNode temp = head;
        if (head == null){
            System.out.println("Inventory is empty!");
        }
        if (head.itemId.equalsIgnoreCase(itemId)) {
            head.quantity = newQuantity;
            return;
        }
        while (temp.next!= null && temp.next.itemId != itemId) {
            if(temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchItem(String idOrName) {
        InventoryNode temp = head;
        while (temp.next != null) {
            if(temp.itemId == idOrName || temp.itemName == idOrName) {
                display(temp);
                return;
            }
        }
    }

    public void calculateTotal(){
        double total = 0;
        InventoryNode temp = head;
        while (temp.next != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
    }

    public void sortInventory(String key, boolean ascending){
        for(InventoryNode i = head; i != null; i = i.next){
            InventoryNode selected = i;
            for(InventoryNode j = i.next; j != null; j = j.next) {
                boolean condition = false;
                if(key.equalsIgnoreCase("name")){
                    condition = ascending ? j.itemName.compareToIgnoreCase(selected.itemName) < 0 :
                            j.itemName.compareToIgnoreCase(selected.itemName) > 0;
                } else if (key.equalsIgnoreCase("price")) {
                    condition = ascending ? j.price < selected.price : j.price > selected.price;
                }

                if (condition) {
                    selected = j;
                }

                if (selected != i) {
                    String tempName = i.itemName;
                    String tempId = i.itemId;
                    int tempQty = i.quantity;
                    double tempPrice = i.price;

                    i.itemName = selected.itemName;;
                    i.itemId = selected.itemId;
                    i.quantity = selected.quantity;
                    i.price = selected.price;

                    selected.itemName = tempName;
                    selected.itemId = tempId;
                    selected.quantity = tempQty;
                    selected.price = tempPrice;
                }
            }
        }
    }

    public void display(InventoryNode item){
        System.out.printf("%-10s %-10s %-10d %-10.2f %-10.2f\n", item.itemId, item.itemName, item.quantity, item.price, (item.price * item.quantity));
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No Student records found.");
            return;
        }

        InventoryNode temp = head;

        System.out.println("======================================================");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Item Id", "Item Name", "Quantity", "Price", "Total");
        System.out.println("======================================================");
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
        System.out.println("======================================================");
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addEnd("Monitor", "101", 5, 12000);
        inventory.addFirst("Mouse", "102", 20, 500);
        inventory.addEnd("Keyboard", "103", 15, 800);
        inventory.addPos("Speaker", "104", 10, 1500, 2);

        inventory.displayAll();

        System.out.println("\nSearching for 'Mouse':");
        inventory.searchItem("Mouse");

        System.out.println("\nUpdating quantity of ItemID 101 to 10:");
        inventory.UpdateQuantity("101", 10);

        System.out.println("\nCalculating total value:");
        inventory.calculateTotal();

        System.out.println("\nSorted by Item Name (Ascending):");
        inventory.sortInventory("name", true);
        inventory.displayAll();

        System.out.println("\nSorted by Price (Descending):");
        inventory.sortInventory("price", false);
        inventory.displayAll();

        System.out.println("\nRemoving ItemID 103:");
        inventory.removeItem("103");
        inventory.displayAll();
    }
}
