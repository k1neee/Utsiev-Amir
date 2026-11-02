import java.util.Scanner;

import java.util.Pattern;
import java.util.Matcher;

public class task2 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();

        Pattern pattern = Pattern.compile("[a-z][a-z0-9_]{2,11}");
        Matcher matcher = pattern.matcher(login);

        if (matcher.matches()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}