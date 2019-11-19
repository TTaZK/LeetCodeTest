package leetcode;

// tag: backtracking
public class Word_Search_79 {
    public static boolean exist(char[][] board, String word) {
        if (board.length <= 0 || word.length() <= 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        return backTracking(board, visited, word, 0, 0, 0);
    }

    // 如果某个分支无法进行下去，则将已访问节点置为未访问
    // 或者说不需要进行访问标识的设置
    public static boolean backTracking(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (index >= word.length()) return true;
        if (i >= board.length || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            // 当前位置的四个方向
            boolean v = false;
            if (i + 1 < board.length && !visited[i + 1][j]) {
                v = v || backTracking(board, visited, word, i + 1, j, index + 1);
            }
            if (j + 1 < board[0].length && !visited[i][j + 1]) {
                v = v || backTracking(board, visited, word, i, j + 1, index + 1);
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                v = v || backTracking(board, visited, word, i - 1, j, index + 1);
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                v = v || backTracking(board, visited, word, i, j - 1, index + 1);
            }
            if (!v) visited[i][j] = false;
            else return true;
        } else {
            visited[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] row1 = new char[]{'a'};
        //char[] row2 = new char[]{'c', 'd'};
        char[][] board = new char[1][1];
        board[0] = row1;
        //board[1] = row2;
        System.out.println(exist(board, "ab"));

    }
}
