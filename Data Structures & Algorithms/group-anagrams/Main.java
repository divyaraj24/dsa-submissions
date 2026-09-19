import java.util.*;

public class Main {
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // get char freq for key
            int[] key = new int[26];
            for (char j : strs[i].toCharArray()) key[j - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int c : key) sb.append(c).append(','); // for cases [1, 23, 0...] and [12, 3, 0...]
            String keyString = sb.toString();

            if (hm.containsKey(keyString)) {
                hm.get(keyString).add(strs[i]);
            }
            else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                hm.put(keyString, newList);
            }
            
            // hm.computeIfAbsent(KeyString, k -> new ArrayList<>()).add(strs[i]);
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
