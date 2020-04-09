package middle_level.coder_gold;

/**
 * ������ 01.07. ��ת����
 * ����һ���� N �� N �����ʾ��ͼ������ÿ�����صĴ�СΪ 4 �ֽڡ��������һ���㷨����ͼ����ת 90 �ȡ�
 *
 * ��ռ�ö����ڴ�ռ��ܷ�������
 *
 * ʾ�� 1:
 *
 * ���� matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * ԭ����ת�������ʹ���Ϊ:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * ʾ�� 2:
 *
 * ���� matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * ԭ����ת�������ʹ���Ϊ:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/9 12:21 ����
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // ���ԶԽ��ߣ�����-���£�Ϊ����з�ת
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // �ٶ�ÿһ�����е���з�ת
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
