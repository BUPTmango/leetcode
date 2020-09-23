package middle_level;

import java.util.TreeSet;

/**
 * 《玩转算法面试视频例题》二分搜索树底层实现的顺序性
 * 220. 存在重复元素 III
 * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得nums [i] 和nums [j]的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ? 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 示例1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/23 7:09 下午
 */
public class ContainsNearbyAlmostDuplicate {
    /**
     * 如果窗口中维护的元素是有序的，只需要用二分搜索检查条件二是否是满足的就可以了。
     * 利用自平衡二叉搜索树，可以在对数时间内通过 插入 和 删除 来对滑动窗口内元素排序。
     *
     * 下面给出整个算法的伪代码：
     *
     * 初始化一颗空的二叉搜索树 set
     * 对于每个元素x，遍历整个数组
     *      在 set 上查找大于等于x的最小的数，如果s-x≤t则返回 true
     *      在 set 上查找小于等于x的最大的数，如果x-g≤t则返回 true
     *      在 set 中插入x
     *      如果树的大小超过了k, 则移除最早加入树的那个数。
     * 返回 false
     *
     * 这里强制转化为long是因为有int的相加 就有可能发生过越界的情况
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // ceiling用来返回大于等于给定元素的最小元素
            Long s = set.ceiling((long) nums[i]);
            if (s != null && s <= (long)(nums[i] + t)) {
                return true;
            }

            // floor用来返回小于等于给定元素的最大元素
            Long g = set.floor((long) nums[i]);
            if (g != null && (long)nums[i] <= (g + t)) {
                return true;
            }

            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
