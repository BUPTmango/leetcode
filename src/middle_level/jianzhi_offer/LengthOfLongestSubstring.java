package middle_level.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * ?
 *
 * 示例?1:
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
 * 解释: 因为无重复字符的最长子串是?"wke"，所以其长度为 3。
 * ?    请注意，你的答案必须是 子串 的长度，"pwke"?是一个子序列，不是子串。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/28 9:36 上午
 */
public class LengthOfLongestSubstring {
    /**
     * 哈希表 dic 统计： 指针 j 遍历字符 s ，哈希表统计字符 s[j] 最后一次出现的索引 。
     * 更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]] ，每轮更新左边界 i ，保证区间 [i + 1, j] 内无重复字符且最大。
     * i = max(dic[s[j]], i)
     *
     * 更新结果 res ： 取上轮 res 和本轮双指针区间 [i + 1,j] 的宽度（即 j - i ）中的最大值。
     * res = max(res, j - i)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
