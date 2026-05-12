class Solution {
    
    public boolean isValidSudoku(char[][] board) {        

        for (int r = 0; r < 9; r++) {
            HashSet<Character> hr = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                if (hr.contains(board[r][c])) return false;
                hr.add(board[r][c]);
            }
        }
        for (int c = 0; c < 9; c++) {
            HashSet<Character> hc = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] == '.') continue;
                if (hc.contains(board[r][c])) return false;
                hc.add(board[r][c]);
            }
        }
        for (int b = 0; b < 9; b++) {
            HashSet<Character> hs = new HashSet();
            for (int i = 0; i < 9; i++) {
                int row = (b / 3) * 3 + i / 3;
                int col = (b % 3) * 3 + i % 3;

                char val = board[row][col];
                if (val == '.') continue;
                if (hs.contains(val)) {
                    return false;
                }
                hs.add(val);
            }
        }

        return true;

    }
}
