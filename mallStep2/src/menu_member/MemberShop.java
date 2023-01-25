package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.ItemDAO;

public class MemberShop implements MenuCommand {

	private ItemDAO itemDAO;
	static public String categoryName;
	private MallController mallController;

	@Override
	public void init() {
		categoryName = null;
		itemDAO = ItemDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {

		System.out.println("===[ 카테고리 ]===");
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		itemDAO.printCategoryList(categoryList);
		int categorySize = categoryList.size();
		System.out.println("[0.쇼핑몰]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("MemberMain");
		} else if (select < 0 || select > categorySize) {
			System.out.println("[잘못된 번호입니다]");
			return true;
		} else {
			select -= 1;
			categoryName = categoryList.get(select);
			mallController.setNextMenu("MemberItem");
		}
		return false;
	}

}
