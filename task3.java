import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("[0-9A-Z]");
        Matcher matcher = pattern.matcher(line);

        String result = matcher.replaceAll("#");
        System.out.println(result);
    }
}