import java.util.Arrays;
import java.util.Scanner;
public class DeliButcheryApplication {
	
	// Global Variable
	static int storeRating = 0;
	
	// Global Scanner
	static Scanner input = new Scanner(System.in);
	
	static ProductList productList = new ProductList();
	static ProductList deliList = new ProductList();
	static ProductList meatList = new ProductList();
	static ProductList seafoodList = new ProductList();
	static ProductList cheeseList = new ProductList();

	public static void main(String[] args) {
		
		
		// Load Arrays with first products
		productList.addProduct(new Product("Reusable Bag", 9.99, "Misc", "None", 3));
		deliList.addProduct(new Deli("Italian Hoagie", 6.99, "Deli", "3 Days After Purchase", 4, "Cold Sandwich"));
		meatList.addProduct(new Meat("T-Bone", 17.99, "Meat", "7-16-2023", 2, "Cow", "Short Loin", 1.00));
		seafoodList.addProduct(new Seafood("Sekami", 23.99, "Seafood", "5-31-2023", 3, "Tuna", true));
		cheeseList.addProduct(new Cheese("Type 1 Sharp", 3.50, "Cheese", "6-12-2023", 1, "America", "Cheddar", "Semi-Hard"));
		
		while(true) {
			System.out.println();
			System.out.println("[]===============[] Deli-Butchery []===============[]");
			System.out.println("1. General Products");
			System.out.println("2. Deli Products");
			System.out.println("3. Meat Products");
			System.out.println("4. Seafood Products");
			System.out.println("5. Cheese Products");
			System.out.println("6. Store Rating");
			System.out.println("7. Exit Menu");
			System.out.print("Select an option: ");
			int choice = input.nextInt();
			if (choice == 1) { // General Products
				displayAllProducts(productList);
				displayMenu();
				displaySubMenu(input.nextInt(), productList);
			} else if (choice == 2) { // Deli Products
				displayAllProducts(deliList);
				displayMenu();
				displaySubMenu(input.nextInt(), deliList);
			} else if (choice == 3) { // Meat Products
				displayAllProducts(meatList);
				displayMenu();
				displaySubMenu(input.nextInt(), meatList);
			} else if (choice == 4) { // Seafood Products
				displayAllProducts(seafoodList);
				displayMenu();
				displaySubMenu(input.nextInt(), seafoodList);
			} else if (choice == 5) { // Cheese Products
				displayAllProducts(cheeseList);
				displayMenu();
				displaySubMenu(input.nextInt(), cheeseList);
			} else if (choice == 6) { // Store Rating
				System.out.println();
				System.out.println("Current Store Rating: " + storeRating);
				rateStore();
			}else if (choice == 7) { // Exit Menu
				System.out.println();
				System.out.println("Menu Exit Complete");
				break;
			} else { // Send to beginning of menu
				System.out.println();
				System.out.println("That is not a valid selection");
			}
		} // End While Loop
	} // End Main Method
	
	// Helper Method - Display all products of a specific list
	public static void displayAllProducts(ProductList productList) {
		System.out.println();
		System.out.println("        []=======[]     Items     []=======[]        ");
		for (int i = 0; i < productList.getSize(); i++) {
			System.out.print(i + ": ");
			productList.displayProductID(i);
		} // End For Loop
	} // End displayAllProducts
	
	public static void displayMenu() { // Display menu, meant to lessen coding
		System.out.println();
		System.out.println("[]===============[]     Menu     []================[]");
		System.out.println("1. Display Product Attributes");
		System.out.println("2. Add a New Product");
		System.out.println("3. Update an Existing Product");
		System.out.println("4. Delete an Existing Product");
		System.out.println("5. Rate a Product");
	} // End Display Menu
	
