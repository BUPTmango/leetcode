package middle_level;

/**
 * 949. 给定数字能组成的最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * <p>
 * 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是00:00 ，而最大的是23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * <p>
 * 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4]
 * 输出："23:41"
 * 解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:43"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
 * 示例 2：
 * <p>
 * 输入：arr = [5,5,5,5]
 * 输出：""
 * 解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
 * 示例 3：
 * <p>
 * 输入：arr = [0,0,0,0]
 * 输出："00:00"
 * 示例 4：
 * <p>
 * 输入：arr = [0,0,1,0]
 * 输出："10:00"
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr.length == 4
 * 0 <= arr[i] <= 9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/2 21:37
 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;

        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j != i) {
                    for (int k = 0; k < 4; ++k) {
                        if (k != i && k != j) {
                            int l = 6 - i - j - k;

                            // For each permutation of A[i], read out the time and
                            // record the largest legal time.
                            int hours = 10 * A[i] + A[j];
                            int mins = 10 * A[k] + A[l];
                            if (hours < 24 && mins < 60) {
                                ans = Math.max(ans, hours * 60 + mins);
                            }
                        }
                    }
                }
            }
        }

        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
}
