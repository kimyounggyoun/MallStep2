package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.Item;
import item.ItemDAO;

public class AdminAddItem implements MenuCommand {
	private MallController mallController;
	private ItemDAO itemDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		itemDAO = ItemDAO.getInstance();
	}

	@Override
	public boolean update() {

		System.out.println("[�������߰�] ī�װ� �Է� : ");
		String categoryName = _Main.scan.next();
		System.out.println("[�������߰�] �������̸� �Է� :  ");
		String itemName = _Main.scan.next();
		boolean check = itemDAO.checkItemName(itemName);
		if (check == true) {
			System.out.println("[�������߰� ���� (�ߺ� ������ �̸�)]");
		} else {
			System.out.println("[�������߰�] �����Է� : ");
			int price = _Main.scan.nextInt();
			int number = itemDAO.getNextItemNumber();

			Item item = new Item(number, categoryName, itemName, price);
			itemDAO.addItem(item);
			System.out.println("[�������߰� ����]");
		}
		mallController.setNextMenu("AdminItem");
		return false;
	}

}
