package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.Item;
import item.ItemDAO;

public class AdminDeleteItem implements MenuCommand {
	private MallController mallController;
	private ItemDAO itemDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		itemDAO = ItemDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("[�����ۻ���] ī�װ� �Է� : ");
		String categoryName = _Main.scan.next();

		System.out.println("[�����ۻ���] �������̸� �Է� :  ");
		String itemName = _Main.scan.next();
		boolean check = itemDAO.checkItemName(itemName);
		if (check == true) {
			itemDAO.deleteItem(itemName);
			System.out.printf("[ %s �������� �����Ǿ����ϴ�]", itemName);
		} else {
			System.out.println("[�����ۻ��� ���� (���� ������ �̸�)]");
		}
		mallController.setNextMenu("AdminItem");
		return false;
	}

}
