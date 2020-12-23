package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 387
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 * ?
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/23 10:25 上午
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        // 第一遍记录次数
        int[] times = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            times[s.charAt(i) - 'a']++;
        }
        // 寻找次数为1的第一个
        for (int i = 0; i < len; i++) {
            if (times[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
