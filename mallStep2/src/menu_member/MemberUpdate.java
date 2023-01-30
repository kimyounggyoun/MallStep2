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
		System.out.println("===[ �������� ]===");
		int idx = Integer.parseInt(memberDAO.printOneMemberData(mallController.getMemberLoginID()));
		System.out.println("[1.��й�ȣ����] [0.�ڷΰ���]");
		int select = _Main.scan.nextInt();
		if (select == 0) {
			mallController.setNextMenu("MemberMain");
		} else if (select == 1) {
			System.out.println("�����Ͻ� ��й�ȣ�� �Է����ּ��� : ");
			String newPw = _Main.scan.next();
			if (memberDAO.getMemberList().get(idx).getMemberPW().equals(newPw)) {
				System.out.println("���� ��й�ȣ�� �����մϴ�.");
				
			} else {
				memberDAO.passUpdate(newPw, idx);
				System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");

			}

		} else {
			return true;
		}
		return false;
	}

}
