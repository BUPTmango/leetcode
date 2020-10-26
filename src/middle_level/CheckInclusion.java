package middle_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口模型
 * 567. 字符串的排列
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/26 11:03 上午
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        // need记录寻找字串需要包含的所有字符 window记录窗口中的所有字符
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char n : char1) {
            need.put(n, need.getOrDefault(n, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = char2[right];
            right++;
            // 更新数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 长度大于目标就可以收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                char d = char2[left];
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
        // 未找到
        return false;
    }
}
