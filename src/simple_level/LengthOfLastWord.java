package simple_level;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 *
 * @author mango
 * @create 2019-03-12 3:48 PM
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.equals(" ")) {
            return 0;
        }
        s = s.trim();
        //遍历寻找" "出现的最后位置
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                index = i;
            }
        }
        if (index == -1) {
            return s.length();
        } else {
            return s.length() - index - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(""));
    }
}