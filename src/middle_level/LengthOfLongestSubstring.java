package middle_level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 《玩转算法面试视频例题》 滑动窗口
 * 3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Wang Guolong
 * @create 2019-03-30 8:52 PM
 */
public class LengthOfLongestSubstring {
    /**
     * 滑动窗口
     * 定义不重复的字串开始位置为j，结束位置为i
     * 随着 i 不断遍历向后，会遇到与 [j, i] 区间内字符相同的情况，
     * 此时将字符作为 key 值，获取其 value 值，并更新 j，此时 [j, i] 区间内不存在重复字符
     * 无论是否更新 j，都会更新其 map 数据结构和结果 ans。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            // 存在重复字符
            if (map.containsKey(s.charAt(i))) {
                // 将重复的上一个字符之前的扔掉 就是将j向后挪一位
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // 更新字符出现的位置
            map.put(s.charAt(i), i);
            // 用窗口的长度更新结果的最大值
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring_another(String s) {
        int[] freq = new int[256];
        // 滑动窗口为s[l, r]
        int l = 0;
        int r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_another("abcabcbb"));
    }
}