package EaCy;

public class Goods {
	private int id;
	private String title;
	private int price;
	private int stock;
	private String category;

	public Goods(int id, String title, int price, int stock, String category) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
