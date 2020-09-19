package simple_level;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;

/**
 * 《玩转算法面试视频例题》查找问题 map
 * 350
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/22 9:30 上午
 */
public class Intersect {
    /**
     * 第一次通过map记录每个数字出现的次数
     * 第二次遍历第二个数组，进行输出
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                if (map.get(n) > 0) {
                    resultList.add(n);
                    map.put(n, map.get(n) - 1);
                }
            }
        }
        // List<Integer> -> Integer[] -> int[]
        return Arrays.stream(resultList.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }
}
