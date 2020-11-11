package middle_level;

import java.util.Arrays;

/**
 * 区间问题
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当c <= a且b <= d时，我们才认为区间[a,b) 被区间[c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * 
 *
 * 提示：
 *
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] <intervals[i][1] <= 10^5
 * 对于所有的i != j：intervals[i] != intervals[j]
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 6:39 下午
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        // 按照起点升序排列 起点相同时降序排列
        // 因为起点相同是要保证大的区间在上面 所以降序排列终点
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 情况一 找到覆盖区间
            if (left <= interval[0] && right >= interval[1]) {
                res++;
            }
            // 情况二 找到相交区间 合并
            if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            }
            // 情况三 完全不相交 更新起点和终点
            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }

        return intervals.length - res;
    }
}
