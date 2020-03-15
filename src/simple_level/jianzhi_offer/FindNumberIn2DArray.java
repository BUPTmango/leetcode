package simple_level.jianzhi_offer;

/**
 * ������04. ��ά�����еĲ���
 * ��һ�� n * m �Ķ�ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 *
 * ʾ��:
 *
 * ���о��� matrix ���£�
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * ���� target?=?5������?true��
 *
 * ����?target?=?20������?false��
 *
 * ���ƣ�
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/15 8:42 ����
 */
public class FindNumberIn2DArray {
    /**
     * �����Ͻǿ�ʼ ���������������������
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int curRow = 0, curCol = n - 1;
        while (curCol >= 0 && curRow < m ) {
            int cur = matrix[curRow][curCol];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                curCol--;
            } else {
                curRow++;
            }
        }
        return false;
    }
}
