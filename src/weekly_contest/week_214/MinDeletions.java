package weekly_contest.week_214;

import java.util.HashMap;
import java.util.Map;

/**
 * 5562. 字符频次唯一的最小删除次数
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * <p>
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * <p>
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * 示例 2：
 * <p>
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * 示例 3：
 * <p>
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅含小写英文字母
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/8 11:12 上午
 */
public class MinDeletions {
    public int minDeletions(String s) {
        int len = s.length();
        int[] tmp = new int[len + 1];
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            tmp[map.get(ch)]++;
        }
        // 大于1的全部向下减1
        for (int i = len; i > 0; i--) {
            if (tmp[i] > 1) {
                res += tmp[i] - 1;
                tmp[i - 1] += tmp[i] - 1;
            }
        }
        return res;
    }
}