	public static void displaySubMenu(int a, ProductList selectedList) {
		String newID = null;
		double newPrice = 0;
		String newCategory = null;
		String newDate = null;
		int newRating = 0;
		String newDeliType = null;
		String newAnimal = null;
		String newCut = null;
		double newWeight = 0;
		String newSpecies = null;
		boolean isFresh = false;
		String newOrigin = null;
		String newCheeseType = null;
		String newTexture = null;
		
		if (a == 1) { // Display all details of the array
			System.out.println();
			System.out.println("        []======[]    Details    []=======[]        ");
			for (int i = 0; i < productList.getSize(); i++) {
				System.out.print(i + ": ");
				selectedList.displayProduct(i);
			} // End For Loop
		} else if (a == 2) { // Add new product to array
			System.out.println();
			System.out.println("        []======[]   Addition    []=======[]        ");
			if (selectedList == productList) {
				System.out.println("Adding new product to list...");
				System.out.print("Enter a product identifier: ");
				newID = input.next();
				System.out.print("Enter a product price: ");
				newPrice = input.nextDouble();
				System.out.print("Enter a category: ");
				newCategory = input.next();
				System.out.print("Enter a experation date: ");
				newDate = input.next();
				int x = input.nextInt();
				while (x < 1 || x > 5) {
					System.out.println("Must be a rating of 1 through 5");
					System.out.println("Enter a rating:");
					x = input.nextInt();
				}
				newRating = x;
				selectedList.addProduct(new Product(newID, newPrice, newCategory, newDate, newRating));
			} else if (selectedList == deliList) {
				System.out.println("Adding new product to list...");
				System.out.print("Enter a product identifier: ");
				newID = input.next();
				System.out.print("Enter a product price: ");
				newPrice = input.nextDouble();
				System.out.print("Enter a category: ");
				newCategory = input.next();
				System.out.print("Enter a experation date: ");
				newDate = input.next();
				System.out.print("Enter the type of deli product: ");
				newDeliType = input.next();
				int x = input.nextInt();
				while (x < 1 || x > 5) {
					System.out.println("Must be a rating of 1 through 5");
					System.out.println("Enter a rating:");
					x = input.nextInt();
				}
				newRating = x;
				selectedList.addProduct(new Deli(newID, newPrice, newCategory, newDate, newRating, newDeliType));
			} else if (selectedList == meatList) {
				System.out.println("Adding new product to list...");
				System.out.print("Enter a product identifier: ");
				newID = input.next();
				System.out.print("Enter a product price: ");
				newPrice = input.nextDouble();
				System.out.print("Enter a category: ");
				newCategory = input.next();
				System.out.print("Enter a experation date: ");
				newDate = input.next();
				System.out.print("Enter the source animal: ");
				newAnimal = input.next();
				System.out.print("Enter the cut of meat: ");
				newCut = input.next();
				System.out.print("Enter the weight of the cut: ");
				newWeight = input.nextDouble();
				int x = input.nextInt();
				while (x < 1 || x > 5) {
					System.out.println("Must be a rating of 1 through 5");
					System.out.println("Enter a rating:");
					x = input.nextInt();
				}
				newRating = x;
				selectedList.addProduct(new Meat(newID, newPrice, newCategory, newDate, newRating, newAnimal, newCut, newWeight));
			} else if (selectedList == seafoodList) {
				System.out.println("Adding new product to list...");
				System.out.print("Enter a product identifier: ");
				newID = input.next();
				System.out.print("Enter a product price: ");
				newPrice = input.nextDouble();
				System.out.print("Enter a category: ");
				newCategory = input.next();
				System.out.print("Enter a experation date: ");
				newDate = input.next();
				System.out.print("Enter the fish species: ");
				newSpecies = input.next();
				System.out.println("Is the seafood fresh?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int choiceFresh = input.nextInt();
				if (choiceFresh == 1) {
					isFresh = true;
				} else if (choiceFresh == 2) {
					isFresh = false;
				}
				int x = input.nextInt();
				while (x < 1 || x > 5) {
					System.out.println("Must be a rating of 1 through 5");
					System.out.println("Enter a rating:");
					x = input.nextInt();
				}
				newRating = x;
				selectedList.addProduct(new Seafood(newID, newPrice, newCategory, newDate, newRating, newSpecies, isFresh));
			} else if (selectedList == cheeseList) {
				System.out.println("Adding new product to list...");
				System.out.print("Enter a product identifier: ");
				newID = input.next();
				System.out.print("Enter a product price: ");
				newPrice = input.nextDouble();
				System.out.print("Enter a category: ");
				newCategory = input.next();
				System.out.print("Enter a experation date: ");
				newDate = input.next();
				System.out.print("Enter the cheese origin: ");
				newOrigin = input.next();
				System.out.print("Enter the cheese type: ");
				newCheeseType = input.next();
				System.out.print("Enter the cheese texture: ");
				newTexture = input.next();
				System.out.println("Enter a product rating (1-5): ");
				int x = input.nextInt();
				while (x < 1 || x > 5) {
					System.out.println("Must be a rating of 1 through 5");
					System.out.println("Enter a rating:");
					x = input.nextInt();
				}
				newRating = x;
				selectedList.addProduct(new Cheese(newID, newPrice, newCategory, newDate, newRating, newOrigin, newCheeseType, newTexture));
			}
			for (int i = 0; i < productList.getSize(); i++) {
				System.out.print(i + ": ");
				selectedList.displayProduct(i);
			} // End For Loop
		} else if (a == 3) { // Update product of array
			System.out.println();
			System.out.println("        []======[]     Update    []=======[]        ");
			for (int i = 0; i < productList.getSize(); i++) {
				System.out.print(i + ": ");
				selectedList.displayProduct(i);
			} // End For Loop
			for (int i = 0; i < selectedList.getCount(); i++) {
				System.out.print(i + ": ");
				selectedList.displayProduct(i);
			} // End For Loop
			System.out.println("Select an item you wish to update: ");
			selectedList.getProduct(input.nextInt()).updateProduct();
		} else if (a == 4) { // Delete product of array
			System.out.println();
			System.out.println("        []======[]    Deleting   []=======[]        ");
			for (int i = 0; i < productList.getSize(); i++) {
				System.out.print(i + ": ");
				selectedList.displayProduct(i);
			} // End For Loop
			System.out.print("Select the item to delete: ");
			selectedList.removeProduct(input.nextInt());
		} else if (a == 5) { // Change rating of a product
			System.out.println();
			System.out.println("        []=======[]     Rate      []=======[]        ");
			for (int i = 0; i < productList.getSize(); i++) {
				System.out.print(i + ": ");
				selectedList.displayProduct(i);
			} // End For Loop
			System.out.print("Select the item you wish to rate: ");
			int selection = input.nextInt();
			System.out.print("Enter the rating for the product: ");
			int x = input.nextInt();
			while (x < 1 || x > 5) {
				System.out.println("Must be a rating of 1 through 5");
				System.out.println("Enter a rating:");
				x = input.nextInt();
			}
			selectedList.getProduct(selection).setProductRating(x);
		} else { // Send them back to the beginning if invalid
			System.out.println("That is not a valid option.");
		}
	} // End displaySubMenu
	public static void rateStore() {
		System.out.println();
		System.out.println("Would you like to change the store rating?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int a = input.nextInt();
		if (a == 1) {
			System.out.print("Enter new store rating: ");
			int x = input.nextInt();
			while (x < 1 || x > 5) {
				System.out.println("Rating must be from 1 to 5. Please try again.");
				System.out.print("Enter new store rating: ");
				x = input.nextInt();
			}
			storeRating = x;
		}
	} // End rateStore
} // End Class