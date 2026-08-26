package EaCy;

public class Main {
	public static void main(String[] args) {

		System.out.println("簡易EC注文管理アプリケーション　EaCy");

		boolean i = true;
		while (i == true) {
			System.out.println("メニュー一覧");
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
				i = false;
			}
		}
	}
}
