package EaCy;

public class Main {
	public static void main(String[] args) {

		System.out.println("簡易EC注文管理アプリケーション　EaCy");

		while (true) {
			System.out.println("メニュー一覧");
			System.out.println("1：商品一覧");
			System.out.println("2：カート内確認");
			System.out.println("3：管理画面");
			System.out.println("4：終了");
			int number = InputUtil.inputInt("数字を入力してください");

			if (number == 1) {
				//一覧表示
			} else if (number == 2) {
				//カート内表示
			} else if (number == 3) {
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
