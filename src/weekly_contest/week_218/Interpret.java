package weekly_contest.week_218;

/**
 * 5617. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 *
 *
 * 提示：
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/6 10:31 上午
 */
public class Interpret {
    public String interpret(String command) {
        int length = command.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < length) {
            char curr = command.charAt(index);
            if (curr == 'G') {
                sb.append("G");
                index++;
            }
            if (curr == '(') {
                // 向后寻找 ) 或者是 al)
                char next = command.charAt(index + 1);
                if (next == ')') {
                    sb.append("o");
                    index += 2;
                } else {
                    sb.append("al");
                    index += 4;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Interpret interpret = new Interpret();
        String str = "G()()()()(al)";
        System.out.println(interpret.interpret(str));
    }
}
