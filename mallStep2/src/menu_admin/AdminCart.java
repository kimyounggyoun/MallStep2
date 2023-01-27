package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;
import item.ItemDAO;

public class AdminCart implements MenuCommand {

	private CartDAO cartDAO;
	private ItemDAO itemDAO;
	private MallController mallController;

	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		itemDAO = ItemDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== ��ٱ��� ������ ===");
		System.out.println("[ȸ����ü ��ٱ��� ���]");
		cartDAO.printAllCartList(); // ��ٱ��� ��üȮ��, ���̵� ���� ǥ��
		System.out.println("[1.������Ʈ] [0.�����ڸ���]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("AdminMain");
		} else if (select == 1) {
			// ������ �����ۼ������� �ٸ� ��ٱ��� ��� ������ ������Ʈ �ϴ� ���,
			for (int i = cartDAO.getCartList().size() - 1; i >= 0; i--) {
				String temp = cartDAO.getCartList().get(i).getItemName();
				int check = -1;
				for (int j = 0; j < itemDAO.getItemList().size() - 1; j++) {
					if (itemDAO.getItemList().get(j).getItemName().equals(temp)) {
						int itemPrice = itemDAO.getItemList().get(j).getPrice();
						cartDAO.cartListUpdate(i, itemPrice);
						check = 0;
						break;
					}
				}
				if (check == -1) {
					cartDAO.cartListUpdate(i);
				}
			}
			System.out.println("��ٱ��� ������Ʈ�� �Ǿ����ϴ�.");
		} else {
			return true;
		}
		return false;
	}

}
