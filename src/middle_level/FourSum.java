package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sum问题
 * 《玩转算法面试视频例题》查找问题 sum
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author Wang Guolong
 * @create 2019-04-29 2:15 PM
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 两层循环 加 双指针
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 边界处理
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }
            int max = nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1];
            if (max < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 边界处理
                min = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min > target) {
                    break;
                }
                max = nums[i] + nums[j] + nums[n - 2] + nums[n - 1];
                if (max < target) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        // 去重
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
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 通用的方法
     * @param nums
     * @param n n数之和
     * @param start 从哪里开始
     * @param target 目标值
     * @return
     */
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || sz < n) {
            return res;
        }
        // 2Sum是base case
        if (n == 2) {
            int left = start, right = sz - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 去重
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    // 去重
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        } else {
            // n > 2 时，递归计算 (n - 1)Sum 的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    // (n - 1)Sum 加上nums[i]就是nSum
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0, 0, 0, 0}, 0));
    }
}