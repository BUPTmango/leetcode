package middle_level.jianzhi_offer;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例?2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/21 9:49 上午
 */
public class MinNumber {
    /**
     * 此题求拼接起来的 “最小数字” ，本质上是一个排序问题。
     * 排序判断规则： 设 nums 任意两数字的字符串格式 x 和 y ，则
     *
     * 若拼接字符串 x + y > y + x ，则 m > n ；
     * 反之，若 x + y < y + x ，则 n < m ；
     *
     * 根据以上规则，套用任何排序方法对 nums 执行排序即可。
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        // 将int数组变成String数组
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 根据自定义的排序规则进行排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        // 通过StringBuilder进行连接
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
