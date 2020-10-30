package middle_level;

/**
 * 74. 搜索二维矩阵
 *
 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。

 示例 1：

 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 输出：true
 示例 2：

 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 输出：false
 示例 3：

 输入：matrix = [], target = 0
 输出：false

 提示：

 m == matrix.length
 n == matrix[i].length
 0 <= m, n <= 100
 -104 <= matrix[i][j], target <= 104
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 9:22 下午
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 从右上角开始找 target大就往下走 target小就往左走
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            int curr = matrix[i][j];
            if (curr == target) {
                return true;
            } else if (curr < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
