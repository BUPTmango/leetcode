package beforeBegining_2018;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 *
 * 该矩阵具有以下特性
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @author mango
 * @create 2019-02-27 11:32 AM
 */
public class SearchMatrix {
    /**
     * 假如我判断这一行的行首元素比target大，那么这一行就可以直接排除了，每一列同理
     * 我们就要考虑排除的顺序了，我采取的是按行倒序，按列正序的方式，也就是从左下角入手，向右上角收缩
     * 也可以选择从右上角入手，向左下角收缩，思路是一样的
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            }
        }
        return false;
    }
}