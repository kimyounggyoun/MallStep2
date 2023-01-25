package cart;

import java.util.ArrayList;

public class CartDAO {
	private CartDAO() {
	}

	static private CartDAO instance = new CartDAO();

	static public CartDAO getInstance() {
		return instance;
	}

	private ArrayList<Cart> cartList;
	private int cartNumber;

	public void init() {
		cartList = new ArrayList<Cart>();
		cartNumber = 1000;
	}

	public int getCartNumber() {
		cartNumber += 1;
		return cartNumber;
	}

	public void insertCart(Cart cart) {
		cartList.add(cart);
	}

	public ArrayList<Cart> getOneCartList(String memberLoginID) {
		ArrayList<Cart> oneCartList = new ArrayList<Cart>();
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getMemberID().equals(memberLoginID)) {
				oneCartList.add(cartList.get(i));
			}
		}
		return oneCartList;
	}

	public void printOneCartList(ArrayList<Cart> oneCartList) {
		for (int i = 0; i < oneCartList.size(); i++) {
			System.out.println(i + 1 + ")" + oneCartList.get(i));
		}
	}



}
