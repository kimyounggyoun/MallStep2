package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.MemberDAO;

public class AdminMember implements MenuCommand {
	private MallController mallController;
	private MemberDAO mamberDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		mamberDAO = MemberDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("=== 회원 관리자 ===");
		mamberDAO.printAllMemberList();
		System.out.println("[1.회원 검색] [0.관리자메인]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("AdminMain");
		} else if (select == 1) {
			System.out.println("[직접하기]");
		} else {
			return true;
		}
		return false;
	}

}
