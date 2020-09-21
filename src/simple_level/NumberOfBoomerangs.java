package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 《玩转算法面试视频例题》查找表 灵活处理键值
 * 447. 回旋镖的数量
 * <p>
 * 给定平面上n 对不同的点，“回旋镖” 是由点表示的元组(i, j, k)，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/21 8:39 下午
 */
public class NumberOfBoomerangs {
    /**
     * 应用查找表
     * 统计距离i有相同距离的点有多少个
     * 有两个就是2*1 有三个就是3*2 （不同的组合计算）
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        // O(n^2)
        for (int i = 0; i < points.length; i++) {
            // 计算其余所有点到i的距离
            Map<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    record.put(distance(points[i], points[j]),
                            record.getOrDefault(distance(points[i], points[j]), 0) + 1);
                }
            }
            for (int k : record.values()) {
                res += k * (k - 1);
            }
        }
        return res;
    }

    private int distance(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }
}
