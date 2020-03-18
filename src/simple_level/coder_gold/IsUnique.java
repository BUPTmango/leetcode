package simple_level.coder_gold;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/18 10:32 上午
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
