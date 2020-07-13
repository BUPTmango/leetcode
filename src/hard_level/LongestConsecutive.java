package hard_level;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为?O(n)。
 *
 * 示例:
 *
 * 输入:?[100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/13 10:20 上午
 */
public class LongestConsecutive {
    /**
     * 第一步：将所有数装进HashSet中；
     * 第二步：从数组第一个元素开始查HashSet,不仅要查它前面的，还要查它后面的，比如：3，2，1，4，6，查3，查前面的会查到2，1，查后面的会查到4。
     * 一旦一个元素被查到，直接将这个数从Set中移除，这样一来，3，2，1，4直接全被踢出Set；
     * 再开始查2，2已经被踢出去了（HashSet中不包含2），可以直接跳过，1，4亦是如此，最后查6。
     * 整个过程只需要记录中间最长的即可。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hash.add(nums[i]);
        }
        int cnt = 0;
        int result = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int j = 0; j < nums.length; j++){
            if(!hash.contains(nums[j])) {
                continue;
            }
            // 记录长度
            cnt = 0;
            // 记录当前元素
            tmp1 = nums[j];
            // 记录下一个元素
            tmp2 = nums[j]+1;
            // 因为会删除 所以要看是不是存在
            while(hash.contains(tmp1)) {
                // 长度加一 并删除
                cnt++;
                hash.remove(tmp1);
                // 删除后更新索引 向前查看
                tmp1--;
            }
            // 因为会删除 所以要看是不是存在
            while(hash.contains(tmp2)) {
                // 长度加一 并删除
                cnt++;
                hash.remove(tmp2);
                // 删除后更新索引 向后查看
                tmp2++;
            }
            result = cnt > result ? cnt : result;
        }
        return result;
    }
}
