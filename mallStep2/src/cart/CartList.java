package cart;

public class CartList {
	private CartList() {
	}

	static private CartList instance = new CartList();

	static public CartList getInstance() {
		return instance;
	}
	
	
	
	public void printAllCartList() {
		for (int i = 0; i < cartList.size(); i++) {
			System.out.println(i + 1 + ")" + cartList.get(i));
		}
	}
}
