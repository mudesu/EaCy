package EaCy;

import java.util.Scanner;

public class InputUtil {

	private static final Scanner scanner = new Scanner(System.in);

	public static String inputString(String message) {
		System.out.println(message);
		return scanner.next();
	}

	public static int inputInt(String message) {
		while (true) {
			try {
				System.out.println(message);
				int num = scanner.nextInt();
				if (num < 0) {
					System.out.println("0以上の整数のみが有効です");
					continue;
				}
				return num;
			} catch (Exception e) {
				System.out.println("整数字を入力してください");
				continue;
			}

		}
	}
}
