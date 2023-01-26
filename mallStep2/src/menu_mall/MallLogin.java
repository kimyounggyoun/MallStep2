package menu_mall;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.MemberDAO;

public class MallLogin implements MenuCommand {
	private MallController mallController;
	private MemberDAO memberDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		memberDAO = MemberDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("===[ �α��� ]===");
		System.out.println("[�α���] ���̵� �Է� : ");
		String id = _Main.scan.next();
		System.out.println("[�α���] ��й�ȣ �Է� : ");
		String pw = _Main.scan.next();
		boolean check = memberDAO.checkMemberLogin(id, pw);
		if (check == true) {
			System.out.println("[" + id + " �α��� ����]");
			if (id.equals("admin")) {
				mallController.setMemberLoginID(id);
				mallController.setNextMenu("AdminMain");
			} else {
				mallController.setMemberLoginID(id);
				mallController.setNextMenu("MemberMain");
			}
		} else {
			System.out.println("[�α��� ����]");
			mallController.setMemberLoginID(null);
			mallController.setNextMenu("MallMain");

		}
		return false;
	}

}
