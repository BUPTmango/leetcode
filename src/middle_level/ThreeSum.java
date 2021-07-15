package middle_level;

import java.util.*;

/**
 * sum问题
 * 《玩转算法面试视频例题》查找问题 sum
 * 15 三数之和
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Wang Guolong
 * @create 2019-04-25 2:00 PM
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // 遍历第一个数 剩下的用双指针
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            // 如果第一个数大于0 后面的更大 三数之和不可能为0
            if (nums[i] > 0) {
                break;
            }
            // 去掉重复情况   注意！！！ 这里用if就可以了 不用while 因为continue之后又来了 相当于就是while
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 注意！！！ 是在相等的时候去重
                    // 去重   注意！！！！ 这里条件是left < right 不是和数组长度去比较
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    // 去重
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    // 注意！！ 两侧同时向里缩
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}