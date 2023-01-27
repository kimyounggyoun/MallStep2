package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.ItemDAO;

public class AdminItem implements MenuCommand {
	private ItemDAO itemDAO;
	private MallController mallController;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		itemDAO = ItemDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== ������ ������ ===");
		itemDAO.printItemList();
		System.out.println("[1.�������߰� ] [2.�����ۻ���] [0.�����ڸ���]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("AdminMain");
		} else if (select == 1) {
			mallController.setNextMenu("AdminAddItem");
		} else if (select == 2) {
			mallController.setNextMenu("AdminDeleteItem");
		} else {
			return true;
		}

		return false;
	}

}
