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
		setSampleData();
	}

	public ArrayList<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<Cart> cartList) {
		this.cartList = cartList;
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
			if (cartList.get(i).getMemberID().equals(memberLoginID) && cartList.get(i).isBuy() == false) {
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

	public void printOnePrice(ArrayList<Cart> oneCartList) {
		int price = 0;
		for (int i = 0; i < oneCartList.size(); i++) {
			price += oneCartList.get(i).getItemPrice();
		}
		System.out.println(price);
	}

	public void buyOneCart(ArrayList<Cart> oneCartList) {
		for (int i = 0; i < oneCartList.size(); i++) {
			oneCartList.get(i).setBuy(true);
		}
	}

	public void printAllCartList() {
		for (int i = 0; i < cartList.size(); i++) {
			String buy = cartList.get(i).isBuy() ? "Yes" : "No";
			System.out.println(i + 1 + ")" + cartList.get(i) + "   주문 : " + buy);
		}
	}

	public int serchItem(ArrayList<Cart> oneCartList, String itemName, int ItemCount, String memberLoginID) {
		int cnt = 0;
		for (int i = 0; i < oneCartList.size(); i++) {
			if (oneCartList.get(i).getItemName().equals(itemName))
				cnt++;
		}
		if (cnt < ItemCount || cnt == 0 || ItemCount == 0) {
			return -1;
		} else {
			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getMemberID().equals(memberLoginID)
						&& cartList.get(i).getItemName().equals(itemName)) {
					cartList.remove(i);
					cnt--;
				}
				if (cnt == 0) {
					break;
				}
			}
		}
		return 0;
	}

	public void cartListUpdate(int idx, int price) {
		cartList.get(idx).setItemPrice(price);
	}

	public void cartListUpdate(int idx) {
		cartList.remove(idx);
	}

	public void setSampleData() {
		Cart temp = new Cart(1001, "a", "새우깡", 1500); // 업데이트하면 1000으로 변경될 부분
		cartList.add(temp);
		temp = new Cart(1002, "b", "감자깡", 1500);
		cartList.add(temp);
		temp = new Cart(1003, "a", "콜라", 2000);
		cartList.add(temp);
		temp = new Cart(1004, "b", "환타", 1500); // 업데이트하면 삭제될 목록
		cartList.add(temp);
		cartNumber += 4;

	}

}
