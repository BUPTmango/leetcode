package simple_level;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数
 * 其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 *
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 *
 * @author mango
 * @create 2019-03-11 11:01 AM
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        int k;
        for (int i = 1; i < n; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < s.length(); j = k) {
                k = j;
                //先寻找有几个相同的
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                t.append(k - j).append(s.charAt(j));
            }
            s = t.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}