package member;

import java.util.ArrayList;

import _mall._Main;

public class MemberDAO {
	private MemberDAO() {
	}

	static private MemberDAO instance = new MemberDAO();

	static public MemberDAO getInstance() {
		return instance;
	}

	private ArrayList<Member> memberList;
	private int memberNumber;

	public void init() {
		memberNumber = 1000;
		memberList = new ArrayList<>();
		setSampleData();
	}

	public void addMember(Member member) {
		memberList.add(member);
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public int getNextNumber() {
		memberNumber += 1;
		return memberNumber;
	}

	public boolean checkMember(String id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkMemberLogin(String id, String pw) {
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getMemberID()) && pw.equals(memberList.get(i).getMemberPW())) {
				return true;
			}
		}
		return false;
	}

	public void printAllMemberList() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(i + 1 + ") " + memberList.get(i));
		}
	}

	public String printOneMemberData(String memberID) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMemberID().equals(memberID)) {
				System.out.printf("회원번호 : %d \n", memberList.get(i).getMemberNumber());
				System.out.printf("아 이 디 : %s \n", memberList.get(i).getMemberID());
				System.out.printf("비밀번호 : %s \n", memberList.get(i).getMemberPW());
				System.out.printf("성    함 : %s \n", memberList.get(i).getMemberName());
				return i + "";
			}
		}
		System.out.println(" ㄴㄴ");
		return "";
	}

	public void passUpdate(String pw, int idx) {
		memberList.get(idx).setMemberPW(pw);

	}

	public String printOneMemberData(int memberNumber) {
		String memID = null;
		for (int i = 0; i < memberList.size() - 1; i++) {
			if (memberList.get(i).getMemberNumber() == memberNumber) {
				System.out.println(memberList.get(i).toString());
				memID = memberList.get(i).getMemberID();
				break;
			}
		}
		return memID;
	}

	public void setSampleData() {
		Member member = new Member(getNextNumber(), "admin", "admin", "관리자");
		addMember(member);
		member = new Member(getNextNumber(), "a", "a", "김철민");
		addMember(member);
		member = new Member(getNextNumber(), "b", "b", "이민영");
		addMember(member);
	}
}
