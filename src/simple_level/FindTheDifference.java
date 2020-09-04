package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串?t?由字符串?s?随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * ?
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/4 9:09 上午
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!charMap.containsKey(ch)) {
                return ch;
            } else if (charMap.get(ch) == 0) {
                return ch;
            } else {
                charMap.put(ch, charMap.get(ch) - 1);
            }
        }
        return 'a';
    }
}
