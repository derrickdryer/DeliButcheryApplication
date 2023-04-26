import java.util.Scanner;
public class Product implements Updatable, Displayable {	
	// Private Variables
	private String productID;
	private double productPrice;
	private String productCategory;
	private String experationDate;
	private int productRating;
	
	// Full Argument Constructor
	public Product(String productID, double productPrice, String productCategory, 
			String experationDate, int productRating) {
		this.productID = productID;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.experationDate = experationDate;
		this.productRating = productRating;
	} // End Product Constructor
	
	// Getters and Setters
	public double getProductPrice() {
		return productPrice;
	} // End getProductPrice
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	} // End setProductPrice
	public String getProductCategory() {
		return productCategory;
	} // End getProductCategory
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	} // End setProductCategory
	public String getExperationDate() {
		return experationDate;
	} // End getExperationDate
	public void setExperationDate(String experationDate) {
		this.experationDate = experationDate;
	} // End setExperationDate
	public int getProductRating() {
		return productRating;
	} // End getProductRating
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	public String getProductID() {
		return productID;
	} // End getProductID
	
	// Update Product Method
	public void updateProduct() {
		Scanner input = new Scanner(System.in);
		boolean update = true;
		while (update == true) {
			// Top Level Menu
			System.out.println("||=======|| Product Update Menu ||=======||");
			System.out.println("Updating Product: " + this.getProductID());
			System.out.println("||=======================================||");
			System.out.println("1. Update Price");
			System.out.println("2. Update Category");
			System.out.println("3. Update Experation Date");
			System.out.println("4. Update Rating");
			System.out.println("5. Exit");
			int option = input.nextInt();
			// Take user input and open lower menu
			if (option == 1) {
				System.out.println("Enter the new price:");
				this.setProductPrice(input.nextDouble());
			} else if (option == 2) {
				System.out.println("Enter the new category:");
				this.setProductCategory(input.next());
			} else if (option == 3) {
				System.out.println("Enter the new experation date:");
				this.setExperationDate(input.next());
			} else if (option == 4) {
				System.out.println("Enter the new rating:");
				int x = input.nextInt();
				while (x < 1 || x > 5) {
					System.out.println("Must be a rating of 1 through 5");
					System.out.println("Enter a rating:");
					this.setProductRating(input.nextInt());
				}
				this.setProductRating(x);
			} else if (option == 5) {
				System.out.println("Exiting Menu");
				update = false;
			} else {
				System.out.println("Not a valid option.");
			}
			// Ask user if they want to continue updating
			System.out.println("Would you like to continue updating: " + this.getProductID());
			System.out.println("1. Yes");
			System.out.println("2. No");
			int option2 = input.nextInt();
			
			// Take user input and change values
			if (option2 == 1) {
				update = true; // Returns user to top of menu
			} else if (option2 == 2) {
				System.out.println("Exiting Updater...");
				update = false; // Stops the while loop
				input = null; // Prevent infinite loop
			}
		} // End While Loop
	} // End updateProduct
	
	// Display Product Method
	public void displayProduct() {
		System.out.println("Product ID: " + this.getProductID() + " Price: " + this.getProductPrice() + 
				" Category: " + this.getProductCategory() + " Experation Date: " + this.getExperationDate() + 
				" Rating: " + this.getProductRating());
	} // End displayProduct
} // End Class
