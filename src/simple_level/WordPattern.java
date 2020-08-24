package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern?和一个字符串?str?，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的?遵循?指完全匹配，例如，?pattern?里的每个字母和字符串?str?中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例?4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设?pattern?只包含小写字母，?str?包含了由单个空格分隔的小写字母。? ??
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/24 9:13 上午
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map index = new HashMap();
        // 通过put的返回值判断 两个集合同时映射到一个第三方集合中
        for (Integer i = 0; i < words.length; ++i) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
