package simple_level.jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix =?[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * ?
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length?<= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/13 12:40 下午
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int d = 0;
        boolean[][] visited = new boolean[m][n];
        int x = 0;
        int y = 0;
        List<Integer> res = new ArrayList<>();
        while (res.size() < n * m) {
            res.add(matrix[x][y]);
            visited[x][y] = true;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < m && nx >= 0 && ny < n && ny >= 0 && !visited[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
                x = nx;
                y = ny;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.
            }
            if(++t > b) {
                break;
            }
            for(int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; // top to bottom.
            }
            if(l > --r) {
                break;
            }
            for(int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // right to left.
            }
            if(t > --b) {
                break;
            }
            for(int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }
}
