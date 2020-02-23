package middle_level;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author Wang Guolong
 * @create 2019-04-28 10:22 AM
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : chars) {//遍历输入的每一位
            List<String> tmpList = new ArrayList<>();
            String sufStr = map.get(c);
            for (String str : result) {
                for (char tmpC : sufStr.toCharArray()) {
                    String tmpStr = str + tmpC;
                    tmpList.add(tmpStr);
                }
            }
            result = tmpList;
        }
    return result;
    }
}