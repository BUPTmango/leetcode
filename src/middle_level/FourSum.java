package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
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
        if (nums == null || nums.length < 4) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int m = 0; m < nums.length - 3; m++) {
            //重复的跳过
            if (m > 0 && nums[m] == nums[m - 1]) {
                continue;
            }
            for (int n = m + 1; n < nums.length - 2; n++) {
                //  重复的跳过
                if (n > m + 1 && nums[n] == nums[n - 1]) {
                    continue;
                }
                int j = n + 1, k = nums.length - 1;
                while (j < k) {
                    if (nums[m] + nums[n] + nums[j] + nums[k] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[m]);
                        list.add(nums[n]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        //当有重复的数字出现时，j往前跑，防止结果有重复
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[m] + nums[n] + nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        k--;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0,0,0,0}, 0));
    }
}