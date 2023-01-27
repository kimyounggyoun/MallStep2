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

	public void printAllCartList() {
		printOneCartList(cartList);
		// TODO Auto-generated method stub
	}

	public void cartListUpdate(int idx, int price) {
		cartList.get(idx).setItemPrice(price);
	}

	public void cartListUpdate(int idx) {
		cartList.remove(idx);
	}

	public void setSampleData() {
		Cart temp = new Cart(1001, "a", "�����", 1500); // ������Ʈ�ϸ� 1000���� ����� �κ�
		cartList.add(temp);
		temp = new Cart(1003, "b", "���ڱ�", 1500);
		cartList.add(temp);
		temp = new Cart(1002, "a", "�ݶ�", 2000);
		cartList.add(temp);
		temp = new Cart(1004, "b", "ȯŸ", 1500); // ������Ʈ�ϸ� ������ ���
		cartList.add(temp);
		cartNumber += 4;

	}

}
