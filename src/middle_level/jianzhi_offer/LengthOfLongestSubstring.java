package middle_level.jianzhi_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * ?
 * <p>
 * 示例?1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
 * ?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/28 9:36 上午
 */
public class LengthOfLongestSubstring {
    /**
     * 滑动窗口，双指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int l = 0, r = 0;
        int res = 0;
        // 滑动窗口
        while (l < n) {
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            // 更新
            res = Math.max(res, r - l);
            set.remove(s.charAt(l++));
        }
        return res;
    }
}
