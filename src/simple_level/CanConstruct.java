package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * ?
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/3 9:25 下午
 */
public class CanConstruct {
    /**
     * 自己的写法
     *
     * 还有一种思路：
     * 第一次遍历，记录ransonNote中字母出现的次数；
     * 第二次遍历，记录magazine中字母出现的次数；
     * 然后保证ransonNote中字母出现的次数 <= magazine中相应字母次数即可。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] source = magazine.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : source) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        char[] result = ransomNote.toCharArray();
        for (char ch : result) {
            if (!charMap.containsKey(ch)) {
                return false;
            } else if (charMap.get(ch) == 0) {
                return false;
            } else {
                charMap.put(ch, charMap.get(ch) - 1);
            }
        }

        return true;
    }
}
