package hard_level;

import java.util.*;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 ��άƽ��
 * 51. N �ʺ�
 * n�ʺ������о�������ν� n���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 * ��ͼΪ 8 �ʺ������һ�ֽⷨ��
 *
 * ����һ������ n���������в�ͬ��n�ʺ�����Ľ��������
 *
 * ÿһ�ֽⷨ����һ����ȷ��n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 *
 * ʾ����
 *
 * ���룺4
 * �����[
 *  [".Q..",  // �ⷨ 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // �ⷨ 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * ����: 4 �ʺ��������������ͬ�Ľⷨ��
 * 
 * ��ʾ��
 *
 * �ʺ�˴˲����໥������Ҳ����˵���κ������ʺ󶼲��ܴ���ͬһ�����С����л�б���ϡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 10:31 ����
 */
public class SolveNQueens {

    private boolean[] column;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    private List<Integer> rowRes = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        // ���ܳ�����ͬһ��
        column = new boolean[n];
        // ���ܳ�����ͬһ������Խ���
        diagonal1 = new boolean[2 * n - 1];
        // ���ܳ�����ͬһ������Խ���
        diagonal2 = new boolean[2 * n - 1];
        putQueen(n, 0);
        return res;
    }

    /**
     * ������һ��n�ʺ������У��ڷŵ�index�еĻʺ��λ��
     * @param n
     * @param index
     */
    private void putQueen(int n, int index) {
        if (index == n) {
            res.add(generateBoard(n, new ArrayList<>(rowRes)));
        }

        for (int i = 0; i < n; i ++) {
            // ���Խ�index�еĻʺ���ڵ�i��
            if (!column[i] && !diagonal1[index + i] && !diagonal2[index - i + (n - 1)]) {
                rowRes.add(i);
                column[i] = true;
                diagonal1[index + i] = true;
                diagonal2[index - i + (n - 1)] = true;
                putQueen(n, index + 1);
                // ����
                rowRes.remove(rowRes.size() - 1);
                column[i] = false;
                diagonal1[index + i] = false;
                diagonal2[index - i + (n - 1)] = false;
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> positions) {
        List<String> board = new ArrayList<>();
        char[] rowChar = new char[n];
        positions.forEach(pos -> {
            Arrays.fill(rowChar, '.');
            rowChar[pos] = 'Q';
            board.add(new String(rowChar));
        });
        return board;
    }
}
