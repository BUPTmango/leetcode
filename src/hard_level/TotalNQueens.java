package hard_level;


/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 ��άƽ��
 * 52. N�ʺ� II
 * n�ʺ������о�������ν� n���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 *
 * ��ͼΪ 8 �ʺ������һ�ֽⷨ��
 *
 * ����һ������ n������ n �ʺ�ͬ�Ľ��������������
 *
 * ʾ��:
 *
 * ����: 4
 * ���: 2
 * ����: 4 �ʺ������������������ͬ�Ľⷨ��
 * [
 * [".Q..", // �ⷨ 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.", // �ⷨ 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 11:45 ����
 */
public class TotalNQueens {
    private boolean[] column;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    private int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        // ���ܳ�����ͬһ��
        column = new boolean[n];
        // ���ܳ�����ͬһ������Խ���
        diagonal1 = new boolean[2 * n - 1];
        // ���ܳ�����ͬһ������Խ���
        diagonal2 = new boolean[2 * n - 1];
        putQueen(n, 0);
        return count;
    }

    /**
     * ������һ��n�ʺ������У��ڷŵ�index�еĻʺ��λ��
     * @param n
     * @param index
     */
    private void putQueen(int n, int index) {
        if (index == n) {
            count++;
        }

        for (int i = 0; i < n; i ++) {
            // ���Խ�index�еĻʺ���ڵ�i��
            if (!column[i] && !diagonal1[index + i] && !diagonal2[index - i + (n - 1)]) {
                column[i] = true;
                diagonal1[index + i] = true;
                diagonal2[index - i + (n - 1)] = true;
                putQueen(n, index + 1);
                // ����
                column[i] = false;
                diagonal1[index + i] = false;
                diagonal2[index - i + (n - 1)] = false;
            }
        }
    }
}
