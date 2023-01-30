package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;
import member.MemberDAO;

public class AdminMember implements MenuCommand {
	private MallController mallController;
	private MemberDAO memberDAO;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		memberDAO = MemberDAO.getInstance();
		cartDAO = CartDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== ȸ�� ������ ===");
		memberDAO.printAllMemberList();
		System.out.println("[1.ȸ�� �˻�] [0.�����ڸ���]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("AdminMain");
		} else if (select == 1) {
			System.out.println("ȸ����ȣ�Է� : ");
			int memberNumber = _Main.scan.nextInt();
			for (int i = 0; i < memberDAO.getMemberList().size(); i++) {
				if (memberDAO.getMemberList().get(i).getMemberNumber() == memberNumber) {
					String memberID = memberDAO.printOneMemberData(memberNumber);
					System.out.printf("[ %s ���� ��ٱ��� ����Ʈ]\n", memberID);
					cartDAO.printOneCartList(cartDAO.getOneCartList(memberID));
					break;
				}
			}
		} else {
			return true;
		}
		return false;
	}

}
