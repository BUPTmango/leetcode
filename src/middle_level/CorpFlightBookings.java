package middle_level;

/**
 * 差分数组法
 * 1109. 航班预订统计
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第i条预订记录bookings[i] = [i, j, k]意味着我们在从i到j的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 
 *
 * 提示：
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/27 7:39 下午
 */
public class CorpFlightBookings {
    /**
     * 差分数组法
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        // 计算出差分数组
        // 遍历bookings 计算航班i+1 对航班i 变化的预订数
        for (int[] b : bookings) {
            // 增加的预订数
            answer[b[0] - 1] += b[2];
            // 防止数组越界
            if (b[1] < n) {
                // 减少的预订数量
                answer[b[1]] -= b[2];
            }
        }

        // 对差分数组进行还原
        // 航班i的预订数等于,i-1的预订数，加i时刻变化的预定数
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }
}
