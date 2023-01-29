package board;

import java.util.ArrayList;

public class BoardDAO {
	private BoardDAO() {

	}

	static private BoardDAO instance = new BoardDAO();

	static public BoardDAO getInstance() {
		return instance;
	}

	private ArrayList<Board> boardList;
	private int count = 0; // ��ü �Խñ� ��
	private int pageSize = 5; // �� �������� ������ �Խñ� ��
	private int curPageNum = 1; // ���� ������ ��ȣ
	private int pageCount = 1; // ��ü ������ ����
	private int startRow = 0; // ���� �������� �Խñ� ���� ��ȣ
	private int endRow = 0; // ���� �������� �Խñ� ������ ��ȣ

	public void init() {
		boardList = new ArrayList<Board>();
		setSampleData();
	}

	public ArrayList<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public void backCurPageNum() {
		if (curPageNum == 1) {
			System.out.println("[�� �̻� �� �������� �����ϴ�]");
			return;
		}
		curPageNum--;
	}

	public void nextCurPageNum() {
		if (curPageNum == pageCount) {
			System.out.println("[�� �̻� �� �������� �����ϴ�]");
			return;
		}
		curPageNum++;
	}

	public void newText(String memberID, String title, String mainText) {
		Board newBoard = new Board(memberID, title, mainText);
		boardList.add(newBoard);
		count++;
	}

	public int deleteText(int idx) {
		boardList.remove(idx);
		count--;
		if (count < idx+1) {
			return idx - 1;
		}
		return idx;
	}

	public void editText(int idx, String title, String mainText) {
		if (title != "") {
			boardList.get(idx).setTitle(title);
		}
		if (mainText != "") {
			boardList.get(idx).setMainText(mainText);
		}
	}

	public void printPage() {
		pageCount = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;

		startRow = (curPageNum - 1) * pageSize;
		endRow = startRow + pageSize > count ? count : startRow + pageSize;
		endRow--;

		for (int i = startRow; i <= endRow; i++) {
			System.out.printf("[%2d] %s \n", i + 1, boardList.get(i).getTitle());
		}
	}

	public void printTextMain(int idx) {
		System.out.println(boardList.get(idx).toString());
	}

	public void setSampleData() {
		Board board = new Board("ö��", "��������������", "����������??");
		boardList.add(board);
		board = new Board("����", "������Դϱ�?", "����ƴմϱ�?");
		boardList.add(board);
		count += 2;
	}

}
