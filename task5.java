import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.hasNextLine() ? scanner.nextLine() : "";

        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(line);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        System.out.println(count);
    }
}