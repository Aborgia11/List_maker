import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {
    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runMenu();
    }

    private static void runMenu() {
        boolean quit = false;

        while (!quit) {
            displayMenu();
            char choice = SafeInput.getRegExString(scanner, "Enter your choice (A/D/P/Q):", "[AaDdPpQq]").charAt(0);

            switch (choice) {
                case 'A':
                case 'a':
                    addItem();
                    break;
                case 'D':
                case 'd':
                    deleteItem();
                    break;
                case 'P':
                case 'p':
                    printList();
                    break;
                case 'Q':
                case 'q':
                    quit = confirmQuit();
                    break;
            }
        }

        System.out.println("Goodbye!");
    }

    private static void displayMenu() {
        SafeInput.prettyHeader("List Maker Menu");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter the item to add:");
        itemList.add(item);
        System.out.println("Item added to the list.");
    }

    private static void deleteItem() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Current List:");
        printNumberedItems();
        int index = SafeInput.getRangedInt(scanner, "Enter the number of the item to delete:", 1, itemList.size()) - 1;
        String deletedItem = itemList.remove(index);
        System.out.println("'" + deletedItem + "' has been removed from the list.");
    }

    private static void printList() {
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.println("Current List:");
        printNumberedItems();
    }

    private static void printNumberedItems() {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println((i + 1) + ". " + itemList.get(i));
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }
}
