import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task1 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("[A-Z]{2}-[0-9]{3}");
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}