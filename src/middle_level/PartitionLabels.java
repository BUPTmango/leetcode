package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/22 9:15 上午
 */
public class PartitionLabels {
    /**
     * 贪心算法 + 双指针
     *
     * 使用贪心的思想寻找每个片段可能的最小结束下标，因此可以保证每个片段的长度一定是符合要求的最短长度，
     * 如果取更短的片段，则一定会出现同一个字母出现在多个片段中的情况。
     * 由于每次取的片段都是符合要求的最短的片段，因此得到的片段数也是最多的。
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        // 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。
        int[] last = new int[26];
        int length = S.length();
        // 需要遍历字符串，得到每个字母最后一次出现的下标位置。
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            // 对于每个访问到的字母 c，得到当前字母的最后一次出现的下标位置endc，则当前片段的结束下标一定不会小于endc， 所以取max
            end = Math.max(end, last[S.charAt(i) - 'a']);
            // 当访问到下标 end 时，当前片段访问结束，当前片段的下标范围是[start,end]
            if (i == end) {
                partition.add(end - start + 1);
                // 继续寻找下一个片段
                start = end + 1;
            }
        }
        return partition;
    }
}
