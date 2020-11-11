package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间问题
 * 986. 区间列表的交集
 * 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
 *
 * 返回这两个区间列表的交集。
 *
 * （形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
 *
 * 示例：
 *
 * 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 
 *
 * 提示：
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 7:20 下午
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // 双指针
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            // 如果两个区间相交 对不相交的情况取反 a2 < b1 or b2 < a1
            if (b2 >= a1 && a2 >= b1) {
                list.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            // 指针前进 取决于a2和b2的大小关系
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }

        int[][] res = new int[list.size()][2];
        for (int m = 0; m < list.size(); m++) {
            res[m] = list.get(m);
        }
        return res;
    }
}
