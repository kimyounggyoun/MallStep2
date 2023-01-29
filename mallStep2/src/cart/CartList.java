package cart;

public class CartList {
	private CartList() {
	}

	static private CartList instance = new CartList();

	static public CartList getInstance() {
		return instance;
	}

}
