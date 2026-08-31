package EaCy;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		System.out.println("簡易EC注文管理アプリケーション　EaCy");

		ArrayList<Goods> goods = new ArrayList<>();
		ArrayList<Cart> cart = new ArrayList<>();

		while (true) {
			int number = Menu.menu();
			if (number == 1) {
				System.out.println("商品一覧");
				for (Goods no : goods) {
					System.out.println("商品名:" + no.getTitle());
					System.out.println("値段:" + no.getPrice());
					System.out.println("在庫数:" + no.getStock());
					System.out.println("カテゴリー:" + no.getCategory());
				}
				//一覧表示
			} else if (number == 2) {
				for (Cart no : cart) {
					System.out.println("商品名:" + no.getTitle());
					System.out.println("購入数:" + no.getQuantity());
				}
				//カート内表示
			} else if (number == 3) {
				while (true) {
					System.out.println("管理画面");
					System.out.println("1：商品追加");
					System.out.println("2：商品情報更新");
					System.out.println("3：商品削除");
					System.out.println("4：終了");
					int admin = InputUtil.inputInt("番号を入力");

					if (admin == 1) {
						//商品追加
					} else if (admin == 2) {
						//商品情報更新
					} else if (admin == 3) {
						//商品削除
					} else if (admin == 4) {
						System.out.println("メニューに戻ります。");
						break;
						//終了
					} else {
						System.out.println("1~4の番号を入力してください。");
					}
				}
				//管理
			} else if (number == 4) {
				//終了
				System.out.println("アプリケーションを終了します。");
				break;
			} else {
				System.out.println("1~4の番号を選択してください。");
			}
		}
	}
}