import java.util.*;

public class Main {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
	HashMap<Character, Integer> hm = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
		hm.merge(s.charAt(i), +1, (OldVal, Val) -> OldVal + Val == 0 ? null : OldVal + Val);
		hm.merge(t.charAt(i), -1, (OldVal, Val) -> OldVal + Val == 0 ? null : OldVal + Val);
	}

	return hm.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        System.out.println(isAnagram(s, t));
    }
}
