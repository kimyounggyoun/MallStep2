package item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class ItemDAO {
	private ItemDAO() {
	}

	static private ItemDAO instance = new ItemDAO();

	static public ItemDAO getInstance() {
		return instance;
	}

	private ArrayList<Item> itemList;
	private int itemNumber;

	public void init() {
		itemList = new ArrayList<Item>();
		itemNumber = 1000;
		setSampleData();
	}

	public void setSampleData() {
		String categoryData[] = { "과자", "음료수", "과자", "음료수" };
		String itemNameData[] = { "새우깡", "콜라", "감자깡", "사이다" };
		int priceData[] = { 1000, 2000, 1500, 2500 };
		for (int i = 0; i < categoryData.length; i++) {
			Item item = new Item(getNextItemNumber(), categoryData[i], itemNameData[i], priceData[i]);
			itemList.add(item);
		}
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public int getNextItemNumber() {
		itemNumber++;
		return itemNumber;
	}

	public boolean checkCategoryName(String categoryName) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getCategoryName().equals(categoryName)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkItemName(String itemName) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	public void deleteItem(String itemName) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getItemName().equals(itemName)) {
				itemList.remove(i);
				return;
			}
		}
	}

	public void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i));
		}
	}

	public void printItemList(ArrayList<Item> itemList) {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(i + 1 + ") " + itemList.get(i));
		}
	}

	public ArrayList<String> getCategoryList() {
		TreeSet<String> categorySet = new TreeSet<String>();
		for (int i = 0; i < itemList.size(); i++) {
			categorySet.add(itemList.get(i).getCategoryName());
		}
		ArrayList<String> categoryList = new ArrayList<String>();
		Iterator<String> iter = categorySet.iterator();
		while (iter.hasNext()) {
			categoryList.add(iter.next());
		}
		return categoryList;
	}

	public void printCategoryList(ArrayList<String> categoryList) {

		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println(i + 1 + ")" + categoryList.get(i));
		}
	}

	public int getCategorySize() {
		ArrayList<String> categoryList = getCategoryList();
		return categoryList.size();
	}

	public String getCategoryName(int index) {
		ArrayList<String> categoryList = getCategoryList();
		return categoryList.get(index);
	}

	public ArrayList<Item> getCategoryItemList(String category) {
		ArrayList<Item> categoryItemList = new ArrayList<Item>();
		for (int i = 0; i < itemList.size(); i++) {
			Item item = itemList.get(i);
			if (category.equals(item.getCategoryName())) {
				categoryItemList.add(item);
			}
		}
		return categoryItemList;
	}

	public void printOneCategoryItemList(ArrayList<Item> itemList) {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(i + 1 + ") " + itemList.get(i));
		}
	}

}
