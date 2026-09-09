package EaCy;

import java.util.Scanner;

public class InputUtil {

	private static final Scanner scanner = new Scanner(System.in);

	public static String inputString(String string) {
		return scanner.nextLine();
	}

	public static int inputInt(String message) {
		while (true) {
			try {
				System.out.println(message);
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println("整数字を入力してください");
				continue;
			}

		}
	}
}
