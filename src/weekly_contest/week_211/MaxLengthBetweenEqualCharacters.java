package weekly_contest.week_211;

import java.util.HashMap;
import java.util.Map;

/**
 * 5543. 两个相同字符之间的最长子字符串
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * 示例 3：
 *
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * 示例 4：
 *
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 10:32 上午
 */
public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        // to hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 注意！！！ 默认值为-1
        int max = -1;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) < 2) {
                continue;
            }
            // 必然出现过两次以上
            int length = 0;
            for (int j = i + 1; j < chars.length; j++) {
                // 找到重复字符 更新长度
                if (chars[i] == chars[j]) {
                    length = j - i - 1;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
