package EaCy;

import java.util.ArrayList;

public class GoodsService {

	static ArrayList<Goods> goods = new ArrayList<>();

	public static void listprice(String message) {
		if (message == "admin") {
			for (Goods no : goods) {
				System.out.println("商品id:" + no.getId());
				System.out.println("商品名:" + no.getTitle());
				System.out.println("値段:" + no.getPrice());
				System.out.println("在庫数:" + no.getStock());
				System.out.println("カテゴリー:" + no.getCategory());
			}
		} else {
			for (Goods no : goods) {
				System.out.println("商品名:" + no.getTitle());
				System.out.println("値段:" + no.getPrice());
				System.out.println("在庫数:" + no.getStock());
				System.out.println("カテゴリー:" + no.getCategory());
			}
		}
	}

	public static void addprice() {
		System.out.println("商品登録");
		goods.add(new Goods(InputUtil.inputInt("idを入力してください"),
				InputUtil.inputString("名前を入力してください"),
				InputUtil.inputInt("値段を入力してください"),
				InputUtil.inputInt("在庫数を入力してください"),
				InputUtil.inputString("カテゴリーを入力してください")));
	}

	public static void updateprice() {
		System.out.println("商品情報更新");
		int targetid = InputUtil.inputInt("更新したい商品のidを入力");
		for (Goods goods : goods) {
			if (goods.getId() == targetid) {
				System.out.println("1：商品名");
				System.out.println("2：値段");
				System.out.println("3：在庫数");
				System.out.println("4：カテゴリー");
				int targetitem = InputUtil.inputInt("更新したい項目を選択");

				if (targetitem == 1) {
					goods.setTitle(InputUtil.inputString("商品名を入力"));
					return;
				} else if (targetitem == 2) {
					goods.setPrice(InputUtil.inputInt("値段を入力"));
					return;
				} else if (targetitem == 3) {
					goods.setStock(InputUtil.inputInt("在庫数を入力"));
					return;
				} else if (targetitem == 4) {
					goods.setCategory(InputUtil.inputString("カテゴリーを入力"));
					return;
				}
			}
		}
		System.out.println("idが一致しません");
	}

	public static void deleteprice() {
		System.out.println("商品削除");
		int targetid = InputUtil.inputInt("削除したい商品のidを入力");

		for (int i = 0; i < goods.size(); i++) {
			Goods g = goods.get(i);

			if (g.getId() == targetid) {
				goods.remove(i);
				return;
			}
		}
		System.out.println("idが一致しません");
	}
}
