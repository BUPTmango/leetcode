package simple_level;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串?s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/27 11:17 上午
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length()-1, 1);
    }

    /**
     *
     * @param s 输入字符串
     * @param left 左指针
     * @param right 右指针
     * @param chance 删除节点的机会次数
     */
    private boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome(s, left, right - 1, chance-1) || validPalindrome(s, left + 1, right, chance-1);
        }
    }
}
