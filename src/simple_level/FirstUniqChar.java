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
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        // 第一遍添加map次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // 第二遍进行查找
        for (int j = 0; j < s.length(); j++) {
            char r = s.charAt(j);
            if (map.containsKey(r)) {
                if (map.get(r) == 1) {
                    return j;
                }
            }
        }
        return -1;
    }
}
