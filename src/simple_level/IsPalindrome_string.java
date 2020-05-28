package simple_level;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/28 10:41 上午
 */
public class IsPalindrome_string {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindrome_twoPointer(String s) {

        if (s.length() == 0)
            return true;

        String low = s.toLowerCase();

        int i = 0;
        int j = low.length() - 1;

        while (i < j)
        {
            if (!Character.isLetterOrDigit(low.charAt(i)))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(low.charAt(j)))
            {
                j--;
                continue;
            }
            if (low.charAt(i) != low.charAt(j))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
}
