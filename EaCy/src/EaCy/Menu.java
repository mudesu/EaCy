package EaCy;

public class Menu {
	static public int menu() {
		System.out.println("メニュー一覧");
		System.out.println("1：商品一覧");
		System.out.println("2：カート内確認");
		System.out.println("3：管理画面");
		System.out.println("4：終了");
		return InputUtil.inputInt("数字を入力してください");
	}
}
