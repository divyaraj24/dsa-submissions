class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            // Find delimiter #
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            // Length of string
            int len = Integer.parseInt(str.substring(i, j));

            // Actual string starts after #
            j++;

            String s = str.substring(j, j + len);

            res.add(s);

            // Move i to next encoded string
            i = j + len;
        }

        return res;
    }
}