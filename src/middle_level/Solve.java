package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 ��άƽ��
 * 130. ��Χ�Ƶ�����
 * ����һ����ά�ľ��󣬰���'X'��'O'����ĸ O����
 *
 * �ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е�'O' �� 'X' ��䡣
 *
 * ʾ��:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * ������ĺ����󣬾����Ϊ��
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/13 8:44 ����
 */
public class Solve {
    private int m;
    private int n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        // �ҵ��߽��ϵ�O ��ʼ���� ���ΪA
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // A�ı��ΪO O�ı��ΪX
        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
                if (board[p][q] == 'A') {
                    board[p][q] = 'O';
                } else if (board[p][q] == 'O') {
                    board[p][q] = 'X';
                }
            }
        }
    }

    /**
     * ��Ǳ��ϵ�OΪA
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        // ���OΪA
        board[i][j] = 'A';
        // ���������ĸ�����
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
