package EaCy;

public class Menu {
	static public int menu() {
		System.out.println("メニュー一覧");
		System.out.println("1：商品一覧");
		System.out.println("2：カート内確認");
		System.out.println("3：注文確定");
		System.out.println("4：管理画面");
		System.out.println("5：終了");
		return InputUtil.inputInt("数字を入力してください");
	}

	static public int adminMenu() {
		System.out.println("管理画面");
		System.out.println("0：商品一覧(id可視化)");
		System.out.println("1：商品追加");
		System.out.println("2：商品情報更新");
		System.out.println("3：商品削除");
		System.out.println("4：終了");
		return InputUtil.inputInt("番号を入力");
	}
}
