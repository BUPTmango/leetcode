package weekly_contest.week_215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 5603. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 *
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 *
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 示例 4：
 *
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 10:53 上午
 */
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        // 统计两个字符出现数组
        Map<Character, Integer> map1 = getMap(word1);
        Map<Character, Integer> map2 = getMap(word2);
        int[] arr1 = countString(map1);
        int[] arr2 = countString(map2);
        char[] keySet1 = getKeySet(map1);
        char[] keySet2 = getKeySet(map2);

        return Arrays.equals(arr1, arr2) && Arrays.equals(keySet1, keySet2);
    }

    private Map<Character, Integer> getMap(String str) {
        char[] chars = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    private int[] countString(Map<Character, Integer> map) {
        int[] res = new int[map.size()];
        int index = 0;
        for (char key : map.keySet()) {
            res[index++] = map.get(key);
        }
        Arrays.sort(res);
        return res;
    }

    private char[] getKeySet(Map<Character, Integer> map) {
        Set<Character> characters = map.keySet();
        char[] chars = new char[characters.size()];
        int index = 0;
        for (char c : characters) {
            chars[index++] = c;
        }
        Arrays.sort(chars);
        return chars;
    }

    public static void main(String[] args) {
        CloseStrings closeStrings = new CloseStrings();
        String word1 = "cabbba";
        String word2 = "aabbss";
        System.out.println(closeStrings.closeStrings(word1, word2));
    }
}
