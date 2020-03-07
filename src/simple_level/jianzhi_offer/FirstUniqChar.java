package simple_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 * ?
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/6 11:10 下午
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
