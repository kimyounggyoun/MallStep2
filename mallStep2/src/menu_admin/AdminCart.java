package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;

public class AdminCart implements MenuCommand {

	private CartDAO cartDAO;
	private MallController mallController;

	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== 장바구니 관리자 ===");
		cartDAO.printAllCartList();
		System.out.println("[1.검색] [0.관리자메인]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setMemberLoginID("AdminMain");
		} else if (select == 1) {
			System.out.println("[직접하기]");
		} else {
			return true;
		}
		return false;
	}

}
