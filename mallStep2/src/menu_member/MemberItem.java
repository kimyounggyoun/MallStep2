package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;
import item.Item;
import item.ItemDAO;

public class MemberItem implements MenuCommand {

	private ItemDAO itemDAO;
	private String categoryName;
	private MallController mallController;
	private CartDAO cartDAO;

	@Override
	public void init() {
		itemDAO = ItemDAO.getInstance();
		cartDAO = CartDAO.getInstance();
		categoryName = MemberShop.categoryName;
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		ArrayList<Item> itemList = itemDAO.getCategoryItemList(categoryName);
		System.out.println("===[" + categoryName + "]===");
		itemDAO.printOneCategoryItemList(itemList);
		int itemSize = itemList.size();
		System.out.println("[0.카테고리]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("MemberShop");
		} else if (select < 0 || select > itemSize) {
			System.out.println("[잘못된 번호입니다]");
			return true;
		} else {
			select -= 1;
			Item item = itemList.get(select);
			Cart cart = new Cart();
			cart.setNumber(cartDAO.getCartNumber());
			cart.setMemberID(mallController.getMemberLoginID());
			cart.setItemName(item.getItemName());
			cart.setItemPrice(item.getPrice());
			cartDAO.insertCart(cart);
			System.out.println("[장바구니에 담았습니다]");
			return true;
		}
		return false;
	}

	public void printOneCartList() {
		ArrayList<Cart> onCartList = cartDAO.getOneCartList(mallController.getMemberLoginID());
		cartDAO.printOneCartList(onCartList);
	}

}
