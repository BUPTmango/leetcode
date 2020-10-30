package middle_level;


/**
 * 59. �������� II
 * ����һ��������n������һ������ 1 ��n2����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
 *
 * ʾ��:
 *
 * ����: 3
 * ���:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/30 8:51 ����
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int numEle = n * n;
        int num = 1;

        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result[top][i] = num++;
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result[i][right] = num++;
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result[bottom][i] = num++;
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result[i][left] = num++;
                numEle--;
            }
            left++;
        }

        return result;
    }
}
