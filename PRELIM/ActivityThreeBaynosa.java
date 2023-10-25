import java.util.Scanner;

public class ActivityThreeBaynosa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

               String[] menuItems = { "C1", "C2", "C3" };
        double[] menuPrices = { 10.0, 12.0, 15.0 };
        String[] addOns = { "R1", "R2" };
        double[] addOnPrices = { 2.0, 3.0 };

               int[] orderQuantities = new int[menuItems.length + addOns.length];

        while (true) {
            System.out.println("Menu:");
            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". " + menuItems[i] + " - Php" + menuPrices[i]);
            }
            System.out.println("Add-ons:");
            for (int i = 0; i < addOns.length; i++) {
                int itemNumber = menuItems.length + i + 1;
                System.out.println(itemNumber + ". " + addOns[i] + " - Php" + addOnPrices[i]);
            }

            System.out.print("Enter your choice (or 'done' to finish): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            int index = -1;

            switch (choice.toLowerCase()) {
                case "c1":
                case "c2":
                case "c3":
                    index = getIndex(menuItems, choice);
                    break;
                case "r1":
                case "r2":
                    index = getIndex(addOns, choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid item from the menu or add-ons.");
                    continue;
            }

            if (index != -1) {
                orderQuantities[index] += quantity;
            }
        }

        double total = 0;
        System.out.println("\nYour Order:");
        for (int i = 0; i < orderQuantities.length; i++) {
            if (orderQuantities[i] > 0) {
                if (i < menuItems.length) {
                    total += menuPrices[i] * orderQuantities[i];
                    System.out.println(menuItems[i] + " - Quantity: " + orderQuantities[i] + " - Total Price: Php" + (menuPrices[i] * orderQuantities[i]));
                } else {
                    int addOnIndex = i - menuItems.length;
                    total += addOnPrices[addOnIndex] * orderQuantities[i];
                    System.out.println(addOns[addOnIndex] + " - Quantity: " + orderQuantities[i] + " - Total Price: Php" + (addOnPrices[addOnIndex] * orderQuantities[i]));
                }
            }
        }

        System.out.println("\nTotal Price: Php" + total);
    }

    private static int getIndex(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return -1;
    }
}