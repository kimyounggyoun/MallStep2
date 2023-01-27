package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class MemberMain implements MenuCommand {
	private MallController mallController;

	@Override
	public void init() {
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("===[ 쇼핑몰 ]===");
		System.out.println("[1.쇼핑] [2.장바구니] [3.게시판] [4.개인정보] [0.메인화면]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("MallMain");
		} else if (select == 1) {
			mallController.setNextMenu("MemberShop");
		} else if (select == 2) {
			mallController.setNextMenu("MemberCart");
		} else if (select == 3) {
			System.out.println("[직접하기]");
		} else if (select == 4) {
			mallController.setNextMenu("MemberUpdate");
		} else {
			return true;
		}
		return false;
	}

}
