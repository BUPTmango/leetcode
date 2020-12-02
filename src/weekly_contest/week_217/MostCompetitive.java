package weekly_contest.week_217;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈
 * 5614. 找出最具竞争力的子序列
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 *
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 *
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 *
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 1 <= k <= nums.length
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/29 10:36 上午
 */
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        boolean isIncre = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]){
                isIncre = false;
                break;
            }
        }
        if (isIncre) {
            res = Arrays.copyOfRange(nums, 0, k);
            return res;
        }

        // k个数字 寻找k次
        int start = 0, end = nums.length - k;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    // 更新start索引
                    start = j + 1;
                }
            }
            res[i] = min;
            // 更新end索引
            end++;
        }
        return res;
    }

    /**
     * 单调栈 推荐
     * @param nums
     * @param k
     * @return
     */
    public int[] mostCompetitive_better(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 先pop 判断剩余数组元素能不能凑够k
            while (!stack.isEmpty() && stack.peek() > nums[i] && n - i + stack.size() > k) {
                stack.pop();
            }
            // 再添加
            stack.push(nums[i]);
        }
        // stack变为数组
        int length = stack.size();
        int[] array = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        return Arrays.copyOfRange(array, 0, k);
    }

    public static void main(String[] args) {
        MostCompetitive most = new MostCompetitive();
        System.out.println(Arrays.toString(most.mostCompetitive_better(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }
}
