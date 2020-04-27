package middle_level;

/**
 * 73. 矩阵置零
 * 给定一个?m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例?1:
 *
 * 输入:
 * [
 * ? [1,1,1],
 * ? [1,0,1],
 * ? [1,1,1]
 * ]
 * 输出:
 * [
 * ? [1,0,1],
 * ? [0,0,0],
 * ? [1,0,1]
 * ]
 * 示例?2:
 *
 * 输入:
 * [
 * ? [0,1,2,0],
 * ? [3,4,5,2],
 * ? [1,3,1,5]
 * ]
 * 输出:
 * [
 * ? [0,0,0,0],
 * ? [0,4,5,0],
 * ? [0,3,1,0]
 * ]
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/27 4:06 下午
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            // 标示行首元素是否为0
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 找到0后标记行首或者列首为0
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                // 通过标志位将行和列设置为0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) matrix[i][0] = 0;
        }
    }
}
