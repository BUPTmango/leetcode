package middle_level;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵A 其中每个元素的值为0或1。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j]是0 或1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/7 9:03 上午
 */
public class MatrixScore {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        // 第一步 将每行第一个变成1
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                changeOneZero(A[i]);
            }
        }
        // 第二步 计算第二列开始的每一列中的1的个数 尽量多
        for (int j = 1; j < n; j++) {
            changeColumnNumbers(A, j);
        }
        // 第三步 计算值
        int num = 0;
        for (int j = 0; j < n; j++) {
            int temp = (int) Math.pow(2, n - j - 1);
            for (int i = 0; i < m; i++) {
                num += A[i][j] * temp;
            }
        }
        return num;
    }

    private void changeColumnNumbers(int[][] A, int column) {
        // 计算0的个数
        int zeroCount = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (A[i][column] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount > length / 2) {
            for (int i = 0; i < length; i++) {
                A[i][column] = A[i][column] == 0 ? 1 : 0;
            }
        }
    }

    private void changeOneZero(int[] line) {
        int length = line.length;
        for (int i = 0; i < length; i++) {
            line[i] = line[i] == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        MatrixScore matrixScore = new MatrixScore();
        matrixScore.matrixScore(new int[][]{{1, 1, 1, 0}, {0, 0, 0, 0}});
    }
}
