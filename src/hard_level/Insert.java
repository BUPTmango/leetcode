package hard_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 区间问题
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/4 12:57 下午
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int index = 0;
        // 遍历区间列表
        // 1 将新区间左边且相离的区间加入结果集
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        // 2 接着判断当前区间是否与新区间重叠 重叠就合并
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[index++] = newInterval;
        // 3 最后将新区间右边且相离的区间加入结果集
        while (i < intervals.length) {
            res[index++] = intervals[i++];
        }
        // 因为又可能最后一个是[0,0] 排除这种情况
        return Arrays.copyOf(res, index);
    }
}
