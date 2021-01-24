package hard_level;

/**
 * 37. ������
 * ��дһ������ͨ�����ո�������������⡣
 *
 * һ�������Ľⷨ����ѭ���¹���
 *
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ���Դ�ʵ�߷ָ���3x3����ֻ�ܳ���һ�Ρ�
 * �հ׸���'.'��ʾ��
 *
 * һ��������
 *
 * �𰸱���ɺ�ɫ��
 *
 * ��ʾ��
 *
 * ��������������ֻ��������1-9���ַ�'.'��
 * ����Լ������������ֻ��Ψһ�⡣
 * ����������Զ��9x9��ʽ�ġ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/24 10:38 ����
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // ��ٵ����һ�еĻ��ͻ�����һ�����¿�ʼ
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // �ҵ�һ�����н⣬����base case
            return true;
        }

        if (board[i][j] != '.') {
            // �����Ԥ�����֣� �������
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // ����������Ϸ������֣�������
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            // ����ҵ�һ�����н� ��������
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // �����1-9����Ȼû���ҵ����н�
        // ��Ҫǰ��ĸ��ӻ����������
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // �ж����Ƿ�����ظ�
            if (board[r][i] == n) {
                return false;
            }
            // �ж����Ƿ�����ظ�
            if (board[i][c] == n) {
                return false;
            }
            // �ж� 3 * 3 �����Ƿ�����ظ�
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}
