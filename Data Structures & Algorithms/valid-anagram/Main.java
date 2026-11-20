import java.util.*;

public class Main {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sc = new int[26];
        int[] tc = new int[26];

        for (char i : s.toCharArray()) sc[i - 'a'] = 1;
        for (char i : t.toCharArray()) tc[i - 'a'] = 1;

        return Arrays.equals(sc, tc);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(isAnagram(s, t));
    }
}
