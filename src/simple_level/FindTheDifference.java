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
    /**
     * 计数法
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 求和法 计算两个字符串的asc码的差值
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_sum(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * 位运算
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。
     * 类似于「136. 只出现一次的数字」，我们使用位运算的技巧解决本题。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_bit(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
