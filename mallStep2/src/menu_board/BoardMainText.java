package menu_board;

import _mall.MenuCommand;
import _mall._Main;
import board.BoardDAO;
import controller.MallController;

public class BoardMainText implements MenuCommand {
	private MallController mallController;
	private BoardDAO boardDAO;

	@Override
	public void init() {
		mallController = MallController.getInstance();
		boardDAO = BoardDAO.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("확인할 게시물의 번호를 입력해주세요");
		int idx = _Main.scan.nextInt() - 1;
		if (idx > boardDAO.getCount() || idx < 0) {
			System.out.println("게시물 번호를 다시 확인해주세요");
			mallController.setNextMenu("BoardMain");
			return false;
		} else {
			while (true) {
				boardDAO.printTextMain(idx);
				boolean myText = mallController.getMemberLoginID()
						.equals(boardDAO.getBoardList().get(idx).getMemberID());

				System.out.println("[1.삭제][2.수정][0.뒤로가기]");
				int editSel = _Main.scan.nextInt();
				if (editSel == 0) {
					mallController.setNextMenu("BoardMain");
					return false;

				} else if (editSel == 1 && myText) {
					idx = boardDAO.deleteText(idx);
					mallController.setNextMenu("BoardMain");
					mallController.setNextMenu("BoardMain");
					return false;

				} else if (editSel == 2 && myText) {
					System.out.print("제목 : \n");
					String title = _Main.scan.next();
					_Main.scan.nextLine();
					System.out.print("내용 : \n");
					String mainText = _Main.scan.next();
					_Main.scan.nextLine();

					boardDAO.editText(idx, title, mainText);

				} else {
					System.out.println("게시글 권한은 작성자에게만 있습니다");
				}
			}
		}
	}
}