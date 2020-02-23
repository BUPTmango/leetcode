package simple_level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例?1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/19 9:58 上午
 */
public class IsAnagram {
    /**
     * 自己的做法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = countString(s);
        Map<Character, Integer> mapT = countString(t);

        boolean flag = true;
        for (char c : mapS.keySet()) {
            if (!mapS.get(c).equals(mapT.get(c))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Map<Character, Integer> countString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+ 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    /**
     * 推荐的做法
     * 通过将 ss 的字母重新排列成 tt 来生成变位词。
     * 因此，如果 TT 是 SS 的变位词，对两个字符串进行排序将产生两个相同的字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_better(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }

}
