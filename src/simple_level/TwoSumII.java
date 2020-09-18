package simple_level;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》对撞指针
 * 167
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author mango
 * @create 2019-03-26 5:56 PM
 */
public class TwoSumII {
    /**
     * 暴力解法
     * 暴力解法没用充分利用数组的性质--有序
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return new int[]{};
    }

    /**
     * 二分查找法
     * 数组有序 就会想到用二分查找法优化
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_binary(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int m = i + 1;
            int n = numbers.length - 1;
            while (m <= n) {
                int mid = (n - m) / 2 + m;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                }
                if (numbers[mid] > target - numbers[i]) {
                    n = mid - 1;
                }
                if (numbers[mid] < target - numbers[i]) {
                    m = mid + 1;
                }
            }
        }
        return new int[]{};
    }

    /**
     * 对撞指针法
     * 两个指针分别指向头和尾
     * 如果两数之和大于target 左移尾指针
     * 如果两数之和小于target 右移头指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_pointer(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        // 如果head == tail的时候两个指针就指向相同元素了
        // 由于这道题需要找到两个不同的索引 所以要用<
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                return new int[]{head + 1, tail + 1};
            }
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            }
            if (numbers[head] + numbers[tail] < target) {
                head++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = {5,25,75};
        System.out.println(Arrays.toString(twoSum_pointer(ints, 100)));
    }
}