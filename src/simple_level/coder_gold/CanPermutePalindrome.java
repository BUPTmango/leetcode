package simple_level.coder_gold;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * ?
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/29 12:21 下午
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int count = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}
