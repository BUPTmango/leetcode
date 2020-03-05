package simple_level.jianzhi_offer;

/**
 * 面试题57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * ?
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]?<= 10^6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/5 9:52 上午
 */
public class TwoSum {
    /**
     * 提交不成功
     * 超过时间限制
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int num = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    return new int[] {nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    /**
     * 从第一个和最后一个元素开始算。
     * 如果算出来的结果比目标大，那就最后一个往前移，否则就第一个目标往后移。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_better(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            int sum = nums[head] + nums[tail];
            if (sum == target) {
                return new int[] {nums[head], nums[tail]};
            } else if (sum > target) {
                tail--;
            } else {
                head++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] result = sum.twoSum(new int[]{2,7,11,15}, 9);
        for (int i : result) {
            System.out.println(i + "    ");
        }
    }
}
