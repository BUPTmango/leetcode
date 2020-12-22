package middle_level.jianzhi_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/7 10:19 上午
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>(2);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                resultList.add(num);
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    /**
     * 将两个不同的数字分到两个组中 分别全员异或
     * @param nums
     * @return
     */
    public int[] singleNumbers_better(int[] nums) {
        int ret = 0;
        // 全员异或
        for (int n : nums) {
            ret ^= n;
        }
        // 找到第一个为1的地方 也就是两个数字不一样的地方
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        // 进行分组异或
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
