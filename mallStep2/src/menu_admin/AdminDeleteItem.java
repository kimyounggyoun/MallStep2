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
		System.out.println("[아이템삭제] 카테고리 입력 : ");
		String categoryName = _Main.scan.next();

		System.out.println("[아이템삭제] 아이템이름 입력 :  ");
		String itemName = _Main.scan.next();
		boolean check = itemDAO.checkItemName(itemName);
		if (check == true) {
			itemDAO.deleteItem(itemName);
			System.out.printf("[ %s 아이템이 삭제되었습니다]", itemName);
		} else {
			System.out.println("[아이템삭제 실패 (없는 아이템 이름)]");
		}
		mallController.setNextMenu("AdminItem");
		return false;
	}

}
