
public class Product {
	
	private int id;
	private String name;
	private double price;
	private String category;
	
	public Product(int id, String name,String category, double price ) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public String toString() {
		return id + " " + name + " " + category + " " + price;
	}
	
	public String getCategory(){
		return category;
	}
	
	
	
	
	
	
}
