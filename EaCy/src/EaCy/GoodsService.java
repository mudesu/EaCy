package EaCy;

import java.util.ArrayList;

public class GoodsService {

	static ArrayList<Goods> goods = new ArrayList<>();
	static ArrayList<Cart> cart = new ArrayList<>();

	//商品一覧表示機能
	public static void listPrice(String message) {
		if (message == "admin") {
			for (Goods no : goods) {
				System.out.println("商品id:" + no.getId());
				System.out.println("商品名:" + no.getTitle());
				System.out.println("値段:" + no.getPrice());
				System.out.println("在庫数:" + no.getStock());
				System.out.println("カテゴリー:" + no.getCategory());
			}
		} else {
			for (int i = 0; i < goods.size(); i++) {
				Goods no = goods.get(i);
				System.out.println("項目:" + (i + 1));
				System.out.println("商品id:" + no.getId());
				System.out.println("商品名:" + no.getTitle());
				System.out.println("値段:" + no.getPrice());
				System.out.println("在庫数:" + no.getStock());
				System.out.println("カテゴリー:" + no.getCategory());
			}
		}
	}

	public static void listCart() {
		for (Cart cart : cart) {
			System.out.println("商品id:" + cart.getId());
			System.out.println("商品名:" + cart.getTitle());
			System.out.println("購入数:" + cart.getQuantity());
		}
	}

	//商品登録機能
	public static void addPrice() {
		System.out.println("商品登録");
		goods.add(new Goods(InputUtil.inputInt("idを入力してください"),
				InputUtil.inputString("名前を入力してください"),
				InputUtil.inputInt("値段を入力してください"),
				InputUtil.inputInt("在庫数を入力してください"),
				InputUtil.inputString("カテゴリーを入力してください")));
	}

	//商品情報更新機能
	public static void update() {
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

	//商品削除機能
	public static void deletePrice() {
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

	//注文確定機能
	public static void orderPrice() {
		while (true) {
			int decision = InputUtil.inputInt("注文内容を確定する場合は1を入力、キャンセルする場合は2を入力");
			if (decision == 1) {
				for (int i = 0; i < cart.size(); i++) {
					Cart c = cart.get(i);
					for (Goods goods : goods)
						if (c.getId() == goods.getId()) {
							goods.setStock((goods.getStock() - c.getQuantity()));
						}
					cart.remove(i);
				}
				System.out.println("注文を確定しました");
				return;
			}
			if (decision == 2) {
				System.out.println("注文をキャンセルしました");
				return;
			} else {
				System.out.println("1か2を入力してください");
			}
		}
	}

	//注文商品内容変更機能
	public static void update(int targetid) {

		if (targetid == 0) {
			return;
		}
		for (Cart c : cart) {
			if (targetid == c.getId()) {
				System.out.println("1:購入数変更");
				System.out.println("2:カートから削除");
				int targetitem = InputUtil.inputInt("変更したい項目を選択");

				if (targetitem == 1) {
					for (Goods goods : goods) {
						if (goods.getId() == c.getId()) {
							System.out.println("購入商品の在庫数:" + goods.getStock());
						}
					}
					while (true) {
						int quantity = InputUtil.inputInt("購入数を変更");
						for (Goods goods : goods) {
							if (targetid == goods.getId()) {
								if (quantity > goods.getStock()) {
									System.out.println("在庫数が足りません再入力してください");
									continue;
								}
								c.setQuantity(quantity);
								return;
							}
						}
					}
				} else if (targetitem == 2) {
					cart.remove(cart.indexOf(c));
					System.out.println("削除しました");
					return;
				}
			}
		}
	}

	//検索機能
	public static void search() {
		String targetcategory = InputUtil.inputString("カテゴリーを入力してください");

		int i = 0;
		for (Goods goods : goods) {
			if (targetcategory == goods.getCategory()) {
				i++;
				System.out.println("項目:" + (i + 1));
				System.out.println("商品名:" + goods.getTitle());
				System.out.println("値段:" + goods.getPrice());
				System.out.println("在庫数:" + goods.getStock());
				System.out.println("カテゴリー:" + goods.getCategory());
			}
		}
		if (i == 0) {
			System.out.println("検索したカテゴリーの商品がありませんでした");
		}
	}

	//商品購入機能
	public static void buyPrice(int choicenumber) {
		if (choicenumber == 0) {
			return;
		}
		for (Goods g : goods) {
			if (g == goods.get((choicenumber - 1))) {
				if (g.getStock() == 0) {
					System.out.println("在庫がありません補充されるまでお待ちください");
					return;
				}
				while (true) {
					int quantity = InputUtil.inputInt("購入数を入力してください");
					if (quantity > g.getStock()) {
						System.out.println("在庫数が足りません、再度入力してください");
						continue;
					}
					cart.add(new Cart(g.getId(), g.getTitle(), quantity));
					break;
				}
				return;
			}
		}
		System.out.println("入力した項目が見つかりません再入力してください");
	}
}
