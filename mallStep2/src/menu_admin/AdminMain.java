package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class AdminMain implements MenuCommand {

	private MallController mallController;

	@Override
	public void init() {
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("[1.ȸ������] [2.��ǰ����] [3.��ٱ��ϰ���] [0.����ȭ��]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("MallMain");
		} else if (select == 1) {
			mallController.setNextMenu("AdminMember");
		} else if (select == 2) {
			mallController.setNextMenu("AdminItem");
		} else if (select == 3) {
			mallController.setNextMenu("AdminCart");
		} else {
			return true;
		}
		return false;
	}

}
