package middle_level;

/**
 * 73. ��������
 * ����һ��?m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��
 *
 * ʾ��?1:
 *
 * ����:
 * [
 * ? [1,1,1],
 * ? [1,0,1],
 * ? [1,1,1]
 * ]
 * ���:
 * [
 * ? [1,0,1],
 * ? [0,0,0],
 * ? [1,0,1]
 * ]
 * ʾ��?2:
 *
 * ����:
 * [
 * ? [0,1,2,0],
 * ? [3,4,5,2],
 * ? [1,3,1,5]
 * ]
 * ���:
 * [
 * ? [0,0,0,0],
 * ? [0,4,5,0],
 * ? [0,3,1,0]
 * ]
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/27 4:06 ����
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            // ��ʾ����Ԫ���Ƿ�Ϊ0
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // �ҵ�0�������׻�������Ϊ0
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                // ͨ����־λ���к�������Ϊ0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) matrix[i][0] = 0;
        }
    }
}
