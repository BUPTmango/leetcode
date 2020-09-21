package simple_level.jianzhi_offer;

/**
 * 面试题58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出:?"blue is sky the"
 * 示例 2：
 *
 * 输入: " ?hello world! ?"
 * 输出:?"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good ? example"
 * 输出:?"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * ?
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/14 5:15 下午
 */
public class ReverseWords {
    /**
     * 分割 + 倒序
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.trim().length() == 0) {
            return "";
        }
        String[] result = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i].length() != 0) {
                sb.append(result[i] + " ");
            }
        }
        return sb.substring(0, sb.toString().length() - 1);
    }

    public static void main(String[] args) {
        String s = "a good   example";
        String[] result = s.trim().split(" ");
        for (String str : result) {
            if (str.length() != 0) {
                System.out.println(str);
            }
        }
    }
}
