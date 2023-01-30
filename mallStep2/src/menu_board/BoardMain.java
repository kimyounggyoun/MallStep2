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
			System.out.println("===[ 게시판 ]===");
			boardDAO.printPage();
			System.out.printf("총게시글수 : %d / 페이지 %d/%d \n", boardDAO.getCount(), boardDAO.getCurPageNum(),
					boardDAO.getPageCount());

			System.out.println("[1.이전페이지] [2.다음페이지] [3.게시글작성] [4.본문보기] [0.뒤로가기]");
			int sel = _Main.scan.nextInt();
			if (sel == 0) {
				mallController.setNextMenu("MemberMain");
				break;
			} else if (sel == 1) {
				boardDAO.backCurPageNum();
			} else if (sel == 2) {
				boardDAO.nextCurPageNum();
			} else if (sel == 3) {
				System.out.print("게시글을 작성합니다.");
				System.out.print("제목 : ");
				String title = _Main.scan.next();
				_Main.scan.nextLine();
				System.out.print("내용 : ");
				String maintext = _Main.scan.next();
				_Main.scan.nextLine();
				boardDAO.newText(mallController.getMemberLoginID(), title, maintext);
				System.out.println("작성이 완료 되었습니다.");
			} else if (sel == 4) {
				mallController.setNextMenu("BoardMainText");
				return false;
			} else {

			}
		}

		return false;
	}
}
