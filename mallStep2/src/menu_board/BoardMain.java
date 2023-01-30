package menu_board;

import _mall.MenuCommand;
import _mall._Main;
import board.BoardDAO;
import controller.MallController;

public class BoardMain implements MenuCommand {
	private MallController mallController;
	private BoardDAO boardDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		boardDAO = BoardDAO.getInstance();
	}

	@Override
	public boolean update() {
		while (true) {
			System.out.println("===[ �Խ��� ]===");
			boardDAO.printPage();
			System.out.printf("�ѰԽñۼ� : %d / ������ %d/%d \n", boardDAO.getCount(), boardDAO.getCurPageNum(),
					boardDAO.getPageCount());

			System.out.println("[1.����������] [2.����������] [3.�Խñ��ۼ�] [4.��������] [0.�ڷΰ���]");
			int sel = _Main.scan.nextInt();
			if (sel == 0) {
				mallController.setNextMenu("MemberMain");
				break;
			} else if (sel == 1) {
				boardDAO.backCurPageNum();
			} else if (sel == 2) {
				boardDAO.nextCurPageNum();
			} else if (sel == 3) {
				System.out.print("�Խñ��� �ۼ��մϴ�.");
				System.out.print("���� : ");
				String title = _Main.scan.next();
				_Main.scan.nextLine();
				System.out.print("���� : ");
				String maintext = _Main.scan.next();
				_Main.scan.nextLine();
				boardDAO.newText(mallController.getMemberLoginID(), title, maintext);
				System.out.println("�ۼ��� �Ϸ� �Ǿ����ϴ�.");
			} else if (sel == 4) {
				mallController.setNextMenu("BoardMainText");
				return false;
			} else {

			}
		}

		return false;
	}
}
