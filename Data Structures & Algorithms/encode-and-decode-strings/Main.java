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

        public List<String> decode(String encoded) {
            int i = 0;
            List<String> res = new ArrayList<>();
            while (i < encoded.length()) {
                int j = i;
                while (encoded.charAt(j) != '#') j++;
                int len = Integer.parseInt(encoded.substring(i, j));
                res.add(encoded.substring(j + 1, j + len + 1));
                i = j + len + 1;
            }
            return res;
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
