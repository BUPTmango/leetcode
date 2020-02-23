package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 *
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 *
 * @author mango
 * @create 2019-03-27 10:44 AM
 */
public class ConvertToTitle {
    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            char s=(char) ((n-1)%26+'A');
            result = s + result;
            n = (n-1) / 26;
        }
        return result;
    }
}