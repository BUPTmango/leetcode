package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组）?words?和一张『字母表』（字符串）?chars。
 *
 * 假如你可以用?chars?中的『字母』（字符）拼写出 words?中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表?words?中你掌握的所有单词的 长度之和。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * ?
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length?<= 100
 * 所有字符串中都仅包含小写英文字母
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/17 11:02 下午
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> source = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (source.containsKey(c)) {
                source.put(c, source.get(c) + 1);
            } else {
                source.put(c, 1);
            }
        }
        for (char c : source.keySet()) {
            System.out.println(c + " : " + source.get(c));
        }
        System.out.println();
        System.out.println();

        for (String s : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            for (char c : map.keySet()) {
                System.out.println(c + " : " + map.get(c));
            }
            System.out.println();
            boolean flag = true;
            for (char target : map.keySet()) {
                if (!source.containsKey(target)) {
                    flag = false;
                    break;
                }
                if (source.get(target) < map.get(target)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += s.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountCharacters c = new CountCharacters();
        System.out.println(c.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}
