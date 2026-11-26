import java.util.*;

public class Main {
    static boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] column = new HashSet[9];
        Set<Character>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        //one pass
        for (int r = 0; r < board[0].length; r++) {
            for (int c = 0; c < board.length; c++) {
                char d = board[r][c];
                if (d == '.') continue;
                int b = (r / 3) * 3 + (c / 3);
                if (row[r].contains(d) || column[c].contains(d) || box[b].contains(d)) {
                    return false;
                }
                row[r].add(d);
                column[c].add(d);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String[] row = scanner.nextLine().split(",");
            for (int j = 0; j < 9; j++) {
                board[i][j] = row[j].trim().charAt(0);
            }
        }
        System.out.println(isValidSudoku(board));
    }
}
