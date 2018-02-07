package Bean;

public class Product {
	public Product() {
		this.id = count;
		count++;
	}
	private String name;
	private double price;
	private String type;
	private static int count=0;
	private final int id;
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
