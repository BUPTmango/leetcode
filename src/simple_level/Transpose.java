package simple_level;

/**
 * 867. 转置矩阵
 * 给定一个矩阵A，返回A的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * 
 * 提示：
 *
 * 1 <= A.length<= 1000
 * 1 <= A[0].length<= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/24 2:38 下午
 */
public class Transpose {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = A[i][j];
            }
        }

        return res;
    }
}
