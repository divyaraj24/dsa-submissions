import java.util.*;

public class Main {
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(",", -1);
        List<List<String>> groups = groupAnagrams(strs);
        List<String> canonical = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sorted = new ArrayList<>(group);
            Collections.sort(sorted);
            canonical.add(String.join(",", sorted));
        }
        Collections.sort(canonical);
        System.out.println(String.join(";", canonical));
    }
}
