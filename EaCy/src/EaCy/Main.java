package EaCy;

public class Main {
	public static void main(String[] args) {

		System.out.println("簡易EC注文管理アプリケーション　EaCy");

		while (true) {
			//メニュー表示
			int number = Menu.menu();
			//検索
			if (number == 0) {
				if (GoodsService.search(InputUtil.inputString("カテゴリーを入力してください")) != 0) {
					while (true) {
						GoodsService.buyPrice(InputUtil.inputInt("購入したい商品の項目番号を入力してください(0でメニューに戻る)"));
						break;
					}
				}
				//一覧表示
			} else if (number == 1) {
				GoodsService.listPrice(null);
				while (true) {
					GoodsService.buyPrice(InputUtil.inputInt("購入したい商品の項目番号を入力してください(0でメニューに戻る)"));
					break;
				}
				//カート内表示
			} else if (number == 2) {
				GoodsService.listCart();
				GoodsService.update(InputUtil.inputInt("変更したい注文商品のidを入力してください"));
				//注文内容確定
			} else if (number == 3) {
				GoodsService.orderPrice();
				//管理画面
			} else if (number == 4) {
				while (true) {
					int admin = Menu.adminMenu();
					//商品一覧確認
					if (admin == 0) {
						GoodsService.listPrice("admin");
						//商品追加
					} else if (admin == 1) {
						GoodsService.addPrice();
						//商品情報更新
					} else if (admin == 2) {
						GoodsService.update();
						//商品削除
					} else if (admin == 3) {
						GoodsService.deletePrice();
						//終了
					} else if (admin == 4) {
						System.out.println("メニューに戻ります。");
						break;
						//エラー処理
					} else {
						System.out.println("1~5の番号を入力してください。");
					}
				}
				//終了
			} else if (number == 5) {
				System.out.println("アプリケーションを終了します。");
				break;
				//エラー処理
			} else {
				System.out.println("1~5の番号を選択してください。");
			}
		}
	}
}