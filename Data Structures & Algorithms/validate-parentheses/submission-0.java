class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> hm = new HashMap<>();

        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');

        char[] l = s.toCharArray();

        for (char c : l) {
            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty() && st.peek() == hm.get(c)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}