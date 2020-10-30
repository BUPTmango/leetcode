package middle_level;


/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数n，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/30 8:51 上午
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
