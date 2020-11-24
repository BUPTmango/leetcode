package simple_level;

import java.util.*;

/**
 * sum问题
 * 《玩转算法面试视频例题》查找问题 sum
 * No.1
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author mango
 * @create 2019-03-05 1:24 PM
 */
public class TwoSum {
    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_better(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            if (hashMap.containsKey(target - num1)) {
                return new int[]{i, hashMap.get(target - num1)};
            }
            // 不要一次性把所有元素都放进去 会出现相同元素相互覆盖的问题
            // 这样就是每次把i之前的元素放到hash表中，之后查找过后再进行put
            hashMap.put(num1, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] indexs = twoSum_better(new int[]{2, 7, 11, 15}, 9);
        for (int index : indexs) {
            System.out.println(index);
        }
    }
}