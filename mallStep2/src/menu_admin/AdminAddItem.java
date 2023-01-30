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

		System.out.println("[아이템추가] 카테고리 입력 : ");
		String categoryName = _Main.scan.next();
		System.out.println("[아이템추가] 아이템이름 입력 :  ");
		String itemName = _Main.scan.next();
		boolean check = itemDAO.checkItemName(itemName);
		if (check == true) {
			System.out.println("[아이템추가 실패 (중복 아이템 이름)]");
		} else {
			System.out.println("[아이템추가] 가격입력 : ");
			int price = _Main.scan.nextInt();
			int number = itemDAO.getNextItemNumber();

			Item item = new Item(number, categoryName, itemName, price);
			itemDAO.addItem(item);
			System.out.println("[아이템추가 성공]");
		}
		mallController.setNextMenu("AdminItem");
		return false;
	}

}
