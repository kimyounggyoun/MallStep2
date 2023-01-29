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
		System.out.println("===[장바구니관리]===");

		System.out.println("[1.구입] [2.삭제] [0.쇼핑몰]");
		int sel = _Main.scan.nextInt();
		if (sel == 0) {
			mallController.setNextMenu("MemberMain");
		} else if (sel == 1) {
			System.out.print("총 금액 : ");
			cartDAO.printOnePrice(oneCartList);
			System.out.println("장바구니 목록을 구매 하시겠습니까?");
			System.out.println("[1.구입] [0.뒤로가기]");
			int buySel = _Main.scan.nextInt();
			if (buySel == 0) {

			} else if (buySel == 1) {
				cartDAO.buyOneCart(oneCartList);
				System.out.println("장바구니를 구매하였습니다.");
			} else {

			}
		} else if (sel == 2) {
			System.out.println("삭제할 상품 이름를 입력해주세요");
			String delItemName = _Main.scan.next();
			System.out.println("삭제할 상품 갯수를 입력해주세요");
			int delItemCount = _Main.scan.nextInt();
			if (cartDAO.serchItem(oneCartList, delItemName, delItemCount, ID) == 0) {
				System.out.printf("%s 상품  %d 개 장바구니에서 삭제 되었습니다\n", delItemName, delItemCount);
			} else {
				System.out.println("[상품명, 갯수를 확인해주세요]");
			}
		}
		return false;
	}

}
