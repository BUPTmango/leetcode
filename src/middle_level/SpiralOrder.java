package middle_level;

import java.util.LinkedList;
import java.util.List;

/**
 * 54. ��������
 * ����һ������m x n��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
 * <p>
 * ʾ��1:
 * <p>
 * ����:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * ���: [1,2,3,6,9,8,7,4,5]
 * ʾ��2:
 * <p>
 * ����:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * ���: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 9:34 ����
 */
public class SpiralOrder {
    /**
     * תȦ����
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }
}
