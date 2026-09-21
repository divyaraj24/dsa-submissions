import java.util.*;

public class Main {
    static class Codec {
        public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j));
            int start = j + 1;
            result.add(s.substring(start, start + len));
            i = start + len;
        }
        return result;
    }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(",", -1);
        List<String> strs = new ArrayList<>(Arrays.asList(parts));
        Codec codec = new Codec();
        String encoded = codec.encode(strs);
        List<String> decoded = codec.decode(encoded);
        System.out.println(String.join(",", decoded));
    }
}
