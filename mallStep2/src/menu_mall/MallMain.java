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
		System.out.println("=== ���θ� ===");
		System.out.println("[1] �α��� [2] ȸ������ [0] ����");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			System.out.println("[����]");
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
