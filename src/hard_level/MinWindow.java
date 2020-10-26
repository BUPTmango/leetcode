package hard_level;

import java.util.HashMap;
import java.util.Map;

/**  滑动窗口模型
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *
 * 提示：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/26 10:11 上午
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // need记录寻找字串需要包含的所有字符 window记录窗口中的所有字符
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char tChar : tArray) {
            need.put(tChar, need.getOrDefault(tChar, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是将移入窗口中的字符
            char c = sArray[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 以上一直右移right指针，直到窗口中包含了need中的所有字符
            // 接下来需要左移left指针寻找最优解
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出窗口的字符
                char d = sArray[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
