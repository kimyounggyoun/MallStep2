package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;
import item.ItemDAO;

public class AdminCart implements MenuCommand {

	private CartDAO cartDAO;
	private ItemDAO itemDAO;
	private MallController mallController;

	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		itemDAO = ItemDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== 장바구니 관리자 ===");
		System.out.println("[회원전체 장바구니 목록]");
		cartDAO.printAllCartList(); // 장바구니 전체확인, 아이디 옆에 표시
		System.out.println("[1.업데이트] [0.관리자메인]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("AdminMain");
		} else if (select == 1) {
			// 수정된 아이템설정값과 다른 장바구니 목록 내용을 업데이트 하는 기능,
			for (int i = cartDAO.getCartList().size() - 1; i >= 0; i--) {
				String temp = cartDAO.getCartList().get(i).getItemName();
				int check = -1;
				for (int j = 0; j < itemDAO.getItemList().size() - 1; j++) {
					if (itemDAO.getItemList().get(j).getItemName().equals(temp)) {
						int itemPrice = itemDAO.getItemList().get(j).getPrice();
						cartDAO.cartListUpdate(i, itemPrice);
						check = 0;
						break;
					}
				}
				if (check == -1) {
					cartDAO.cartListUpdate(i);
				}
			}
			System.out.println("장바구니 업데이트가 되었습니다.");
		} else {
			return true;
		}
		return false;
	}

}
