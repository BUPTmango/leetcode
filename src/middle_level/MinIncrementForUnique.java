package middle_level;

/**
 * 945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意?A[i]，并将其递增?1。
 *
 * 返回使 A?中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/22 9:12 上午
 */
public class MinIncrementForUnique {
    /**
     * 我们还可以对该算法进行优化，使得我们不需要将额外出现的数记录下来。
     * 还是以 [1, 1, 1, 1, 3, 5] 为例，当我们发现有 3 个重复的 1 时，我们先将操作次数减去 1 + 1 + 1。
     * 接下来，当我们发现 2，4 和 6 都没有出现过时，我们依次将操作次数增加 2，4 和 6。
     * 这种优化方法在方法二中也被使用。
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x: A) {
            count[x]++;
        }
        int ans = 0, taken = 0;
        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }
        return ans;
    }
}
