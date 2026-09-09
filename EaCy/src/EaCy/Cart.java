package EaCy;

public class Cart {
	private int id;
	private String title;
	private int quantity;

	public Cart(int id, String title, int quantity) {
		this.id = id;
		this.title = title;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
