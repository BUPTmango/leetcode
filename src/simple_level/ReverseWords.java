package simple_level;

/**
 * 557
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例?1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"?
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/24 9:51 上午
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] inputArray = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : inputArray) {
            StringBuilder builder = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                builder.append(str.charAt(i));
            }
            result.append(builder);
            result.append(" ");
        }
        return result.toString().substring(0, result.toString().length() - 1);
    }

    public static void main(String[] args) {
        ReverseWords re = new ReverseWords();
        System.out.println(re.reverseWords(null));
    }
}
