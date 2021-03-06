package simple_level;


/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/26 1:41 下午
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 计数排序
     * 注意到数组元素的值域为 [0,100]，所以可以考虑建立一个频次数组 cnt ，cnt[i] 表示数字 i 出现的次数。
     * 那么对于数字 i 而言，小于它的数目就为 cnt[0...i-1] 的总和。
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent_better(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }
}
