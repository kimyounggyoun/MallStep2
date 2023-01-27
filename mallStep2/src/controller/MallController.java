package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import cart.CartDAO;
import item.ItemDAO;
import member.MemberDAO;
import menu_admin.AdminAddItem;
import menu_admin.AdminCart;
import menu_admin.AdminDeleteItem;
import menu_admin.AdminItem;
import menu_admin.AdminMain;
import menu_admin.AdminMember;
import menu_mall.MallJoin;
import menu_mall.MallLogin;
import menu_mall.MallMain;
import menu_member.MemberCart;
import menu_member.MemberItem;
import menu_member.MemberMain;
import menu_member.MemberShop;
import menu_member.MemberUpdate;

public class MallController {
	private MallController() {
	}

	static private MallController instance = new MallController();

	static public MallController getInstance() {
		return instance;
	}

	private String nextMenu;
	private String memberLoginID;
	private MenuCommand menuCommand;
	private Map<String, MenuCommand> mapContoller;

	public String getMemberLoginID() {
		return memberLoginID;
	}

	public void setMemberLoginID(String memberLoginID) {
		this.memberLoginID = memberLoginID;
	}

	public void setNextMenu(String nextMenu) {
		this.nextMenu = nextMenu;
	}

	public void init() {
		MemberDAO.getInstance().init();
		ItemDAO.getInstance().init();
		CartDAO.getInstance().init();

		mapContoller = new HashMap<String, MenuCommand>();
		mapContoller.put("MallMain", new MallMain());
		mapContoller.put("MallJoin", new MallJoin());
		mapContoller.put("MallLogin", new MallLogin());

		mapContoller.put("AdminMain", new AdminMain());
		mapContoller.put("AdminItem", new AdminItem());
		mapContoller.put("AdminMember", new AdminMember());
		mapContoller.put("AdminAddItem", new AdminAddItem());
		mapContoller.put("AdminCart", new AdminCart());
		mapContoller.put("AdminDeleteItem", new AdminDeleteItem());

		mapContoller.put("MemberMain", new MemberMain());
		mapContoller.put("MemberShop", new MemberShop());
		mapContoller.put("MemberItem", new MemberItem());
		mapContoller.put("MemberCart", new MemberCart());
		mapContoller.put("MemberUpdate", new MemberUpdate());
		

		menuCommand = mapContoller.get("MallMain");
		menuCommand.init();
		update();
	}

	public void update() {
		while (true) {
			if (menuCommand.update() == false) {
				if (nextMenu != null) {
					menuCommand = mapContoller.get(nextMenu);
					menuCommand.init();
				} else {
					break;
				}
			}
		}
	}
}
