package menu_mall;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class MallMain implements MenuCommand {
	private MallController mallController;

	public void init() {
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== 쇼핑몰 ===");
		System.out.println("[1] 로그인 [2] 회원가입 [0] 종료");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			System.out.println("[종료]");
			mallController.setNextMenu(null);
			return false;
		}
		if (select == 1) {
			mallController.setNextMenu("MallLogin");
		} else if (select == 2) {
			mallController.setNextMenu("MallJoin");
		} else {
			return true;
		}
		return false;
	}

}
