package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class MemberCart implements MenuCommand {
	private MallController mallController;
	private CartDAO cartDAO;

	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		ArrayList<Cart> oneCartList = cartDAO.getOneCartList(mallController.getMemberLoginID());
		cartDAO.printOneCartList(oneCartList);
		System.out.println("===[장바구니관리]===");

		System.out.println("[1.구입] [2.삭제] [0.쇼핑몰]");
		int sel = _Main.scan.nextInt();
		if (sel == 0) {
			mallController.setNextMenu("MallMain");
		} else if (sel == 1) {
			System.out.println("[직접하기]");
		} else if (sel == 2) {
			System.out.println("[직접하기]");
		}
		return false;
	}

}
