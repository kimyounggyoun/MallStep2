package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.MemberDAO;

public class MemberUpdate implements MenuCommand {
	private MallController mallController;
	private MemberDAO memberDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		memberDAO = MemberDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("===[ 개인정보 ]===");
		int idx = Integer.parseInt(memberDAO.printOneMemberData(mallController.getMemberLoginID()));
		System.out.println("[1.비밀번호변경] [0.뒤로가기]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("MemberMain");
		} else if (select == 1) {
			System.out.println("변경하실 비밀번호를 입력해주세요 : ");
			String newPw = _Main.scan.next();
			if (memberDAO.getMemberList().get(idx).getMemberPW().equals(newPw)) {
				System.out.println("기존 비밀번호와 동일합니다.");
				
			} else {
				memberDAO.passUpdate(newPw, idx);
				System.out.println("비밀번호가 변경되었습니다.");

			}

		} else {
			return true;
		}
		return false;
	}

}
