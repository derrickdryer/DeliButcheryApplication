import java.util.ArrayList;
import java.util.Scanner;
public class ProductList {
	// Scanner
	Scanner input = new Scanner(System.in);
	
	// ArrayList Attribute
	private ArrayList<Product> productList;
	private int count = 0;
	
	// Constructor
	public ProductList() {
		productList = new ArrayList<Product>();
		count = 0;
	} // End Constructor
	
	// Getters and Setters
	public ArrayList<Product> getProductList() {
		return productList;
	} // End getProductList
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	} // End setProductList
	
	// Helper Methods
	public int getCount() {
		return count;
	} // End getCount
	public void setCount(int count) {
		this.count = count;
	} // End setCount
	public int getSize() {
		return this.getProductList().size();
	}
	public void addProduct(Product product) {
		productList.add(product);
	} // End addProduct
	public void setProduct(int a, Product product) {
		productList.set(a, product);
	} // End setProduct
	public void removeProduct(int a) {
		productList.remove(a);
	} // End removeProduct by index
	public void removeProduct(Product product) {
		productList.remove(product);
	} // End removeProduct by product
	public Product getProduct(int a) {
		return productList.get(a);
	} // End getProduct
	public void displayProduct(int a) {		
		productList.get(a).displayProduct();
	} // End displayProduct
	public void displayProductID(int a) {
		System.out.println(this.getProduct(a).getProductID());
	}
} // End Class
