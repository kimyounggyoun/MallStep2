package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.CartDAO;
import controller.MallController;
import member.MemberDAO;

public class AdminMember implements MenuCommand {
	private MallController mallController;
	private MemberDAO mamberDAO;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		mamberDAO = MemberDAO.getInstance();
		cartDAO = CartDAO.getInstance();
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
			System.out.println("회원번호입력 : ");
			int memberNumber = _Main.scan.nextInt();
			String memberID = mamberDAO.printOneMemberData(memberNumber);
			System.out.printf("[ %s 님의 장바구니 리스트]\n", memberID);
			cartDAO.printOneCartList(cartDAO.getOneCartList(memberID));
		} else {
			return true;
		}
		return false;
	}

}
