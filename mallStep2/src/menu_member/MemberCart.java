package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class MemberCart implements MenuCommand {
	private MallController mallController;
	private CartDAO cartDAO;

	@Override
	public void init() {
		cartDAO = CartDAO.getInstance();
		mallController = MallController.getInstance();
	}

	@Override
	public boolean update() {
		String ID = mallController.getMemberLoginID();
		ArrayList<Cart> oneCartList = cartDAO.getOneCartList(ID);
		cartDAO.printOneCartList(oneCartList);
		System.out.println("===[��ٱ��ϰ���]===");

		System.out.println("[1.����] [2.����] [0.���θ�]");
		int sel = _Main.scan.nextInt();
		if (sel == 0) {
			mallController.setNextMenu("MemberMain");
		} else if (sel == 1) {
			System.out.print("�� �ݾ� : ");
			cartDAO.printOnePrice(oneCartList);
			System.out.println("��ٱ��� ����� ���� �Ͻðڽ��ϱ�?");
			System.out.println("[1.����] [0.�ڷΰ���]");
			int buySel = _Main.scan.nextInt();
			if (buySel == 0) {

			} else if (buySel == 1) {
				cartDAO.buyOneCart(oneCartList);
				System.out.println("��ٱ��ϸ� �����Ͽ����ϴ�.");
			} else {

			}
		} else if (sel == 2) {
			System.out.println("������ ��ǰ �̸��� �Է����ּ���");
			String delItemName = _Main.scan.next();
			System.out.println("������ ��ǰ ������ �Է����ּ���");
			int delItemCount = _Main.scan.nextInt();
			if (cartDAO.serchItem(oneCartList, delItemName, delItemCount, ID) == 0) {
				System.out.printf("%s ��ǰ  %d �� ��ٱ��Ͽ��� ���� �Ǿ����ϴ�\n", delItemName, delItemCount);
			} else {
				System.out.println("[��ǰ��, ������ Ȯ�����ּ���]");
			}
		}
		return false;
	}

}
